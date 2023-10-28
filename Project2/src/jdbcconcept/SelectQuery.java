package jdbcconcept;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectQuery {
	
	public void RetriveData() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Driver myDriver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			
			String url = "jdbc:mysql://localhost:3306/employee";
			String UserName = "root";
			String Password = "root";					
			
			Connection con = DriverManager.getConnection(url, UserName, Password) ;
			Statement statement = con.createStatement();
			
			String MyQuery = "SELECT * FROM details_of_emp ;";
			//String MyQuery = "SELECT * FROM city";
			ResultSet rs = statement.executeQuery(MyQuery);
			
			int Employee_id = 0;
			
			while(rs.next()) {
				System.out.println("Employee_id="+rs.getInt("Employee_id"));
			}
			
			
			
		}catch(Exception e){
			System.out.println("e:"+e);
		}
		
		
	}
	public void selectCity() {
		
		String city = "";
		int cityId = 9; 
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				//Driver myDriver = new com.mysql.cj.jdbc.Driver();
				//DriverManager.registerDriver(myDriver);
				
				String url = "jdbc:mysql://localhost:3306/sakila";
				String UserName = "root";
				String Password = "root";			
				Connection con = DriverManager.getConnection(url, UserName, Password) ;
				
				Statement stmnt = con.createStatement();
				String Query = "select * from city where city_id = "+cityId+ ";";
				ResultSet rs =   stmnt.executeQuery(Query);
				
				//System.out.println(rs.getString("city"));
				
				
				
				while(rs.next()) {
					city = rs.getString("city");
					cityId = rs.getInt("city_id");
					System.out.println(cityId+" "+city);
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
			
			String MyQuery = "delete from city where city_id = 602";
			statement.executeUpdate(MyQuery);
			System.out.println("Query succesfully executed");
			con.close();
			
			
		}
		catch(Exception e) {
			System.out.println("e form select>>>>"+e);
		}
		
	}
		
		

		public static void main(String[] args) {
			SelectQuery s = new SelectQuery();
			
			//s.RetriveData();
			//s.selectCity();
			s.DeleteQuery();
			

		}

	}

	
