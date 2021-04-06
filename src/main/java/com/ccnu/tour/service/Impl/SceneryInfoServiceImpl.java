package com.ccnu.tour.service.Impl;

import com.ccnu.tour.dao.SceneryInfoMapper;
import com.ccnu.tour.pojo.SceneryInfo;
import com.ccnu.tour.service.SceneryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Author: yang
 * @CreateTime: 2021-04-06 22:14
 * @Description: 景区基本信息操作
 */
@Service
public class SceneryInfoServiceImpl implements SceneryInfoService {
    @Autowired
    private SceneryInfoMapper mapper;
    @Override
    public boolean insert(SceneryInfo record) {
        return mapper.insert(record)>0;
    }

    @Override
    public SceneryInfo findById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SceneryInfo> findByIds(Collection<Long> ids) {
        return mapper.findByIds(ids);
    }
}
