package com.example.okhttpdemo;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class TestRequestTask extends AsyncTask<Object, Void, Void> {

    private ActionCompletedListener listener;

    public TestRequestTask(ActionCompletedListener listener) {
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(Object... params) {
        try {
            String response = MakeAPICall("http://4382438bf923.ngrok.io/late", "Hello world");
            listener.callback(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String MakeAPICall(String url, String requestBody) throws IOException {
        final OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        final OkHttpClient okHttpClient = okHttpClientBuilder
                .callTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();

        final Request.Builder builder = new Request
                .Builder()
                .url(url)
                .post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), requestBody));

        final ResponseBody result = okHttpClient.newCall(builder.build()).execute().body();
        if (result != null) {
            return result.string();
        }

        return null;
    }
}
