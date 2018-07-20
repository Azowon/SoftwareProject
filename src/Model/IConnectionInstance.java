package Model;

import java.sql.Connection;

/**
 * Interface for database connections
 * @author Raphael Albiez
 *
 */
public interface IConnectionInstance {
	
	public Connection getDatabaseConnection();
	
	
}
