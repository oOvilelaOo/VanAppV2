package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.teste.VOs.TelefoneVO;
import com.example.teste.VOs.TransportadorVO;
import com.example.teste.VOs.UsuarioVO;
import com.example.teste.VOs.VanEscolarVO;

import java.util.ArrayList;

public class DetalhamentoTransportador_Activity extends AppCompatActivity {

    TransportadorVO transportador;

    UsuarioVO usuario;

    TelefoneVO telefone;

    VanEscolarVO van;

    TextView nomeEmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhamento_transportador);

        nomeEmp = findViewById(R.id.nomeEmpresa);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null && bundle.containsKey("transportador")&& bundle.containsKey("usuario")&& bundle.containsKey("telefone")&& bundle.containsKey("van")){

            transportador = (TransportadorVO)bundle.getSerializable("transportador");
            telefone = (TelefoneVO)bundle.getSerializable("telefone");
            usuario = (UsuarioVO)bundle.getSerializable("usuario");
            van = (VanEscolarVO)bundle.getSerializable("van");
        }

        nomeEmp.setText(transportador.getNomeEmpresa());

    }
}
