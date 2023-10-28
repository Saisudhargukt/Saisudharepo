package jdbcconcept;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertEmp {
	public void Doconnection()
	{
		try {
			Class.forName("com.mysql.cj.jbbc.Driver");
			Driver myDriver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			String url = "jdbc:mysql://localhost:3306/employee";
			String UserName = "root";
			String Password = "@Siuh8642";
			Connection con = DriverManager.getConnection(url, UserName, Password) ;
			Statement statement = con.createStatement();
			
			String MyQuery = "insert into details_of_emp values ( 110, 'Ar1', 60000, '2023-10-11','full stack developer' ) ";
			statement.executeUpdate(MyQuery);
			System.out.println("Query Executed--->"+MyQuery);
			con.close();
			
		} 
		catch(Exception e) {
			System.out.println("e:"+e);
		}		
	}	
public void ConfirmInsert() {
		
		try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Driver myDriver = new com.mysql.jdbc.Driver();
				DriverManager.registerDriver(myDriver);
				
				String url = "jdbc:mysql://localhost:3306/employee";
				String UserName = "root";
				String Password = "@Siuh8642";
				
				Connection con = DriverManager.getConnection(url, UserName, Password) ;
				Statement statement = con.createStatement();
				
				String MyQuery = "insert into details_of_emp values ( 117, 'Sbha', 60000, '2023-11-11','Intern' ) ";
				statement.executeUpdate(MyQuery);
				System.out.println("Query Executed--->"+MyQuery);
				
				String MyQuery2 = "select * from details_of_emp where employee_id = 12 ";
				ResultSet rs = statement.executeQuery(MyQuery2);
				
				while(rs.next()) {
					System.out.println("emp_name="+rs.getString("emp_name"));
				}
				
				
				
				con.close();
				
		} 
		catch(Exception e) {
			System.out.println("e:"+e);
		}		
	}	
public static void main(String[] args) {
	InsertEmp ie = new InsertEmp();
	//ie.DoConnection();
	ie.ConfirmInsert();
}
		
	
	
}
