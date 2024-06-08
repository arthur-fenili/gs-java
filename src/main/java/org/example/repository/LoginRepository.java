package org.example.repository;

import org.example.annotations.Query;
import org.example.config.DataBase;
import org.example.entities.Login;
import org.example.utils.Log4jLogger;
import org.example.infrastructure.QueryProcessor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class LoginRepository extends _BaseRepositoryImpl<Login> {
    Log4jLogger<Login> logger = new Log4jLogger<>(Login.class);
    private final DataBase databaseConnection = new DataBase();
    public static final String TB_NAME = "GS_LOGIN";

    public static final HashMap<String, String> TB_COLUMNS = new HashMap<>() {{
        put("COD_LOGIN", "COD_LOGIN");
        put("EMAIL", "EMAIL");
        put("SENHA", "SENHA");
        put("TIPO_USUARIO", "TIPO_USUARIO");
    }};

    public LoginRepository() {
        super(Login.class);
        initialize();
    }

    public void initialize() {
        String checkTableExistsSQL = "SELECT COUNT(*) FROM USER_TABLES WHERE TABLE_NAME = '" + TB_NAME.toUpperCase() + "'";
        String createTableSQL = "CREATE TABLE " + TB_NAME + " ("
                + "COD_LOGIN INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, "
                + "EMAIL VARCHAR2(255) NOT NULL, "
                + "SENHA VARCHAR2(255) NOT NULL, "
                + "TIPO_USUARIO VARCHAR2(50) NOT NULL)";

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

    @Query("INSERT INTO GS_LOGIN (EMAIL, SENHA, TIPO_USUARIO) VALUES (?, ?, ?)")
    public void create(Login login) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "create", login.getEmail(), login.getSenha(), login.getTipoUsuario());
            logger.logCreate(login);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error in login: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_LOGIN WHERE COD_LOGIN = ?")
    public Login readById(int id) {
        try {
            return QueryProcessor.executeSingleResultQuery(this, rs -> {
                Login login = new Login(
                        rs.getInt("COD_LOGIN"),
                        rs.getString("EMAIL"),
                        rs.getString("SENHA"),
                        rs.getString("TIPO_USUARIO")
                );
                logger.logReadById(login);
                return login;
            }, "readById", id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading login by id: " + e.getMessage());
        }
    }

    @Query("SELECT * FROM GS_LOGIN ORDER BY COD_LOGIN ASC")
    public List<Login> readAll() {
        try {
            return QueryProcessor.executeSelectQuery(this, rs -> {
                Login login = new Login(
                        rs.getInt("COD_LOGIN"),
                        rs.getString("EMAIL"),
                        rs.getString("SENHA"),
                        rs.getString("TIPO_USUARIO")
                );
                logger.logReadAll();
                return login;
            }, "readAll");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading all logins: " + e.getMessage());
        }
    }

    @Query("UPDATE GS_LOGIN SET EMAIL = ?, SENHA = ?, TIPO_USUARIO = ? WHERE COD_LOGIN = ?")
    public boolean updateById(Login login, int id) {
        try {
            QueryProcessor.executeAnnotatedMethod(this, "updateById", login.getEmail(), login.getSenha(), login.getTipoUsuario(), id);
            logger.logUpdateById(login);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating login: " + e.getMessage());
        }
    }

    @Query("DELETE FROM GS_LOGIN WHERE COD_LOGIN = ?")
    public boolean deleteById(int id) {
        try {
            Login deletedLogin = readById(id);
            QueryProcessor.executeAnnotatedMethod(this, "deleteById", id);
            logger.logDeleteById(deletedLogin);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting login: " + e.getMessage());
        }
    }
}
