package com.example.teste.ui.main.VOs;

public class Resp_alunosVO {

    private String cpf;
    private String dataNasc;
    private String cep;
    private String numCasa;
    private String complemento;
    private String chaveUsuario;

    public Resp_alunosVO(String cpf, String dataNasc, String cep, String numCasa, String complemento, String chaveUsuario) {
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.cep = cep;
        this.numCasa = numCasa;
        this.complemento = complemento;
        this.chaveUsuario = chaveUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getChaveUsuario() {
        return chaveUsuario;
    }

    public void setChaveUsuario(String chaveUsuario) {
        this.chaveUsuario = chaveUsuario;
    }
}
