package com.ccnu.tour.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccnu.tour.manager.SceneryManager;
import com.ccnu.tour.service.RedisService;
import com.ccnu.tour.service.TourService;
import com.ccnu.tour.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jnlp.ServiceManager;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tour")
public class TourController {
    @Resource
    TourService tourService;
    @Autowired
    private SceneryManager sceneryManager;
    private static Logger log = LoggerFactory.getLogger(TourController.class);

    @RequestMapping(value = "/getTour", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getTour(HttpServletRequest request) {
        sceneryManager.sceneryList();
        JSONObject jsonObject = CommonUtil.convert2JsonAndCheckRequiredColumns(request, "pageNum,pageSize");

        return this.tourService.getQueryTour(Integer.parseInt(jsonObject.getString("pageNum")), Integer.parseInt(jsonObject.getString("pageSize")));

    }
}
