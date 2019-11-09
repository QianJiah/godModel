package com.loong.base.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.loong.base.error.NetworkTip;
import com.loong.base.util.NetworkUtil;

/**
 * author: Hao
 * date: 2019/10/8 16:00
 * description: 网络监听器
 */
public class NetworkChangeReceiver extends BroadcastReceiver {

    private Activity mActivity;
    private NetworkTip networkTip;

    public NetworkChangeReceiver(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (networkTip == null) {
            networkTip = new NetworkTip(mActivity);
        }
        if (NetworkUtil.isNetworkAvailable(context)) {
            if (networkTip != null && networkTip.isShowing()) {
                networkTip.dismiss();
            }
        } else {
            if (networkTip != null && !networkTip.isShowing()) {
                networkTip.show();
            }
        }
    }

    public void onDestroy() {
        if (networkTip != null && networkTip.isShowing()) {
            networkTip.dismiss();
        }
        networkTip = null;
        mActivity = null;
    }
}
