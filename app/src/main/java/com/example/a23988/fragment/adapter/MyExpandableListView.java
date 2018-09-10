package com.example.a23988.fragment.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a23988.fragment.R;
import com.example.a23988.fragment.bean.group_info;

import java.util.List;

public class MyExpandableListView extends BaseExpandableListAdapter {

    List<group_info> data;

    public MyExpandableListView(List<group_info> data) {
        this.data = data;
    }

    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return data.get(i).getFriends().size();
    }

    @Override
    public Object getGroup(int i) {
        return data.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return data.get(i).getFriends().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if(view == null){
            view = View.inflate(viewGroup.getContext(), R.layout.act_msg_group,null);
        }
        TextView tv = view.findViewById(R.id.group_tv);
        tv.setText(data.get(i).getName());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if(view == null){
            view = View.inflate(viewGroup.getContext(),R.layout.act_msg_people,null);
        }
        TextView tv = view.findViewById(R.id.people_tv);
        ImageView im = view.findViewById(R.id.people_iv);
        tv.setText(data.get(i).getFriends().get(i1).getName());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
