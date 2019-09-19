package com.example.teste.VOs;

public class TelefoneVO {

    private String celular;
    private String codTel;
    private String codUsuario;
    private String telefoneResidencial;

    public TelefoneVO(String celular, String codTel, String codUsuario, String telefoneResidencial) {
        this.celular = celular;
        this.codTel = codTel;
        this.codUsuario = codUsuario;
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCodTel() {
        return codTel;
    }

    public void setCodTel(String codTel) {
        this.codTel = codTel;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }
}
