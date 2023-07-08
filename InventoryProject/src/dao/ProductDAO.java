package dao;
import java.sql.*;
import ConnectionManager.ConnectionManager;

public class ProductDAO {
	
		
		public void addProduct(Model.product product) throws ClassNotFoundException, SQLException
		{
			//1. Java and JDBC connect
			ConnectionManager conm = new ConnectionManager();
			Connection con = conm.establishConnection();
			
			String sql_query="insert into product(productid,productname,minSellQuantity,price,quantity) value (?,?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(sql_query);
			ps.setInt(1,product.getProductid());
			ps.setString(2,product.getProductname());
			ps.setInt(3,product.getMinimumsellQuantity());
			ps.setInt(4,product.getPrice());
			ps.setInt(5,product.getQuantity());
			
			ps.executeUpdate();
			
			conm.closeConnection();
			
		}

		public static void display() throws ClassNotFoundException,SQLException
		{
			ConnectionManager conm = new ConnectionManager();
			Connection con = conm.establishConnection();
			Statement st = con.createStatement();
			//result class
			ResultSet rs = st.executeQuery("select * from Product");
			
			//check username and password
			while(rs.next())
			{
				System.out.println(rs.getInt("productid")+  " "+rs.getString("productname")+" "+rs.getInt("minsellQuantity") + " "+rs.getInt("price")+" "+rs.getInt("quantity"));
			}
			conm.closeConnection();		
		}
		
		
	}


