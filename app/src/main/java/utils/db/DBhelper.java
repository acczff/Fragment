package utils.db;

import android.app.Application;

import com.example.a23988.fragment.bean.RcData;
import com.example.a23988.fragment.bean.group_info;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import utils.GsonUtils;
import utils.app.AppContent;

public class DBhelper {

    public static void init(Application app){
        Realm.init(app);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .name(AppContent.APP_NAME)
                .deleteRealmIfMigrationNeeded()
                .initialData(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.insert(new RcData(1, "好友微视", null, "1"));
                        realm.insert(new RcData(2, "同城服务", null, "1"));
                        realm.insert(new RcData(3, "游戏", null, "1"));
                        realm.insert(new RcData(4, "看点", null, "1"));
                        realm.insert(new RcData(5, "京东购物", null, "1"));
                        realm.insert(new RcData(6, "企鹅电竞", null, "0"));
                        realm.insert(new RcData(7, "鹅漫U品", null, "0"));
                        realm.insert(new RcData(8, "动漫", null, "0"));
                        realm.insert(new RcData(9, "阅读", null, "0"));
                        realm.insert(new RcData(10, "音乐", null, "0"));
                        realm.insert(new RcData(11, "直播", null, "0"));
                        realm.insert(new RcData(12, "运动", null, "0"));
                        realm.insert(new RcData(13, "吃喝玩乐", null, "0"));
                        realm.insert(new RcData(14, "腾讯新闻", null, "0"));
                        realm.insert(new RcData(15, "腾讯课堂", null, "0"));
                        String sss = "[{\"id\":1,\"name\":\"好友\",\"friends\":[{\"id\":1,\"name\":\"红猪\",\"headUrl\":\"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d3198678185,878755003\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":2,\"name\":\"黑帽子\",\"headUrl\":\"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d1934952861,3453579486\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":3,\"name\":\"Ara\",\"headUrl\":\"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d3303741086,3211617265\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":4,\"name\":\"Bri\",\"headUrl\":\"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d4233882545,270382672\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"}]},{\"id\":2,\"name\":\"家人\",\"friends\":[{\"id\":5,\"name\":\"苹果\",\"headUrl\":\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d2659519208,2040552462\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":6,\"name\":\"Smoke\",\"headUrl\":\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d3063085903,3230502727\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":7,\"name\":\"BigDog\",\"headUrl\":\"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d2370424667,3031767846\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"}]},{\"id\":3,\"name\":\"XX公司\",\"friends\":[{\"id\":8,\"name\":\"小蜘蛛\",\"headUrl\":\"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d1053771801,4239224829\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":9,\"name\":\"Ali\",\"headUrl\":\"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d3266183129,26862261\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":10,\"name\":\"Logan\",\"headUrl\":\"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d2503440006,744810055\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":11,\"name\":\"Es\",\"headUrl\":\"http://img4.imgtn.bdimg.com/it/u\\u003d2838532421,4231779873\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":12,\"name\":\"SmallCat\",\"headUrl\":\"http://img0.imgtn.bdimg.com/it/u\\u003d2661993305,1199724439\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"}]},{\"id\":4,\"name\":\"客户\",\"friends\":[{\"id\":13,\"name\":\"Mask\",\"headUrl\":\"http://img5.imgtn.bdimg.com/it/u\\u003d1606972337,3987749266\\u0026fm\\u003d200\\u0026gp\\u003d0.jpg\"},{\"id\":14,\"name\":\"SmallCar\",\"headUrl\":\"http://img1.imgtn.bdimg.com/it/u\\u003d2623703544,3858420575\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"}]},{\"id\":5,\"name\":\"新分组\",\"friends\":[]}]";
                        List<group_info> info = GsonUtils.toBean(sss, GsonUtils.newType(List.class, group_info.class));
                        realm.insert(info);
                    }
                })
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
