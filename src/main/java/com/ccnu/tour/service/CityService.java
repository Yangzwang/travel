package com.ccnu.tour.service;

import com.ccnu.tour.pojo.City;

import java.util.List;

public interface CityService {

    List<City> findByAll();

    boolean updateSidById(Integer id,String sid);

    City  findByCityName(String cityName);
}
