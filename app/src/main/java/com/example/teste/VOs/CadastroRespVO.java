package com.example.teste.VOs;

public class CadastroRespVO {

    private final String uuid;
    private final String username;
    private final String profileUrl;


    public CadastroRespVO(String uuid, String username, String profileUrl) {
        this.uuid = uuid;
        this.username = username;
        this.profileUrl = profileUrl;
    }


    public String getProfileUrl() {
        return profileUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getUuid() {
        return uuid;
    }
}
