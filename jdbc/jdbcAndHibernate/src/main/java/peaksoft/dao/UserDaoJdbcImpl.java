package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJdbcImpl implements UserDao {
    public UserDaoJdbcImpl() {

    }



    public void createUsersTable() {
        String query = "create table users(id serial primary key ," +
                "name varchar," +
                "last_name varchar," +
                "age smallint);";
        try (Connection connection = Util.connectionToDatabase();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Table is created on database!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void dropUsersTable() {
        String sql = "drop table users";
        try (Connection connection = Util.connectionToDatabase();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("drop");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public void saveUser(String name, String lastName, byte age) {
            String sql = "insert into users(name, last_name, age) VALUES (?,?,?)";
            try (Connection connection = Util.connectionToDatabase();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,lastName);
                preparedStatement.setByte(3,age);
                preparedStatement.executeUpdate();
                System.out.println("Successfully saved!");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }




    public void removeUserById(long id) {
        String sql = "delete from users where id=?";
        try (Connection connection = Util.connectionToDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("delete");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public List<User> getAllUsers() {
        List<User> getAll = new ArrayList<>();
        String sql = "select * from users";
        try (Connection connection = Util.connectionToDatabase();
             Statement prepared = connection.createStatement()) {
            ResultSet resultSet = prepared.executeQuery(sql);
            while (resultSet.next()) {
                getAll.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return getAll;
    }


    public void cleanUsersTable() {
        String sql = "truncate table  users";
        try (Connection connection = Util.connectionToDatabase();
             Statement statement = connection.createStatement()) {
           statement.executeUpdate(sql);
            System.out.println("clean");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

}