package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText Edit_Email;
    private EditText Edit_Pass;
    private Button Button;
    private TextView textView;
    private FirebaseAuth mAuth;
    private TextView lib;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Edit_Email = findViewById(R.id.edit_email);
        Edit_Pass = findViewById(R.id.edit_pass);
        Button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        mAuth = FirebaseAuth.getInstance();
        lib = findViewById(R.id.textView4);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Edit_Email.getText().toString();
                String senha = Edit_Pass.getText().toString();

                if (email.isEmpty() || email == null || senha == null || senha.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Os campos devem ser prenchidos", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    signIn(email, senha);
                }
            }

        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                LoginActivity.this.startActivity(intent);
            }
        });
    }

    private void signIn(String email, String senha) {
        Log.d("Logar", "Logar:" + email);

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Logando", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            Intent intent = new Intent (LoginActivity.this, MainActivity.class);

                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);



                            LoginActivity.this.startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Logando", "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Autenticação falhou.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        if (!task.isSuccessful()) {
                            lib.setText(R.string.auth_failed);
                        }
                    }
                });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){
            Intent intent = new Intent (LoginActivity.this, AberturaActivity.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

            LoginActivity.this.startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
