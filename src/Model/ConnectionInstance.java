package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database Connection Instance
 * @author Raphael Albiez
 *
 */
public class ConnectionInstance {
	private static Connection conn=null;
	
	/**
	 * Private Constructor
	 */
	private ConnectionInstance(){}
	
	/**
	 * Returns the Connection Instance
	 * @return Connection Instance
	 */
	public static Connection getInstance()
	{
		if(conn==null) //create new Connection Instance if none already exists
		{
			try
			{
				Class.forName("org.postgresql.Driver");
			}
			catch (ClassNotFoundException e)
			{
				System.out.println("Driver not found: "+e.getMessage());
			}

			try 
			{
				conn=DriverManager.getConnection ("jdbc:postgresql://localhost/sw_project","postgres", "postgres" );
			} 
			catch (SQLException e) 
			{
				System.out.println(e.getMessage());
			}
		}
		return conn;
	}
}
