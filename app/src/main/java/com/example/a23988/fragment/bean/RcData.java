package com.example.a23988.fragment.bean;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RcData extends RealmObject{
    @PrimaryKey
    private int id;
    private String name;
    private String imge;
    private String isopen;

    public RcData() {
    }

    public RcData(int id, String name, String imge, String isopen) {
        this.id = id;
        this.name = name;
        this.imge = imge;
        this.isopen = isopen;
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

    public String getImge() {
        return imge;
    }

    public void setImge(String imge) {
        this.imge = imge;
    }

    public String getIsopen() {
        return isopen;
    }

    public void setIsopen(String isopen) {
        this.isopen = isopen;
    }
}
