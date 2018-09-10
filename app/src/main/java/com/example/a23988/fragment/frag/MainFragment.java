package com.example.a23988.fragment.frag;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.a23988.fragment.R;

import utils.app.BaseFragment;

public class MainFragment extends BaseFragment {

    private FrameLayout fl;
    RadioGroup rg;
    private int[] rbIds = {R.id.rb_msg, R.id.rb_contact, R.id.rb_news};
    // 存放已经加载了的frag（工作间）
    private BaseFragment[] frags;
    // 存放要加载的所有的fragment（仓库）
    private BaseFragment[] frags_backup;
    @Override
    protected View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.frag_main,container,false);
        fl = view.findViewById(R.id.fl);
        rg = view.findViewById(R.id.rg);

        return view;
    }

    @Override
    protected void initData() {
        frags_backup = new BaseFragment[]{new MsgFragment(), new ContactFragment(), new NewsFragment()};
        frags = new BaseFragment[3];
    }

    @Override
    protected void initListener() {
        rg.check(R.id.rb_msg); // Bug:触发两次onCheckedChanged
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
              /*  for(int n = 0;n < rbIds.length;n++)
                {
                    if(rbIds[n] != i) continue;
                    changeFragment(n);
                }*/
                switch (i){
                    case R.id.rb_msg:
                        changeFragment(0);
                        break;
                    case R.id.rb_contact:
                        changeFragment(1);
                        break;
                    case R.id.rb_news:
                        changeFragment(2);
                        break;
                }
            }
        });
        rg.check(0);
    }

    private void changeFragment(int i ){
        FragmentTransaction ft =  getChildFragmentManager().beginTransaction();
        for(Fragment frag:frags){
            if(frag != null){
                ft.hide(frag);
            }
        }
        if(frags[i] == null){
            frags[i] = frags_backup[i];
            ft.add(R.id.fl,frags[i]);
            ft.show(frags[i]);
        }else{
            ft.show(frags[i]);
        }
        ft.commit();
    }
}
