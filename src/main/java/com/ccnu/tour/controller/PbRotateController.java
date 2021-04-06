package com.ccnu.tour.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccnu.tour.dao.CityMapper;
import com.ccnu.tour.dao.ProvinceMapper;
import com.ccnu.tour.manager.SceneryManager;
import com.ccnu.tour.pojo.City;
import com.ccnu.tour.pojo.Province;
import com.ccnu.tour.pojo.ProvinceCityInfo;
import com.ccnu.tour.pojo.Rotate;
import com.ccnu.tour.service.CityService;
import com.ccnu.tour.service.RotateService;
import com.ccnu.tour.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: yang
 * @CreateTime: 2021-03-07 22:56
 * @Description: 轮播图
 */
@RestController
@RequestMapping("/api/pb/rotate")
public class PbRotateController {
    @Autowired
    private RotateService rotateService;
    @Autowired
    private CityService cityService;
    @Autowired
    private SceneryManager sceneryManager;
    @Value("${img.url}")
    private String imgUrl;

    @RequestMapping(value = "/get_list", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getList(@RequestBody JSONObject requestJson, HttpServletRequest request) {
        CommonUtil.hasAllRequired(requestJson, "city_name");
        City city=cityService.findByCityName(requestJson.getString("city_name"));
        List<Rotate> rotates = rotateService.finByCityId(city.getId());
        for (Rotate rotate : rotates) {
            rotate.setImgUrl(imgUrl+rotate.getImgUrl());
        }
        return CommonUtil.successJson(rotates);
    }
    @RequestMapping(value = "/init_db", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject initDb( HttpServletRequest request) {
        sceneryManager.initSceneryInfo();
        return CommonUtil.successJson("ok");
    }

}
