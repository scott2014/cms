package com.cms.model.util;

import java.security.MessageDigest;

/**
 * <p>
 * This class has a static method, which is for MD5 encode. 
 * </p>
 * @author freegod.wanted@gmail.com
 */
public class MDEncode {
	
	/**
	 * <p>
	 * MD5 encode.
	 * </p>
	 * @param plainText the String to be encoded.
	 * @return cipher the cipher text of the plain text.
	 */
	public static String encode(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			StringBuffer buf = new StringBuffer("");
			for (int i:b) {
				if (i < 0) i += 256;
				if (i < 16) buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			String res = buf.toString();
			return res;
		}catch(Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	
	public static void main(String[] args){
		System.out.println(MDEncode.encode(""));
	
	}
}
