package com.ccnu.tour.dao;


import com.ccnu.tour.pojo.Province;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProvinceMapper {
    int insert(Province record);
}