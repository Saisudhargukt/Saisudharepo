package jdbcconcept;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Homeworkq2 {
	
	public void RetriveData() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Driver myDriver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			
			String url = "jdbc:mysql://localhost:3306/sakila";
			String UserName = "root";
			String Password = "root";					
			
			Connection con = DriverManager.getConnection(url, UserName, Password) ;
			Statement statement = con.createStatement();
			
			String MyQuery = "SELECT * FROM country ;";
	
			ResultSet rs = statement.executeQuery(MyQuery);
			
			int country_id = 0;
			
			while(rs.next()) {
				System.out.println("country_id="+rs.getInt("country_id"));
			}
			
			
			
		}catch(Exception e){
			System.out.println("e:"+e);
		}
		
		
	}
	public void selectCity() {
		
		String country = "";
		int country_id = 9; 
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				//Driver myDriver = new com.mysql.cj.jdbc.Driver();
				//DriverManager.registerDriver(myDriver);
				
				String url = "jdbc:mysql://localhost:3306/sakila";
				String UserName = "root";
				String Password = "root";			
				Connection con = DriverManager.getConnection(url, UserName, Password) ;
				
				Statement stmnt = con.createStatement();
				String Query = "select * from country where country_id = "+country_id+ ";";
				ResultSet rs =   stmnt.executeQuery(Query);
				
				
				
				
				
				while(rs.next()) {
					country = rs.getString("country");
					country_id = rs.getInt("country_id");
					System.out.println(country+" "+country_id);
				}
				
				
				
			}catch (Exception e) {
				System.out.println("e form select>>>>"+e);
				}
			
		}

	public void DeleteQuery() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/sakila";
			String UserName = "root";
			String Password = "root";
			
			Connection con = DriverManager.getConnection(url, UserName, Password) ;
			Statement statement = con.createStatement();
			
			String MyQuery = "delete from country where country_id= 121";
			statement.executeUpdate(MyQuery);
			System.out.println("Query succesfully executed");
			con.close();
			
			
		}
		catch(Exception e) {
			System.out.println("e form select>>>>"+e);
		}
		
	}
		
		

		public static void main(String[] args) {
			Homeworkq2 s = new Homeworkq2();
			
			//s.RetriveData();
			//s.selectCity();
			s.DeleteQuery();
			

		}

	}

	
