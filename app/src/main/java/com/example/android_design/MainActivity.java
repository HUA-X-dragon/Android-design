package com.example.android_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg1;
    private RadioButton rgb1;
    private RadioButton rgb2;
    private RadioButton rgb3;
    private RadioButton rgb4;

    private FragmentManager fManager;
    private Fragment_appearance fg1;
    private Fragment_test fg2, fg3, fg4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        rgb1 = (RadioButton)findViewById(R.id.radioButton);
        rgb2 = (RadioButton)findViewById(R.id.radioButton2);
        rgb3 = (RadioButton)findViewById(R.id.radioButton3);
        rgb4 = (RadioButton)findViewById(R.id.radioButton4);

        RadioButton[] rbs = new RadioButton[4];
        rbs[0] =rgb1;
        rbs[1] =rgb2;
        rbs[2] =rgb3;
        rbs[3] =rgb4;
        for (RadioButton rb : rbs) {
            //挨着给每个RadioButton加入drawable限制边距以控制显示大小
            Drawable[] drawables = rb.getCompoundDrawables();
            //获取drawables
            Rect r = new Rect(0, 0, drawables[1].getMinimumWidth()*2/8, drawables[1].getMinimumHeight()* 2/8);
            //定义一个Rect边界
            drawables[1].setBounds(r);
            rb.setCompoundDrawables(null,drawables[1],null,null);
        }

        fManager = getSupportFragmentManager();
        rg1 = (RadioGroup)findViewById(R.id.radiogroup);
        rgb1.setChecked(true);


        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction fTransaction = fManager.beginTransaction();
                hideAllFragment(fTransaction);
                switch (checkedId){
                    case R.id.radioButton:
                        if(fg1 == null){
                            fg1 = new Fragment_appearance();
                            fTransaction.add(R.id.ly_content,fg1);
                        }else{
                            fTransaction.show(fg1);
                        }
                        break;
                    case R.id.radioButton2:
                        if(fg2 == null){
                            fg2 = new Fragment_test("戏乐");
                            fTransaction.add(R.id.ly_content,fg2);
                        }else{
                            fTransaction.show(fg2);
                        }
                        break;
                    case R.id.radioButton3:
                        if(fg3 == null){
                            fg3 = new Fragment_test("戏商城");
                            fTransaction.add(R.id.ly_content,fg3);
                        }else{
                            fTransaction.show(fg3);
                        }
                        break;
                    case R.id.radioButton4:
                        if(fg4 == null){
                            fg4 = new Fragment_test("我的");
                            fTransaction.add(R.id.ly_content,fg4);
                        }else{
                            fTransaction.show(fg4);
                        }
                        break;
                }
                fTransaction.commit();
            }
        });
    }
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg4 != null)fragmentTransaction.hide(fg4);
    }

}