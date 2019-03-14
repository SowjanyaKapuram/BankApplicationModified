package com.cg.ba.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.ba.DTO.TransactionDetails;

public class BankAppDaoImpl2 implements IBankAppDao2 {

	static int bal1, bal2, bal3,bal4,bal5;
	int i;

	public int deposit(int accno, int amount) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "DATABASE",
					"oracle");

			Statement statement = connection.createStatement();
			ResultSet resultset = statement
					.executeQuery("select * from customer_details ");

			while (resultset.next()) {

				if (resultset.getInt(1) == accno) {

					bal1 = resultset.getInt(10);
				}

			}

			bal1 += amount;
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE customer_details SET balance=? where account_no=?");
			preparedStatement.setInt(1, bal1);
			preparedStatement.setInt(2, accno);
			i = preparedStatement.executeUpdate();

			System.out.println("Error");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public int withdrawal(int accno, int amount) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "DATABASE",
					"oracle");

			Statement statement = connection.createStatement();
			ResultSet resultset = statement
					.executeQuery("select * from customer_details ");

			while (resultset.next()) {

				if (resultset.getInt(1) == accno) {

					bal2 = resultset.getInt(10);
				}

			}

			bal2 -= amount;
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE customer_details SET balance=? where account_no=?");
			preparedStatement.setInt(1, bal2);
			preparedStatement.setInt(2, accno);
			i = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public int showBalance(int accno) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "DATABASE",
					"oracle");

			Statement statement = connection.createStatement();
			ResultSet resultset = statement
					.executeQuery("select * from customer_details ");

			while (resultset.next()) {

				if (resultset.getInt(1) == accno) {

					bal3 = resultset.getInt(10);
				}

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bal3;
	}

	public int transferFund(TransactionDetails td) {
		
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "DATABASE",
					"oracle");

			Statement statement = connection.createStatement();
			ResultSet resultset = statement
					.executeQuery("select * from customer_details ");

			while (resultset.next()) {

				if (resultset.getInt(1) == td.getFromAccountNo()) {

					bal4 = resultset.getInt(10);
				}

			}
			bal4-=td.getAmountTransfered();
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE customer_details SET balance=? where account_no=?");
			preparedStatement.setInt(1, bal4);
			preparedStatement.setInt(2, td.getFromAccountNo());
			 preparedStatement.executeUpdate();

			 ResultSet resultset1 = statement
						.executeQuery("select * from customer_details ");
			 while (resultset1.next()) {

					if (resultset1.getInt(1) == td.getToAccountNo()) {

						bal5 = resultset1.getInt(10);
					}

				}
				bal5+=td.getAmountTransfered();
				
				PreparedStatement preparedStatement1 = connection
						.prepareStatement("UPDATE customer_details SET balance=? where account_no=?");
				preparedStatement1.setInt(1, bal5);
				preparedStatement1.setInt(2, td.getToAccountNo());
				preparedStatement1.executeUpdate();
				PreparedStatement preparedStatement2 = connection
						.prepareStatement("INSERT INTO transaction_details VALUES(MY_SEQ.NEXTVAL,?,?,?)");
				
				 preparedStatement2.setInt(1, td.getFromAccountNo());
				 preparedStatement2.setInt(2, td.getToAccountNo());
				 preparedStatement2.setInt(3, td.getAmountTransfered());
				i= preparedStatement2.executeUpdate();
			 
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