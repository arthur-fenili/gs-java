package org.example.repository;

import org.example.annotations.Query;
import org.example.config.DataBase;
import org.example.entities.Cliente;
import org.example.infrastructure.QueryProcessor;
import org.example.utils.Log4jLogger;

import java.util.HashMap;
import java.util.List;

public class ClienteRepository extends _BaseRepositoryImpl<Cliente> {
    Log4jLogger<Cliente> logger = new Log4jLogger<>(Cliente.class);
    private final DataBase databaseConnection = new DataBase();
    public static final String TB_NAME = "GS_CLIENTE";

    public static final HashMap<String, String> TB_COLUMNS = new HashMap<>() {{
        put("COD_CLIENTE", "COD_CLIENTE");
        put("NOME", "NOME");
        put("EMAIL", "EMAIL");
        put("TELEFONE", "TELEFONE");
        put("GS_ENDERECO_COD_ENDERECO", "GS_ENDERECO_COD_ENDERECO");
    }};

    public ClienteRepository() {
        super(Cliente.class);
    }

    @Query("INSERT INTO GS_CLIENTE (COD_CLIENTE, NOME, EMAIL, TELEFONE, GS_ENDERECO_COD_ENDERECO) VALUES (?, ?, ?, ?, ?)")
    public void create(Cliente cliente) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "create", cliente.getId(), cliente.getNome(), cliente.getEmail(),
                    cliente.getTelefone(), cliente.getCod_endereco());
            logger.logCreate(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating cliente: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_CLIENTE WHERE COD_CLIENTE = ?")
    public Cliente readById(int id) {
        try {
            return QueryProcessor.executeSingleResultQuery(this, rs -> {
                Cliente cliente = new Cliente(
                        rs.getString("NOME"),
                        rs.getString("EMAIL"),
                        rs.getString("TELEFONE")
                );
                logger.logReadById(cliente);
                return cliente;
            }, "readById", id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading cliente by id: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_CLIENTE ORDER BY COD_CLIENTE ASC")
    public List<Cliente> readAll() {
        try {
            return QueryProcessor.executeSelectQuery(this, rs -> {
                Cliente cliente = new Cliente(
                        rs.getString("NOME"),
                        rs.getString("EMAIL"),
                        rs.getString("TELEFONE")
                );
                logger.logReadAll();
                return cliente;
            }, "readAll");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading all clientes: " + e.getMessage());
        }
    }

    @Query("UPDATE GS_CLIENTE SET NOME = ?, EMAIL = ?, TELEFONE = ?, GS_ENDERECO_COD_ENDERECO = ? WHERE COD_CLIENTE = ?")
    public boolean updateById(Cliente cliente, int id, int enderecoId) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "updateById", cliente.getNome(), cliente.getEmail(),
                    cliente.getTelefone(), enderecoId, id);
            logger.logUpdateById(cliente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating cliente: " + e.getMessage());
        }
    }

    @Query("DELETE FROM GS_CLIENTE WHERE COD_CLIENTE = ?")
    public boolean deleteById(int id) {
        try {
            Cliente deletedCliente = readById(id);
            QueryProcessor.executeAnnotatedMethod(this, "deleteById", id);
            logger.logDeleteById(deletedCliente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting cliente: " + e.getMessage());
        }
    }
}
