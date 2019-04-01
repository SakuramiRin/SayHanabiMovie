/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author SakuramiRin
 * @date 2019-03-30 14:36
 */
@SuppressWarnings("unused")
public class AllAnimesBean {

    /**
     * current_page : 1
     * data : [{"id":1,"name":"Mellie Sporer","cover":"https://pic.china-gif.com/pic/upload/vod/2018-03/152018270714.jpg","watch":4,"collection":3961,"danmaku":7306,"introduction":"Ut hic illum debitis odit maxime qui. Harum illo tempora dolore rerum tempora tempore suscipit. Repudiandae dignissimos et magnam sed est et delectus. Minus dolor omnis alias molestiae nam qui.","release_time":"2019-01-31 16:38:37","episodes":12,"status":"updating","update_time":4,"season_id":1,"season_name":"et","created_at":"2018-05-14 15:44:42","updated_at":"2019-01-31 16:38:37"},{"id":2,"name":"Prof. Leilani Williamson","cover":"https://pic.china-gif.com/pic/upload/vod/2018-10/15387952051.jpg","watch":3992383,"collection":2872,"danmaku":178312012,"introduction":"Quibusdam a quaerat voluptatem recusandae sit consectetur non. Labore quam tenetur debitis eum dolores eius. Ut veniam ut est.","release_time":"2019-01-31 16:38:37","episodes":12,"status":"end","update_time":6,"season_id":2,"season_name":"voluptatum","created_at":"2018-10-23 04:10:06","updated_at":"2019-01-31 16:38:37"}]
     * first_page_url : http://umarutv.misakas.com/animes?page=1
     * from : 1
     * last_page : 25
     * last_page_url : http://umarutv.misakas.com/animes?page=25
     * next_page_url : http://umarutv.misakas.com/animes?page=2
     * path : http://umarutv.misakas.com/animes
     * per_page : 2
     * prev_page_url : null
     * to : 2
     * total : 50
     */

    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("first_page_url")
    private String firstPageUrl;
    private int from;
    @SerializedName("last_page")
    private int lastPage;
    @SerializedName("last_page_url")
    private String lastPageUrl;
    @SerializedName("next_page_url")
    private String nextPageUrl;
    private String path;
    @SerializedName("per_page")
    private String perPage;
    @SerializedName("prev_page_url")
    private Object prevPageUrl;
    private int to;
    private int total;
    private List<DataBean> data;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getFirstPageUrl() {
        return firstPageUrl;
    }

    public void setFirstPageUrl(String firstPageUrl) {
        this.firstPageUrl = firstPageUrl;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public String getLastPageUrl() {
        return lastPageUrl;
    }

    public void setLastPageUrl(String lastPageUrl) {
        this.lastPageUrl = lastPageUrl;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPerPage() {
        return perPage;
    }

    public void setPerPage(String perPage) {
        this.perPage = perPage;
    }

    public Object getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(Object prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : Mellie Sporer
         * cover : https://pic.china-gif.com/pic/upload/vod/2018-03/152018270714.jpg
         * watch : 4
         * collection : 3961
         * danmaku : 7306
         * introduction : Ut hic illum debitis odit maxime qui. Harum illo tempora dolore rerum tempora tempore suscipit. Repudiandae dignissimos et magnam sed est et delectus. Minus dolor omnis alias molestiae nam qui.
         * release_time : 2019-01-31 16:38:37
         * episodes : 12
         * status : updating
         * update_time : 4
         * season_id : 1
         * season_name : et
         * created_at : 2018-05-14 15:44:42
         * updated_at : 2019-01-31 16:38:37
         */

        private int id;
        private String name;
        private String cover;
        private int watch;
        private int collection;
        private int danmaku;
        private String introduction;
        @SerializedName("release_time")
        private String releaseTime;
        private int episodes;
        private String status;
        @SerializedName("update_time")
        private int updateTime;
        @SerializedName("season_id")
        private int seasonId;
        @SerializedName("season_name")
        private String seasonName;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getWatch() {
            return watch;
        }

        public void setWatch(int watch) {
            this.watch = watch;
        }

        public int getCollection() {
            return collection;
        }

        public void setCollection(int collection) {
            this.collection = collection;
        }

        public int getDanmaku() {
            return danmaku;
        }

        public void setDanmaku(int danmaku) {
            this.danmaku = danmaku;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(String releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getEpisodes() {
            return episodes;
        }

        public void setEpisodes(int episodes) {
            this.episodes = episodes;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(int updateTime) {
            this.updateTime = updateTime;
        }

        public int getSeasonId() {
            return seasonId;
        }

        public void setSeasonId(int seasonId) {
            this.seasonId = seasonId;
        }

        public String getSeasonName() {
            return seasonName;
        }

        public void setSeasonName(String seasonName) {
            this.seasonName = seasonName;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}
