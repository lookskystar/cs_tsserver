package com.ts.common.util;

/**
 * ������뼯��
 * ������ T_ ��ͷ�Ĵ������������ʵϰϵͳ
 * @author Administrator
 *
 */
public class ResultCode {
	
	private int value;
	public ResultCode(int value) {
		this.value=value;
	}
	/**
	 * �Ƚ����
	 */
	@Override
	public boolean equals(Object obj){
		if(obj !=null && obj instanceof ResultCode){
				return ((ResultCode)obj).value==value;
		}
		return false;
	}
	@Override
	public String toString(){
		return value+"";
	}
	/**
	 * ���ֵ
	 * @return
	 */
	public int getValue(){
		return value;
	}
	
	/**
	 * �ɹ�
	 */
	public static final ResultCode OK = new ResultCode(0);
	/**
	 * ʧ��
	 */
	public static final ResultCode FAIL = new ResultCode(-1);
	
	/**
	 * ��ݲ�����
	 */
	public static final ResultCode UNEXISTS = new ResultCode(-2);
	/**
	 * ����Ѿ�����
	 */
	public static final ResultCode EXISTS = new ResultCode(-3);
	/**
	 *	����Ϊ��
	 */
	public static final ResultCode MISSCODE = new ResultCode(-4);
	/**
	 * ����IDΪ��
	 */
	public static final ResultCode MISSID = new ResultCode(-5);
	/**
	 * ���ͺ�Ϊ��
	 */
	public static final ResultCode MISSTYPE = new ResultCode(-6);
}
