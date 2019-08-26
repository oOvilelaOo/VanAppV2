package com.example.teste;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.teste.ui.main.VOs.EscolaVO;
import com.example.teste.ui.main.VOs.Resp_alunosVO;
import com.example.teste.ui.main.VOs.UsuarioVO;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class TransportadorFragment extends Fragment {


    DatabaseReference dataBaseReference;

    public TransportadorFragment(DatabaseReference dataBaseReference) {

        this.dataBaseReference = dataBaseReference;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_transportador,container,false);

        // Inflate the layout for this fragment

        return view;
    }
}
