package utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthUtil {
	
	public static boolean isLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		
		if(session.getAttribute("userInfo")==null) {
			return false;
		}
		return true;
		}
//	public static boolean checkIntegerNull(String str, HttpServletRequest request) throws IOException{
//		try {
//			Integer.parseInt(request.getParameter(str));
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//		}
}
