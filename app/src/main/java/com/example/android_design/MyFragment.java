package com.example.android_design;

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
        itemList.add(new Recycler_item(R.mipmap.bottom1, "1"));
        itemList.add(new Recycler_item(R.mipmap.bottom2, "2"));
        itemList.add(new Recycler_item(R.mipmap.bottom3, "3"));
        itemList.add(new Recycler_item(R.mipmap.appearance_1, "3"));
        itemList.add(new Recycler_item(R.mipmap.appearance_1, "3"));
        itemList.add(new Recycler_item(R.mipmap.bottom3, "3"));
        itemList.add(new Recycler_item(R.mipmap.bottom3, "3"));
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
                Toast.makeText(getActivity(),"我是item",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
