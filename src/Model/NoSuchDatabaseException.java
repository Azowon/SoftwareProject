package Model;

/**
 * Exception thrown if requested database is not defined in code
 * @author Raphael Albiez
 *
 */
public class NoSuchDatabaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5196876826469428691L;

	@Override
	public String getMessage()
	{
		return "No such database exists";
	}

}
