package org.example.repository;

import org.example.annotations.Query;
import org.example.config.DataBase;
import org.example.entities.Doacao;
import org.example.utils.Log4jLogger;
import org.example.infrastructure.QueryProcessor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class DoacaoRepository extends _BaseRepositoryImpl<Doacao> {
    Log4jLogger<Doacao> logger = new Log4jLogger<>(Doacao.class);
    private final DataBase databaseConnection = new DataBase();
    public static final String TB_NAME = "GS_DOACAO";

    public static final HashMap<String, String> TB_COLUMNS = new HashMap<>() {{
        put("COD_DOACAO", "COD_DOACAO");
        put("DATA_DOACAO", "DATA_DOACAO");
        put("VALOR", "VALOR");
        put("COD_CLIENTE", "COD_CLIENTE");
        put("GS_USUARIO_APLICACAO_COD_USUARIO", "GS_USUARIO_APLICACAO_COD_USUARIO");
    }};

    public DoacaoRepository() {
        super(Doacao.class);
    }
    @Query("INSERT INTO GS_DOACAO (DATA_DOACAO, VALOR, COD_CLIENTE, GS_USUARIO_APLICACAO_COD_USUARIO) VALUES (?, ?, ?, ?)")
    public void create(Doacao doacao, int clienteId, int usuarioAplicacaoId) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "create", doacao.getDataDoacao(), doacao.getValor(), clienteId, usuarioAplicacaoId);
            logger.logCreate(doacao);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating doacao: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_DOACAO WHERE COD_DOACAO = ?")
    public Doacao readById(int id) {
        try {
            return QueryProcessor.executeSingleResultQuery(this, rs -> {
                Doacao doacao = new Doacao(
                        rs.getDate("DATA_DOACAO"),
                        rs.getDouble("VALOR")
                );
                logger.logReadById(doacao);
                return doacao;
            }, "readById", id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading doacao by id: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_DOACAO ORDER BY COD_DOACAO ASC")
    public List<Doacao> readAll() {
        try {
            return QueryProcessor.executeSelectQuery(this, rs -> {
                Doacao doacao = new Doacao(
                        rs.getDate("DATA_DOACAO"),
                        rs.getDouble("VALOR")
                );
                logger.logReadAll();
                return doacao;
            }, "readAll");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading all doacoes: " + e.getMessage());
        }
    }

    @Query("UPDATE GS_DOACAO SET DATA_DOACAO = ?, VALOR = ?, COD_CLIENTE = ?, GS_USUARIO_APLICACAO_COD_USUARIO = ? WHERE COD_DOACAO = ?")
    public boolean updateById(Doacao doacao, int id, int clienteId, int usuarioAplicacaoId) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "updateById", doacao.getDataDoacao(), doacao.getValor(), clienteId, usuarioAplicacaoId, id);
            logger.logUpdateById(doacao);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating doacao: " + e.getMessage());
        }
    }

    @Query("DELETE FROM GS_DOACAO WHERE COD_DOACAO = ?")
    public boolean deleteById(int id) {
        try {
            Doacao deletedDoacao = readById(id);
            QueryProcessor.executeAnnotatedMethod(this, "deleteById", id);
            logger.logDeleteById(deletedDoacao);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting doacao: " + e.getMessage());
        }
    }
}

