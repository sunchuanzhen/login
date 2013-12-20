package cn.itcast.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import cn.itcast.utils.DigestUtil;

public class DigestUtilTest {

	@Test
	public void getMd5Test() {

		String str = DigestUtil.getMd5("¹þ¹þ");
		System.out.println(str);

	}

}
