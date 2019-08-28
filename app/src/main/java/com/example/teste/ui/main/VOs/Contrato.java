package com.example.teste.ui.main.VOs;

public class Contrato {

    private String cnh;
    private String cpf;
    private String cod;
    private String codInepMec;
    private String hrEntrada;
    private String hrSaida;
    private String nomeAluno;

    public Contrato(String cnh, String cpf, String cod, String codInepMec, String hrEntrada, String hrSaida, String nomeAluno) {
        this.cnh = cnh;
        this.cpf = cpf;
        this.cod = cod;
        this.codInepMec = codInepMec;
        this.hrEntrada = hrEntrada;
        this.hrSaida = hrSaida;
        this.nomeAluno = nomeAluno;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCodInepMec() {
        return codInepMec;
    }

    public void setCodInepMec(String codInepMec) {
        this.codInepMec = codInepMec;
    }

    public String getHrEntrada() {
        return hrEntrada;
    }

    public void setHrEntrada(String hrEntrada) {
        this.hrEntrada = hrEntrada;
    }

    public String getHrSaida() {
        return hrSaida;
    }

    public void setHrSaida(String hrSaida) {
        this.hrSaida = hrSaida;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
}
