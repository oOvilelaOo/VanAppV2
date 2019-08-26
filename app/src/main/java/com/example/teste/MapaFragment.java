package com.example.teste;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapaFragment extends Fragment {

    DatabaseReference dataBaseReference;

    public MapaFragment(DatabaseReference dataBaseReference) {
        this.dataBaseReference = dataBaseReference;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_mapa, container, false);
    }

}
