package utils;

import javax.servlet.jsp.JspWriter;

public class CodeMessageUtil {
	public static final int ADD_SUCCESS = 1;
	public static final int DEL_SUCCESS = 2;
	public static final int EDIT_SUCCESS = 3;
	public static final int ERROR = 0;

	public static String disPlayMessage(JspWriter out, String msg) {
		String result = "";
		if (!"".equals(msg.trim())) {
			result = "<p class=\"alert alert-success\">"+msg+"</p>";
		}
		return result;

	}
}
