package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teste.VOs.EscolaVO;
import com.example.teste.VOs.MarcaVO;
import com.example.teste.VOs.ModeloVO;
import com.example.teste.VOs.TelefoneVO;
import com.example.teste.VOs.TransportadorVO;
import com.example.teste.VOs.UsuarioVO;
import com.example.teste.VOs.VanEscolarVO;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DetalhamentoTransportador_Activity extends AppCompatActivity {

    TransportadorVO transportadorVO;
    UsuarioVO usuarioVO;
    TelefoneVO telefoneVO;
    VanEscolarVO vanVO;
    ModeloVO modeloVO;
    MarcaVO marcaVO;

    FirebaseFirestore firebaseFirestore;

    List<String> escolas;

    TextView nomeEmp;
    TextView nome;
    TextView modelo;
    TextView vagas;
    TextView email;
    TextView telefone;
    ListView escolasList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhamento_transportador);

        nomeEmp = findViewById(R.id.nomeEmpresa);
        nome = findViewById(R.id.name);
        modelo = findViewById(R.id.modelo);
        vagas = findViewById(R.id.vagas);
        email = findViewById(R.id.email);
        telefone = findViewById(R.id.telefone);
        escolasList = findViewById(R.id.escolas);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null && bundle.containsKey("transportador")&& bundle.containsKey("usuario")&& bundle.containsKey("telefone")&& bundle.containsKey("van")&& bundle.containsKey("modelo")&& bundle.containsKey("marca")){

            transportadorVO = (TransportadorVO)bundle.getSerializable("transportador");
            telefoneVO = (TelefoneVO)bundle.getSerializable("telefone");
            usuarioVO = (UsuarioVO)bundle.getSerializable("usuario");
            vanVO = (VanEscolarVO)bundle.getSerializable("van");
            modeloVO = (ModeloVO)bundle.getSerializable("modelo");
            marcaVO = (MarcaVO)bundle.getSerializable("marca");
        }

        nomeEmp.setText(transportadorVO.getNomeEmpresa());
        nome.setText(usuarioVO.getNome());
        modelo.setText(marcaVO.getNome()+" "+modeloVO.getModelo()+" "+vanVO.getAno());
        vagas.setText(vanVO.getVagas()+"/"+vanVO.getNumAcentos());
        email.setText(usuarioVO.getEmail());
        telefone.setText(telefoneVO.getCelular());

        /*Map<String,String> referenciaEscolas = transportadorVO.getReferenciaEscolas();

        for (String key : referenciaEscolas.keySet()) {

            DocumentReference docEscola = mFirestore.collection("Escolas").document(referenciaEscolas.get(key));

            docEscola.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {

                    EscolaVO escola = documentSnapshot.toObject(EscolaVO.class);

                    escolas.add(escola.getNome());

                }
            });
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,escolas);

        escolasList.setAdapter(adapter);*/
    }
}
