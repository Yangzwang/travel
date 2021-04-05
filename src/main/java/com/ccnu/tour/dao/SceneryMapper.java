package com.ccnu.tour.dao;


import com.ccnu.tour.config.InterProcessLock;
import com.ccnu.tour.pojo.Scenery;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

import java.security.Security;
import java.util.List;
@Mapper
public interface SceneryMapper {

    List<Scenery>  findBySid(String sid);

    int insert(Scenery record);

    List<Scenery> findByCount(Integer count, Integer size);

}