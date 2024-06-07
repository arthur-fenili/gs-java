package org.example.repository;

import org.example.annotations.Query;
import org.example.config.DataBase;
import org.example.entities.ClienteNewsletter;
import org.example.utils.Log4jLogger;
import org.example.infrastructure.QueryProcessor;
import java.util.HashMap;
import java.util.List;

public class ClienteNewsletterRepository extends _BaseRepositoryImpl<ClienteNewsletter> {
    Log4jLogger<ClienteNewsletter> logger = new Log4jLogger<>(ClienteNewsletter.class);
    private final DataBase databaseConnection = new DataBase();
    public static final String TB_NAME = "GS_CLIENTE_NEWSLETTER";

    public static final HashMap<String, String> TB_COLUMNS = new HashMap<>() {{
        put("GS_CLIENTE_COD_CLIENTE", "GS_CLIENTE_COD_CLIENTE");
        put("GS_NEWSLETTER_COD_NEWSLETTER", "GS_NEWSLETTER_COD_NEWSLETTER");
        put("DATA_ENVIO", "DATA_ENVIO");
    }};

    public ClienteNewsletterRepository() {
        super(ClienteNewsletter.class);

    }

    @Query("INSERT INTO GS_CLIENTE_NEWSLETTER (GS_CLIENTE_COD_CLIENTE, GS_NEWSLETTER_COD_NEWSLETTER, DATA_ENVIO) VALUES (?, ?, ?)")
    public void create(ClienteNewsletter clienteNewsletter, int clienteId, int newsletterId) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "create", clienteId, newsletterId, clienteNewsletter.getDataEnvio());
            logger.logCreate(clienteNewsletter);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating clienteNewsletter: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_CLIENTE_NEWSLETTER WHERE GS_CLIENTE_COD_CLIENTE = ? AND GS_NEWSLETTER_COD_NEWSLETTER = ?")
    public ClienteNewsletter readById(int clienteId, int newsletterId) {
        try {
            return QueryProcessor.executeSingleResultQuery(this, rs -> {
                ClienteNewsletter clienteNewsletter = new ClienteNewsletter(
                        rs.getDate("DATA_ENVIO")
                );
                logger.logReadById(clienteNewsletter);
                return clienteNewsletter;
            }, "readById", clienteId, newsletterId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading clienteNewsletter by id: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_CLIENTE_NEWSLETTER ORDER BY GS_CLIENTE_COD_CLIENTE, GS_NEWSLETTER_COD_NEWSLETTER ASC")
    public List<ClienteNewsletter> readAll() {
        try {
            return QueryProcessor.executeSelectQuery(this, rs -> {
                ClienteNewsletter clienteNewsletter = new ClienteNewsletter(
                        rs.getDate("DATA_ENVIO")
                );
                logger.logReadAll();
                return clienteNewsletter;
            }, "readAll");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading all clienteNewsletters: " + e.getMessage());
        }
    }

    @Query("UPDATE GS_CLIENTE_NEWSLETTER SET DATA_ENVIO = ? WHERE GS_CLIENTE_COD_CLIENTE = ? AND GS_NEWSLETTER_COD_NEWSLETTER = ?")
    public boolean updateById(ClienteNewsletter clienteNewsletter, int clienteId, int newsletterId) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "updateById", clienteNewsletter.getDataEnvio(), clienteId, newsletterId);
            logger.logUpdateById(clienteNewsletter);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating clienteNewsletter: " + e.getMessage());
        }
    }

    @Query("DELETE FROM GS_CLIENTE_NEWSLETTER WHERE GS_CLIENTE_COD_CLIENTE = ? AND GS_NEWSLETTER_COD_NEWSLETTER = ?")
    public boolean deleteById(int clienteId, int newsletterId) {
        try {
            ClienteNewsletter deletedClienteNewsletter = readById(clienteId, newsletterId);
            QueryProcessor.executeAnnotatedMethod(this, "deleteById", clienteId, newsletterId);
            logger.logDeleteById(deletedClienteNewsletter);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting clienteNewsletter: " + e.getMessage());
        }
    }
}

