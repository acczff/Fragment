package com.example.a23988.fragment.frag;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a23988.fragment.OpenActivity;
import com.example.a23988.fragment.R;
import com.example.a23988.fragment.adapter.RcNewsAdapter;
import com.example.a23988.fragment.bean.RcData;
import com.example.a23988.fragment.dao.RcDataDao;

import java.util.List;

import utils.app.BaseFragment;

public class NewsFragment extends BaseFragment {

    private ImageView iv_head;
    private TextView tv_more;
    private RecyclerView rc;

    @Override
    protected View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.frag_news, container, false);
        iv_head = view.findViewById(R.id.iv_head);
        tv_more = view.findViewById(R.id.tv_more);
        rc = view.findViewById(R.id.rc);
        return view;
    }

    @Override
    protected void initData() {
        RcDataDao dao = new RcDataDao();
        List<RcData> data = dao.FindCloseShow();
        RcNewsAdapter adapter = new RcNewsAdapter(data);
        rc.setLayoutManager(new LinearLayoutManager(act));
        rc.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        tv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),OpenActivity.class);
                startActivity(intent);

            }
        });
    }


}
