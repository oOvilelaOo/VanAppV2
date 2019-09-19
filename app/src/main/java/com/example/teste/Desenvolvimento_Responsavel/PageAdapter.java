package com.example.teste.Desenvolvimento_Responsavel;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.teste.Desenvolvimento_Responsavel.ChatFragment;
import com.example.teste.Desenvolvimento_Responsavel.MapaFragment;
import com.example.teste.Desenvolvimento_Responsavel.TransportadorFragment;
import com.google.firebase.firestore.FirebaseFirestore;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
    FirebaseFirestore firebaseReference;

    public PageAdapter(FragmentManager fm, int numOfTabs, FirebaseFirestore firebaseReference
    ) {
        super(fm);
        this.numOfTabs=numOfTabs;
        this.firebaseReference=firebaseReference;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ChatFragment(firebaseReference);
            case 1:
                return new TransportadorFragment(firebaseReference);
            case 2:
                return new MapaFragment(firebaseReference);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
