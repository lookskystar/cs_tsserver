package com.ts.common.util;
/**
 * �����ַ�
 */
public class StringUtil {
	
	/**
	 * ���ַ�null��Ϊ""
	 * @param desc
	 * @return
	 */
	public static String dealNullString(String desc){
		if(desc==null){
			return "";
		}else{
			return desc;
		}
	}
	
	/**
	 * ׷�ӷ��ظ����ַ�
	 */
	public static String addString(String parent,String child){
		String result = "";
		if(parent==null || "".equals(parent)){
			parent = "";
		}
		if(child==null || "".equals(child)){
			child = "";
		}
		parent = parent.replace(",","");
		child = child.replace(",","");
		if(parent.contains(child)){
			result = parent;
		}else{
			result = parent+","+child;
		}
		if(child.contains(parent)){
			result = child;
		}
		return result;
	}
}
