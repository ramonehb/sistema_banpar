package model;

public class OperacaoInner {
    public int id_operacao;
    public String nome_cedente;
    public String usuario;
    public int qtd_titulos;
    public double valor_total;

    public int getId_operacao() {
        return id_operacao;
    }

    public void setId_operacao(int id_operacao) {
        this.id_operacao = id_operacao;
    }

    public String getNome_cedente() {
        return nome_cedente;
    }

    public void setNome_cedente(String nome_cedente) {
        this.nome_cedente = nome_cedente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getQtd_titulos() {
        return qtd_titulos;
    }

    public void setQtd_titulos(int qtd_titulos) {
        this.qtd_titulos = qtd_titulos;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }


    public String toString() {
        return "\nID: " + id_operacao + ",\nNome do Cedente: " + nome_cedente + "\nNome do usuário responsavel: " + usuario + "\nQuantida de Titulos na carteira: " + qtd_titulos + "\nValor Total: " + valor_total + "\n";
    }
}
