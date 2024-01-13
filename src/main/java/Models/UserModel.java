package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import viewmodels.UserVM;

public class UserModel {
	private String login;
	private String password;
	private Connection connection;
	String url ="jdbc:mysql://localhost:3304/prepa";
	String username = "root";
	String pass = "";
	
	
	public UserModel(UserVM uservm) {
		
		
		this.setLogin(uservm.getLogin());
		this.setPassword(uservm.getPassword());
		
		try {
			this.connection = DriverManager.getConnection(url , username , pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean Login(UserVM user) {
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPassword());
			ResultSet result = stmt.executeQuery();
			if(result.next()) {
				return true;
			}
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
