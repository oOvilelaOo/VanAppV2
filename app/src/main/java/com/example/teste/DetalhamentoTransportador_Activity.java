package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.teste.VOs.TransportadorVO;

import java.util.ArrayList;

public class DetalhamentoTransportador_Activity extends AppCompatActivity {

    TransportadorVO transportador;

    TextView nomeEmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhamento_transportador);

        nomeEmp = findViewById(R.id.nomeEmpresa);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null && bundle.containsKey("transportador")){

            TransportadorVO tp = (TransportadorVO)bundle.getSerializable("transportador");

            transportador = tp;

        }

        nomeEmp.setText(transportador.getNomeEmpresa());

    }
}
