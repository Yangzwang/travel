package com.ccnu.tour.service;

import com.ccnu.tour.pojo.SceneryRecommend;

import java.util.List;

public interface SceneryRecommendService {

    List<SceneryRecommend> findByCityId(Integer cityId);


}
