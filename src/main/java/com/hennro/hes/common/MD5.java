package com.hennro.hes.common;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具
 *
 * 
 */
public class MD5 {
	/** 用于十六进制转换 */
	private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	private static String toHexString(byte[] b) { // byte to String
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
			sb.append(HEX_DIGITS[b[i] & 0x0f]);
		}
		return sb.toString();
	}

	/** 对字符串进行MD5散列，正常返回32位字符串，异常则返回null */
	public static String encode(String str) {
		try {
			// Create MD5 Hash
			MessageDigest digest = MessageDigest
					.getInstance("MD5");
			//转为“utf-8”类型
			digest.update(str.getBytes("utf-8"));
			byte messageDigest[] = digest.digest();

			String result= toHexString(messageDigest);
			if(31==result.length())
			{
				result="0"+result;
			}
			return result.toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getFileMD5String(File file)
			throws NoSuchAlgorithmException, IOException {
		String result = null;
		MessageDigest digest = null;

		digest = MessageDigest.getInstance("MD5");
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int len = 0;

		while ((len = fileInputStream.read(buffer, 0, 1024)) != -1) {
			digest.update(buffer, 0, len);
		}
		fileInputStream.close();

		BigInteger bigInt = new BigInteger(1, digest.digest());
		result = bigInt.toString(16);
		/**
		 * 该方法加密时有可能会出现31位情况，因为转16进制时会出现最前面的0省掉，此处需要加上
		 * */
		if(31==result.length())
		{
			result="0"+result;
		}
		return result;
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println(MD5.encode("4b3d4b53-e788-427f-9acc-f5d32599bc5f")); }
	 */
}
