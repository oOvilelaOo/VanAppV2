package com.example.teste;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editEmail = findViewById(R.id.editText);

        editNome = findViewById(R.id.editText2);
        button_Foto = findViewById(R.id.buttonFoto);
        editPhone = findViewById(R.id.editText3);
        editSenha = findViewById(R.id.editText4);
        editSenhaNov = findViewById(R.id.editText5);
        button_Cad = findViewById(R.id.button);
        imgFoto = findViewById(R.id.imageFoto);
        editCpf = findViewById(R.id.editText7);
        editCep = findViewById(R.id.editText9);
        editData_nasc = findViewById(R.id.editText10);


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

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0){
            uri = data.getData();

            Bitmap bitmap = null;

            try{
                MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imgFoto.setImageDrawable(new BitmapDrawable(bitmap));
                button_Foto.setAlpha(0);
            }
            catch(IOException e){

            }


        }
    }

    private void selectFoto(){

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0);


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
        
        if(email.isEmpty() || email == null || senha == null || senha.isEmpty() || nome == null || nome.isEmpty() || phone == null || phone.isEmpty()
                || data_nasc == null || data_nasc.isEmpty() || cpf == null || cpf.isEmpty() || cep == null || cep.isEmpty() ){
            Toast.makeText(this, "Os campos devem ser prenchidos", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(!senha.equals(senhanov)){
            Toast.makeText(this, "As senhas devem ser iguais", Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            saveUserInFirebase();

                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("Inválido", e.getMessage());
                    }
                });
    }

    private void saveUserInFirebase() {
        String filename = UUID.randomUUID().toString();
        final StorageReference ref = FirebaseStorage.getInstance().getReference("/images/" + filename);
        ref.putFile(uri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Log.i("Sucesso", uri.toString());

                                String uuid = firebaseAuth.getInstance().getUuid();

                                //new User();
                            }
                        });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("Falha", e.getMessage());
                        e.printStackTrace();
                    }
                });
    }
}
