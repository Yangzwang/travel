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

        CommonUtil.hasAllRequired(requestJson, "pageNum,pageSize,city_name");

        City city = cityService.findByCityName(requestJson.getString("city_name"));
        int pageNum = requestJson.getIntValue("pageNum");
        int pageSize = requestJson.getIntValue("pageSize");
        List<SceneryInfo> sceneryInfos = sceneryInfoService.findByCount(city.getId(), pageNum * pageSize, pageSize);
        int totalCount = sceneryInfoService.countByCityId(city.getId());
        JSONObject returnData = new JSONObject();
        returnData.put("list", sceneryInfos);
        returnData.put("totalCount", totalCount);
        returnData.put("totalPage", CommonUtil.getPageCounts(requestJson.getIntValue("pageSize"), totalCount));
        return CommonUtil.successPage(returnData);

    }

    @RequestMapping(value = "/recommend_list", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getList(@RequestBody JSONObject requestJson, HttpServletRequest request) {
        CommonUtil.hasAllRequired(requestJson, "city_name");
        City city = cityService.findByCityName(requestJson.getString("city_name"));
        List<SceneryRecommend> sceneryRecommends = sceneryRecommendService.findByCityId(city.getId());
        List<Long> sceneryIds = sceneryRecommends.stream().map(SceneryRecommend::getSceneryId).collect(Collectors.toList());
        List<SceneryInfo> sceneries = sceneryInfoService.findByIds(sceneryIds);
        return CommonUtil.successJson(sceneries);
    }

    @RequestMapping(value = "/scenery_detail", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject sceneryDetail(@RequestBody JSONObject requestJson, HttpServletRequest request) {
        CommonUtil.hasAllRequired(requestJson, "scenery_id");
        SceneryInfo sceneryInfo = sceneryInfoService.findById(requestJson.getLongValue("scenery_id"));
        return CommonUtil.successJson(sceneryInfo);
    }
}
