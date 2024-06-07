package org.example.repository;

import org.example.annotations.Query;
import org.example.config.DataBase;
import org.example.entities.UsuarioAplicacao;
import org.example.utils.Log4jLogger;
import org.example.infrastructure.QueryProcessor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class UsuarioAplicacaoRepository extends _BaseRepositoryImpl<UsuarioAplicacao> {
    Log4jLogger<UsuarioAplicacao> logger = new Log4jLogger<>(UsuarioAplicacao.class);
    private final DataBase databaseConnection = new DataBase();
    public static final String TB_NAME = "GS_USUARIO_APLICACAO";

    public static final HashMap<String, String> TB_COLUMNS = new HashMap<>() {{
        put("COD_USUARIO", "COD_USUARIO");
        put("NOME", "NOME");
        put("GS_LOGIN_COD_LOGIN", "GS_LOGIN_COD_LOGIN");
        put("TELEFONE", "TELEFONE");
        put("COD_ENDERECO", "COD_ENDERECO");
        put("GS_CLIENTE_COD_CLIENTE", "GS_CLIENTE_COD_CLIENTE");
    }};

    public UsuarioAplicacaoRepository() {
        super(UsuarioAplicacao.class);
        initialize();
    }

    public void initialize() {
        String checkTableExistsSQL = "SELECT COUNT(*) FROM USER_TABLES WHERE TABLE_NAME = '" + TB_NAME.toUpperCase() + "'";
        String createTableSQL = "CREATE TABLE " + TB_NAME + " ("
                + "COD_USUARIO INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, "
                + "NOME VARCHAR2(255) NOT NULL, "
                + "GS_LOGIN_COD_LOGIN INTEGER NOT NULL, "
                + "TELEFONE VARCHAR2(20), "
                + "COD_ENDERECO INTEGER, "
                + "GS_CLIENTE_COD_CLIENTE INTEGER NOT NULL, "
                + "CONSTRAINT fk_login FOREIGN KEY (GS_LOGIN_COD_LOGIN) REFERENCES GS_LOGIN(COD_LOGIN), "
                + "CONSTRAINT fk_endereco FOREIGN KEY (COD_ENDERECO) REFERENCES GS_ENDERECO(COD_ENDERECO), "
                + "CONSTRAINT fk_cliente FOREIGN KEY (GS_CLIENTE_COD_CLIENTE) REFERENCES GS_CLIENTE(COD_CLIENTE))";

        try (Connection connection = databaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // Verifica se a tabela já existe
            ResultSet rs = statement.executeQuery(checkTableExistsSQL);
            if (rs.next() && rs.getInt(1) == 0) {
                // Cria a tabela se não existir
                statement.execute(createTableSQL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing the database: " + e.getMessage());
        }
    }

    @Query("INSERT INTO GS_USUARIO_APLICACAO (NOME, GS_LOGIN_COD_LOGIN, TELEFONE, COD_ENDERECO, GS_CLIENTE_COD_CLIENTE) VALUES (?, ?, ?, ?, ?)")
    public void create(UsuarioAplicacao usuarioAplicacao, int loginId, Integer enderecoId, int clienteId) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "create", usuarioAplicacao.getNome(), loginId,
                    usuarioAplicacao.getTelefone(), enderecoId, clienteId);
            logger.logCreate(usuarioAplicacao);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating usuarioAplicacao: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_USUARIO_APLICACAO WHERE COD_USUARIO = ?")
    public UsuarioAplicacao readById(int id) {
        try {
            return QueryProcessor.executeSingleResultQuery(this, rs -> {
                UsuarioAplicacao usuarioAplicacao = new UsuarioAplicacao(
                        rs.getString("NOME"),
                        rs.getString("TELEFONE")
                );
                logger.logReadById(usuarioAplicacao);
                return usuarioAplicacao;
            }, "readById", id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading usuarioAplicacao by id: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_USUARIO_APLICACAO ORDER BY COD_USUARIO ASC")
    public List<UsuarioAplicacao> readAll() {
        try {
            return QueryProcessor.executeSelectQuery(this, rs -> {
                UsuarioAplicacao usuarioAplicacao = new UsuarioAplicacao(
                        rs.getString("NOME"),
                        rs.getString("TELEFONE")
                );
                logger.logReadAll();
                return usuarioAplicacao;
            }, "readAll");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading all usuarioAplicacaos: " + e.getMessage());
        }
    }

    @Query("UPDATE GS_USUARIO_APLICACAO SET NOME = ?, GS_LOGIN_COD_LOGIN = ?, TELEFONE = ?, COD_ENDERECO = ?, GS_CLIENTE_COD_CLIENTE = ? WHERE COD_USUARIO = ?")
    public boolean updateById(UsuarioAplicacao usuarioAplicacao, int id, int loginId, Integer enderecoId, int clienteId) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "updateById", usuarioAplicacao.getNome(), loginId,
                    usuarioAplicacao.getTelefone(), enderecoId, clienteId, id);
            logger.logUpdateById(usuarioAplicacao);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating usuarioAplicacao: " + e.getMessage());
        }
    }

    @Query("DELETE FROM GS_USUARIO_APLICACAO WHERE COD_USUARIO = ?")
    public boolean deleteById(int id) {
        try {
            UsuarioAplicacao deletedUsuarioAplicacao = readById(id);
            QueryProcessor.executeAnnotatedMethod(this, "deleteById", id);
            logger.logDeleteById(deletedUsuarioAplicacao);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting usuarioAplicacao: " + e.getMessage());
        }
    }
}