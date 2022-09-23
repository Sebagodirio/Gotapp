package com.example.gotapp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "login")
public class Login {
    @DatabaseField(id = true)
    private Integer id;
    @DatabaseField
    private String  usuario;
    @DatabaseField
    private String password;

    public Login(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
