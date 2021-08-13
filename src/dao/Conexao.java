package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    //Atributos da classe Conexa
    private static String connectionString = "jdbc:mysql://localhost:3306";
    private static String user = "root";
    private static String pass = "@Abc123";

    //Funcao que abre a conexão com o banco dados
    public static Connection abreConexao() {
        try {
            return DriverManager.getConnection(connectionString, user, pass);
        } catch (SQLException erro) {
            System.out.println("SQLException");
            System.out.println(erro.getMessage());
        } catch (Exception erro) {
            System.out.println("Exception");
            System.out.println(erro.getMessage());
        }
        return null;
    }
}
