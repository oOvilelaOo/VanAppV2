package com.example.teste;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.teste.ui.main.VOs.EscolaVO;
import com.example.teste.ui.main.VOs.Resp_alunosVO;
import com.example.teste.ui.main.VOs.TransportadorVO;
import com.example.teste.ui.main.VOs.UsuarioVO;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class TransportadorFragment extends Fragment {

    private List<TransportadorVO> listaTransportadores= new ArrayList<TransportadorVO>();
    private ArrayAdapter<TransportadorVO> adapterTransportadorVO;

    private ListView listView;

    DatabaseReference dataBaseReference;

    public TransportadorFragment(DatabaseReference dataBaseReference) {

        this.dataBaseReference = dataBaseReference;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_transportador,container,false);

        listView = view.findViewById(R.id.listView);

        listagemTransportador();

        return view;
    }

    private void listagemTransportador(){


        dataBaseReference.child("Transportador").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            /*    listaTransportadores.clear();
                for(DataSnapshot objSnapshot:dataSnapshot.getChildren()){

                    TransportadorVO transportadorVO = objSnapshot.getValue(TransportadorVO.class);
                    listaTransportadores.add(transportadorVO);

                }
                adapterTransportadorVO = new ArrayAdapter<TransportadorVO>(getContext(),android.R.layout.simple_list_item_1,listaTransportadores);
                listView.setAdapter(adapterTransportadorVO);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
}
