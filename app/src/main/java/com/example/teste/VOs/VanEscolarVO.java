package com.example.teste.VOs;

import java.io.Serializable;

public class VanEscolarVO implements Serializable {

    private String DataUltRevis;
    private String ano;
    private String cnh;
    private String codModelo;
    private int numAcentos;
    private int vagas;

    public VanEscolarVO() {
    }

    public VanEscolarVO(String dataUltRevis, String ano, String cnh, String codModelo, int numAcentos, int vagas) {
        DataUltRevis = dataUltRevis;
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

    public int getNumAcentos() {
        return numAcentos;
    }

    public void setNumAcentos(int numAcentos) {
        this.numAcentos = numAcentos;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
}
