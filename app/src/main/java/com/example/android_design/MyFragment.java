package com.example.android_design;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MyFragment extends Fragment {
    private View view;//定义view用来设置fragment的layout
    public RecyclerView recyclerView;//定义RecyclerView
    private ArrayList<Recycler_item> itemList = new ArrayList<Recycler_item>();
    private RecyclerAdapter recyclerAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fg_content, container, false);
        initRecyclerView();
        initData();
        return view;
    }

    private void initData() {
        itemList.add(new Recycler_item(R.mipmap.item_video1, "浙江少儿戏剧团《三岔口》精彩片段，超级好看", 1));
        itemList.add(new Recycler_item(R.mipmap.item_video2, "浙江少儿戏剧团《三岔口》精彩片段，超级好看", 2));
        itemList.add(new Recycler_item(R.mipmap.item_video8, "浙江少儿戏剧团《三岔口》精彩片段，超级好看", 3));
        itemList.add(new Recycler_item(R.mipmap.item_video4, "浙江少儿戏剧团《三岔口》精彩片段，超级好看", 4));
        itemList.add(new Recycler_item(R.mipmap.item_video5, "浙江少儿戏剧团《三岔口》精彩片段，超级好看", 5));
        itemList.add(new Recycler_item(R.mipmap.item_video9, "3", 6));
        itemList.add(new Recycler_item(R.mipmap.item_video7, "3", 7));
    }
    private void initRecyclerView() {
        //获取RecyclerView
        recyclerView=(RecyclerView) view.findViewById(R.id.recycler_v);
        //创建adapter
        recyclerAdapter = new RecyclerAdapter(getActivity(), itemList);
        //给RecyclerView设置adapter
        recyclerView.setAdapter(recyclerAdapter);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //设置item的分割线
        recyclerView.addItemDecoration(new SpacesItemDecoration(16));
        //RecyclerView中没有item的监听事件，需要自己在适配器中写一个监听事件的接口。参数根据自定义
        recyclerAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Recycler_item data) {
//                Toast.makeText(getActivity(),"我是item",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(getActivity(), Activity_video.class);
                Bundle bd = new Bundle();
                bd.putInt("id", data.getId());
                intent.putExtras(bd);
                getActivity().startActivity(intent);
            }
        });
    }

}
