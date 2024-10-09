package com.santander.geradordto;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521/XE";
        String user = "seu_usuario";
        String password = "sua_senha";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão bem-sucedida!");

            String sql = "SELECT * FROM sua_tabela";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    // Supondo que sua tabela tenha colunas id e nome
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    System.out.println("ID: " + id + ", Nome: " + nome);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados:");
            e.printStackTrace();
        }
    }
}