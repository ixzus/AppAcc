package com.eeepay.awdiget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.eeepay.awdiget.demo.XYZActivity;
import com.eeepay.awdiget.hencoder.Practice1Activity;
import com.eeepay.awdiget.hencoder.Practice2Activity;
import com.eeepay.awdiget.hencoder.Practice3Activity;
import com.eeepay.awdiget.hencoder.Practice6Activity;
import com.eeepay.awdiget.hencoder.Practice7Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hencoder
        findViewById(R.id.pratice1).setOnClickListener(this);
        findViewById(R.id.pratice2).setOnClickListener(this);
        findViewById(R.id.pratice3).setOnClickListener(this);
        findViewById(R.id.pratice6).setOnClickListener(this);
        findViewById(R.id.pratice7).setOnClickListener(this);
        findViewById(R.id.customview).setOnClickListener(this);

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
            case R.id.pratice6:
                startActivity(new Intent(this, Practice6Activity.class));
                break;
            case R.id.pratice7:
                startActivity(new Intent(this, Practice7Activity.class));
                break;
            case R.id.customview:
                startActivity(new Intent(this, XYZActivity.class));
                break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        return super.dispatchTouchEvent(ev);
    }


}
