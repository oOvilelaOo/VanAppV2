package com.example.teste.VOs;

public class ModeloVO {

    private String cod;
    private String codMarca;
    private String modelo;

    public ModeloVO(String cod, String codMarca, String modelo) {
        this.cod = cod;
        this.codMarca = codMarca;
        this.modelo = modelo;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(String codMarca) {
        this.codMarca = codMarca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
