package com.example.teste;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CadastroTransportadorActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editNome;
    private EditText editCnh;
    private EditText editSenha;
    private EditText editSenhaNov;
    private EditText editEmpresa;
    private EditText editPhone;
    private Button button_Cad;
    private Button button_Foto;
    private Uri uri;
    private ImageView imgFoto;
    private TextView lib;
    private FirebaseAuth mAuth;
    public FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_transportador);
        Intent intent = getIntent();

        editEmail = findViewById(R.id.editText);
        lib = findViewById(R.id.textView8);
        editNome = findViewById(R.id.editText2);
        button_Foto = findViewById(R.id.buttonFoto);
        editCnh = findViewById(R.id.editText3);
        editSenha = findViewById(R.id.editText4);
        editSenhaNov = findViewById(R.id.editText5);
        button_Cad = findViewById(R.id.button2);
        imgFoto = findViewById(R.id.imageFoto);
        editEmpresa = findViewById(R.id.editText6);
        mAuth = FirebaseAuth.getInstance();
        editPhone = findViewById(R.id.editText9);

        this.db = FirebaseFirestore.getInstance();

        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();

        button_Foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFoto();
            }
        });

        button_Cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });
    }

    private void selectFoto(){

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivity(Intent.createChooser(intent, "Selecione uma Imagem"));

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 0){
            assert data != null;
            uri = data.getData();
            Bitmap bitmap = null;

            try{
                MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                imgFoto.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
                button_Foto.setAlpha(0);
            }
            catch(IOException e){
                Toast.makeText(this, "Falha ao carregar imagem", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    private void createUser(){

        final String email = editEmail.getText().toString();
        final String senha = editSenha.getText().toString();
        String senhanov = editSenhaNov.getText().toString();
        final String phone = editPhone.getText().toString();
        final String nome = editNome.getText().toString();
        final String cnh = editCnh.getText().toString();
        final String nome_empresa = editEmpresa.getText().toString();

        if(email.isEmpty() || email == null || senha == null || senha.isEmpty() || nome == null || nome.isEmpty() || phone == null || phone.isEmpty()|| cnh == null || cnh.isEmpty() || nome_empresa == null || nome_empresa.isEmpty()){
            Toast.makeText(this, "Os campos devem ser prenchidos", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(!senha.equals(senhanov)){
            Toast.makeText(this, "As senhas devem ser iguais", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            mAuth.createUserWithEmailAndPassword(email, senha);
            saveUserInFirebase(email, senha, phone, nome, cnh, nome_empresa);
        }
    }

    public void saveUserInFirebase(String email, String senha, String phone, String nome, String cnh, String nome_empresa) {

        String id= UUID.randomUUID().toString();

        Map<String, Object> user = new HashMap<>();
        user.put("ID", id);
        user.put("Email", email);
        user.put("Senha", senha);
        user.put("Celular", phone);
        user.put("Nome", nome);
        user.put("CNH", cnh);
        user.put("Nome da Empresa:", nome_empresa);

        DocumentReference addTransp = db.collection("Transportadores").document(id);

        db.collection("Transportador")
            .add(user)
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
            })
        ;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){
            Intent intent = new Intent (CadastroTransportadorActivity.this, LoginTransportadorActivity.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

            CadastroTransportadorActivity.this.startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
