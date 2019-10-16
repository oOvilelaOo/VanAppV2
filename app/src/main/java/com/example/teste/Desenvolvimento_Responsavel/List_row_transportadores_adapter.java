package com.example.teste.Desenvolvimento_Responsavel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teste.DetalhamentoTransportador_Activity;
import com.example.teste.R;
import com.example.teste.VOs.EscolaVO;
import com.example.teste.VOs.MarcaVO;
import com.example.teste.VOs.ModeloVO;
import com.example.teste.VOs.TelefoneVO;
import com.example.teste.VOs.TransportadorVO;
import com.example.teste.VOs.UsuarioVO;
import com.example.teste.VOs.VanEscolarVO;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class List_row_transportadores_adapter extends FirestoreRecyclerAdapter<TransportadorVO, List_row_transportadores_adapter.ViewHolder> {

    ArrayList<TransportadorVO> tp = new ArrayList<TransportadorVO>();
    ArrayList<UsuarioVO> us = new ArrayList<UsuarioVO>();
    ArrayList<TelefoneVO> tl = new ArrayList<TelefoneVO>();
    ArrayList<VanEscolarVO> ve = new ArrayList<VanEscolarVO>();
    ArrayList<ModeloVO> md = new ArrayList<ModeloVO>();
    ArrayList<MarcaVO> mr = new ArrayList<MarcaVO>();

    FirebaseFirestore mFirestore;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public List_row_transportadores_adapter(@NonNull FirestoreRecyclerOptions<TransportadorVO> options,FirebaseFirestore mFirestore) {
        super(options);

        this.mFirestore=mFirestore;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

        View view = layoutInflater.inflate(R.layout.list_row_transportadores,viewGroup,false);



        return new ViewHolder(view,viewGroup.getContext());
    }

    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull TransportadorVO transportadorVO) {

            tp.add(transportadorVO) ;

            viewHolder.nomeEmpresa.setText(transportadorVO.getNomeEmpresa());

            carregaDados(transportadorVO,viewHolder,i);

    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nomeEmpresa;
        TextView nomeTransp;
        TextView vagas;
        TextView telefone;


        public ViewHolder(@NonNull View itemView, final Context context) {
            super(itemView);
            nomeTransp = itemView.findViewById(R.id.nomeTransp);
            nomeEmpresa = itemView.findViewById(R.id.nomeEmpresa);
            vagas = itemView.findViewById(R.id.vagas);
            telefone = itemView.findViewById(R.id.telefone);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        TransportadorVO transportador = tp.get(getLayoutPosition());

                        UsuarioVO usuario = us.get(getLayoutPosition());

                        TelefoneVO telefone = tl.get(getLayoutPosition());

                        VanEscolarVO van = ve.get(getLayoutPosition());

                        ModeloVO modelo = md.get(getLayoutPosition());

                        MarcaVO marca = mr.get(getLayoutPosition());

                        Intent i = new Intent(context,DetalhamentoTransportador_Activity.class);

                        i.putExtra("transportador",transportador);
                        i.putExtra("usuario",usuario);
                        i.putExtra("telefone",telefone);
                        i.putExtra("van",van);
                        i.putExtra("modelo",modelo);
                        i.putExtra("marca",marca);

                    ((AppCompatActivity)context).startActivityForResult(i,0);

                }
            });

        }
    }
    public void carregaDados(TransportadorVO transportadorVO, @NonNull final ViewHolder viewHolder,int i){

        DocumentReference docUser = mFirestore.collection("Usuarios").document(transportadorVO.getReferenceUsuario());

        DocumentReference docTel = mFirestore.collection("Telefone").document(transportadorVO.getReferenceTel());

        DocumentReference docVan = mFirestore.collection("VanEscolar").document(transportadorVO.getVan());

        docUser.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                UsuarioVO usuario = documentSnapshot.toObject(UsuarioVO.class);

                us.add(usuario);

                viewHolder.nomeTransp.setText(usuario.getNome());

            }
        });

        /*String id = docTel.getId();

        System.out.println(id);*/

        docTel.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                TelefoneVO tel = documentSnapshot.toObject(TelefoneVO.class);

                tl.add(tel);

                viewHolder.telefone.setText(tel.getCelular());
            }
        });

        docVan.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                VanEscolarVO van = documentSnapshot.toObject(VanEscolarVO.class);

                ve.add(van);

                viewHolder.vagas.setText(String.valueOf(van.getVagas()));

                carregaModelo(van);

            }
        });
    }

    public void carregaModelo(VanEscolarVO vanVO){

        DocumentReference docVan = mFirestore.collection("Modelo").document(vanVO.getCodModelo());

        docVan.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                ModeloVO modelo = documentSnapshot.toObject(ModeloVO.class);

                md.add(modelo);

                carregaMarca(modelo);

            }
        });
    }

    public void carregaMarca(ModeloVO modeloVO){

        DocumentReference docVan = mFirestore.collection("Marca").document(modeloVO.getCodMarca());

        docVan.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                MarcaVO marca = documentSnapshot.toObject(MarcaVO.class);

                mr.add(marca);

            }
        });
    }
}
