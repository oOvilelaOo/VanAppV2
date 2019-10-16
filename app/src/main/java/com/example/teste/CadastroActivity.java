package com.example.teste;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
//import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CadastroActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editNome;
    private EditText editPhone;
    private EditText editSenha;
    private EditText editSenhaNov;
    private EditText editCep;
    private EditText editCpf;
    private EditText editData_nasc;
    private Button button_Cad;
    private Button button_Foto;
    private Uri uri;
    private ImageView imgFoto;
    private FirebaseAuth mAuth;
    private TextView lib;
    public FirebaseFirestore db;
    private static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_cadastro);

        editEmail = findViewById(R.id.editText);

        editNome = findViewById(R.id.editText2);
        button_Foto = findViewById(R.id.buttonFoto);
        editPhone = findViewById(R.id.editText3);
        editSenha = findViewById(R.id.editText4);
        editSenhaNov = findViewById(R.id.editText5);
        button_Cad = findViewById(R.id.button2);
        imgFoto = findViewById(R.id.imageFoto);
        editCpf = findViewById(R.id.editText7);
        editCep = findViewById(R.id.editText9);
        editData_nasc = findViewById(R.id.editText10);
        lib = findViewById(R.id.textView5);

        this.db = FirebaseFirestore.getInstance();

        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);

        mAuth = FirebaseAuth.getInstance();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

    //Carrega o usuário atual do serviço
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    //Pega a foto e manda para o servidor
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null){

            uri = data.getData();

            //Picasso.get().load(uri).into(imgFoto);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){
            Intent intent = new Intent (CadastroActivity.this, LoginActivity.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

            CadastroActivity.this.startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void selectFoto(){

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);

    }

    private void createUser(){

        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();
        String senhanov = editSenhaNov.getText().toString();
        String phone = editPhone.getText().toString();
        String nome = editNome.getText().toString();
        String data_nasc = editData_nasc.getText().toString();
        String cpf = editCpf.getText().toString();
        String cep = editCep.getText().toString();


        if(email.isEmpty() || email == null || senha == null || senha.isEmpty() || nome == null || nome.isEmpty() || phone == null || phone.isEmpty()|| data_nasc == null || data_nasc.isEmpty() || cpf == null || cpf.isEmpty() || cep == null || cep.isEmpty() ){
            Toast.makeText(this, "Os campos devem ser prenchidos", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(!senha.equals(senhanov)){
            Toast.makeText(this, "As senhas devem ser iguais", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            mAuth.createUserWithEmailAndPassword(email, senha);
            saveUserInFirebase(email, senha, nome, phone, data_nasc, cpf, cep);
        }
    }

    private void saveUserInFirebase(String email, String senha, String nome, String phone, String data_nasc, String cpf, String cep) {

        String id= UUID.randomUUID().toString();
        FirebaseUser fuser = FirebaseAuth.getInstance().getCurrentUser();

        Map<String, Object> user = new HashMap<>();
        user.put("Email", email);
        user.put("Senha", senha);
        user.put("Celular", phone);
        user.put("Nome", nome);
        user.put("Data_nasc", data_nasc);
        user.put("cpf", cpf);
        user.put("cep", cep);
        user.put("ID", id);
        user.put("UserCode", fuser);

        DocumentReference addUser = db.collection("Usuarios").document(id);

        db.collection("Usuarios")
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
                });
    }
}
