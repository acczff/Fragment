package com.example.a23988.fragment.bean;



import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class group_info extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private RealmList<people_info> friends;

    public group_info() {
    }

    public group_info(int id, String name, RealmList<people_info> friends) {
        this.id = id;
        this.name = name;
        this.friends = friends;
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

    public RealmList<people_info> getFriends() {
        return friends;
    }

    public void setFriends(RealmList<people_info> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(people_info p : friends)
        {
            sb.append((p.toString()));
            sb.append('\n');
        }
        return "group_info{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", friends=" + '\n'
                +sb.toString()+
                '}';
    }

}
