package com.ccnu.tour.manager;

import com.ccnu.tour.dao.CityMapper;
import com.ccnu.tour.pojo.City;
import com.ccnu.tour.pojo.Scenery;
import com.ccnu.tour.service.CityService;
import com.ccnu.tour.service.SceneryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Security;
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
    private CityMapper  cityMapper;



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
                   if(city.getCityName().equals(scenery.getSname())){
                       if(cityService.updateSidById(city.getId(),scenery.getSid())){
                           log.info("update city succeed cityId:{}",city.getId());
                       }
                   }
                }
            }
            count++;
        }


    }

}
