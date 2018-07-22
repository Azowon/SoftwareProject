package Util;

import java.io.*;

/**
 * Holds application settings
 * @author Raphael Albiez
 *
 */
public class Settings {
	public static String regularDatabaseName;
	public static String regularDatabaseUsername;
	public static String regularDatabasePassword;
	public static String passwordDatabaseName;
	public static String passwordDatabaseUsername;
	public static String passwordDatabasePassword;
	public static String saltValue;
	public static boolean isLoaded=false; //needs to be checked before using, if false call loadSettings()
	
	/**
	 * Loads settings from setting file
	 * @throws SettingsFileNotExistingException
	 */
	public static void loadSettings() throws SettingsFileNotExistingException
	{
		
		String s="C:\\Settings.txt";
		File f=new File(s);
		
		if(!f.exists()) throw new SettingsFileNotExistingException();
		
		try(BufferedReader br = new BufferedReader(new FileReader(f))) {
		    String line = br.readLine();

		    while (line != null) {
		        String[] content=line.split("=",2); //only splits on first =
		        
		        switch(content[0])
		        {
		        case "regularDatabaseName" : 
		        	regularDatabaseName=content[1];
		        	break;
		        case "regularDatabaseUsername" : 
		        	regularDatabaseUsername=content[1];
		        	break;
		        case "regularDatabasePassword" : 
		        	regularDatabasePassword=content[1];
		        	break;
		        case "passwordDatabaseName" : 
		        	passwordDatabaseName=content[1];
		        	break;
		        case "passwordDatabaseUsername" : 
		        	passwordDatabaseUsername=content[1];
		        	break;
		        case "passwordDatabasePassword" : 
		        	passwordDatabasePassword=content[1];
		        	break;
		        case "saltValue" : 
		        	saltValue=content[1];
		        	break;
		        }
		    	
		    	
		        line = br.readLine();
		    }
		    isLoaded=true;
		}
		catch(IOException e)
		{
			Logger.log(e.getMessage());
		}
	}
}
