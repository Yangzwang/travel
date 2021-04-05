package com.ccnu.tour.dao;


import com.ccnu.tour.pojo.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CityMapper {
    int insert(City record);

    List<City> findByAll();

    int updateSidById(Integer id,String sid);

    City  findByCityName(String cityName);
}