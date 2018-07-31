package com.example.testweb;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniUi();
    }

    private void iniUi() {
        button = findViewById(R.id.button_test);
        textView = findViewById(R.id.text_test);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        new TestTask().execute();
    }

    private class TestTask extends AsyncTask<Void,Void,String>{
        String str;

        @Override
        protected String doInBackground(Void... voids) {
            return testHTTP.getJSON();
        }

        @Override
        protected void onPostExecute(String s) {
            textView.setText(s);
        }
    }

}
