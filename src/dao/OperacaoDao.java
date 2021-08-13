package dao;


import model.OperacaoInner;

import java.awt.geom.RectangularShape;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OperacaoDao {
    //Atributos da classe OperacaoDao
    private Connection conn;
    private PreparedStatement query;
    private PreparedStatement use;
    private String u = "USE banpar";
    private ResultSet res;

    //LISTANDO TODAS AS LINHAS DA TABELA OPERACAO COM INNER PARA MOSTRAR OS NOMES E USUARIO DE CADA OPERACAO
    public List<OperacaoInner> listar() {
        List<OperacaoInner> operacoes = new ArrayList<>();
        try {
            conn = Conexao.abreConexao();
            assert conn != null;
            use = conn.prepareStatement(u);
            use.executeQuery();
            query = conn.prepareStatement
                    ("SELECT " +
                            "id_operacao \n" +
                            ",cedente.nome_cedente \n" +
                            ",usuario.usuario\n" +
                            ",qtd_titulos \n" +
                            ",valor_total \n" +
                            "from operacao\n" +
                            "inner join cedente \n" +
                            "on operacao.id_cedente = cedente.id_cedente\n" +
                            "inner join usuario\n" +
                            "on operacao.id_usuario = usuario.id_usuario"
                    );
            res = query.executeQuery();

            while (res.next()) {
                OperacaoInner o = new OperacaoInner();
                o.setId_operacao(res.getInt("id_operacao"));
                o.setNome_cedente(res.getString("nome_cedente"));
                o.setUsuario(res.getString("usuario"));
                o.setQtd_titulos(res.getInt("qtd_titulos"));
                o.setValor_total(res.getDouble("valor_total"));

                operacoes.add(o);
            }
            conn.close();
            use.close();
            query.close();
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
        return operacoes;
    }
}
