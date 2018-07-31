package com.example.testweb;

import android.net.Uri;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class testHTTP {

    static String getJSON() {
        try {
            String url = Uri.parse("http://194.87.232.210/TestHttp/hs/testhttp")
                    .buildUpon()
                    .appendQueryParameter("action", "getusers")
                    .build().toString();
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            String result = response.body().string();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


