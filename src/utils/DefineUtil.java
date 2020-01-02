package utils;

import javax.servlet.http.HttpServletRequest;

public class DefineUtil {
	protected static HttpServletRequest request;
	public static final int NUMBER_PER_PAGE = 3;
	public static final int NUMBER_MOST_READ_ART= 3;
	public static final int NUMBER_PER_PAGE_BY_CAT= 3;
	public static final int NUMBER_CMT_PUBLIC= 3;
	public static final int NUMBER_NEWS_ADMIM= 6; // số bài viết trang: admin/news
	public static final int NUMBER_CMT_ADMIM= 10; // số bài viết trang: admin/comment
	
	
	public static final String DIR_UPLOAD = "uploads";   //bài viết
	public static final String DIR_UPLOAD_PROJ = "uploadPro"; //
	public static final String DIR_UPLOAD_HOM = "uploadHom";  //home
	
}
