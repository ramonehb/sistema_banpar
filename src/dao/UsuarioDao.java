package dao;

import model.Usuario;

import javax.swing.plaf.metal.MetalRootPaneUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao extends Usuario {
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement query;
    private PreparedStatement use;
    private String us = "USE banpar";


    //ATUALIZAR USUÁRIO
    public void atualizar(String usuario, String senha, String email, String data, int nivel_acesso, int id) {
        try {
            conn = new ConnectionFactory().getConnection();
            use = conn.prepareStatement(us);
            use.executeQuery();
            query = conn.prepareStatement("UPDATE usuario SET usuario = ?, senha = ?, email = ?," +
                    "data_nascimento = ?, id_nivel_acesso = ? WHERE id_usuario = ?");
            query.setString(1, usuario);
            query.setString(2, senha);
            query.setString(3, email);
            query.setString(4, data);
            query.setInt(5, nivel_acesso);
            query.setInt(6, id);
            boolean resultQuery = query.execute();

            if (!resultQuery) {
                System.out.println("\n---------------------------------USUÁRIO ATUALIZADO COM SUCESSO-------------------------------------\n");
            } else {
                System.out.println("\n---------------------------------USUÁRIO NÃO ATUALIZADO-------------------------------------\n");
            }
            use.close();;
            query.close();;
            conn.close();;
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }

    //SELECT POR USUARIO E SENHA
    public boolean verificarAcesso(String usuario, String senha) {
        boolean autenticacao = false;
        try {

            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement use = conn.prepareStatement("USE banpar");
            use.executeQuery();
            String selectAll = "SELECT * FROM usuario WHERE usuario='" + usuario + "' AND senha='" + senha + "'";
            PreparedStatement query = conn.prepareStatement(selectAll);
            ResultSet resultado = query.executeQuery();

            if (resultado.next()) {
                autenticacao = true;
            }
            use.close();
            query.close();
            conn.close();
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
        return autenticacao;
    }

    //INSERT PASSANDO OS PARAMENTROS
    public void cadastrar(String usuario, String senha, String email, String data, int nivel_acesso) {

        try {
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement use = conn.prepareStatement("USE banpar");
            use.executeQuery();
            String insert = "INSERT INTO usuario (usuario,senha,email,data_nascimento,id_nivel_acesso) VALUES (?,?,?,?,?)";
            PreparedStatement query = conn.prepareStatement(insert);
            query.setString(1, usuario);
            query.setString(2, senha);
            query.setString(3, email);
            query.setString(4, data);
            query.setInt(5, nivel_acesso);
            boolean resultadoQuery = query.execute();
            if (!resultadoQuery) {
                System.out.println("\n---------------------------------CADASTRADO COM SUCESSO-------------------------------------\n");
            } else {
                System.out.println("\n---------------------------------USUÁRIO NÃO CADASTRADO !-------------------------------------\n");
            }
            use.close();
            query.close();
            conn.close();
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }

    }

    //SELECT POR NOME
    public List<Usuario> selectNome(String nome) {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement use = conn.prepareStatement("USE banpar");
            use.executeQuery();
            String like = "SELECT * FROM usuario WHERE usuario LIKE '%" + nome + "%'";
            PreparedStatement query = conn.prepareStatement(like);
            ResultSet res = query.executeQuery();
            int contador = 0;
            while (res.next()) {
                contador++;
                Usuario us = new Usuario();
                us.setId(res.getInt("id_usuario"));
                us.setUsuario(res.getString("usuario"));
                us.setSenha(res.getString("senha"));
                us.setEmail(res.getString("email"));
                us.setData(res.getDate("data_nascimento"));
                us.setNivel_acesso(res.getInt("id_nivel_acesso"));
                usuarios.add(us);
            }
            if (contador == 1) {
                System.out.println("Usuário Localizado");
            } else if (contador > 1) {
                System.out.println("Usuários Localizados");
            } else {
                System.out.println("Usuário não Localizado");
            }

            use.close();
            query.close();
            conn.close();

            return usuarios;
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }

    }

    //SELECT ALL
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement use = con.prepareStatement("USE banpar");
            use.executeQuery();
            PreparedStatement smt = con.prepareStatement("SELECT * FROM usuario");
            ResultSet res = smt.executeQuery();

            while (res.next()) {
                Usuario u = new Usuario();
                u.setId(res.getInt("id_usuario"));
                u.setUsuario(res.getString("usuario"));
                u.setSenha(res.getString("senha"));
                u.setEmail(res.getString("email"));
                u.setData(res.getDate("data_nascimento"));
                u.setNivel_acesso(res.getInt("id_nivel_acesso"));
                usuarios.add(u);
            }
            res.close();
            smt.close();
            con.close();
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
        return usuarios;
    }

    //SELECT POR ID
    public Usuario select(int id_usuario) {
        try {
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement use = conn.prepareStatement("USE banpar");
            use.executeQuery();
            PreparedStatement query = conn.prepareStatement("SELECT * FROM usuario WHERE id_usuario = ?");
            query.setInt(1, id_usuario);
            ResultSet res = query.executeQuery();
            Usuario us = new Usuario();
            if (res.next()) {
                us.setId(res.getInt("id_usuario"));
                us.setUsuario(res.getString("usuario"));
                us.setSenha(res.getString("senha"));
                us.setEmail(res.getString("email"));
                us.setData(res.getDate("data_nascimento"));
                us.setNivel_acesso(res.getInt("id_nivel_acesso"));
            }
            use.close();
            query.close();
            conn.close();
            return us;
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }

    //DELETE POR ID
    public void delete(int id) {
        try {
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement use = conn.prepareStatement("USE banpar");
            use.executeQuery();
            PreparedStatement query = conn.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
            query.setInt(1, id);
            query.execute();
            System.out.println("---------------------------------EXCLUIDO COM SUCESSO-------------------------------------\n");
            use.close();
            query.close();
            conn.close();
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }


    }
}
