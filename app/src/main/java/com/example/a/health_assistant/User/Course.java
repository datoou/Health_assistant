package com.example.a.health_assistant.User;

/**
 * Created by 21441 on 2020/6/10.
 */

public class Course {
    private int courseImage;
    private String courseName;

    public Course(int courseImage, String courseName) {
        this.courseImage = courseImage;
        this.courseName = courseName;
    }

    public int getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(int courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
