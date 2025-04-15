package org.example;

import java.sql.*;

public class ResultSetDemo {
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
			Statement statement  = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); //ResultSet.CONCUR_UPDATABLE --- Helps us to update changes in the db from our code itself ; ResultSet.TYPE_SCROLL_INSENSITIVE --- the database changes are reflected in the codebase too
			String query = "select * from students";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()){
				Thread.sleep(3000);
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String course = resultSet.getString("course");
				System.out.println(id+"||"+name+"||"+course);

			}


			resultSet.first();

//			System.out.println("Fetching first row");
//			int id2 = resultSet.getInt("id");
//			String name2 = resultSet.getString("name");
//			String course2 = resultSet.getString("course");
//			System.out.println(id2+"||"+name2+"||"+course2);

			resultSet.updateString("name","Akash");
			resultSet.updateRow();

			resultSet.moveToInsertRow();
			resultSet.updateInt("id",6);
			resultSet.updateString("name", "Nikhil");
			resultSet.updateString("course","Spring");
			resultSet.insertRow();
			resultSet.last();
			System.out.println("Fetching last row");
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String course = resultSet.getString("course");
			System.out.println(id+"||"+name+"||"+course);



			connection.close();

		} catch (ClassNotFoundException | InterruptedException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
