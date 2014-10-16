package com.jyoffer.utils;

import java.util.List;

/**
 * �ַ�����������
 * @author jiang.li
 * @date 2013-12-18 11:22
 */
public class StringUtils {

	/**
	 * ����ַ����Ƿ�Ϊ��
	 * @param str �ַ���
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		} else if (str.length() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ����ַ����Ƿ�Ϊ��
	 * @param str �ַ���
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str == null) {
			return false;
		} else if (str.length() == 0) {
			return false;
		} else {
			return true;
		}
	}


	 /**
	  * ���ַ������ָ���ת��Ϊ����
	  * @param str  �ַ���
	  * @param expr �ָ���
	  * @return
	  */
	 public static String[] stringToArray(String str, String expr){
		 return str.split(expr);
	 }
	 
	 /**
	  * �����鰴�ո����ķָ�ת�����ַ���
	  * @param arr
	  * @param expr
	  * @return
	  */
	 public static String arrayToString(String[] arr,String expr){
		 String strInfo = "";
		 if(arr != null && arr.length > 0){
			 StringBuffer sf = new StringBuffer();
			 for(String str : arr){
				 sf.append(str);
				 sf.append(expr);
			 }
			 strInfo = sf.substring(0, sf.length()-1);
		 }
		 return strInfo;
	 }
	 
	 
	 /**
	  * �����ϰ��ո����ķָ�ת�����ַ���
	  * @param arr
	  * @param expr
	  * @return
	  */
	 public static String listToString(List<String> list,String expr){
		 String strInfo = "";
		 if(list != null && list.size() > 0){
			 StringBuffer sf = new StringBuffer();
			 for(String str : list){
				 sf.append(str);
				 sf.append(expr);
			 }
			 strInfo = sf.substring(0, sf.length()-1);
		 }
		 return strInfo;
	 }

}
