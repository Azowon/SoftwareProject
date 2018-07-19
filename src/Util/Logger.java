package Util;

import java.io.*;

public class Logger {
	
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
	
	private static File getFile()
	{
		File f=null;
		try
		{
			f=new File("/Log.txt");
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
