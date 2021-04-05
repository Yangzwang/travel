package com.ccnu.tour.dao;


import com.ccnu.tour.pojo.SceneryRecommend;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SceneryRecommendMapper {

    int insert(SceneryRecommend record);

    SceneryRecommend selectByPrimaryKey(Integer id);

    List<SceneryRecommend> findByCityId(Integer cityId);

}