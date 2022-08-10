package com.newland.tool.file;

import java.io.*;

/**
 * 文件操作工具类
 */
public class FileUtils {
	/**
	 * 写文件
	 *
	 * @param path
	 * @param content
	 * @param append  是否追加
	 * @return
	 */
	public static boolean writeStr(String path, String content, boolean append) {
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			FileWriter writer = new FileWriter(path, append);
			writer.write(content);
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 读取指定路径文本内容
	 *
	 * @param path
	 * @return 文件内容
	 * @author LiuLun
	 * @Time 2015年11月9日下午5:58:05
	 */
	public static String readStr(String path) {
		try {
			File file = new File(path);
			if (!file.exists())
				return null;
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis, "utf-8"));
			StringBuilder sb = new StringBuilder();
			String s = null;
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			br.close();
			fis.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String readStr(InputStream is) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			StringBuilder sb = new StringBuilder();
			String s = null;
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			br.close();
			is.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 删除文件
	 */
	public static void deleteFile(File file) {
		if (!file.exists())
			return;
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				deleteFile(f);
			}
		} else {
			file.delete();
		}
	}

	public static void write(Throwable ex) {
		StringBuffer sb = new StringBuffer();
		Writer writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		ex.printStackTrace(printWriter);
		Throwable cause = ex.getCause();
		while (cause != null) {
			cause.printStackTrace(printWriter);
			cause = cause.getCause();
		}
		printWriter.close();
		String result = writer.toString();
		sb.append(result);
		final String exStr = sb.toString();
		long timestamp = System.currentTimeMillis();
		String time = System.currentTimeMillis() + "";
		String fileName = "crash-" + time + "-" + timestamp + ".log";
		FileUtils.writeStr(fileName, exStr, true);
	}
}
