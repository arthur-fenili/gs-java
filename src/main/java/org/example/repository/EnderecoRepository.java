package org.example.repository;


import org.example.annotations.Query;
import org.example.config.DataBase;
import org.example.entities.Endereco;
import org.example.infrastructure.QueryProcessor;
import org.example.utils.Log4jLogger;

import java.util.HashMap;
import java.util.List;

public class EnderecoRepository extends _BaseRepositoryImpl<Endereco> {
    Log4jLogger<Endereco> logger = new Log4jLogger<>(Endereco.class);
    private final DataBase databaseConnection = new DataBase();
    public static final String TB_NAME = "GS_ENDERECO";

    public static final HashMap<String, String> TB_COLUMNS = new HashMap<>() {{
        put("COD_ENDERECO", "COD_ENDERECO");
        put("RUA", "RUA");
        put("NUMERO", "NUMERO");
        put("COMPLEMENTO", "COMPLEMENTO");
        put("CEP", "CEP");
        put("BAIRRO", "BAIRRO");
        put("CIDADE", "CIDADE");
        put("ESTADO", "ESTADO");
        put("PAIS", "PAIS");
    }};

    public EnderecoRepository() {
        super(Endereco.class);
    }


    @Query("INSERT INTO GS_ENDERECO (COD_ENDERECO, RUA, NUMERO, COMPLEMENTO, CEP, BAIRRO, CIDADE, ESTADO, PAIS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")
    public void create(Endereco endereco) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "create", endereco.getId(), endereco.getRua(), endereco.getNumero(),
                    endereco.getComplemento(), endereco.getCep(), endereco.getBairro(), endereco.getCidade(),
                    endereco.getEstado(), endereco.getPais());
            logger.logCreate(endereco);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating endereco: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_ENDERECO WHERE COD_ENDERECO = ?")
    public Endereco readById(int id) {
        try {
            return QueryProcessor.executeSingleResultQuery(this, rs -> {
                Endereco endereco = new Endereco(
                        rs.getString("RUA"),
                        rs.getString("NUMERO"),
                        rs.getString("COMPLEMENTO"),
                        rs.getString("CEP"),
                        rs.getString("BAIRRO"),
                        rs.getString("CIDADE"),
                        rs.getString("ESTADO"),
                        rs.getString("PAIS")
                );
                logger.logReadById(endereco);
                return endereco;
            }, "readById", id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading endereco by id: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_ENDERECO ORDER BY COD_ENDERECO ASC")
    public List<Endereco> readAll() {
        try {
            return QueryProcessor.executeSelectQuery(this, rs -> {
                Endereco endereco = new Endereco(
                        rs.getString("RUA"),
                        rs.getString("NUMERO"),
                        rs.getString("COMPLEMENTO"),
                        rs.getString("CEP"),
                        rs.getString("BAIRRO"),
                        rs.getString("CIDADE"),
                        rs.getString("ESTADO"),
                        rs.getString("PAIS")
                );
                logger.logReadAll();
                return endereco;
            }, "readAll");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading all enderecos: " + e.getMessage());
        }
    }

    @Query("UPDATE GS_ENDERECO SET RUA = ?, NUMERO = ?, COMPLEMENTO = ?, CEP = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?, PAIS = ? WHERE COD_ENDERECO = ?")
    public boolean updateById(Endereco endereco, int id) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "updateById", endereco.getRua(), endereco.getNumero(),
                    endereco.getComplemento(), endereco.getCep(), endereco.getBairro(), endereco.getCidade(),
                    endereco.getEstado(), endereco.getPais(), id);
            logger.logUpdateById(endereco);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating endereco: " + e.getMessage());
        }
    }

    @Query("DELETE FROM GS_ENDERECO WHERE COD_ENDERECO = ?")
    public boolean deleteById(int id) {
        try {
            Endereco deletedEndereco = readById(id);
            QueryProcessor.executeAnnotatedMethod(this, "deleteById", id);
            logger.logDeleteById(deletedEndereco);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting endereco: " + e.getMessage());
        }
    }
}