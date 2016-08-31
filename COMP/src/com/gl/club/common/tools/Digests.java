package com.gl.club.common.tools;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import org.apache.commons.lang3.Validate;

import com.gl.club.entity.SysUser;


public class Digests {

	private static final String SHA1 = "SHA-1";

	private static final String MD5 = "MD5";

	public static final String HASH_ALGORITHM = "SHA-1";

	public static final int HASH_INTERATIONS = 1024;

	public static final int SALT_SIZE = 8;

	private static SecureRandom random = new SecureRandom();

	/**
	 * 对输入字符串进行sha1散列.
	 */
	public static byte[] sha1(byte[] input) {
		return digest(input, SHA1, null, 1);
	}

	public static byte[] sha1(byte[] input, byte[] salt) {
		return digest(input, SHA1, salt, 1);
	}

	public static byte[] sha1(byte[] input, byte[] salt, int iterations) {
		return digest(input, SHA1, salt, iterations);
	}

	/**
	 * 对字符串进行散列, 支持md5与sha1算法.
	 */
	private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);

			if (salt != null) {
				digest.update(salt);
			}

			byte[] result = digest.digest(input);

			for (int i = 1; i < iterations; i++) {
				digest.reset();
				result = digest.digest(result);
			}
			return result;
		} catch (GeneralSecurityException e) {
			throw ExceptionsUtil.unchecked(e);
		}
	}

	/**
	 * 生成随机的Byte[]作为salt.
	 * 
	 * @param numBytes byte数组的大小
	 */
	public static byte[] generateSalt(int numBytes) {
		Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", numBytes);

		byte[] bytes = new byte[numBytes];
		random.nextBytes(bytes);
		return bytes;
	}

	/**
	 * 对文件进行md5散列.
	 */
	public static byte[] md5(InputStream input) throws IOException {
		return digest(input, MD5);
	}

	/**
	 * 对文件进行sha1散列.
	 */
	public static byte[] sha1(InputStream input) throws IOException {
		return digest(input, SHA1);
	}

	private static byte[] digest(InputStream input, String algorithm) throws IOException {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			int bufferLength = 8 * 1024;
			byte[] buffer = new byte[bufferLength];
			int read = input.read(buffer, 0, bufferLength);

			while (read > -1) {
				messageDigest.update(buffer, 0, read);
				read = input.read(buffer, 0, bufferLength);
			}

			return messageDigest.digest();
		} catch (GeneralSecurityException e) {
			throw ExceptionsUtil.unchecked(e);
		}
	}

	public static void entryptPassword(SysUser sysUser) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		sysUser.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(sysUser.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		sysUser.setPassword(Encodes.encodeHex(hashPassword));
	}
	
	public static void entryptPasswordForWeChat(SysUser sysUser) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		sysUser.setOpenSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(sysUser.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		sysUser.setOpenPassword(Encodes.encodeHex(hashPassword));
	}

	

	/**
	 * 
	 * 方法名：checkOldPasswordRight
	 * 功能说明：TODO
	 * @Title: checkOldPasswordRight
	 * @param saltInDB 数据库记录中的salt
	 * @param passwordInDB 数据库记录中的password
	 * @param password	数据库输入的password
	 * @return   
	 * @author 李庆
	 * @date  2015-10-24 下午01:44:41
	 */
	public static boolean checkOldPasswordRight(String saltInDB, String passwordInDB, String password) {
		byte[] salt = Encodes.decodeHex(saltInDB);
		byte[] hashPassword = Digests.sha1(password.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(hashPassword).equals(passwordInDB);
	}
	
}
