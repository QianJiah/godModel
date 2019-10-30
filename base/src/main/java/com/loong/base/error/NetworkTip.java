package com.loong.base.error;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.loong.base.R;

import java.lang.ref.WeakReference;

/**
 * author: Hao
 * date: 2019/10/8 16:08
 * description:
 */
public class NetworkTip {

    private WeakReference<Activity> activityWeakReference;
    private WindowManager windowManager;
    private boolean isShowing = false;
    private View mView;
    private WindowManager.LayoutParams layoutParams;

    public NetworkTip(Activity activity) {
        activityWeakReference = new WeakReference<>(activity);
        windowManager = activity.getWindowManager();
        layoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,
                            WindowManager.LayoutParams.WRAP_CONTENT,
                            WindowManager.LayoutParams.TYPE_APPLICATION,
                            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                            PixelFormat.TRANSLUCENT);
        layoutParams.gravity = Gravity.START | Gravity.TOP;
        layoutParams.horizontalMargin = 100;
        layoutParams.horizontalWeight = 0.8f;
        layoutParams.y = 150;
        initView();
    }

    private void initView() {
        final Activity activity = activityWeakReference.get();
        if (activity != null) {
           mView = LayoutInflater.from(activity).inflate(R.layout.layout_no_network, null);
           mView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   //跳转设置
                   Intent intent = new Intent(Settings.ACTION_SETTINGS);
                   intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   activity.startActivity(intent);
               }
           });
        }
    }

    public void show() {
        isShowing = true;
        if (mView == null) {
            initView();
        }
        if (mView != null) {
            windowManager.addView(mView, layoutParams);
        }
    }

    public void dismiss() {
        isShowing = false;
        windowManager.removeViewImmediate(mView);
        mView = null;
    }

    public boolean isShowing() {
        return isShowing;
    }
}
