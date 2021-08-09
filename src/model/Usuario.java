package model;

import java.util.Date;

public class Usuario {
    public int id_usuario;
    public String usuario;
    public String senha;
    public String email;
    public Date data_nascimento;
    public int nivel_acesso;

    /*public Usuario(String user, String pass,String mail,Date data_nascimento) {
         this.id_usuario = 1;
         this.login = user;
         this.senha = pass;
         this.email = mail;
         this.data_nascimento = data_nascimento;
     }*/
    public int getId() {
        return id_usuario;
    }

    public void setId(int id) {
        this.id_usuario = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData() {
        return data_nascimento;
    }

    public void setData(Date data) {
        this.data_nascimento = data;
    }

    public int getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(int nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public String toString() {
        return "\nID:" + id_usuario + ", Login: " + usuario + ", Senha:" + senha + ", E-mail:" + email + ", Data de nascimento yyyy/mm/dd " + data_nascimento + "\n";
    }
}
