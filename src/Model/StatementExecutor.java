package Model;

import java.sql.*;

/**
 * Executes SQL Statements with current connection
 * @author Raphael Albiez
 *
 */
public class StatementExecutor {
	
	/**
	 * Executes SQL statement
	 * @param statement Statement to execute
	 * @return ResultSet from statement execution
	 * @throws SQLException 
	 */
	public static ResultSet execute(String statement) throws SQLException
	{
		return contactDatabase(statement);
	}
	
	/**
	 * Executes SQL statement
	 * @param statement Statement to execute
	 * @return ResultSet from statement execution
	 * @throws SQLException 
	 */
	private static ResultSet contactDatabase(String statement) throws SQLException
	{
		Connection conn=ConnectionInstance.getInstance();
		
		PreparedStatement p = conn.prepareStatement(statement);
		
		return p.executeQuery();
	}
}
