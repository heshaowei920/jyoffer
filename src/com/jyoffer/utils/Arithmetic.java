package com.jyoffer.utils;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * url参数加密解密
 * @author xhsoft
 *
 */
public class Arithmetic {

	static Key key;

	/**
	 * 根据参数生成KEY
	 * 
	 * @param strKey
	 */
	public void getKey(String strKey) {
		try {
			KeyGenerator _generator = KeyGenerator.getInstance("DES");
			_generator.init(new SecureRandom(strKey.getBytes()));
			key = _generator.generateKey();
			_generator = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加密String明文输入,String密文输出
	 * 
	 * @param strMing
	 * @return
	 */
	public String getEncString(String strMing) {
		@SuppressWarnings("unused")
		byte[] byteMi = null;
		@SuppressWarnings("unused")
		byte[] byteMing = null;
		String strMi = "";
		try {
			
			return byte2hex(getEncCode(strMing.getBytes()));

			// byteMing = strMing.getBytes("UTF8");
			// byteMi = this.getEncCode(byteMing);
			// strMi = new String( byteMi,"UTF8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			byteMing = null;
			byteMi = null;
		}
		return strMi;
	}

	/**
	 * 解密 以String密文输入,String明文输出
	 * 
	 * @param strMi
	 * @return
	 */
	public String getDesString(String strMi) {
		@SuppressWarnings("unused")
		byte[] byteMing = null;
		@SuppressWarnings("unused")
		byte[] byteMi = null;
		String strMing = "";
		try {
			return new String(getDesCode(hex2byte(strMi.getBytes())));

			// byteMing = this.getDesCode(byteMi);
			// strMing = new String(byteMing,"UTF8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}

	/**
	 * 加密以byte[]明文输入,byte[]密文输出
	 * 
	 * @param byteS
	 * @return
	 */
	private static byte[] getEncCode(byte[] byteS) {
		byte[] byteFina = null;
		
		
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 解密以byte[]密文输入,以byte[]明文输出
	 * 
	 * @param byteD
	 * @return
	 */
	private static byte[] getDesCode(byte[] byteD) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 二行制转字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) { // 一个字节的数，
		// 转成16进制字符串
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			// 整数转成十六进制表示
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase(); // 转成大写
	}

	public static byte[] hex2byte(byte[] b) {
		if ((b.length % 2) != 0)
			throw new IllegalArgumentException("长度不是偶数");
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			// 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个进制字节
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}

		return b2;
	}

	public static void main(String[] args) {
		Arithmetic des = new Arithmetic();// 实例化一个对像
		des.getKey("jyoffer");// 生成密匙

		String strEnc = des.getEncString("root");// 加密字符串,返回String的密文
		System.out.println(strEnc);

		String strDes = des.getDesString(strEnc);// 把String 类型的密文解密
		System.out.println(strDes);
	}

}
