package com.example.teste.VOs;

import java.io.Serializable;

public class TelefoneVO implements Serializable {

    private String celular;
    private String telefoneResidencial;

    public TelefoneVO() {
    }

    public TelefoneVO(String celular, String telefoneResidencial) {
        this.celular = celular;
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }
}
