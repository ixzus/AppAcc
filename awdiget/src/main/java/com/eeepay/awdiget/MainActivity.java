package com.eeepay.awdiget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.eeepay.awdiget.hencoder.Practice1Activity;
import com.eeepay.awdiget.hencoder.Practice2Activity;
import com.eeepay.awdiget.hencoder.Practice3Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.pratice1).setOnClickListener(this);
        findViewById(R.id.pratice2).setOnClickListener(this);
        findViewById(R.id.pratice3).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pratice1:
                startActivity(new Intent(this, Practice1Activity.class));
                break;
            case R.id.pratice2:
                startActivity(new Intent(this, Practice2Activity.class));
                break;
            case R.id.pratice3:
                startActivity(new Intent(this, Practice3Activity.class));
                break;
        }
    }
}
