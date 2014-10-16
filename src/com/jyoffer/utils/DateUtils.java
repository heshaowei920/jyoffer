package com.jyoffer.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * ���ڴ�������
 * @author jiang.li
 * @date 2013-12-18 11:22
 */
public class DateUtils {
	
	/**���峣��**/
	public static final String DATE_FULL_STR = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_LONG_STR = "yyyy-MM-dd kk:mm:ss.SSS";
	public static final String DATE_SMALL_STR = "yyyy-MM-dd";
	public static final String DATE_KEY_STR = "yyMMddHHmmss";
    public static final String DATE_All_KEY_STR = "yyyyMMddHHmmss";

    /**
     * ��ָ�������ڼ���(��ȥ)�·�
     * @param date
     * @param pattern
     * @param num
     * @return
     */
    public static String addMoth(Date date,String pattern,int num){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.MONTH, num);
        return simpleDateFormat.format(calender.getTime());
    }


    /**
     * ���ƶ���ʱ�����(��ȥ)��
     * @param date
     * @param pattern
     * @param num
     * @return
     */
    public static String addDay(Date date,String pattern,int num){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.DATE, num);
        return simpleDateFormat.format(calender.getTime());
    }
    
    /**
	 * ��ȡϵͳ��ǰʱ��
	 * @return
	 */
	public static String getNowTime() {
		SimpleDateFormat df = new SimpleDateFormat(DATE_FULL_STR);
		return df.format(new Date());
	}
	
	/**
	 * ��ȡϵͳ��ǰʱ��(ָ����������)
	 * @return
	 */
	public static String getNowTime(String type) {
		SimpleDateFormat df = new SimpleDateFormat(type);
		return df.format(new Date());
	}
	
	/**
	 * ʹ��Ԥ���ʽ��ȡ�ַ�������
	 * @param date �����ַ���
	 * @return
	 */
	public static Date parse(String date) {
		return parse(date,DATE_FULL_STR);
	}
	
	/**
	 * ָ��ָ�������ַ���
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date parse(String date, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ����ʱ��Ƚ�
	 * @param
	 * @return
	 */
	public static int compareDateWithNow(Date date){
		Date now = new Date();
		int rnum = date.compareTo(now);
		return rnum;
	}
	
	/**
	 * ����ʱ��Ƚ�(ʱ����Ƚ�)
	 * @param
	 * @return
	 */
	public static int compareDateWithNow(long date){
		long now = dateToUnixTimestamp();
		if(date>now){
			return 1;
		}else if(date<now){
			return -1;
		}else{
			return 0;
		}
	}
	
	
	/**
	 * ��ָ��������ת����Unixʱ���
	 * @param date ��Ҫת�������� yyyy-MM-dd HH:mm:ss
	 * @return long ʱ���
	 */
	public static long dateToUnixTimestamp(String date) {
		long timestamp = 0;
		try {
			timestamp = new SimpleDateFormat(DATE_FULL_STR).parse(date).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return timestamp;
	}
	
	/**
	 * ��ָ��������ת����Unixʱ���
	 * @param  date ��Ҫת�������� yyyy-MM-dd
	 * @return long ʱ���
	 */
	public static long dateToUnixTimestamp(String date, String dateFormat) {
		long timestamp = 0;
		try {
			timestamp = new SimpleDateFormat(dateFormat).parse(date).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timestamp;
	}
	
	/**
	 * ����ǰ����ת����Unixʱ���
	 * @return long ʱ���
	 */
	public static long dateToUnixTimestamp() {
		long timestamp = new Date().getTime();
		return timestamp;
	}

	/**
	 * ��Unixʱ���ת��������
	 * @param timestamp ʱ���
	 * @return String �����ַ���
	 */
	public static String unixTimestampToDate(long timestamp) {
		SimpleDateFormat sd = new SimpleDateFormat(DATE_FULL_STR);
		sd.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return sd.format(new Date(timestamp));
	}

    /**
     * ��Unixʱ���ת��������
     * @param timestamp ʱ���
     * @return String �����ַ���
     */
    public static String TimeStamp2Date(long timestamp,String dateFormat){
        String date = new SimpleDateFormat(dateFormat).format(new Date(timestamp));
        return date;
    }

    /**
     * ��Unixʱ���ת��������
     * @param timestamp ʱ���
     * @return String �����ַ���
     */
    public static String TimeStamp2Date(long timestamp){
        String date = new SimpleDateFormat(DATE_FULL_STR).format(new Date(timestamp));
        return date;
    }

}
