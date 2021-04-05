package com.ccnu.tour.service.Impl;

import com.ccnu.tour.dao.SceneryMapper;
import com.ccnu.tour.pojo.Scenery;
import com.ccnu.tour.service.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.List;

/**
 * @Author: yang
 * @CreateTime: 2021-04-05 13:39
 * @Description: 景区景点
 */
@Service
public class SceneryServiceImpl implements SceneryService {
   @Autowired
   private SceneryMapper sceneryMapper;
    @Override
    public List<Scenery> findBySid(String sid) {
        return sceneryMapper.findBySid(sid);
    }

    @Override
    public List<Scenery> findByCount(Integer count, Integer size) {
        return sceneryMapper.findByCount(count,size);
    }
}
