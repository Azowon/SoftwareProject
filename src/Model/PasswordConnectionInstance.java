package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Util.Logger;
import Util.Settings;

public class PasswordConnectionInstance implements IConnectionInstance {

	private Connection databaseConnection;
	
	public PasswordConnectionInstance(){
		try
		{
			Class.forName("org.postgresql.Driver");
		}
		catch (ClassNotFoundException e)
		{
			Logger.log(e.getMessage());
		}
		try 
		{
			this.setDatabaseConnection(
					DriverManager.getConnection (Settings.passwordDatabaseName
							,Settings.passwordDatabaseUsername, Settings.passwordDatabasePassword ));
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	

	public Connection getDatabaseConnection() {
		return databaseConnection;
	}

	private void setDatabaseConnection(Connection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

}
