package com.example.ixzus.acc.widget;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;


import com.eeepay.modulebase.widget.dialog.AbsDialog;
import com.eeepay.modulebase.widget.dialog.ViewHolder;
import com.example.ixzus.acc.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConfirmDialog extends AbsDialog {
    private String type;
    private List<String> listInfo;

    public static ConfirmDialog newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        ConfirmDialog dialog = new ConfirmDialog();
        dialog.setArguments(bundle);
        return dialog;
    }

    public static ConfirmDialog newInstance(String type, ArrayList<String> listInfo) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        bundle.putStringArrayList("listInfo", listInfo);
        ConfirmDialog dialog = new ConfirmDialog();
        dialog.setArguments(bundle);
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        type = bundle.getString("type");
        listInfo = bundle.getStringArrayList("listInfo");
        if (savedInstanceState != null) {
            confirmOkListener = (ConfirmOkListener) savedInstanceState.getSerializable("confirmOkListener");
            confirmCancelListener = (ConfirmCancelListener) savedInstanceState.getSerializable("confirmCancelListener");
        }
    }

    @Override
    public void onPause() {
        dismiss();
        super.onPause();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("confirmOkListener", confirmOkListener);
        outState.putSerializable("confirmCancelListener", confirmCancelListener);
    }

    @Override
    public int intLayoutId() {
        return R.layout.wd_dialog_confirm;
    }

    @Override
    public void convertView(final ViewHolder viewHolder, final AbsDialog dialog) {
        viewHolder.setOnClickListener(R.id.cancel, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmCancelListener.convertView(viewHolder, dialog);
            }
        });

        viewHolder.setOnClickListener(R.id.ok, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmOkListener.convertView(viewHolder, dialog);
            }
        });

        if ("1".equals(type)) {
            viewHolder.setText(R.id.title, "提示");
            viewHolder.setText(R.id.message, "您已支付成功！");
        } else if ("2".equals(type)) {
            viewHolder.setText(R.id.title, "警告");
            viewHolder.setText(R.id.message, "您的账号已被冻结！");
            viewHolder.setText(R.id.ok, "立即修改");
            viewHolder.setText(R.id.cancel, "取消");
        } else if ("3".equals(type)) {
            //退出登录
            viewHolder.setText(R.id.title, "提示");
            viewHolder.setText(R.id.message, "您确定要退出登录吗？");
            viewHolder.setText(R.id.ok, "确定");
            viewHolder.setText(R.id.cancel, "取消");
        }


        if ("确认订单".equals(type)) {
            String str = "您已选择" + listInfo.get(0) + "辆车,共计" + listInfo.get(1) + "条违章\n罚款总额" + listInfo.get(2) + "元\n您确认接单吗？";
            Spannable span = new SpannableString(str);
            span.setSpan(new ForegroundColorSpan(Color.parseColor("#508CEE")), str.length() - 7, str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            viewHolder.setText(R.id.title, "温馨提示");
//            viewHolder.setText(R.id.message, str);
            ((TextView) viewHolder.getView(R.id.message)).setText(span);
            viewHolder.setText(R.id.ok, "确认接单");
            viewHolder.setText(R.id.cancel, "取消");
        }
        if ("上传凭证".equals(type)) {
            viewHolder.setText(R.id.title, "温馨提示");
            viewHolder.setText(R.id.message, "确认上传吗！");
            viewHolder.setText(R.id.ok, "确认");
            viewHolder.setText(R.id.cancel, "取消");
        }

        if ("版本更新".equals(type)) {
            viewHolder.setText(R.id.title, "温馨提示");
            viewHolder.setText(R.id.message, listInfo.get(1));
            viewHolder.setText(R.id.ok, "升级");
            viewHolder.setText(R.id.cancel, listInfo.get(0));
        }

    }

    private ConfirmOkListener confirmOkListener;

    public interface ConfirmOkListener extends Serializable {
        long serialVersionUID = System.currentTimeMillis();

        void convertView(ViewHolder holder, AbsDialog dialog);
    }

    private ConfirmCancelListener confirmCancelListener;

    public interface ConfirmCancelListener extends Serializable {
        long serialVersionUID = System.currentTimeMillis();

        void convertView(ViewHolder holder, AbsDialog dialog);
    }

    public ConfirmDialog setConfirmOkListener(ConfirmOkListener confirmOkListener) {
        this.confirmOkListener = confirmOkListener;
        return this;
    }

    public ConfirmDialog setConfirmCancelListener(ConfirmCancelListener confirmCancelListener) {
        this.confirmCancelListener = confirmCancelListener;
        return this;
    }
}