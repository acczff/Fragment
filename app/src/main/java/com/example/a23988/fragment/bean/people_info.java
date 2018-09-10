package com.example.a23988.fragment.bean;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class people_info extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private String headUrl;

    public people_info() {
    }

    public people_info(int id, String name, String headUrl) {
        this.id = id;
        this.name = name;
        this.headUrl = headUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    @Override
    public String toString() {
        return "people_info{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headUrl='" + headUrl + '\'' +
                '}';
    }
}
