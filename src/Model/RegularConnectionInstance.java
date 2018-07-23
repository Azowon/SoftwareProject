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
public class RegularConnectionInstance implements IConnectionInstance{
	
	private Connection databaseConnection;
	
	/**
	 * Defines new connection with parameters from settings file
	 */
	public RegularConnectionInstance(){
		if(!Settings.isLoaded) 
		{
			try {
				Settings.loadSettings();
			} catch (SettingsFileNotExistingException e) {
				Logger.log(e.getMessage());
			}
		}
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
			DriverManager.getConnection(Settings.regularDatabaseName,
					Settings.regularDatabaseUsername, Settings.regularDatabasePassword ));
			
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	
	/**
	 * Returns database connection
	 * @return Connection
	 */
	public Connection getDatabaseConnection() {
		return databaseConnection;
	}
	
	/**
	 * closes Connection
	 */
	public void freeConnection()
	{
		try {
			databaseConnection.close();
		} catch (SQLException e) {
			Logger.log(e.getMessage());
		}
	}

	/**
	 * Sets database connection
	 * @param databaseConnection Connection
	 */
	private void setDatabaseConnection(Connection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}
}
