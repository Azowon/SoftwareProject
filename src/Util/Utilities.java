package Util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utilities {
	
	public static String createHash(String password)
	{
		String res="";
		String saltedPassword=password+Settings.saltValue;
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
	
	private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
}
