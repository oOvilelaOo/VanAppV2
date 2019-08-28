package com.example.teste.ui.main.VOs;

public class EstudaVO {

    private String codEscola;
    private String codEstuda;
    private String cpfUsuario;

    public EstudaVO(String codEscola, String codEstuda, String cpfUsuario) {
        this.codEscola = codEscola;
        this.codEstuda = codEstuda;
        this.cpfUsuario = cpfUsuario;
    }

    public String getCodEscola() {
        return codEscola;
    }

    public void setCodEscola(String codEscola) {
        this.codEscola = codEscola;
    }

    public String getCodEstuda() {
        return codEstuda;
    }

    public void setCodEstuda(String codEstuda) {
        this.codEstuda = codEstuda;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }
}
