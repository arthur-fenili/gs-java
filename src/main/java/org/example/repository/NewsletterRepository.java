package org.example.repository;

import org.example.annotations.Query;
import org.example.config.DataBase;
import org.example.entities.Newsletter;
import org.example.utils.Log4jLogger;
import org.example.infrastructure.QueryProcessor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class NewsletterRepository extends _BaseRepositoryImpl<Newsletter> {
    Log4jLogger<Newsletter> logger = new Log4jLogger<>(Newsletter.class);
    private final DataBase databaseConnection = new DataBase();
    public static final String TB_NAME = "GS_NEWSLETTER";

    public static final HashMap<String, String> TB_COLUMNS = new HashMap<>() {{
        put("COD_NEWSLETTER", "COD_NEWSLETTER");
        put("ASSUNTO", "ASSUNTO");
        put("DATA", "DATA");
    }};

    public NewsletterRepository() {
        super(Newsletter.class);
        initialize();
    }

    public void initialize() {
        String checkTableExistsSQL = "SELECT COUNT(*) FROM USER_TABLES WHERE TABLE_NAME = '" + TB_NAME.toUpperCase() + "'";
        String createTableSQL = "CREATE TABLE " + TB_NAME + " ("
                + "COD_NEWSLETTER INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, "
                + "ASSUNTO VARCHAR2(255) NOT NULL, "
                + "DATA DATE NOT NULL)";

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

    @Query("INSERT INTO GS_NEWSLETTER (ASSUNTO, DATA) VALUES (?, ?)")
    public void create(Newsletter newsletter) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "create", newsletter.getAssunto(), newsletter.getData());
            logger.logCreate(newsletter);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating newsletter: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_NEWSLETTER WHERE COD_NEWSLETTER = ?")
    public Newsletter readById(int id) {
        try {
            return QueryProcessor.executeSingleResultQuery(this, rs -> {
                Newsletter newsletter = new Newsletter(
                        rs.getString("ASSUNTO"),
                        rs.getDate("DATA")
                );
                logger.logReadById(newsletter);
                return newsletter;
            }, "readById", id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading newsletter by id: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_NEWSLETTER ORDER BY COD_NEWSLETTER ASC")
    public List<Newsletter> readAll() {
        try {
            return QueryProcessor.executeSelectQuery(this, rs -> {
                Newsletter newsletter = new Newsletter(
                        rs.getString("ASSUNTO"),
                        rs.getDate("DATA")
                );
                logger.logReadAll();
                return newsletter;
            }, "readAll");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading all newsletters: " + e.getMessage());
        }
    }

    @Query("UPDATE GS_NEWSLETTER SET ASSUNTO = ?, DATA = ? WHERE COD_NEWSLETTER = ?")
    public boolean updateById(Newsletter newsletter, int id) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "updateById", newsletter.getAssunto(), newsletter.getData(), id);
            logger.logUpdateById(newsletter);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating newsletter: " + e.getMessage());
        }
    }

    @Query("DELETE FROM GS_NEWSLETTER WHERE COD_NEWSLETTER = ?")
    public boolean deleteById(int id) {
        try {
            Newsletter deletedNewsletter = readById(id);
            QueryProcessor.executeAnnotatedMethod(this, "deleteById", id);
            logger.logDeleteById(deletedNewsletter);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting newsletter: " + e.getMessage());
        }
    }
}
