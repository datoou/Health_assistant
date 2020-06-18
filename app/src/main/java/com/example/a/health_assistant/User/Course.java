package com.example.a.health_assistant.User;

/**
 * Created by 21441 on 2020/6/10.
 */

public class Course {
    private String courseTitle;
    private String courseTag;
    private String courseInfo;
    private String courseApply;
    private String courseVideo;

    public Course(String courseTitle, String courseTag, String courseInfo, String courseApply, String courseVideo) {
        this.courseTitle = courseTitle;
        this.courseTag = courseTag;
        this.courseInfo = courseInfo;
        this.courseApply = courseApply;
        this.courseVideo = courseVideo;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseTag() {
        return courseTag;
    }

    public void setCourseTag(String courseTag) {
        this.courseTag = courseTag;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    public String getCourseApply() {
        return courseApply;
    }

    public void setCourseApply(String courseApply) {
        this.courseApply = courseApply;
    }

    public String getCourseVideo() {
        return courseVideo;
    }

    public void setCourseVideo(String courseVideo) {
        this.courseVideo = courseVideo;
    }
}
