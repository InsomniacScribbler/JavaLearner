package org.example;

import java.sql.*;

public class FirstProject {
    public static final String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    public static final String PASSWORD = "nikhil21122";
    public static final String USERNAME = "root";


    public static void main(String[] args) {
        try {
            //load driver
            Class.forName(LOAD_DRIVER);
            //connection establishment
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            //create statement
            Statement statement  = connection.createStatement();
            String qurey = "select * from students";
            ResultSet resultSet = statement.executeQuery(qurey);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String course = resultSet.getString("course");
                System.out.println(id+"||"+name+"||"+"course");

            }
            connection.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
