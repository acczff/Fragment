package com.example.a23988.fragment.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a23988.fragment.R;
import com.example.a23988.fragment.bean.RcData;

import java.util.List;

public class RcNewsAdapter extends  RecyclerView.Adapter<RcNewsAdapter.ViewHoudler>{

    private List<RcData> listData;
    public RcNewsAdapter(List<RcData> listData){
            this.listData = listData;
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
    @NonNull
    @Override
    public ViewHoudler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frag_item_news,viewGroup,false);

        return new ViewHoudler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoudler viewHoudler, int i) {
        RcData data = listData.get(i);
        viewHoudler.setData(data);
    }


    public class ViewHoudler extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView tv;
        public ViewHoudler(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
        public void setData(RcData data){
            tv.setText(data.getName());
        }
    }
}
