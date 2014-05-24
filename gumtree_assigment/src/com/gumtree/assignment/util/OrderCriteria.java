package com.gumtree.assignment.util;

/**
 * Created by Dilyan B. on 14-5-24.
 */
public class OrderCriteria {
    private String Name;
    private int orderMode;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getOrderMode() {
        return orderMode;
    }

    public void setOrderMode(int orderMode) {
        this.orderMode = orderMode;
    }
}
