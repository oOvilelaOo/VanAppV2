package com.example.teste.Desenvolvimento_Responsavel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teste.R;
import com.example.teste.VOs.TransportadorVO;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class List_row_transportadores_adapter extends FirestoreRecyclerAdapter<TransportadorVO, List_row_transportadores_adapter.ViewHolder> {


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

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row_transportadores,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull TransportadorVO transportadorVO) {

        viewHolder.nomeEmpresa.setText(transportadorVO.getNomeEmpresa());
        viewHolder.cnh.setText(transportadorVO.getCnh());
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nomeEmpresa;
        TextView cnh;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cnh = itemView.findViewById(R.id.cnhTransp);
            nomeEmpresa = itemView.findViewById(R.id.nomeTransp);


        }
    }
}
