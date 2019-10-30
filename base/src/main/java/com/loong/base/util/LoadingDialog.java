package com.loong.base.util;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.loong.base.R;

/**
 * author: Hao
 * date: 2019/9/23 15:45
 * description:
 */
public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context) {
        super(context);
    }

    public LoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected LoadingDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder{
        private Context context;
        private boolean isShowMsg;          //是否显示文字信息
        private boolean isCanceled;         //是否能够被取消
        private boolean isOutSideCancel;    //是否能够点击外部取消
        private String msg;                 //自定义的文字信息

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setShowMsg(boolean isShowMsg) {
            this.isShowMsg = isShowMsg;
            return this;
        }

        public Builder setCanceled(boolean isCanceled) {
            this.isCanceled = isCanceled;
            return this;
        }

        public Builder setOutSideCancel(boolean isOutSideCancel) {
            this.isOutSideCancel = isOutSideCancel;
            return this;
        }

        public Builder setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public LoadingDialog create() {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.loading_ui, null);
            LoadingDialog loadingDialog = new LoadingDialog(context, R.style.CustomDialog);
            TextView msgText = view.findViewById(R.id.tipLoading);
            if (isShowMsg && !TextUtils.isEmpty(msg)) {
                msgText.setText(msg);
            }
            if (!isShowMsg) {
                msgText.setVisibility(View.GONE);
            }
            loadingDialog.setContentView(view);
            loadingDialog.setCancelable(isCanceled);
            loadingDialog.setCanceledOnTouchOutside(isOutSideCancel);
            return loadingDialog;
        }
    }
}
