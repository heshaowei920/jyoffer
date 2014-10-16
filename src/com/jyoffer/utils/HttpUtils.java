package com.jyoffer.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * HTTP POST��GET��������
 * @author jiang.li
 * @date 2013-12-18 11:22
 */
public class HttpUtils {
	
	/**
     * ��ָ��URL����GET����������
     * @param url ���������URL
     * @param param �������
     * @return URL ������Զ����Դ����Ӧ���
     */
    public static String sendGet(String url, HashMap<String,String> params) {
        String result = "";
        BufferedReader in = null;
        try {
        	/**��װ����**/
        	String param = parseParams(params);
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            /**�򿪺�URL֮�������**/
            URLConnection connection = realUrl.openConnection();
            /**����ͨ�õ���������**/
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            /**����ʵ�ʵ�����**/
            connection.connect();
            /**���� BufferedReader����������ȡURL����Ӧ**/
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("����GET��������쳣��" + e);
            e.printStackTrace();
        } finally {/**ʹ��finally�����ر�������**/
            try {
                if(in != null) { in.close(); }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * ��ָ�� URL ����POST����������
     * @param url ��������� URL
     * @param param �������
     * @return ������Զ����Դ����Ӧ���
     */
    public static String sendPost(String url, HashMap<String,String> params) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            /**�򿪺�URL֮�������**/
            URLConnection conn = realUrl.openConnection();
            /**����ͨ�õ���������**/
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            /**����POST�������������������**/
            conn.setDoOutput(true);
            conn.setDoInput(true);
            /**��ȡURLConnection�����Ӧ�������**/
            out = new PrintWriter(conn.getOutputStream());
            /**�����������**/
            String param = parseParams(params);
            out.print(param);
            /**flush������Ļ���**/
            out.flush();
            /**����BufferedReader����������ȡURL����Ӧ**/
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("���� POST ��������쳣��"+e);
            e.printStackTrace();
        } finally{ /**ʹ��finally�����ر��������������**/
            try{
                if(out!=null){   out.close();}
                if(in!=null){ in.close(); }
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }   
    
    /**
     * ��HashMap������װ���ַ���
     * @param map
     * @return
     */
	private static String parseParams(HashMap<String,String> map){
    	StringBuffer sb = new StringBuffer();
    	if(map != null){
	    	for (Entry<String, String> e : map.entrySet()) {
		    	sb.append(e.getKey());
		    	sb.append("=");
		    	sb.append(e.getValue());
		    	sb.append("&");
	    	}
	    	sb.substring(0, sb.length() - 1);
    	}
    	return sb.toString();
    }
}
