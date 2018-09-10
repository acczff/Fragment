package utils.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import utils.http.okgo;

public abstract class BaseActivity extends AppCompatActivity {

    protected Activity base;
    private SharedPreferences sp;
    protected Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        base = this;
        sp = getSharedPreferences("MyAndroid", MODE_PRIVATE);
        Log.e("=",""+getLayoutId());
        setContentView(getLayoutId());
        initView();
        initData();
        initListener();
    }

    public abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    protected void saveSP(String key, String value) {
        sp.edit().putString(key, value).apply();
    }

    protected String getSP(String key, String def) {
        return sp.getString(key, def);
    }

    protected void Activity_skip(Class<? extends BaseActivity> cs, String... s) {
        Intent it = new Intent(this, cs);
        for (int i = 0; i < s.length; i++) {
            it.putExtra(String.valueOf(i), s[i]);
        }
        startActivity(it);
    }

    protected String getDataFromIntent(int i) {
        Intent intent = base.getIntent();
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
                Toast.makeText(base, str, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        okgo.cancel(this); // 取消当前Activity内的网络请求（要求是每次请求的tag为this）
        handler.removeCallbacksAndMessages(null); // 取消handler任务
        super.onDestroy();
    }

}
