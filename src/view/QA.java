package view;

import dao.CedenteDao;
import dao.OperacaoDao;
import dao.UsuarioDao;
import model.Cedente;

public class QA {
    public static void main(String[] args){
        CedenteDao c = new CedenteDao();
        System.out.println(c.listar());;


    }
}
