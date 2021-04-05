package com.ccnu.tour.service.Impl;

import com.ccnu.tour.dao.SceneryRecommendMapper;
import com.ccnu.tour.pojo.SceneryRecommend;
import com.ccnu.tour.service.SceneryRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yang
 * @CreateTime: 2021-04-05 18:30
 * @Description: 景区推荐
 */
@Service
public class SceneryRecommendServiceImpl implements SceneryRecommendService {
   @Autowired
   private SceneryRecommendMapper mapper;

    @Override
    public List<SceneryRecommend> findByCityId(Integer cityId) {
        return mapper.findByCityId(cityId);
    }
}
