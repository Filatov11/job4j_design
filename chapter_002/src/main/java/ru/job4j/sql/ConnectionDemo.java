package ru.job4j.sql;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionDemo {
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

    static private String url;
    static private String login;
    static private String password;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        readFile();

        Class.forName("org.postgresql.Driver");


       try (Connection connection = DriverManager.getConnection(getUrl().trim(), getLogin().trim(), getPassword().trim())) {


            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
          System.out.println(metaData.getURL());
        }
    }

    public static void getProperties(String str) {
String leftPart = "" , rightPart = "", rp ="";
        if (!str.startsWith("#") && (str.contains("="))) {
            int posA = str.indexOf('=');
            leftPart = str.substring(0, posA);
            rightPart = str.substring(posA + 1).trim();
            rp = rightPart.substring( 1, rightPart.length() - 1 );

               switch (leftPart.trim()) {
           case "url": setUrl(rp);
                break;
            case "login": setLogin(rp);
                break;
            case "password": setPassword(rp);
               break;
            default:
               break;
        }
        }
    }

    public static void readFile() {
        try (FileInputStream in = new FileInputStream("/home/aster/IdeaProjects/job4j_design/chapter_002/src/main/resources/app.properties")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }

            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                getProperties(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
