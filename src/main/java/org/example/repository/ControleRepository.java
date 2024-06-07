package org.example.repository;

import org.example.annotations.Query;
import org.example.config.DataBase;
import org.example.entities.Controle;
import org.example.utils.Log4jLogger;
import org.example.infrastructure.QueryProcessor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class ControleRepository extends _BaseRepositoryImpl<Controle> {
    Log4jLogger<Controle> logger = new Log4jLogger<>(Controle.class);
    private final DataBase databaseConnection = new DataBase();
    public static final String TB_NAME = "GS_CONTROLE";

    public static final HashMap<String, String> TB_COLUMNS = new HashMap<>() {{
        put("COD_ADMINISTRADOR", "COD_ADMINISTRADOR");
        put("NOME", "NOME");
        put("GS_LOGIN_COD_LOGIN", "GS_LOGIN_COD_LOGIN");
    }};

    public ControleRepository() {
        super(Controle.class);
    }

    @Query("INSERT INTO GS_CONTROLE (COD_ADMINISTRADOR, NOME, GS_LOGIN_COD_LOGIN) VALUES (?, ?, ?)")
    public void create(Controle controle, int loginId) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "create", controle.getCodAdministrador(), controle.getNome(), loginId);
            logger.logCreate(controle);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating controle: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_CONTROLE WHERE COD_ADMINISTRADOR = ?")
    public Controle readById(int id) {
        try {
            return QueryProcessor.executeSingleResultQuery(this, rs -> {
                Controle controle = new Controle(
                        rs.getInt("COD_ADMINISTRADOR"),
                        rs.getString("NOME")
                );
                logger.logReadById(controle);
                return controle;
            }, "readById", id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading controle by id: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_CONTROLE ORDER BY COD_ADMINISTRADOR ASC")
    public List<Controle> readAll() {
        try {
            return QueryProcessor.executeSelectQuery(this, rs -> {
                Controle controle = new Controle(
                        rs.getInt("COD_ADMINISTRADOR"),
                        rs.getString("NOME")
                );
                logger.logReadAll();
                return controle;
            }, "readAll");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading all controles: " + e.getMessage());
        }
    }

    @Query("UPDATE GS_CONTROLE SET NOME = ?, GS_LOGIN_COD_LOGIN = ? WHERE COD_ADMINISTRADOR = ?")
    public boolean updateById(Controle controle, int id, int loginId) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "updateById", controle.getNome(), loginId, id);
            logger.logUpdateById(controle);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating controle: " + e.getMessage());
        }
    }

    @Query("DELETE FROM GS_CONTROLE WHERE COD_ADMINISTRADOR = ?")
    public boolean deleteById(int id) {
        try {
            Controle deletedControle = readById(id);
            QueryProcessor.executeAnnotatedMethod(this, "deleteById", id);
            logger.logDeleteById(deletedControle);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting controle: " + e.getMessage());
        }
    }
}

