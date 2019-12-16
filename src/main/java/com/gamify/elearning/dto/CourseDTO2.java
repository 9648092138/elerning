package com.gamify.elearning.dto;

public class CourseDTO2 {
    String id;
    String title;
    String description;
    String tags;
    String badgeId;
    // VideoDTO previewVideo;
    String vimeoId;
    String fileName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(String badgeId) {
        this.badgeId = badgeId;
    }

    // public VideoDTO getPreviewVideo() {
    //     return previewVideo;
    // }

    // public void setPreviewVideo(VideoDTO previewVideo) {
    //     this.previewVideo = previewVideo;
    // }

    public String getVimeoId() {
        return vimeoId;
    }

    public void setVimeoId(String vimeoId) {
        this.vimeoId = vimeoId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
