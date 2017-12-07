package com.eeepay.awdiget.hencoder;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.eeepay.awdiget.R;
import com.eeepay.awdiget.hencoder.practice1.OSVersion;
import com.eeepay.awdiget.hencoder.practice1.Practice10HistogramView;
import com.eeepay.awdiget.hencoder.practice1.Practice11PieChartView;
import com.eeepay.awdiget.hencoder.practice1.Sample06KeyframeView;

import java.util.ArrayList;
import java.util.List;

public class Practice1Activity extends AppCompatActivity {

    private Sample06KeyframeView keyframeView;
    private Practice11PieChartView chartView;
    private Practice10HistogramView histogramView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice1);
        keyframeView = findViewById(R.id.aaview);
        chartView = findViewById(R.id.bing);
        histogramView = findViewById(R.id.zhu);

        keyframeView.setData(0, 65);
        chartView.setListData(initData());
        histogramView.setListData(initData());

    }

    private List<OSVersion> initData() {
        List listData = new ArrayList<>();
        OSVersion bean;
        bean = new OSVersion("Jelly Bean", 5, Color.MAGENTA);
        listData.add(bean);
        bean = new OSVersion("KitKat", 7, Color.GRAY);
        listData.add(bean);
        bean = new OSVersion("Lollipop", 22, Color.GREEN);
        listData.add(bean);
        bean = new OSVersion("Marshmallow", 35, Color.BLUE);
        listData.add(bean);
        bean = new OSVersion("Nougat", 20, Color.RED);
        listData.add(bean);
        bean = new OSVersion("O", 10, Color.YELLOW);
        listData.add(bean);
        bean = new OSVersion("P", 1, Color.WHITE);
        listData.add(bean);
        return listData;
    }
}
