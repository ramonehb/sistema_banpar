package model;

public class Operacao {
    public int id_operacao;
    public int id_cedente;
    public int id_usuario;
    public int qtd_titulos;
    public double valor_total;
    public boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_operacao() {
        return id_operacao;
    }

    public void setId_operacao(int id_operacao) {
        this.id_operacao = id_operacao;
    }

    public int getId_cedente() {
        return id_cedente;
    }

    public void setId_cedente(int id_cedente) {
        this.id_cedente = id_cedente;
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
        return "\nID:" + id_operacao + ", Nome do Cedente: " + id_cedente + ",Nome do usuário responsavel:" + id_usuario + ", Quantida de titulos na carteira" + qtd_titulos + "Valor total do titulos " + valor_total + "\n";
    }
}
