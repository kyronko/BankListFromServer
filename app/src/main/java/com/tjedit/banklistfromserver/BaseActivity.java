package com.tjedit.banklistfromserver;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext = this;

    public abstract  void setupEvents();
    public abstract  void setupValues();
    public abstract  void bindViews();

}
