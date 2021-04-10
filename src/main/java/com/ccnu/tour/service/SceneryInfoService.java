package com.ccnu.tour.service;

import com.ccnu.tour.pojo.SceneryInfo;

import java.util.Collection;
import java.util.List;

public interface SceneryInfoService {

    boolean insert(SceneryInfo record);

    SceneryInfo findById(Long id);


    List<SceneryInfo> findByIds(Collection<Long> ids);

    List<SceneryInfo> findByCount(Integer cityId,Integer count,Integer size);

    int countByCityId(Integer cityId);



}
