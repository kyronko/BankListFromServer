package com.tjedit.banklistfromserver.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import com.tjedit.banklistfromserver.R;
import com.tjedit.banklistfromserver.datas.Bank;

import java.util.List;

public class BankAdapter extends ArrayAdapter<Bank> {
    Context mContext;
    List<Bank> mList;
    LayoutInflater inf;

    public BankAdapter(Context context , List<Bank> list){
        super(context, R.layout.bank_list_item,list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }


}
