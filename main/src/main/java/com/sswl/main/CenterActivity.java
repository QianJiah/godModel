package com.sswl.main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/home/main")
public class CenterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        /*
2019-11-23 15:19:00.242 12910-12910/com.loong.componentdemo W/ARouter::: ARouter::No postcard![ ]
2019-11-23 15:19:00.243 12910-12910/com.loong.componentdemo W/ARouter::: ARouter::No postcard![ ]
2019-11-23 15:19:00.245 12910-12910/com.loong.componentdemo D/ARouter::: The group [account] starts loading, trigger by [/account/login][ ]
2019-11-23 15:19:00.247 12910-12910/com.loong.componentdemo D/ARouter::: The group [account] has already been loaded, trigger by [/account/login][ ]
2019-11-23 15:19:00.248 12910-12910/com.loong.componentdemo I/ARouter::: Thread production, name is [ARouter task pool No.1, thread No.3][ ]
2019-11-23 15:19:00.254 1270-2789/? D/ActivityTrigger: ActivityTrigger activityPauseTrigger
2019-11-23 15:19:00.262 1270-4960/? I/ActivityManager: START u0 {flg=0x10000000 cmp=com.loong.componentdemo/com.loong.login.UserCenterActivity (has extras)} from uid 10301
2019-11-23 15:19:00.262 1270-4960/? I/ActivityManager: send message.
2019-11-23 15:19:00.262 2561-8415/? W/ContextImpl: Calling a method in the system process without a qualified user: android.app.ContextImpl.bindService:1645 android.content.ContextWrapper.bindService:698 com.vivo.daemonService.i.a.a:38 com.vivo.daemonService.i.a.a:62 com.vivo.daemonService.IqooSecure.SoftwareLockService$a.activityStarting:1979
2019-11-23 15:19:00.262 1270-4960/? W/ActivityManager: Unable to start service Intent

    { act=com.vivo.thirdappbehavior.ThirdAppBehaviorService pkg=com.vivo.abe } U=0: not found
2019-11-23 15:19:00.262 1270-4960/? I/ActivityManager: remove message.
2019-11-23 15:19:00.262 1270-4960/? I/ActivityManager: send message.
2019-11-23 15:19:00.263 1270-4960/? I/ActivityManager: remove message.


2019-11-23 15:20:49.152 12910-12910/com.loong.componentdemo W/ARouter::: ARouter::No postcard![ ]
2019-11-23 15:20:49.153 12910-12910/com.loong.componentdemo W/ARouter::: ARouter::No postcard![ ]
2019-11-23 15:20:49.153 12910-12910/com.loong.componentdemo D/ARouter::: The group [home] starts loading, trigger by [/home/main][ ]
2019-11-23 15:20:49.154 12910-12910/com.loong.componentdemo D/ARouter::: The group [home] has already been loaded, trigger by [/home/main][ ]
2019-11-23 15:20:49.154 12910-12910/com.loong.componentdemo I/ARouter::: Thread production, name is [ARouter task pool No.1, thread No.4][ ]
2019-11-23 15:20:49.160 1270-12391/? W/WindowManager: Failed looking up window callers=com.android.server.wm.VivoBaseWindowManagerService.adjustDisplayIdForWindow:788 com.android.server.wm.WindowManagerService.addWindow:1412 com.android.server.wm.Session.addToDisplay:208
2019-11-23 15:20:49.170 1270-12391/? I/ActivityManager: START u0 {flg=0x10000000 cmp=com.loong.componentdemo/com.sswl.main.CenterActivity (has extras)} from uid 10301
2019-11-23 15:20:49.170 1270-12391/? I/ActivityManager: send message.
2019-11-23 15:20:49.171 2561-4716/? W/ContextImpl: Calling a method in the system process without a qualified user: android.app.ContextImpl.bindService:1645 android.content.ContextWrapper.bindService:698 com.vivo.daemonService.i.a.a:38 com.vivo.daemonService.i.a.a:62 com.vivo.daemonService.IqooSecure.SoftwareLockService$a.activityStarting:1979
2019-11-23 15:20:49.173 1270-12391/? W/ActivityManager: Unable to start service Intent { act=com.vivo.thirdappbehavior.ThirdAppBehaviorService pkg=com.vivo.abe } U=0: not found
2019-11-23 15:20:49.174 1270-12391/? I/ActivityManager: remove message.
2019-11-23 15:20:49.174 1270-12391/? I/ActivityManager: send message.
2019-11-23 15:20:49.174 1270-12391/? I/ActivityManager: remove message.*/

}
