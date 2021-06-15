package ru.job4j.sql;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    static private String url;
    static private String login;
    static private String password;

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {

        this.properties = properties;
        initConnection();
    }

    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        TableEditor tableEditor = new TableEditor(prop);

        tableEditor.createTable("PGTABLE");
        tableEditor.addColumn("PGTABLE", "NewColumn", "date");
        tableEditor.dropColumn("PGTABLE", "NewColumn");
        tableEditor.dropTable("PGTABLE");
        tableEditor.close();
    }

    private void initConnection() {
        connection = null;
        try (FileInputStream in = new FileInputStream("/home/aster/IdeaProjects/job4j_design/chapter_002/src/main/resources/app.properties")) {
            properties.load(in);
            url = properties.getProperty("url");
            login = properties.getProperty("login");
            password = properties.getProperty("password");
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://cobra:5432/idea_db";
            String login = "postgres";
            String password = "postgres";
            connection = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void createTable(String tableName) throws SQLException {

        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "create table if not exists " + tableName + " (%s, %s);",
                    "id serial primary key",
                    "name varchar(255)"
            );
            statement.execute(sql);
        }

    }

    public void dropTable(String tableName) throws SQLException {

        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DROP TABLE IF EXISTS " + tableName + " CASCADE;");
            statement.execute(sql);
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "ALTER TABLE " + tableName + " ADD COLUMN IF NOT EXISTS " +
                            columnName + "  " + type + " ; ");
            statement.execute(sql);
        }
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("ALTER TABLE " + tableName +
                    " DROP COLUMN IF EXISTS " + columnName + " ; ");
            statement.execute(sql);
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("ALTER TABLE " + tableName +
                    " RENAME COLUMN " + columnName + " TO " + newColumnName + " ; ");
            statement.execute(sql);
        }
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}