package com.ccnu.tour.dao;


import com.ccnu.tour.pojo.SceneryInfo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface SceneryInfoMapper {

    int insert(SceneryInfo record);

    SceneryInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SceneryInfo record);

     List<SceneryInfo> findByIds(@Param("ids") Collection<Long> ids);

    List<SceneryInfo> findByCount(Integer cityId,Integer count,Integer size);

    int countByCityId(Integer cityId);

    SceneryInfo findById(Long id);
}