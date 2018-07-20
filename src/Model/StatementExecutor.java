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
	 * Executes SQL statement with return values
	 * @param statement Statement to execute
	 * @param databaseType type of Database to contact
	 * @return ResultSet from statement execution
	 * @throws SQLException 
	 */
	public static ResultSet executeQuery(String statement, String databaseType) throws SQLException
	{
		PreparedStatement p = getStatement(statement, databaseType);
		
		return p.executeQuery();
	}
	
	/**
	 * Executes SQL statement with no return values
	 * @param statement Statement to execute
	 * @param databaseType type of Database to contact
	 * @throws SQLException 
	 */
	public static void executeUpdate(String statement, String databaseType) throws SQLException
	{
		PreparedStatement p = getStatement(statement, databaseType);
		
		p.executeUpdate();
	}
	
	private static PreparedStatement getStatement(String statement, String databaseType) throws SQLException
	{
		ConnectionFactory connFactory=new ConnectionFactory();
		IConnectionInstance conn=null;
		try {
			conn = connFactory.getConnection(databaseType);
		} catch (NoSuchDatabaseException e) {
			Logger.log(e.getMessage());
		}
		
		PreparedStatement p = conn.getDatabaseConnection().prepareStatement(statement);
		return p;
	}
}
