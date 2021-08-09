package view;

import dao.CedenteDao;
import dao.OperacaoDao;
import dao.UsuarioDao;
import model.Cedente;

public class QA {
    public static void main(String[] args){
        UsuarioDao us = new UsuarioDao();
        String usuario = "Teste";
        String senha = "12333";
        String email = "lipi@hotmail.com";
        String data = "2021-08-06";
        int nivel = 1;
        int id = 1;
        us.atualizar(usuario, senha, email, data, nivel, id);


    }
}
