package com.example.teste.Desenvolvimento_Responsavel;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.teste.DetalhamentoTransportador_Activity;
import com.example.teste.R;
import com.example.teste.VOs.TelefoneVO;
import com.example.teste.VOs.TransportadorVO;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TransportadorFragment extends Fragment {

    RecyclerView recyclerView;

    List_row_transportadores_adapter adapter;

    FirebaseFirestore mFirestore;

    public TransportadorFragment(){}

    public TransportadorFragment(FirebaseFirestore firebaseReference) {

        this.mFirestore = firebaseReference;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_transportador, container, false);

        recyclerView = view.findViewById(R.id.listaRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        setarRecyclerView();

        return view;
    }

    private void setarRecyclerView(){

        Query query = mFirestore.collection("Transportador");

        FirestoreRecyclerOptions<TransportadorVO> options = new FirestoreRecyclerOptions.Builder<TransportadorVO>().setQuery(query,TransportadorVO.class).build();

        adapter = new List_row_transportadores_adapter(options);
        adapter.notifyDataSetChanged();

        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onStart() {
        super.onStart();

        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();

        adapter.stopListening();
    }
}
