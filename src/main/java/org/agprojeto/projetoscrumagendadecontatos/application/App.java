package org.agprojeto.projetoscrumagendadecontatos.application;

import org.agprojeto.projetoscrumagendadecontatos.db.DB;

import java.sql.Connection;

public class App {
    public static void main(String[] args) {

        try (Connection conexao = DB.getConexao()) {

            if (conexao != null && !conexao.isClosed()) {
                System.out.println("Conexão estabelecida com sucesso!");
            } else {
                System.out.println("Falha ao estabelecer a conexão.");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
