package com.example.a23988.fragment.frag;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.a23988.fragment.R;
import com.example.a23988.fragment.adapter.MyExpandableListView;
import com.example.a23988.fragment.adapter.MyPagerAdapter;
import com.example.a23988.fragment.bean.group_info;
import com.example.a23988.fragment.dao.RcDataDao;

import java.util.List;

import utils.app.BaseFragment;

public class MsgFragment extends BaseFragment {

    private RcDataDao dao = new RcDataDao();
    private ViewPager im;
    private ExpandableListView elv;
    private int imgs[] = {R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img4, R.mipmap.img5};

    List<group_info> info;

    @Override
    protected View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.act_msg_main,null);
        im = view.findViewById(R.id.im);
        elv = view.findViewById(R.id.elv);
        info = dao.FindGroup();
        elv.setAdapter(new MyExpandableListView(info));
        im.setAdapter(new MyPagerAdapter(imgs));
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
       im.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View view, MotionEvent motionEvent) {
               switch (motionEvent.getAction()) {
                   case MotionEvent.ACTION_DOWN:
                       handler.removeCallbacks(r);
                       break;
                   case MotionEvent.ACTION_UP:
                   case MotionEvent.ACTION_CANCEL:
                       handler.postDelayed(r,2000);
                       break;
               }
               return false;
           }
       });
    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            im.setCurrentItem(im.getCurrentItem() + 1);
            handler.postDelayed(this,2000);
        }
    };

    @Override
    public void onStart() {
        handler.postDelayed(r,2000);
        super.onStart();
    }

    @Override
    public void onStop() {
        handler.removeCallbacks(r);
        super.onStop();
    }

}
