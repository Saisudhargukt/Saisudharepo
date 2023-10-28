package jdbcconcept;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Homeworkq1 {

public void ConfirmInsert() {
	
	try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Driver myDriver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			
			String url = "jdbc:mysql://localhost:3306/sakila";
			String UserName = "root";
			String Password = "root";
			
			Connection con = DriverManager.getConnection(url, UserName, Password) ;
			Statement statement = con.createStatement();
			
			String MyQuery = "INSERT INTO `sakila`.`country` (`country_id`, `country`) VALUES ('121', 'xyz');\r\n"
					+ "";
			statement.executeUpdate(MyQuery);
			System.out.println("Query Executed--->"+MyQuery);
			
			String MyQuery2 = "select * from country where country_id = 120 ";
			ResultSet rs = statement.executeQuery(MyQuery2);
			
			while(rs.next()) {
				System.out.println("country="+rs.getString("country"));
			}
			
			con.close();
			
		} 
		catch(Exception e) {
			System.out.println("e:"+e);
		}		
	}	


public static void main(String[] args) {
	 Homeworkq1 ie = new  Homeworkq1();
	//ie.DoConnection();
	ie.ConfirmInsert();
}
}