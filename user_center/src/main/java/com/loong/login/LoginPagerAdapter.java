package com.loong.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * author: Hao
 * date: 2019/11/9 11:40
 * description:
 */
class LoginPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;
    private String[] titles;

    public void setFragments(Fragment... fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    public void setTitles(String... titles) {
        this.titles = titles;
    }

    public LoginPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles == null ? "" : titles[position];
    }
}
