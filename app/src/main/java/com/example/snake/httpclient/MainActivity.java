package com.example.snake.httpclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private Button btnGet;
    private TextView txtSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 화면만들기
        setUpUI();

    }

    private void setUpUI() {
        btnGet = (Button)findViewById(R.id.btnGet);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    MyHttpClient http = new MyHttpClient(getApplicationContext());
                    int nResultCode = http.execute("http://www.naver.com", "GET").get();
                    if(nResultCode == MyHttpClient.REQUEST_FAIL) return;

                    String s = http.getString();
                    txtSource.setText(s);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        txtSource = (TextView)findViewById(R.id.txtSource);


    }
}
