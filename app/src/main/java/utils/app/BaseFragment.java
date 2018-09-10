package utils.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import utils.http.okgo;

public abstract class BaseFragment extends Fragment {

    protected Handler handler = new Handler();
    protected FragmentActivity act; // act = this;? 上下文环境还没有搭建起来，导致this中某些东西为null
    private SharedPreferences sp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        act = getActivity();
        sp = getContext().getSharedPreferences(AppContent.SP_NAME, Context.MODE_PRIVATE);
        View view =initView(inflater,container);


        initData();
        initListener();

        return view;
    }

    protected abstract View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container);

    protected abstract void initData();

    protected abstract void initListener();

    protected void saveSP(String key, String value) {
        sp.edit().putString(key, value).apply();
    }

    protected String getSP(String key, String def) {
        return sp.getString(key, def);
    }

    protected void Activity_skip(Class<? extends BaseActivity> cs,String... s){
        Intent it = new Intent(act,cs);
        for(int i = 0; i < s.length;i++){
            it.putExtra(String.valueOf(i),s[i]);
        }
        startActivity(it);
    }

    protected String getDataFromIntent(int i) {
        Intent intent = act.getIntent();
        if (intent == null)
            return null;
        return intent.getStringExtra(String.valueOf(i));
    }


    // 进度提示弹窗的弹出
    protected void showDialog() {
        // TODO: 18/07/25 025
    }

    // 进度提示弹窗的隐藏
    protected void dismissDialog() {
        // TODO: 18/07/25 025
    }


    // 封装Toast（可兼容子线程）
    protected void showToast(final CharSequence str) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(act, str, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onDestroy() {
        okgo.cancel(this); // 取消当前Activity内的网络请求（要求是每次请求的tag为this）
        handler.removeCallbacksAndMessages(null); // 取消handler任务
        super.onDestroy();
    }


}
