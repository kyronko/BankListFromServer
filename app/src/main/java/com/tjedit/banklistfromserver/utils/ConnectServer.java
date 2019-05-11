package com.tjedit.banklistfromserver.utils;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ConnectServer {
    //    서버근본주소
    private final static String BASE_URL = "http://delivery-dev-389146667.ap-northeast-2.elb.amazonaws.com";

    public interface JsonResponseHandler {
        void onResponse(JSONObject json);
    }


    public static void getRequestInfoBank(Context context, /*   필요한 파라미터용 변수들  */ final JsonResponseHandler handler){

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL+"/info/bank").newBuilder();


        String requestURL = urlBuilder.build().toString();

        Request request = new Request.Builder().url(requestURL).build();

    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String responseContent = response.body().string();

            Log.d("서버응답내용",responseContent);
        }
    });



    }


}
