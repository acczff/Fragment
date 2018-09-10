package com.example.a23988.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.a23988.fragment.adapter.RcNewsOpenAdapter;
import com.example.a23988.fragment.bean.RcData;
import com.example.a23988.fragment.dao.RcDataDao;

import java.util.List;

import utils.app.BaseActivity;

public class OpenActivity extends BaseActivity {

    private RecyclerView rc_open;

    @Override
    public int getLayoutId() {
        return R.layout.activity_news_open;
    }

    @Override
    protected void initView() {
        rc_open = findViewById(R.id.rc);
    }

    @Override
    protected void initData() {
        RcDataDao dao = new RcDataDao();
        List<RcData> listclose = dao.FindCloseShow();
        List<RcData> listopen = dao.FindOpenShow();
        RcNewsOpenAdapter adapter = new RcNewsOpenAdapter(listclose,listopen);
        rc_open.setLayoutManager(new LinearLayoutManager(base));
        rc_open.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }
}
