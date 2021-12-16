package com.example.android_design;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_test extends Fragment {

    private String content;

    public Fragment_test(String content) {
        this.content = content;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_test, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textView_test);
        textView.setText(content);
        return view;
    }
}
