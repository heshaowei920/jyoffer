package com.jyoffer.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * �ļ����ļ�����������
 * @author jiang.li
 * @date 2013-12-19 14:27
 */
public class FileUtils {

	/**
	 * �����ļ������ļ�
	 * @param filepath     �ļ�·��
	 * @return ����file�ۣ� ����
	 */
	public static File[] getFileList(String filepath) {
		File d = null;
		File list[] = null;
		/** ������ǰĿ¼���ļ���File���� **/
		try {
			d = new File(filepath);
			if (d.exists()) {
				list = d.listFiles();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/** ȡ�ô���Ŀ¼�������ļ���File�������� **/
		return list;
	}

	/**
	 * ��ȡ�ı��ļ�����
	 * @param filePathAndName  ������������·�����ļ���
	 * @param encoding         �ı��ļ��򿪵ı��뷽ʽ
	 * @return                 �����ı��ļ�������
	 */
	public static String readTxt(String filePathAndName, String encoding) throws IOException {
		encoding = encoding.trim();
		StringBuffer str = new StringBuffer("");
		String st = "";
		try {
			FileInputStream fs = new FileInputStream(filePathAndName);
			InputStreamReader isr;
			if (encoding.equals("")) {
				isr = new InputStreamReader(fs);
			} else {
				isr = new InputStreamReader(fs, encoding);
			}
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(isr);
			try {
				String data = "";
				while ((data = br.readLine()) != null) {
					str.append(data);
				}
			} catch (Exception e) {
				str.append(e.toString());
			}
			st = str.toString();
			if (st != null && st.length() > 1)
				st = st.substring(0, st.length() - 1);
		} catch (IOException es) {
			st = "";
		}
		return st;
	}

	/**
	 * �½�Ŀ¼
	 * @param folderPath  Ŀ¼
	 * @return            ����Ŀ¼�������·��
	 */
	public static String createFolder(String folderPath) {
		String txt = folderPath;
		try {
			java.io.File myFilePath = new java.io.File(txt);
			txt = folderPath;
			if (!myFilePath.exists()) {
				myFilePath.mkdir();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txt;
	}

	/**
	 * �༶Ŀ¼����
	 * @param folderPath ׼��Ҫ�ڱ���Ŀ¼�´�����Ŀ¼��Ŀ¼·������ c:myf
	 * @param paths      ���޼�Ŀ¼����������Ŀ¼�Ե��������� ���� a|b|c
	 * @return           ���ش����ļ����·��
	 */
	public static String createFolders(String folderPath, String paths) {
		String txts = folderPath;
		try {
			String txt;
			txts = folderPath;
			StringTokenizer st = new StringTokenizer(paths, "|");
			for (@SuppressWarnings("unused")
			int i = 0; st.hasMoreTokens(); i++) {
				txt = st.nextToken().trim();
				if (txts.lastIndexOf("/") != -1) {
					txts = createFolder(txts + txt);
				} else {
					txts = createFolder(txts + txt + "/");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txts;
	}

	/**
	 * �½��ļ�
	 * @param filePathAndName �ı��ļ���������·�����ļ���
	 * @param fileContent     �ı��ļ�����
	 * @return
	 */
	public static void createFile(String filePathAndName, String fileContent) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			String strContent = fileContent;
			myFile.println(strContent);
			myFile.close();
			resultFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �б��뷽ʽ���ļ�����
	 * @param filePathAndName �ı��ļ���������·�����ļ���
	 * @param fileContent     �ı��ļ�����
	 * @param encoding  ���뷽ʽ ���� GBK ���� UTF-8
	 * @return
	 */
	public static void createFile(String filePathAndName, String fileContent, String encoding) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			PrintWriter myFile = new PrintWriter(myFilePath, encoding);
			String strContent = fileContent;
			myFile.println(strContent);
			myFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ɾ���ļ�
	 * @param filePathAndName �ı��ļ���������·�����ļ���
	 * @return Boolean �ɹ�ɾ������true�����쳣����false
	 */
	public static boolean delFile(String filePathAndName) {
		boolean bea = false;
		try {
			String filePath = filePathAndName;
			File myDelFile = new File(filePath);
			if (myDelFile.exists()) {
				myDelFile.delete();
				bea = true;
			} else {
				bea = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bea;
	}

	/**
	 * ɾ���ļ�
	 * 
	 * @param folderPath
	 *            �ļ�����������·��
	 * @return
	 */
	public static void delFolder(String folderPath) {
		try {
			/**ɾ����������������**/
			delAllFile(folderPath);
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			/**ɾ�����ļ���**/
			myFilePath.delete(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ɾ��ָ���ļ����������ļ�
	 * @param path �ļ�����������·��
	 * @return
	 */
	public static boolean delAllFile(String path) {
		boolean bea = false;
		File file = new File(path);
		if (!file.exists()) { return bea;}
		if (!file.isDirectory()) { return bea;}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) { temp.delete(); }
			if (temp.isDirectory()) {
				/**��ɾ���ļ���������ļ�**/
				delAllFile(path + "/" + tempList[i]);
				/**��ɾ�����ļ�**/
				delFolder(path + "/" + tempList[i]);
				bea = true;
			}
		}
		return bea;
	}

	/**
	 * ���Ƶ����ļ�
	 * @param oldPathFile  ׼�����Ƶ��ļ�Դ
	 * @param newPathFile �������¾���·�����ļ���
	 * @return
	 */
	public static void copyFile(String oldPathFile, String newPathFile) {
		try {
			@SuppressWarnings("unused")
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPathFile);
			if (oldfile.exists()) {
				InputStream inStream = new FileInputStream(oldPathFile);
				@SuppressWarnings("resource")
				FileOutputStream fs = new FileOutputStream(newPathFile);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���������ļ��е�����
	 * @param oldPath  ׼��������Ŀ¼
	 * @param newPath  ָ������·������Ŀ¼
	 * @return
	 */
	public static void copyFolder(String oldPath, String newPath) {
		try {
			/**����ļ��в����� �������ļ�**/
			new File(newPath).mkdirs(); 
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}
				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath
							+ "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				/**��������ļ�**/
				if (temp.isDirectory()) {
					copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ƶ��ļ�
	 * @param oldPath
	 * @param newPath
	 * @return
	 */
	public static void moveFile(String oldPath, String newPath) {
		copyFile(oldPath, newPath);
		delFile(oldPath);
	}

	/**
	 * �ƶ�Ŀ¼
	 * @param oldPath
	 * @param newPath
	 * @return
	 */
	public static void moveFolder(String oldPath, String newPath) {
		copyFolder(oldPath, newPath);
		delFolder(oldPath);
	}

	/**
	 * ����һ������׷�ӵ�BufferedReader
	 * @param fileDir
	 * @param fileName
	 * @return
	 */
	public static BufferedWriter getWriter(String fileDir, String fileName) {
		try {
			File f1 = new File(fileDir);
			if (!f1.exists()) {
				f1.mkdirs();
			}
			f1 = new File(fileDir, fileName);
			if (!f1.exists()) {
				f1.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(f1.getPath(), true));
			return bw;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

	/**
	 * �õ�һ��BufferedReader
	 * @param fileDir
	 * @param fileName
	 * @param encoding
	 * @return
	 */
	public static BufferedReader getReader(String fileDir, String fileName, String encoding) {
		try {
			File file = new File(fileDir, fileName);
			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file), encoding);
			BufferedReader br = new BufferedReader(read);
			return br;

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
}
