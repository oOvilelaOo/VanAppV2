package com.example.teste.Desenvolvimento_Transportador;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.teste.R;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagamentosFragment extends Fragment {

    FirebaseFirestore mFirestore;

    public PagamentosFragment(FirebaseFirestore firebaseReference) {
        this.mFirestore = firebaseReference;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_pagamentos, container, false);
    }

}
