package com.ccnu.tour.pojo;

public class Scenery {

    private String sid;

    private  String surl;

    private String ambiguitySname;

    private String sname;

    private String parentSid;

    private Integer viewCount;

    private String star;

    private String sceneLayer;

    private Integer goingCount;

    private Integer goneCount;

    private Double rating;

    private Integer ratingCount;

    private String lng;

    private String lat;

    private String mapX;

    private String mapY;

    private String recommendVisitTime;

    private  String absDesc;

    private String moreDesc;

    private  String fullUrl;

    private String priceDesc;
    private String  openTimeDesc;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getParentSid() {
        return parentSid;
    }

    public void setParentSid(String parentSid) {
        this.parentSid = parentSid == null ? null : parentSid.trim();
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star == null ? null : star.trim();
    }

    public String getSceneLayer() {
        return sceneLayer;
    }

    public void setSceneLayer(String sceneLayer) {
        this.sceneLayer = sceneLayer == null ? null : sceneLayer.trim();
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

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getMapX() {
        return mapX;
    }

    public void setMapX(String mapX) {
        this.mapX = mapX == null ? null : mapX.trim();
    }

    public String getMapY() {
        return mapY;
    }

    public void setMapY(String mapY) {
        this.mapY = mapY == null ? null : mapY.trim();
    }

    public String getRecommendVisitTime() {
        return recommendVisitTime;
    }

    public void setRecommendVisitTime(String recommendVisitTime) {
        this.recommendVisitTime = recommendVisitTime == null ? null : recommendVisitTime.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }

    public String getAmbiguitySname() {
        return ambiguitySname;
    }

    public void setAmbiguitySname(String ambiguitySname) {
        this.ambiguitySname = ambiguitySname;
    }

    public String getAbsDesc() {
        return absDesc;
    }

    public void setAbsDesc(String absDesc) {
        this.absDesc = absDesc;
    }

    public String getMoreDesc() {
        return moreDesc;
    }

    public void setMoreDesc(String moreDesc) {
        this.moreDesc = moreDesc;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getPriceDesc() {
        return priceDesc;
    }

    public void setPriceDesc(String priceDesc) {
        this.priceDesc = priceDesc;
    }

    public String getOpenTimeDesc() {
        return openTimeDesc;
    }

    public void setOpenTimeDesc(String openTimeDesc) {
        this.openTimeDesc = openTimeDesc;
    }
}