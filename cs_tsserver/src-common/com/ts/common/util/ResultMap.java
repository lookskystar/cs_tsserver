package com.ts.common.util;
/**
 * ��� * 
 * @author Administrator
 *
 * @param <C> ���뼯
 * @param <R> ��ݼ�
 */
public class ResultMap<C,R> {
	
	private C code;
	private R result;	 
	/**
	 * @return the code
	 */
	public C getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(C code) {
		this.code = code;
	}
	/**
	 * @return the result
	 */
	public R getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(R result) {
		this.result = result;
	}
	/**
	 * ��ȼ��
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj){
		if(obj!=null && getClass().isInstance(obj)){
			ResultMap<C,R> t=(ResultMap<C,R>)obj;
			return t.code==code && t.result==result;
		}
		return false;
	}
	@Override
	public String toString() {
		return "ResultMap [code=" + code + ", result=" + result + "]";
	}
}
