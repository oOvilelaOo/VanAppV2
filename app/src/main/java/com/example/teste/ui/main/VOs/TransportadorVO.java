package com.example.teste.ui.main.VOs;

public class TransportadorVO {

    private String cnh;
    private String codUsuario;
    private String nomeEmpresa;

    public TransportadorVO() {


    }

    public TransportadorVO(String cnh, String codUsuario, String nomeEmpresa) {
        this.cnh = cnh;
        this.codUsuario = codUsuario;
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
}
