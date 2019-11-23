package com.loong.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.loong.base.BaseActivity;
import com.loong.base.BaseApp;
import com.loong.base.error.ErrorMsgBean;
import com.loong.base.util.Constants;
import com.loong.base.util.SharedPreferenceUtil;
import com.loong.base.util.ToastUtil;
import com.loong.login.constract.UserCenterContract;
import com.loong.login.response.LoginResult;
import com.loong.login.response.RegisterResult;

@Route(path = "/account/login")
public class UserCenterActivity extends BaseActivity implements View.OnClickListener {

    private TextView titleTv;
    private ViewPager viewPager;
    private LoginPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // 3.
    @Override
    protected void initData() {
        titleTv.setText("");
        adapter = new LoginPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.setFragments(new LoginFragment());
        viewPager.setAdapter(adapter);
    }

    // 2.
    @Override
    protected void initView() {
        titleTv = findViewById(R.id.title_name);
        viewPager = findViewById(R.id.view_pager);
    }

    // 1.
    @Override
    protected int getContentViewId() {
        return R.layout.login_page;
    }

    public void login(View view) {
        AccountUtils.userInfo = new UserInfo("10086", "Admin");
        updateLoginState();
    }

    private void updateLoginState() {
//        tvState.setText("这里是登录界面：" + (AccountUtils.userInfo == null ? "未登录" : AccountUtils.userInfo.getUserName()));
    }

    public void exit(View view) {
        AccountUtils.userInfo = null;
        updateLoginState();
    }

    public void loginShare(View view) {
//        ARouter.getInstance().build("/share/share").withString("share_content", "分享数据到微博").navigation();
    }



    @Override
    public void onClick(View v) {

    }

}
