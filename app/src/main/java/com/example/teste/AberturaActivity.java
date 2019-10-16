package com.example.teste;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AberturaActivity extends AppCompatActivity {

    private Button buttonTransp;
    private Button buttonPais;
    private ImageView vanApp;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertura);

        textView = findViewById(R.id.textView3);
        vanApp = findViewById(R.id.imageView2);
        buttonPais = findViewById(R.id.button5);
        buttonTransp = findViewById(R.id.button3);

        buttonPais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (AberturaActivity.this, LoginActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                AberturaActivity.this.startActivity(intent);
            }
        });

        buttonTransp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (AberturaActivity.this, LoginTransportadorActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                AberturaActivity.this.startActivity(intent);
            }
        });

    }

    public void OnStart(){
        ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = false;
        if(activeNetwork!=null)
            isConnected = true;
        activeNetwork.isConnectedOrConnecting();
        if(!isConnected){
            final AlertDialog.Builder builder=new AlertDialog.Builder(AberturaActivity.this);
            builder.setTitle("Atenção!");
            builder.setMessage("O aplicativo necessita de internet para funcionar");
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    try {
                        this.finalize();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            });
            builder.show();
        }
    }
}
