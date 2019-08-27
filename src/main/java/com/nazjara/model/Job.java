package com.nazjara.model;

import java.io.Serializable;

public class Job implements Serializable {
    private final static long serialVersionUID = 1L;

    private String title;
    private String company;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
