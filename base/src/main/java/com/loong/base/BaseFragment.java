package com.loong.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.loong.base.iPresenter.IPresenter;
import com.loong.base.iView.IView;

/**
 * author: Hao
 * date: 2019/11/9 11:15
 * description:
 */
public abstract class BaseFragment<T extends IPresenter> extends Fragment implements IView {

    protected T mPresenter;
    protected Context mContext;//activity的上下文对象
    protected Bundle mBundle;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mBundle != null) {
            outState.putBundle("bundle", mBundle);
        }
    }
    /**
     * 绑定activity
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    /**
     * 运行在onAttach之后
     * 可以接受别人传递过来的参数,实例化对象.
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取bundle,并保存起来
        if (savedInstanceState != null) {
            mBundle = savedInstanceState.getBundle("bundle");
        } else {
            mBundle = getArguments() == null ? new Bundle() : getArguments();
        }
        //创建presenter
        mPresenter = initPresenter();
    }

    /**
     * 运行在onCreate之后
     * 生成view视图
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView(inflater, container, savedInstanceState);
    }

    /**
     * 运行在onCreateView之后
     * 加载数据
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //由于fragment生命周期比较复杂,所以Presenter在onCreateView创建视图之后再进行绑定,不然会报空指针异常
        mPresenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
/*
    *//**
     * 跳转fragment
     *
     * @param tofragment
     *//*
    @Override
    public void startFragment(Fragment tofragment) {
        startFragment(tofragment, null);
    }

    *//**
     * @param tofragment 跳转的fragment
     * @param tag        fragment的标签
     *//*
    @Override
    public void startFragment(Fragment tofragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.hide(this).add(android.R.id.content, tofragment, tag);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commitAllowingStateLoss();
    }*/

    /**
     * 类似Activity的OnBackgress
     * fragment进行回退
     */
    public void onBack() {
        getFragmentManager().popBackStack();
    }

    /**
     * 初始化Fragment应有的视图
     *
     * @return
     */
    public abstract View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    /**
     * 创建presenter
     *
     * @return <T extends BasePresenter> 必须是BasePresenter的子类
     */
    public abstract T initPresenter();

    @Override
    public Context getContext() {
        return mContext;
    }

}
