package com.example.android_design;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class Fragment_appearance extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {


    private List<Fragment> list;
    private View view;
    private ViewPager viewPager;
    private Button button01,button02;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_appearance, container, false);
        initView();
        return view;
    }

    private void initView() {
        viewPager=(ViewPager)view.findViewById(R.id.viewpager);

        list=new ArrayList<>();
        button01=(Button)view.findViewById(R.id.button);
        button02=(Button)view.findViewById(R.id.button2);

        button01.setOnClickListener(this);
        button02.setOnClickListener(this);

        //这些界面要也要一个一个先去实现
        list.add(new MyFragment());
        list.add(new Fragment_appearance2());

        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(),list));
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);

    }

    @Override
    public void onClick(View v) {

        initBtnListener();
        switch (v.getId()){
            case R.id.button:
                button01.setBackgroundColor(Color.parseColor("#ff735c"));
                viewPager.setCurrentItem(0);
                break;
            case R.id.button2:
                button02.setBackgroundColor(Color.parseColor("#ff735c"));
                viewPager.setCurrentItem(1);
                break;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        initBtnListener();
        switch (position){
            case 0:
                button01.setBackgroundColor(Color.parseColor("#ff735c"));
                break;
            case 1:
                button02.setBackgroundColor(Color.parseColor("#ff735c"));
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void initBtnListener(){
        button01.setBackgroundColor(Color.parseColor("#ffffff"));
        button02.setBackgroundColor(Color.parseColor("#ffffff"));
    }
}
