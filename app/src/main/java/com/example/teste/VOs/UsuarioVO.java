package com.example.teste.VOs;

import java.io.Serializable;

public class UsuarioVO implements Serializable {

    private String email;
    private String nome;
    private String senha;
    private String usuario;

    public UsuarioVO() {

    }

    public UsuarioVO(String email, String nome, String senha, String usuario) {
        this.email = email;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
