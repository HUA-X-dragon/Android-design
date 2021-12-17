package com.example.android_design;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_happy extends Fragment {

    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_happy, container, false);
        setView();
        return view;
    }

    private void setView(){
        TextView tv_vr = (TextView) view.findViewById(R.id.tv_vr);
        TextView tv_tcs = (TextView) view.findViewById(R.id.tv_tcs);
        TextView tv_pin = (TextView) view.findViewById(R.id.tv_pin);

        tv_vr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("url", "https://720yun.com/t/f4djr5tkzy3?scene_id=26251191");
                intent.setClass(getActivity(), Activity_webView_vr.class);
                getActivity().startActivity(intent);
            }
        });

        tv_tcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tv_pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
