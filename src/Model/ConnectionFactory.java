package Model;

/**
 * Factory for Database Connections
 * @author Raphael Albiez
 *
 */
public class ConnectionFactory {
	
	public ConnectionFactory() {}
	
	/**
	 * Creates a new Database Connection Instance based on type
	 * @param type Type of database
	 * @return new Connection Instance
	 * @throws NoSuchDatabaseException
	 */
	public IConnectionInstance getConnection(String type) throws NoSuchDatabaseException
	{
		switch(type)
		{
		case "Regular": return new RegularConnectionInstance();
		case "Password": return new PasswordConnectionInstance();
		default : 
			throw new NoSuchDatabaseException();
		}
	}
}
