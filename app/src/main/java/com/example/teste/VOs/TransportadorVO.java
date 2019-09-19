package com.example.teste.VOs;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.local.ReferenceSet;
import com.google.firebase.firestore.model.value.ReferenceValue;

public class TransportadorVO {

    private DocumentReference referenceUsuario;
    private String nomeEmpresa;
    private String cnh;

    public TransportadorVO(){



    }

    public TransportadorVO(String nomeEmpresa, DocumentReference referenceUsuario, String cnh) {
        this.referenceUsuario = referenceUsuario;
        this.nomeEmpresa = nomeEmpresa;
        this.cnh = cnh;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public DocumentReference getCodUsuario() {
        return referenceUsuario;
    }

    public void setCodUsuario(DocumentReference referenceUsuario) {
        this.referenceUsuario = referenceUsuario;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
}
