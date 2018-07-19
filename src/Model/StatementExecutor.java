package Model;

import java.sql.*;

import Util.Logger;

/**
 * Executes SQL Statements with current connection
 * @author Raphael Albiez
 *
 */
public class StatementExecutor {
	
	
	/**
	 * Executes SQL statement
	 * @param statement Statement to execute
	 * @param databaseType type of Database to contact
	 * @return ResultSet from statement execution
	 * @throws SQLException 
	 */
	public static ResultSet execute(String statement, String databaseType) throws SQLException
	{
		ConnectionFactory connFactory=new ConnectionFactory();
		IConnectionInstance conn=null;
		try {
			conn = connFactory.getConnection(databaseType);
		} catch (NoSuchDatabaseException e) {
			Logger.log(e.getMessage());
		}
		
		PreparedStatement p = conn.getDatabaseConnection().prepareStatement(statement);
		
		return p.executeQuery();
	}
}
