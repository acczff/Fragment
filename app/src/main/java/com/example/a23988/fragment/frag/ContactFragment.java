package com.example.a23988.fragment.frag;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a23988.fragment.R;
import com.example.a23988.fragment.adapter.PagerContactAdapter;
import com.example.a23988.fragment.frag.ContactSonFragment.BookFragment;
import com.example.a23988.fragment.frag.ContactSonFragment.DeviceFragment;
import com.example.a23988.fragment.frag.ContactSonFragment.FriendFragmen;
import com.example.a23988.fragment.frag.ContactSonFragment.GroupFragment;
import com.example.a23988.fragment.frag.ContactSonFragment.PublicFragment;

import utils.app.BaseFragment;

public class ContactFragment extends BaseFragment {
    private ImageView iv_head;
    private TextView tv_more;
    private ViewPager vp;
    private TabLayout tl;
    private BaseFragment[] frags;
    private String[] str;
    @Override
    protected View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.frag_contact,container,false);
        vp = view.findViewById(R.id.vp);
        tl = view.findViewById(R.id.tl);

        return view;
    }

    @Override
    protected void initData() {
        frags = new BaseFragment[]{new BookFragment(),new DeviceFragment(),new FriendFragmen(),new GroupFragment(),new PublicFragment()};
        str = new String[]{"好友","群聊","设备","通讯录","公众号"};

        PagerContactAdapter adapter = new PagerContactAdapter(getChildFragmentManager(),frags,str);
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(frags.length - 1);

        tl.setSelectedTabIndicatorColor(Color.BLACK);
        tl.setSelectedTabIndicatorHeight(10);
        tl.setTabMode(TabLayout.MODE_SCROLLABLE);
        tl.setupWithViewPager(vp,true);
    }

    @Override
    protected void initListener() {

    }
}
