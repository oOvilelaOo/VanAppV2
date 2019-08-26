package com.example.teste;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.firebase.database.DatabaseReference;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
    DatabaseReference dataBaseReference;

    public PageAdapter(FragmentManager fm, int numOfTabs, DatabaseReference dataBaseReference
    ) {
        super(fm);
        this.numOfTabs=numOfTabs;
        this.dataBaseReference=dataBaseReference;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ChatFragment(dataBaseReference);
            case 1:
                return new TransportadorFragment(dataBaseReference);
            case 2:
                return new MapaFragment(dataBaseReference);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
