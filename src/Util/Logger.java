package Util;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Logger class providing error logging
 * @author Raphael Albiez
 *
 */
public class Logger {
	
	/**
	 * Writes message to logfile
	 * @param message Message to write
	 */
	public static void log(String message)
	{
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(getFile()), "utf-8"))) 
		{
		   writer.write(message+"\n");
		}
		catch(IOException e)
		{
			System.out.println("Can't write to Error Log :"+e.getMessage());
		}
	}
	
	/**
	 * Returns file
	 * @return File
	 */
	private static File getFile()
	{
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		
		File f=null;
		try
		{
			f=new File(s+"\\Log.txt");
			if(!f.exists())
			{
				f.createNewFile();
			}
			
		}
		catch(IOException e)
		{
			System.out.println("Can't create Error Log :"+e.getMessage());
		}
		return f;
	}
}
