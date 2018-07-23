package Model;

import java.sql.*;

import Util.Logger;

/**
 * Executes SQL Statements with current connection
 * @author Raphael Albiez
 *
 */
public class StatementExecutor {
	private static IConnectionInstance conn;
	
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
		try
		{
			return p.executeQuery();
		}
		finally
		{
			conn.freeConnection();
		}
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
		
		closeConnection();
		
	}
	
	private static PreparedStatement getStatement(String statement, String databaseType) throws SQLException
	{
		ConnectionFactory connFactory=new ConnectionFactory();
		conn=null;
		try {
			conn = connFactory.getConnection(databaseType);
		} catch (NoSuchDatabaseException e) {
			Logger.log(e.getMessage());
		}
		
		PreparedStatement p = conn.getDatabaseConnection().prepareStatement(statement);
		return p;
	}
	
	private static void closeConnection()
	{
		conn.freeConnection();
	}
}
