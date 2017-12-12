package com.eeepay.modulebase.widget.kb;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.eeepay.modulebase.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * ixzus
 */
public class KeyBoardAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Map<String, String>> valueList;

    public KeyBoardAdapter(Context context, ArrayList<Map<String, String>> valueList) {
        mContext = context;
        this.valueList = valueList;
    }

    @Override
    public int getCount() {
        return valueList.size();
    }

    @Override
    public Object getItem(int position) {
        return valueList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.wd_kb_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position == 9) {
            holder.imgDelete.setVisibility(View.GONE);
            holder.btnKeys.setVisibility(View.VISIBLE);
            holder.btnKeys.setBackgroundColor(Color.parseColor("#d7d8dc"));
        } else if (position == 11) {
            holder.btnKeys.setBackgroundColor(Color.parseColor("#d7d8dc"));
            holder.imgDelete.setVisibility(View.VISIBLE);
            holder.btnKeys.setVisibility(View.VISIBLE);
        } else {
            holder.imgDelete.setVisibility(View.GONE);
            holder.btnKeys.setVisibility(View.VISIBLE);
            holder.btnKeys.setText(valueList.get(position).get("name"));

        }
        return convertView;
    }

    static class ViewHolder {
        TextView btnKeys;
        RelativeLayout imgDelete;

        ViewHolder(View view) {
            btnKeys = (TextView) view.findViewById(R.id.btn_keys);
            imgDelete = view.findViewById(R.id.imgDelete);
        }
    }
}
