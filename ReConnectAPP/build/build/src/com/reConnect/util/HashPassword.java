package com.reConnect.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
	public String hashPassword(String textToHash) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(
				textToHash.getBytes(StandardCharsets.UTF_8));
	    StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
	    for (int i = 0; i < encodedhash.length; i++) {
	        String hex = Integer.toHexString(0xff & encodedhash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
}
