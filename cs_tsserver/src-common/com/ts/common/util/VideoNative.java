package com.ts.common.util;
/**
 * 调用C本地方法访问硬盘录像机，实现监控视频回放
 * @author Administrator
 *
 */
public class VideoNative {
	
	static{
 	   System.loadLibrary("g");
    }

    public native static String  getTime();
}
