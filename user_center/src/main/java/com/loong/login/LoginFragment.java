package com.loong.login;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * author: Hao
 * date: 2019/11/9 11:38
 * description:
 */
public class LoginFragment extends Fragment {

    private View mView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_login, container, false);
        AutoCompleteTextView textView = mView.findViewById(R.id.piv_login_account);
        EditText editText = mView.findViewById(R.id.et_pwd);
        CheckBox checkBox = mView.findViewById(R.id.cb_pwd_switch);
        //比如drawleft设置图片大小
        //获取图片
        Drawable drawable = getResources().getDrawable(R.drawable.ic_account_normal);
        //第一个0是距左边距离，第二个0是距上边距离，40分别是长宽
        drawable.setBounds(0, 0, 44, 44);
        textView.setCompoundDrawables(drawable, null, null, null);
        Drawable passDraw = getResources().getDrawable(R.drawable.ic_password_normal);
        passDraw.setBounds(0, 0, 44, 44);
        editText.setCompoundDrawables(passDraw, null, null, null);
        Drawable eyeDraw = getResources().getDrawable(R.drawable.ic_eye_normal);
        eyeDraw.setBounds(0, 0, 44, 44);
        checkBox.setCompoundDrawables(eyeDraw, null, null, null);
        return mView;
    }
}
