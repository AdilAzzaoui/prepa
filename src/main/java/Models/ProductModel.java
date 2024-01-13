package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import viewmodels.ProductVM;
import viewmodels.UserVM;

public class ProductModel {
	private int Id;
	private String libelle;
	private Connection connection;
	String url ="jdbc:mysql://localhost:3304/prepa";
	String username = "root";
	String pass = "";
	
	
	public ProductModel(ProductVM productVM) {
		
		
		this.setId(0);
		this.setLibelle("");
		
		try {
			this.connection = DriverManager.getConnection(url , username , pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void AddProduct() {
		String sql = "INSERT INTO products(libelle) VALUES(?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, this.getLibelle());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<ProductModel> List(){				
		ArrayList<ProductModel> products = new ArrayList<>();
		String sql = "SELECT * FROM products";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
	            ProductModel product = new ProductModel(null);
				product.setId(result.getInt("id"));
				product.setLibelle(result.getString("libelle"));
				products.add(product);
			}
			return products;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
