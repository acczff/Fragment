package com.example.a23988.fragment.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a23988.fragment.R;
import com.example.a23988.fragment.bean.RcData;
import com.example.a23988.fragment.dao.RcDataDao;

import java.util.List;

public class RcNewsOpenAdapter extends RecyclerView.Adapter<RcNewsOpenAdapter.BaseViewHoudler>{

    private final int TYPE_HEAD = 1;
    private final int TYPE_BEAN = 2;
    private List<RcData> listclose;
    private List<RcData> listopen;
    private RcDataDao dao;

    public RcNewsOpenAdapter(List<RcData> listclose, List<RcData> listopen) {
        this.listclose = listclose;
        this.listopen = listopen;
        dao = new RcDataDao();
    }

    @NonNull
    @Override
    public BaseViewHoudler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        BaseViewHoudler vh = null;
        switch (i){
            case TYPE_BEAN:
                View v1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_news_more_item,viewGroup,false);
                    vh = new BeanViewHoudler(v1);
                break;
            case  TYPE_HEAD:
                View v2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_news_more_head,viewGroup,false);
                    vh = new HeadViewHoudler(v2);
                break;
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHoudler baseViewHoudler, int i) {
        if(baseViewHoudler instanceof BeanViewHoudler){
            BeanViewHoudler vh = (BeanViewHoudler) baseViewHoudler;
            if(i < 1 + listclose.size()){
                RcData data = listclose.get(i - 1);
                vh.setData(data);
            }else if(i >= 2 + listclose.size()){
                RcData data = listopen.get(i - 2 - listclose.size());
                vh.setData(data);
            }
        }else if(baseViewHoudler instanceof HeadViewHoudler){
            HeadViewHoudler vh = (HeadViewHoudler) baseViewHoudler;
            vh.setData(i);
        }
    }

    @Override
    public int getItemCount() {
        return listclose.size() + listopen.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_HEAD;
        }else if(position < 1 + listclose.size()){
            return TYPE_BEAN;
        }else if(position == 1 + listclose.size()){
            return TYPE_HEAD;
        }else{
            return TYPE_BEAN;
        }
    }

    class BaseViewHoudler extends RecyclerView.ViewHolder {
        BaseViewHoudler(@NonNull View itemView) {
            super(itemView);
        }
    }

    
    public class HeadViewHoudler extends BaseViewHoudler {

        private TextView tv_more_head;
        public HeadViewHoudler(@NonNull View itemView) {
            super(itemView);
            tv_more_head = itemView.findViewById(R.id.tv_more_head);
        }

        public void setData(int i){
            if(i == 0){
                tv_more_head.setText("未开启的功能");
            }else{
                tv_more_head.setText("开启的功能");
            }
        }

    }

    public class BeanViewHoudler extends BaseViewHoudler {

        private ImageView iv_more_head;
        private TextView tv_more_name;
        private Button bt_more_open;
        private RcData data;
        public BeanViewHoudler(@NonNull View itemView) {
            super(itemView);
            iv_more_head = itemView.findViewById(R.id.iv_more_head);
            tv_more_name = itemView.findViewById(R.id.tv_more_name);
            bt_more_open = itemView.findViewById(R.id.bt_more_open);
            bt_more_open.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(view == bt_more_open){
                        data.setIsopen("0".equals(data.getIsopen()) ? "1" : "0");
                        dao.updata(data);
                        listclose.clear();
                        listopen.clear();
                        listclose.addAll(dao.FindCloseShow());
                        listopen.addAll(dao.FindOpenShow());
                        notifyDataSetChanged();
                    }
                }
            });
        }
        public void setData(RcData data){
            this.data = data;
            tv_more_name.setText(data.getName());
            if("0".equals(data.getIsopen())){
                bt_more_open.setText("开启");
            }else{
                bt_more_open.setText("关闭");
            }
        }
    }

}
