package com.example.teste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editNome;
    private EditText editPhone;
    private EditText editSenha;
    private EditText editSenhaNov;
    private Button button_Cad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editEmail = findViewById(R.id.editText);
        editNome = findViewById(R.id.editText2);
        editPhone = findViewById(R.id.editText3);
        editSenha = findViewById(R.id.editText4);
        editSenhaNov = findViewById(R.id.editText5);
        button_Cad = findViewById(R.id.button);

        button_Cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });
    }

    private void createUser(){

        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();
        String senhanov = editSenhaNov.getText().toString();
        String phone = editPhone.getText().toString();
        String nome = editNome.getText().toString();
        
        if(email.isEmpty() || email == null || senha == null || senha.isEmpty() || nome == null || nome.isEmpty() || phone == null || phone.isEmpty()){
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
                        Log.i("Válido", task.getResult().getUser().getUid());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("Inválido", e.getMessage());
                    }
                });
    }
}
