package com.tjedit.banklistfromserver;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tjedit.banklistfromserver.databinding.ActivityMainBinding;
import com.tjedit.banklistfromserver.utils.ConnectServer;

public class MainActivity extends BaseActivity {
    ActivityMainBinding act;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setupEvents() {
    act.serverBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ConnectServer.getRequestInfoBank(mContext,null);
        }
    });
    }

    @Override
    public void setupValues() {

    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this , R.layout.activity_main);
    }
}
