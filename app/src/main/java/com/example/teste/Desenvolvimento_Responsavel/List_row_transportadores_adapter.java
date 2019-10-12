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
import com.example.teste.VOs.TelefoneVO;
import com.example.teste.VOs.TransportadorVO;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class List_row_transportadores_adapter extends FirestoreRecyclerAdapter<TransportadorVO, List_row_transportadores_adapter.ViewHolder> {

    ArrayList<TransportadorVO> tp = new ArrayList<TransportadorVO>();

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public List_row_transportadores_adapter(@NonNull FirestoreRecyclerOptions<TransportadorVO> options) {
        super(options);

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
            viewHolder.cnh.setText(transportadorVO.getCnh());
            //viewHolder.telefone.setText(telefoneVO.getCelular());
            //viewHolder.vagas.setText(vanEscolarVO.getVagas());
            //viewHolder.nomeTransp.setText(usuarioVO.getNome());
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nomeEmpresa;
        TextView nomeTransp;
        TextView vagas;
        TextView telefone;
        TextView cnh;


        public ViewHolder(@NonNull View itemView, final Context context) {
            super(itemView);
            cnh = itemView.findViewById(R.id.nomeTransp);
            nomeEmpresa = itemView.findViewById(R.id.nomeEmpresa);
            //vagas = itemView.findViewById(R.id.vagas);
            //telefone = itemView.findViewById(R.id.telefone);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        TransportadorVO transportador = tp.get(getLayoutPosition());

                        Intent i = new Intent(context,DetalhamentoTransportador_Activity.class);

                        i.putExtra("transportador",transportador);

                        ((AppCompatActivity)context).startActivityForResult(i,0);

                }
            });

        }
    }
}
