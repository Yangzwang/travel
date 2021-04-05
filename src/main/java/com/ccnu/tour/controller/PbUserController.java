package com.ccnu.tour.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccnu.tour.config.CommonJsonException;
import com.ccnu.tour.config.InterProcessLock;
import com.ccnu.tour.pojo.User;
import com.ccnu.tour.service.RedisService;
import com.ccnu.tour.service.SmsService;
import com.ccnu.tour.service.UserService;
import com.ccnu.tour.util.AESUtil;
import com.ccnu.tour.util.CommonUtil;
import com.ccnu.tour.util.ErrorEnum;
import com.ccnu.tour.util.StringTools;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/pb/user")
public class PbUserController {
    @Resource
    UserService userService;
    @Autowired
    RedisService redisService;
    @Autowired
    SmsService smsService;

    private static Logger log = LoggerFactory.getLogger(PbUserController.class);

    private static final String TOKEN_BASE_KSY = "token:";


    private static final long seconds = 60 * 60 * 24 * 7;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody JSONObject requestJson, HttpServletRequest request) {
        CommonUtil.hasAllRequired(requestJson, "phone,password");
        String phone = requestJson.getString("phone");
        String password = requestJson.getString("password");
        User user = userService.findByUserName(phone);
        if (user == null) {
            log.error(ErrorEnum.E_10001.getErrorMsg() + "username:{}", phone);
            throw new CommonJsonException(ErrorEnum.E_10001);
        }
        if (!user.getPasswd().equals(password)) {
            throw new CommonJsonException(ErrorEnum.E_10002);
        }
        String token = StringTools.GetGUID();
        redisService.set(TOKEN_BASE_KSY + token, user.getPhone());
        redisService.expire(TOKEN_BASE_KSY + token, seconds);
        return CommonUtil.successJson(token);

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject register(@RequestBody JSONObject requestJson, HttpServletRequest request) {
        CommonUtil.hasAllRequired(requestJson, "phone,password,validCode");
        String phone = requestJson.getString("phone");
        String validCode = requestJson.getString("validCode");
        String password = requestJson.getString("password");
        InterProcessMutex interProcessMutex = InterProcessLock.initInterProcessMutex("/register");
        try {
            interProcessMutex.acquire();
            if (!smsService.verificationCode(phone, validCode)) {
                throw new CommonJsonException(ErrorEnum.E_10003);
            }
            if (!userService.insert(User.init(phone, password))) {
                throw new CommonJsonException(ErrorEnum.E_10004);
            }
            interProcessMutex.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String token = StringTools.GetGUID();
        redisService.set(TOKEN_BASE_KSY + token, phone);
        redisService.expire(TOKEN_BASE_KSY + token, seconds);
        return CommonUtil.successJson(token);

    }

    @RequestMapping(value = "/forget_password", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject forgetPassword(@RequestBody JSONObject requestJson, HttpServletRequest request) {
        CommonUtil.hasAllRequired(requestJson, "phone,password,validCode");
        String phone = requestJson.getString("phone");
        String validCode = requestJson.getString("validCode");
        String password = requestJson.getString("password");
        if (!smsService.verificationCode(phone, validCode)) {
            throw new CommonJsonException(ErrorEnum.E_10003);
        }
        if (!userService.updatePasswordByPhone(phone, AESUtil.doEncrypt(password))) {
            throw new CommonJsonException(ErrorEnum.E_10006);
        }
        String token = StringTools.GetGUID();
        redisService.set(TOKEN_BASE_KSY + token, phone);
        redisService.expire(TOKEN_BASE_KSY + token, seconds);

        return CommonUtil.successJson(token);

    }

}
