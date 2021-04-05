package com.ccnu.tour.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.ccnu.tour.dao.TourMapper;
import com.ccnu.tour.pojo.TourBean;
import com.ccnu.tour.service.TourService;
import com.ccnu.tour.util.CommonUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    TourMapper tourMapper;


    @Override
    public JSONObject getQueryTour(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TourBean> list = tourMapper.getQueryTour();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", list.getResult());
        jsonObject.put("totalCount", list.getTotal());
        jsonObject.put("totalPage", list.getPages());
        return CommonUtil.successPage(jsonObject);
    }
}
