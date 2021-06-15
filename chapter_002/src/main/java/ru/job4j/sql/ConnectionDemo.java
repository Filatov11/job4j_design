package ru.job4j.sql;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    static private String url;
    static private String login;
    static private String password;
    static Properties prop = new Properties();

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ConnectionDemo.url = url;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        ConnectionDemo.login = login;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        ConnectionDemo.password = password;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        readFile();
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(getUrl().trim(), getLogin().trim(), getPassword().trim())) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }

    public static void readFile() {
        try (FileInputStream in = new FileInputStream("/home/aster/IdeaProjects/job4j_design/chapter_002/src/main/resources/app.properties")) {
            prop.load(in);
            url = prop.getProperty("url");
            login = prop.getProperty("login");
            password = prop.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
