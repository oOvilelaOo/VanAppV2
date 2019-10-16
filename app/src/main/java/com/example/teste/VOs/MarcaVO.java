package com.example.teste.VOs;

import java.io.Serializable;

public class MarcaVO implements Serializable {

    private String codMarca;
    private String nome;

    public MarcaVO() {
    }

    public MarcaVO(String codMarca, String nome) {
        this.codMarca = codMarca;
        this.nome = nome;
    }

    public String getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(String codMarca) {
        this.codMarca = codMarca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
