package utils.http;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.request.PostRequest;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class okgo {

    public static void init(Application app) {
        OkGo.getInstance().init(app);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //全局的读取超时时间
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        //全局的写入超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        //全局的连接超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        HttpsUtils.SSLParams sslParams1 = HttpsUtils.getSslSocketFactory();
        builder.sslSocketFactory(sslParams1.sSLSocketFactory, sslParams1.trustManager);
        OkGo.getInstance().init(app)                       //必须调用初始化
                .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置将使用默认的
                .setRetryCount(3);                              //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
    }

    public static void get(String url, Object s, Map<String, String> params, JsonCallback callback) {
        OkGo.<String>get(url)
                .tag(s)
                .params(params)
                .execute(callback);
    }

    public static void post(String url, Object s, Map<String, String> params, JsonCallback callback) {
        OkGo.<String>post(url)
                .tag(s)
                .params(params)
                .execute(callback);
    }

    public static void upload(String url, Object s, Map<String, String> params, Map<String, File> files, JsonCallback callback) {
        PostRequest<String> okgo = OkGo.<String>post(url)
                .tag(s)
                .params(params);
        for (Map.Entry<String, File> entry : files.entrySet()) {
            okgo.params(entry.getKey(), entry.getValue());
        }
        okgo.execute(callback);
    }
    // 下载（大多APP内，不做下载；通常调用浏览器下载-断点续传、缓存、限速）
    public static void download() {

    }

    public static void cancel(Object tag) {
        OkGo.getInstance().cancelTag(tag);
    }


}
