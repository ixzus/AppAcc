package com.eeepay.modulebase.widget.kb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;


import com.eeepay.modulebase.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ixzus
 */
public class KeyboardView extends RelativeLayout {

    Context mContext;
    private GridView mGridView;
    private ArrayList<Map<String, String>> valueList;

    public KeyboardView(Context context) {
        this(context, null);
    }

    public KeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        View view = View.inflate(context, R.layout.wd_kb_num, null);
        valueList = new ArrayList<>();

        mGridView = (GridView) view.findViewById(R.id.gv_keybord);

        initValueList();
        setView();
        addView(view);
    }

    private void initValueList() {
        //初始化按钮上的数字
        for (int i = 1; i < 13; i++) {
            Map<String, String> map = new HashMap<>();
            if (i < 10) {
                map.put("name", i + "");
            } else if (i == 11) {
                map.put("name", "0");
            } else {
                map.put("name", "");
            }
            valueList.add(map);
        }
    }

    private void setView() {

        KeyBoardAdapter adapter = new KeyBoardAdapter(mContext, valueList);
        mGridView.setAdapter(adapter);

    }


    public ArrayList<Map<String, String>> getValueList() {
        return valueList;
    }

    public GridView getGridView() {
        return mGridView;
    }

}
