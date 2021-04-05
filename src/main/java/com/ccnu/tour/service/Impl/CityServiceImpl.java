package com.ccnu.tour.service.Impl;

import com.ccnu.tour.dao.CityMapper;
import com.ccnu.tour.pojo.City;
import com.ccnu.tour.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yang
 * @CreateTime: 2021-04-05 14:30
 * @Description: 城市信息
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> findByAll() {
        return cityMapper.findByAll();
    }

    @Override
    public boolean updateSidById(Integer id, String sid) {
        return cityMapper.updateSidById(id,sid)>0;
    }
}
