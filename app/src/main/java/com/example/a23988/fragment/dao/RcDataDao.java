package com.example.a23988.fragment.dao;

import com.example.a23988.fragment.bean.RcData;
import com.example.a23988.fragment.bean.group_info;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RcDataDao {

    public List<RcData> FindCloseShow(){

        Realm realm = Realm.getDefaultInstance();
        RealmResults<RcData> results = realm.where(RcData.class).equalTo("isopen","1").findAll();
        List<RcData> result = realm.copyFromRealm(results);
        realm.close();
        return result;
    }

    public List<RcData> FindOpenShow(){

        Realm realm = Realm.getDefaultInstance();
        RealmResults<RcData> results = realm.where(RcData.class).equalTo("isopen","0").findAll();
        List<RcData> result = realm.copyFromRealm(results);
        realm.close();
        return result;
    }

    public void updata(RcData data){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.insertOrUpdate(data);
        realm.commitTransaction();
        realm.close();
    }
    public List<group_info> FindGroup() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<group_info> info = realm.where(group_info.class).findAll();
        List<group_info> data = realm.copyFromRealm(info);
        realm.close();
        return data;
    }
}
