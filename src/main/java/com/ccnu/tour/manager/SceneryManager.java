package com.ccnu.tour.manager;

import com.ccnu.tour.dao.CityMapper;
import com.ccnu.tour.pojo.City;
import com.ccnu.tour.pojo.Scenery;
import com.ccnu.tour.pojo.SceneryInfo;
import com.ccnu.tour.service.CityService;
import com.ccnu.tour.service.SceneryInfoService;
import com.ccnu.tour.service.SceneryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: yang
 * @CreateTime: 2021-04-05 14:39
 * @Description: 景区处理
 */
@Component
public class SceneryManager {
    private static Logger log = LoggerFactory.getLogger(SceneryManager.class);
    @Autowired
    private SceneryService sceneryService;
    @Autowired
    private CityService cityService;

    @Autowired
    private SceneryInfoService sceneryInfoService;

    public void initSceneryInfo() {

        List<Scenery> sceneryList = sceneryService.findBySid("289d2b074d001b3184b27ef7");

        for (Scenery scenery : sceneryList) {
            SceneryInfo sceneryInfo = new SceneryInfo();
            sceneryInfo.setAbsDesc(scenery.getAbsDesc());
            sceneryInfo.setAmbiguitySname(scenery.getAmbiguitySname());
            sceneryInfo.setFullUrl(scenery.getFullUrl());
            sceneryInfo.setSname(scenery.getSname());
            sceneryInfo.setRecommendVisitTime(scenery.getRecommendVisitTime());
            sceneryInfo.setSpell(scenery.getSurl());
            sceneryInfo.setStar(Integer.parseInt(scenery.getStar()));
            sceneryInfo.setSceneLayer(Integer.parseInt(scenery.getSceneLayer()));
            sceneryInfo.setGoingCount(0);
            sceneryInfo.setGoneCount(0);
            sceneryInfo.setLag(Double.parseDouble(scenery.getLng()));
            sceneryInfo.setLat(Double.parseDouble(scenery.getLat()));
            sceneryInfo.setMoreDesc(scenery.getMoreDesc());
            sceneryInfo.setOpenTimeDesc(scenery.getOpenTimeDesc());
            /*if (scenery.getPriceDesc() != null) {
                if ("免费".equals(scenery.getPriceDesc())) {
                    sceneryInfo.setPriceDesc(0d);
                } else {
                    String price = scenery.getPriceDesc().replace("元", "");
                    sceneryInfo.setPriceDesc(Double.parseDouble(price));
                }
            }*/
            sceneryInfo.setPriceDesc(0d);
            sceneryInfo.setRating(5d);
            sceneryInfo.setRatingCount(0);
            List<String> strings = new ArrayList<>();
            strings.add(scenery.getParentSid());
            List<Scenery> sceneries = sceneryService.findBySids(strings);
            String name = sceneries.get(0).getSname();
            City city = cityService.findByCityName(name);
            sceneryInfo.setCityId(city.getId());
            sceneryInfoService.insert(sceneryInfo);

        }


    }

    public void sceneryList() {
        int count = 0;
        List<City> cityList = cityService.findByAll();
        while (true) {
            List<Scenery> sceneryList = sceneryService.findByCount(count * 1000, 1000);
            if (sceneryList.size() < 5) {
                break;
            }
            for (Scenery scenery : sceneryList) {
                for (City city : cityList) {
                    if (city.getName().equals(scenery.getSname())) {
                        if (cityService.updateSidById(city.getId(), scenery.getSid())) {
                            log.info("update city succeed cityId:{}", city.getId());
                        }
                    }
                }
            }
            count++;
        }


    }

}
