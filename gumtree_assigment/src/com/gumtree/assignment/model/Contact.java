package com.gumtree.assignment.model;

import java.util.Date;

/**
 * Created by Dilyan B on 14-5-22.
 */
public class Contact {
    private String name;
    private String gender;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
