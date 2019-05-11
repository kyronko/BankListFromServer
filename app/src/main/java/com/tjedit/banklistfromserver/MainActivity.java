package com.tjedit.banklistfromserver;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tjedit.banklistfromserver.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {
    ActivityMainBinding act;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setupValues() {

    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this , R.layout.activity_main);
    }
}
