package com.dimasbayu.movie.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dimasbayu.movie.Fragment.FragmentFavoriteMovie;

public class ViewPageAdapter extends FragmentPagerAdapter {

    private final Fragment[] tabsFragments;

    public ViewPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabsFragments = new Fragment[] {
                new FragmentFavoriteMovie()
        };
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return tabsFragments[position];
    }

    @Override
    public int getCount() {
        return tabsFragments.length;
    }
}
