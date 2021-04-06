package com.ccnu.tour.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccnu.tour.manager.SceneryManager;
import com.ccnu.tour.pojo.*;
import com.ccnu.tour.service.*;
import com.ccnu.tour.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pb/scenery")
public class PbSceneryController {
    @Resource
    TourService tourService;
    @Autowired
    private SceneryManager sceneryManager;
    @Autowired
    private CityService cityService;
    @Autowired
    private SceneryRecommendService sceneryRecommendService;
    @Autowired
    private SceneryInfoService sceneryInfoService;

    private static Logger log = LoggerFactory.getLogger(PbSceneryController.class);

    @RequestMapping(value = "/getScenery", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getTour(@RequestBody JSONObject requestJson, HttpServletRequest request) {
        sceneryManager.sceneryList();
        CommonUtil.hasAllRequired(requestJson, "pageNum,pageSize");

        return null;

    }
    @RequestMapping(value = "/recommend_list", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getList(@RequestBody JSONObject requestJson, HttpServletRequest request) {
        CommonUtil.hasAllRequired(requestJson, "city_name");
        City city=cityService.findByCityName(requestJson.getString("city_name"));
        List<SceneryRecommend> sceneryRecommends= sceneryRecommendService.findByCityId(city.getId());
        List<Long>  sceneryIds= sceneryRecommends.stream().map(SceneryRecommend::getSceneryId).collect(Collectors.toList());
        List<SceneryInfo>  sceneries= sceneryInfoService.findByIds(sceneryIds);
        return CommonUtil.successJson(sceneries);
    }
}
