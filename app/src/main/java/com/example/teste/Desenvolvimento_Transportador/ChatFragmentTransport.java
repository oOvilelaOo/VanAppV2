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

public class ChatFragmentTransport extends Fragment {

    FirebaseFirestore mFirestore;

    public ChatFragmentTransport(FirebaseFirestore firebaseReference) {
        this.mFirestore = firebaseReference;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_chat_fragment_transport, container, false);
    }


}
