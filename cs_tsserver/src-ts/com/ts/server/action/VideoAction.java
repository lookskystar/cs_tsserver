package com.ts.server.action;

import com.ts.common.util.VideoNative;

/**
 * 视频调用
 * @author Administrator
 *
 */
public class VideoAction {
	
	public String showVideo() throws Exception{
		try{
			System.out.println("start---");
			String s = VideoNative.getTime();
			System.out.println(s);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
