package com.loong.base.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.StringRes;

/**
 * author: Hao
 * date: 2019/10/9 16:21
 * description:
 */
public class ToastUtil {

    private static Toast toast;

    public static void show(Context context, CharSequence charSequence) {
        if (toast == null) {
            toast = Toast.makeText(context, charSequence, Toast.LENGTH_SHORT);
        } else {
            toast.setText(charSequence);
        }
        toast.show();
    }

    public static void show(Context context, @StringRes int textId) {
        if (toast == null) {
            toast = Toast.makeText(context, textId, Toast.LENGTH_SHORT);
        } else {
            toast.setText(textId);
        }
        toast.show();
    }
}
