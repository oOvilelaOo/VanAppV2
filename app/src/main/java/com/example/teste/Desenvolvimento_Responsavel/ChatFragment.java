package com.example.teste.Desenvolvimento_Responsavel;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teste.ChatAdapter;
import com.example.teste.R;
import com.example.teste.VOs.Chat;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.Source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatFragment extends Fragment {

    private RecyclerView rv;
    private FirebaseUser fuser;
    public FirebaseFirestore db;
    private EditText mensagem;
    private Button butao_Envia;
    private DocumentReference docRef;
    private CircleImageView profile;
    private TextView username;
    public ChatAdapter chatAdapter;
    public List<Chat> chat;

    public ChatFragment(FirebaseFirestore db){
        this.db = db;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        rv = view.findViewById(R.id.recyclerView);
        mensagem = view.findViewById(R.id.editChat);
        butao_Envia = view.findViewById(R.id.button_send);

        rv.setHasFixedSize(true);


        Intent myIntent = getActivity().getIntent();
        //final String userid = myIntent.getStringExtra("userid");

        final String userid = "aa";

        fuser = FirebaseAuth.getInstance().getCurrentUser();
        this.db = FirebaseFirestore.getInstance();

        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);

        butao_Envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = mensagem.getText().toString();
                if(!msg.equals("")){
                    sendMessage(fuser.getUid(), userid, msg);
                }
                else{
                    Toast toast;
                    Toast.makeText( ChatFragment.this.getActivity() , "Não é possível enviar", Toast.LENGTH_SHORT).show();
                }
                mensagem.setText("");
            }
        });

        return view;
    }

    public void sendMessage(String sender, String receiver, String message){

        String id= UUID.randomUUID().toString();

        Map<String, Object> messagem = new HashMap<>();
        messagem.put("Enviou", sender);
        messagem.put("Recebidor", receiver);
        messagem.put("Mensagem", messagem);

        db.collection("Chats")
                .add(messagem)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Success", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Error", "Error adding document", e);
                    }
                });
    }

    private void readMessage(String myid, String userid, String imageURL){
        chat = new ArrayList<>();

        docRef = FirebaseFirestore.getInstance().collection("chats").document("Chat");

        Source source = Source.CACHE;

    }
}
