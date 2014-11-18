package com.yan.wang.spring.ws;

import java.util.Date;

/**
 * Created by ywang on 18.11.14.
 */
public class Employee {
    private static final long serialVersionUID = -7788619177798333712L;
    private int id;
    private String name;
    private Date createdDate;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
