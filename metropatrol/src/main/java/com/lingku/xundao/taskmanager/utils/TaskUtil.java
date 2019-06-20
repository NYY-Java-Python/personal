package com.lingku.xundao.taskmanager.utils;

public class TaskUtil {

	public static String concatWord(String mysql, String Site) {
		StringBuffer sb = new StringBuffer();

		if ("".equals(mysql)) {
			return sb.append(Site).append(",").toString();
		} else {
			return sb.append(mysql).append(Site).append(",").toString();
		}
	}

}
