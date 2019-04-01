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
 * @date 2019-03-30 15:58
 */
@SuppressWarnings("unused")
public class AnimesInfoBean {

    /**
     * name : Johnpaul Fadel
     * cover : https://pic.china-gif.com/pic/upload/vod/2018-10/15387952051.jpg
     * watch : 64082525
     * collection : 3248
     * danmaku : 0
     * introduction : Et accusantium delectus tenetur voluptas provident. Recusandae sit optio voluptas exercitationem atque. A voluptas quisquam corrupti pariatur. Sunt explicabo enim commodi est error.
     * release_time : 2019-01-31 16:38:37
     * episodes : 12
     * status : end
     * update_time : 1
     * season_id : 6
     * season_name : consequatur
     * created_at : 2018-06-28 21:23:06
     * updated_at : 2019-01-31 16:38:37
     * tags : [{"id":16,"name":"temporibus","created_at":"2018-09-24 18:41:22","updated_at":"2018-09-24 18:41:22","pivot":{"anime_id":6,"tag_id":16}},{"id":6,"name":"pariatur","created_at":"2018-10-09 06:18:06","updated_at":"2018-10-09 06:18:06","pivot":{"anime_id":6,"tag_id":6}},{"id":10,"name":"velit","created_at":"2018-02-23 14:48:08","updated_at":"2018-02-23 14:48:08","pivot":{"anime_id":6,"tag_id":10}},{"id":3,"name":"vitae","created_at":"2018-10-10 15:02:33","updated_at":"2018-10-10 15:02:33","pivot":{"anime_id":6,"tag_id":3}}]
     */

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
    private List<TagsBean> tags;

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

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class TagsBean {
        /**
         * id : 16
         * name : temporibus
         * created_at : 2018-09-24 18:41:22
         * updated_at : 2018-09-24 18:41:22
         * pivot : {"anime_id":6,"tag_id":16}
         */

        private int id;
        private String name;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        private PivotBean pivot;

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

        public PivotBean getPivot() {
            return pivot;
        }

        public void setPivot(PivotBean pivot) {
            this.pivot = pivot;
        }

        public static class PivotBean {
            /**
             * anime_id : 6
             * tag_id : 16
             */

            @SerializedName("anime_id")
            private int animeId;
            @SerializedName("tag_id")
            private int tagId;

            public int getAnimeId() {
                return animeId;
            }

            public void setAnimeId(int animeId) {
                this.animeId = animeId;
            }

            public int getTagId() {
                return tagId;
            }

            public void setTagId(int tagId) {
                this.tagId = tagId;
            }
        }
    }
}
