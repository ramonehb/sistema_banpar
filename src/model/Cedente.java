package model;

public class Cedente {

    public String nome_cedente;
    public String endereco;
    public String email_cedente;
    public int id_cedente;

    public int getId_cedente() {return id_cedente;}

    public void setId_cedente(int id_cedente) {
        this.id_cedente = id_cedente;
    }

    public String getNome_cedente() {
        return nome_cedente;
    }

    public void setNome_cedente(String nome_cedente) {
        this.nome_cedente = nome_cedente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail_cedente() {
        return email_cedente;
    }

    public void setEmail_cedente(String email_cedente) {
        this.email_cedente = email_cedente;
    }

    public String toString() {
        return "\nID:" + id_cedente + ", Nome do Cedente: " + nome_cedente + ", Endereço do Cedente:" + endereco + ", E-mail do Cedente:" + email_cedente + "\n";
    }


}
