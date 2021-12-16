package com.example.android_design;

import java.io.Serializable;

public class Recycler_item implements Serializable {

    private int Icon;
    private String mTitle;

    public Recycler_item() {
    }

    public Recycler_item(int icon, String mTitle) {
        Icon = icon;
        this.mTitle = mTitle;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
