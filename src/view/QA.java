package view;

import dao.CedenteDao;
import dao.OperacaoDao;
import dao.UsuarioDao;
import model.Cedente;

public class QA {
    public static void main(String[] args){
        OperacaoDao o = new OperacaoDao();
        System.out.println(o.listar());;


    }
}
