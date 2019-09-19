package com.example.teste.VOs;

public class MarcaVO {

    private String codMarca;
    private String marca;

    public MarcaVO(String codMarca, String marca) {
        this.codMarca = codMarca;
        this.marca = marca;
    }

    public MarcaVO() {

    }

    public String getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(String codMarca) {
        this.codMarca = codMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
