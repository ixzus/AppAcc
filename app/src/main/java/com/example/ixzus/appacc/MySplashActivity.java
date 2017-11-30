package com.example.ixzus.appacc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MySplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_splash);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test(view);
            }
        });
    }

    @TestAnnoTrace(value = "aaaaaaaa", type = 1)
    @SingleClick
    public void test(View view) {
        System.out.println("test click");
    }
}
