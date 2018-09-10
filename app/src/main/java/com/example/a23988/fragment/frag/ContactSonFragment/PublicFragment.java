package com.example.a23988.fragment.frag.ContactSonFragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import utils.app.BaseFragment;

public class PublicFragment extends BaseFragment{
    @Override
    protected View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        TextView tv = new TextView(container.getContext());
        tv.setText(getClass().getSimpleName());
        tv.setTextSize(18);
        return tv;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
