package com.example.teste;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public PageAdapter(FragmentManager fm,int numOfTabs) {
        super(fm);
        this.numOfTabs=numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ChatFragment();
            case 1:
                return new TransportadorFragment();
            case 2:
                return new MapaFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
