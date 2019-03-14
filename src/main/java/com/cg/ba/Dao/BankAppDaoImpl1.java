package com.cg.ba.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.ba.DTO.CustomerDetails;

public class BankAppDaoImpl1 implements IBankAppDao1 {
	static int i;

	public int registerCustomer(CustomerDetails custDetails) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "DATABASE",
					"oracle");

			Statement statement = connection.createStatement();

			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO customer_details VALUES(BANK_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)");

			preparedStatement.setString(1, custDetails.getFirstName());
			preparedStatement.setString(2, custDetails.getLastName());
			preparedStatement.setString(3, custDetails.getEmailId());
			preparedStatement.setString(4, custDetails.getPassword());
			preparedStatement.setString(5, custDetails.getPancardNo());
			preparedStatement.setString(6, custDetails.getAadharNo());
			preparedStatement.setString(7, custDetails.getAddress());
			preparedStatement.setInt(8, custDetails.getMobile());
			preparedStatement.setInt(9, custDetails.getBalance());
			preparedStatement.executeUpdate();

			ResultSet resultset = statement
					.executeQuery("select * from customer_details");
			while (resultset.next()) {
				i = resultset.getInt(1);
			}

			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

}
