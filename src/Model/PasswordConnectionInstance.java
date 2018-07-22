package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Util.Logger;
import Util.Settings;
import Util.SettingsFileNotExistingException;

/**
 * Database Connection Instance
 * @author Raphael Albiez
 *
 */
public class PasswordConnectionInstance implements IConnectionInstance {

	private Connection databaseConnection;
	
	/**
	 * Defines new connection with parameters from settings file
	 */
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
					DriverManager.getConnection ("jdbc:postgresql://localhost/db_auth"
							,"postgres", "postgres"));
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	private void holdthis()
	{
		if(!Settings.isLoaded) 
		{
			try {
				Settings.loadSettings();
			} catch (SettingsFileNotExistingException e) {
				Logger.log(e.getMessage());
			}
		}
		//this.setDatabaseConnection(
		//		DriverManager.getConnection (Settings.passwordDatabaseName
		//				,Settings.passwordDatabaseUsername, Settings.passwordDatabasePassword ));
	}
	
	/**
	 * Returns database connection
	 * @return Connection
	 */
	public Connection getDatabaseConnection() {
		return databaseConnection;
	}

	/**
	 * Sets database connection
	 * @param databaseConnection Connection
	 */
	private void setDatabaseConnection(Connection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

}
