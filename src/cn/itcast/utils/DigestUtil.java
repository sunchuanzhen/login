package cn.itcast.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class DigestUtil {
	
	private static MessageDigest md = null;
	
	static{
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException();
		}
	}
	
	public static String getMd5(String str)
	{
		md.update(str.getBytes());
		byte[] toChapter1Digest = md.digest();
		BASE64Encoder base64 = new BASE64Encoder();
		String strs = base64.encode(toChapter1Digest);
		return strs;
	}
	
}
