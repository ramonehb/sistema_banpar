package dao;

import model.Cedente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CedenteDao extends Cedente {

    private Connection conn;
    private PreparedStatement use;
    private PreparedStatement query;
    private ResultSet res;
    ;

    public List<Cedente> listar() {
        List<Cedente> cedentes = new ArrayList<>();

        try {
            conn = Conexao.abreConexao();
            assert conn != null;
            use = conn.prepareStatement("USE banpar");
            use.executeQuery();
            query = conn.prepareStatement("SELECT * FROM cedente");
            res = query.executeQuery();

            while (res.next()) {
                Cedente c = new Cedente();                c.setId_cedente(res.getInt("id_cedente"));
                c.setNome_cedente(res.getString("nome_cedente"));
                c.setEndereco(res.getString("endereco"));
                c.setEmail_cedente(res.getString("email_cedente"));

                cedentes.add(c);
            }
            use.close();
            query.close();
            conn.close();
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
        return cedentes;
    }

    public void cadastrar(String nome, String endereco, String email) {
        try {
           conn = Conexao.abreConexao();
            assert conn != null;
            use = conn.prepareStatement("USE banpar");
            query = conn.prepareStatement("INSERT INTO cedente (nome_cedente, endereco, email_cedente) VALUES (?,?,?)");
            query.setString(1, nome);
            query.setString(2, endereco);
            query.setString(3, email);
            boolean resultadoQuery = query.execute();

            if (!resultadoQuery) {
                System.out.println("\n--------------------------------CEDENTE CADASTRADO COM SUCESSO-------------------------------------\n");
            } else {
                System.out.println("\n----------------------------------NÂO FOI POSSIVEL CADASTRAR O CEDENTE-------------------------------------\n");
            }
            use.close();
            query.close();
            conn.close();
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }

    public Cedente selecionar(int id) {

        try {
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement use = conn.prepareStatement("USE banpar");
            use.executeQuery();
            PreparedStatement query = conn.prepareStatement("SELECT * FROM cedente where id_cedente = ?");
            query.setInt(1, id);
            ResultSet res = query.executeQuery();
            Cedente c = new Cedente();
            if (res.next()) {
                c.setId_cedente(res.getInt("id_cedente"));
                c.setNome_cedente(res.getString("nome_cedente"));
                c.setEndereco(res.getString("endereco"));
                c.setEmail_cedente(res.getString("email_cedente"));
            }
            return c;
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }

    public void atualizar(int id, String nome, String endereco, String email) {
        try {
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement use = conn.prepareStatement("USE banpar");
            use.executeQuery();
            PreparedStatement query = conn.prepareStatement("UPDATE cedente SET nome_cedente = ? ,endereco = ?, email_cedente = ? WHERE id_cedente = ?");
            query.setString(1, nome);
            query.setString(2, endereco);
            query.setString(3, email);
            query.setInt(4, id);

            if (!query.execute()) {
                System.out.println("\n---------------------------------CEDENTE ATUALIZADO COM SUCESSO-------------------------------------\n");
            } else {
                System.out.println("\n---------------------------------CEDENTE NÂO ATUALIZADO-------------------------------------\n");
            }
            use.close();
            query.close();
            conn.close();
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }

    public void deletar(int id) {
        try {
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement use = conn.prepareStatement("USE banpar");
            use.executeQuery();
            PreparedStatement query = conn.prepareStatement("DELETE FROM cedente WHERE id_cedente = ?");
            query.setInt(1, id);
            boolean resultadoQuery = query.execute();
            if (!resultadoQuery) {
                System.out.println("\n---------------------------------CEDENTE EXCLUIDO COM SUCESSO-------------------------------------\n");
            } else {
                System.out.println("\n---------------------------------NÂO FOI POSSIVEL EXCLUIR O CEDENTE-------------------------------------\n");
            }
            conn.close();
            use.close();
            query.close();
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }
}
