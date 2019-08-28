package com.example.teste.ui.main.VOs;

public class VanEscolarVO {

    private String DataUltRevis;
    private String id;
    private String ano;
    private String cnh;
    private String codModelo;
    private String numAcentos;
    private String vagas;

    public VanEscolarVO(String dataUltRevis, String id, String ano, String cnh, String codModelo, String numAcentos, String vagas) {
        DataUltRevis = dataUltRevis;
        this.id = id;
        this.ano = ano;
        this.cnh = cnh;
        this.codModelo = codModelo;
        this.numAcentos = numAcentos;
        this.vagas = vagas;
    }

    public String getDataUltRevis() {
        return DataUltRevis;
    }

    public void setDataUltRevis(String dataUltRevis) {
        DataUltRevis = dataUltRevis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCodModelo() {
        return codModelo;
    }

    public void setCodModelo(String codModelo) {
        this.codModelo = codModelo;
    }

    public String getNumAcentos() {
        return numAcentos;
    }

    public void setNumAcentos(String numAcentos) {
        this.numAcentos = numAcentos;
    }

    public String getVagas() {
        return vagas;
    }

    public void setVagas(String vagas) {
        this.vagas = vagas;
    }
}
