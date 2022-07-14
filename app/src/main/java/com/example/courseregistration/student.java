package com.example.courseregistration;

public class student {
String id;
String name;
String email;
String course;
String fee;
String title;


    public student (String id, String name, String email,String course,String fee, String title) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course=course;
        this.fee=fee;
        this.title=title;
    }

    public student() {

    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }


    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getFee() {
        return fee;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
