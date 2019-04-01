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
 * @date 2019-03-30 15:35
 */
@SuppressWarnings("unused")
public class AnimesResourceBean {

    /**
     * id : 6
     * anime_id : 1
     * ranking : 1
     * name : aut
     * info : nam et
     * coin : 997840753
     * created_at : 2018-07-04 10:16:19
     * updated_at : 2018-07-04 10:16:19
     * resource : [{"id":16,"video_id":6,"resource":"https://tudou.com-v-tudou.com/20181101/18642_f03fcc61/index.m3u8","type":"m3u8","resolution":4000,"ranking":1,"created_at":"2018-04-18 13:22:36","updated_at":"2018-04-18 13:22:36"},{"id":17,"video_id":6,"resource":"https://tudou.com-v-tudou.com/20181001/17121_5cc4571c/index.m3u8","type":"m3u8","resolution":720,"ranking":3,"created_at":"2018-07-26 02:20:04","updated_at":"2018-07-26 02:20:04"},{"id":18,"video_id":6,"resource":"https://youku.cdn1-letv.com/20180701/12982_ab5b3956/index.m3u8","type":"m3u8","resolution":1080,"ranking":2,"created_at":"2019-01-28 23:46:03","updated_at":"2019-01-28 23:46:03"}]
     */

    private int id;
    @SerializedName("anime_id")
    private int animeId;
    private int ranking;
    private String name;
    private String info;
    private int coin;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    private List<ResourceBean> resource;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimeId() {
        return animeId;
    }

    public void setAnimeId(int animeId) {
        this.animeId = animeId;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
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

    public List<ResourceBean> getResource() {
        return resource;
    }

    public void setResource(List<ResourceBean> resource) {
        this.resource = resource;
    }

    public static class ResourceBean {
        /**
         * id : 16
         * video_id : 6
         * resource : https://tudou.com-v-tudou.com/20181101/18642_f03fcc61/index.m3u8
         * type : m3u8
         * resolution : 4000
         * ranking : 1
         * created_at : 2018-04-18 13:22:36
         * updated_at : 2018-04-18 13:22:36
         */

        private int id;
        @SerializedName("video_id")
        private int videoId;
        private String resource;
        private String type;
        private int resolution;
        private int ranking;
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

        public int getVideoId() {
            return videoId;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }

        public String getResource() {
            return resource;
        }

        public void setResource(String resource) {
            this.resource = resource;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getResolution() {
            return resolution;
        }

        public void setResolution(int resolution) {
            this.resolution = resolution;
        }

        public int getRanking() {
            return ranking;
        }

        public void setRanking(int ranking) {
            this.ranking = ranking;
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
