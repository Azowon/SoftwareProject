package Model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Validator {
	
	private String saltValue="Ihd73Ab"; //obviously change this and keep it secret in a real environment
	
	public Validator() {}
	
	private String createHash(String password)
	{
		String res="";
		String saltedPassword=password+saltValue;
		try 
		{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
			res= bytesToHex(encodedhash);	
			
		} 
		catch (NoSuchAlgorithmException e) 
		{
			System.out.println(e.getMessage());
		}
		return res;
		
	}
	
	private String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
	public boolean checkPassword(String username, String password)
	{
		String s="";
		try
		{
			ResultSet res=StatementExecutor.execute("SELECT password FROM authentication WHERE username='"+username+"'");
			res.next();
			s=res.getString("password");
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		
		String pwHash=createHash(password);
		
		return s.equals(pwHash); 
	}
	
	public void savePassword(String username, String password)
	{
		String pwHash=createHash(password);
		
		try 
		{
			StatementExecutor.execute("INSERT INTO authentication VALUES (\'"+username+"\',\'"+pwHash+"\')");
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
