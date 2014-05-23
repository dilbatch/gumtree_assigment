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

    @Override
    public boolean equals(Object obj){
       if (!(obj instanceof Contact)) return false;
       Contact cont = (Contact)obj;
       if (!cont.getName().equals(name)) return false;
       if (!cont.getGender().equals(gender)) return false;
       if (!cont.getDate().equals(date)) return false;
       return true;
    }
}
