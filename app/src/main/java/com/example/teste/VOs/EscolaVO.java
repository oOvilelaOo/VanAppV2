package com.example.teste.VOs;

import java.io.Serializable;

public class EscolaVO implements Serializable {

    private String codInepMec;
    private String nome;

    public EscolaVO() {

    }

    public EscolaVO(String codInepMec, String nome) {
        this.codInepMec = codInepMec;
        this.nome = nome;
    }

    public String getCodInepMec() {
        return codInepMec;
    }

    public void setCodInepMec(String codInepMec) {
        this.codInepMec = codInepMec;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
