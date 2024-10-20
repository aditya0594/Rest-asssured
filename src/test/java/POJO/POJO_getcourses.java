package POJO;

import POJO.POJO_Course;

public class POJO_getcourses {
    private String instructor;
    private String url;
    private String services;
    private String expertise;
    private POJO_Course courses;
    private String linkedIn;

    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }


    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }


    public String getServices() {
        return services;
    }
    public void setServices(String services) {
        this.services = services;
    }


    public String getExpertise() {
        return expertise;
    }
    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }


    public POJO_Course getCourses() {
        return courses;
    }
    public void setCourses(POJO_Course courses) {
        courses = courses;
    }


    public String getLinkedIn() {
        return linkedIn;
    }
    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }






}
