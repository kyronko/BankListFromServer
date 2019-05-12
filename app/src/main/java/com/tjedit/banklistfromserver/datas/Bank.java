package com.tjedit.banklistfromserver.datas;

import org.json.JSONException;
import org.json.JSONObject;

public class Bank {

    public int id;
    public  String code;
    public  String name;
    public  String  logo;
//    JSON -> Bank 클래스로 전환해주는 코드.

    public  static  Bank getBankFromJson(JSONObject bankJson){

        Bank bankObject = new Bank();

        try {
            bankObject.id = bankJson.getInt("id");
            bankObject.code = bankJson.getString("code");
            bankObject.name = bankJson.getString("name");
            bankObject.logo = bankJson.getString("log");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  bankObject;

    }

}
