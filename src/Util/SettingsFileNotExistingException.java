package Util;

/**
 * Execption thrown if settings file is missing
 * @author Raphael Albiez
 *
 */
public class SettingsFileNotExistingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9213022723132609338L;

	@Override
	public String getMessage()
	{
		return "Settings File could not be found, please make sure Settings File exists";
	}
	
}
