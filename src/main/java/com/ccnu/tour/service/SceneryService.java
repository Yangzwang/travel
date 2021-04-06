package com.ccnu.tour.service;

import com.ccnu.tour.pojo.Scenery;

import java.security.Security;
import java.util.Collection;
import java.util.List;

public interface SceneryService {

    List<Scenery> findBySid(String sid);

    List<Scenery> findByCount(Integer count, Integer size);

    List<Scenery> findBySids(List<String> sids);




}
