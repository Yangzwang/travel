package com.ccnu.tour.pojo;

import java.util.List;

/**
 * @Author: yang
 * @CreateTime: 2021-04-06 21:37
 * @Description: 城市信息
 */
public class ProvinceCityInfo {

    private String provice;

    private List<City> city;

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }
}
