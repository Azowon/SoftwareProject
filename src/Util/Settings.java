package Util;

import java.io.*;

public class Settings {
	public static String regularDatabaseName;
	public static String regularDatabaseUsername;
	public static String regularDatabasePassword;
	public static String passwordDatabaseName;
	public static String passwordDatabaseUsername;
	public static String passwordDatabasePassword;
	public static String saltValue;
	
	public static void loadSettings() throws SettingsFileNotExistingException
	{
		File f=new File("/Settings.txt");
		
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
		}
		catch(IOException e)
		{
			Logger.log(e.getMessage());
		}
	}
}
