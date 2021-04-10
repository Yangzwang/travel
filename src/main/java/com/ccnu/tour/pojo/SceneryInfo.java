package com.ccnu.tour.pojo;

import java.util.Date;

public class SceneryInfo {
    private Long id;

    private String sname;

    private String spell;

    private String ambiguitySname;

    private Integer cityId;

    private Integer viewCount;

    private Integer star;

    private Integer sceneLayer;

    private Integer goingCount;

    private Integer goneCount;

    private Double rating;

    private Integer ratingCount;

    private String absDesc;

    private String moreDesc;

    private String fullUrl;

    private Double lag;

    private Double lat;

    private String recommendVisitTime;

    private Double priceDesc;

    private String openTimeDesc;

    private String sceneryAddress;

    private Boolean isDeleted;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell == null ? null : spell.trim();
    }

    public String getAmbiguitySname() {
        return ambiguitySname;
    }

    public void setAmbiguitySname(String ambiguitySname) {
        this.ambiguitySname = ambiguitySname == null ? null : ambiguitySname.trim();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getSceneLayer() {
        return sceneLayer;
    }

    public void setSceneLayer(Integer sceneLayer) {
        this.sceneLayer = sceneLayer;
    }

    public Integer getGoingCount() {
        return goingCount;
    }

    public void setGoingCount(Integer goingCount) {
        this.goingCount = goingCount;
    }

    public Integer getGoneCount() {
        return goneCount;
    }

    public void setGoneCount(Integer goneCount) {
        this.goneCount = goneCount;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public String getAbsDesc() {
        return absDesc;
    }

    public void setAbsDesc(String absDesc) {
        this.absDesc = absDesc == null ? null : absDesc.trim();
    }

    public String getMoreDesc() {
        return moreDesc;
    }

    public void setMoreDesc(String moreDesc) {
        this.moreDesc = moreDesc == null ? null : moreDesc.trim();
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl == null ? null : fullUrl.trim();
    }

    public Double getLag() {
        return lag;
    }

    public void setLag(Double lag) {
        this.lag = lag;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getRecommendVisitTime() {
        return recommendVisitTime;
    }

    public void setRecommendVisitTime(String recommendVisitTime) {
        this.recommendVisitTime = recommendVisitTime == null ? null : recommendVisitTime.trim();
    }

    public Double getPriceDesc() {
        return priceDesc;
    }

    public void setPriceDesc(Double priceDesc) {
        this.priceDesc = priceDesc;
    }

    public String getOpenTimeDesc() {
        return openTimeDesc;
    }

    public void setOpenTimeDesc(String openTimeDesc) {
        this.openTimeDesc = openTimeDesc == null ? null : openTimeDesc.trim();
    }

    public String getSceneryAddress() {
        return sceneryAddress;
    }

    public void setSceneryAddress(String sceneryAddress) {
        this.sceneryAddress = sceneryAddress;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}