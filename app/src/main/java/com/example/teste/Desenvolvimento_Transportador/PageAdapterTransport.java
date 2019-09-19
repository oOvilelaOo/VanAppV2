package com.example.teste.Desenvolvimento_Transportador;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.teste.Desenvolvimento_Transportador.ChatFragmentTransport;
import com.google.firebase.firestore.FirebaseFirestore;


public class PageAdapterTransport extends FragmentPagerAdapter {

    private int numOfTabs;
    FirebaseFirestore firebaseReference;

    public PageAdapterTransport(FragmentManager fm, int numOfTabs, FirebaseFirestore firebaseReference
    ) {
        super(fm);
        this.numOfTabs=numOfTabs;
        this.firebaseReference=firebaseReference;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ChatFragmentTransport(firebaseReference);
            case 1:
                return new VagasFragment(firebaseReference);
            case 2:
                return new PagamentosFragment(firebaseReference);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
