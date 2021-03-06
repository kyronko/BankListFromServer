package com.tjedit.banklistfromserver;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tjedit.banklistfromserver.adapters.BankAdapter;
import com.tjedit.banklistfromserver.databinding.ActivityMainBinding;
import com.tjedit.banklistfromserver.datas.Bank;
import com.tjedit.banklistfromserver.utils.ConnectServer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    ActivityMainBinding act;
    List<Bank> bankList = new ArrayList<>();
    BankAdapter bankAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        setupEvents();
        setupValues();

    }

    @Override
    public void setupEvents() {
    act.serverBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });
    }

    @Override
    public void setupValues() {
    bankAdapter = new BankAdapter(mContext,bankList);
    act.bankListView.setAdapter(bankAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ConnectServer.getRequestInfoBank(mContext, new ConnectServer.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
//                    실제로 서버에서 돌아온 응답을 메인 액티비티에서 처리하는 메쏘드
                try {
                    int code = json.getInt("code");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if ( code ==200){
                                Toast.makeText(mContext, "정상적으로 데이터를 가져왔습니다", Toast.LENGTH_SHORT).show();

                                try {
                                    JSONObject data = json.getJSONObject("data");
                                    JSONArray banks = data.getJSONArray("banks");
                                    bankList.clear();

                                    for ( int i = 0; i < banks.length() ; i++){
                                        JSONObject bank = banks.getJSONObject(i);

                                        Bank bankObj = Bank.getBankFromJson(bank);

                                        bankList.add(bankObj);
//                                            String name = bank.getString("name");
//                                            Log.d("은해이름",name);
                                    }
                                    bankAdapter.notifyDataSetChanged();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            else{
                                try {
                                    String message = json.getString("message");
                                    Toast.makeText(mContext, "message", Toast.LENGTH_SHORT).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this , R.layout.activity_main);
    }
}
