package ru.job4j.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrepareStatementDemo {

    private Connection connection;

    public PrepareStatementDemo() throws Exception {
        initConnection();
    }

    public static void main(String[] args) throws Exception {
        PrepareStatementDemo prepareStatementDemo = new PrepareStatementDemo();
        prepareStatementDemo.insert(new City(1, "Chikago", 1000000));
        prepareStatementDemo.update(new City(1, "Chikago", 1500000));
        prepareStatementDemo.insert(new City(2, "Dehli", 2500000));
        for (City city : prepareStatementDemo.findAll()) {
            System.out.println(city.getId() + " " + city.getName() + " " + city.getPopulation());
        }


    }

    public void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://cobra:5432/idea_db";
        String login = "postgres";
        String password = "postgres";
        connection = DriverManager.getConnection(url, login, password);
    }


    public boolean update(City city) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("update cities set name = ?, population = ? where id = ?")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.setInt(3, city.getId());
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("delete from cities where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from cities")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cities.add(new City(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("population")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    public City insert(City city) {
        try (PreparedStatement statement =
                     connection.prepareStatement("insert into cities(name, population) values (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    city.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

}