package com.example.teste.VOs;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.local.ReferenceSet;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.value.ReferenceValue;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class TransportadorVO implements Serializable{

    private String referenceUsuario;
    private String nomeEmpresa;
    private String cnh;
    private String referenceTel;
    private String van;
    Map<String,String> referenciaEscolas;

    public TransportadorVO() {
    }

    public TransportadorVO(String referenceUsuario, String nomeEmpresa, String cnh, String referenceTel, String van, Map<String, String> referenciaEscolas) {
        this.referenceUsuario = referenceUsuario;
        this.nomeEmpresa = nomeEmpresa;
        this.cnh = cnh;
        this.referenceTel = referenceTel;
        this.van = van;
        this.referenciaEscolas = referenciaEscolas;
    }

    public String getReferenceUsuario() {
        return referenceUsuario;
    }

    public void setReferenceUsuario(String referenceUsuario) {
        this.referenceUsuario = referenceUsuario;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getReferenceTel() {
        return referenceTel;
    }

    public void setReferenceTel(String referenceTel) {
        this.referenceTel = referenceTel;
    }

    public String getVan() {
        return van;
    }

    public void setVan(String van) {
        this.van = van;
    }

    public Map<String, String> getReferenciaEscolas() {
        return referenciaEscolas;
    }

    public void setReferenciaEscolas(Map<String, String> referenciaEscolas) {
        this.referenciaEscolas = referenciaEscolas;
    }
}
