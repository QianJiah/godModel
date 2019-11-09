package com.loong.base;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.loong.base.receiver.NetworkChangeReceiver;


/**
 * author: Hao
 * date: 2019/10/8 15:57
 * description:
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    private NetworkChangeReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        mContext = this;
//        EventBus.getDefault().register(this);
        registerNetworkChangeReceiver();
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getContentViewId();

    /**
     * 注册广播监听器
     */
    protected void registerNetworkChangeReceiver() {
        receiver = new NetworkChangeReceiver(this);
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, intentFilter);
    }

    /**
     * 注销广播监听
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver.onDestroy();
            receiver = null;
        }
//        EventBus.getDefault().unregister(this);
    }
}
