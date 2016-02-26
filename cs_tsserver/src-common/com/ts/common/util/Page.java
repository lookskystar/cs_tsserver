package com.ts.common.util;

public class Page {
		
		/**
		 * ��ǰҳ��, ������Ȼ����� 1,2,3,...
		 */
		private int num;
		
		/**
		 * ҳ���С
		 */
		private int size;
		
		/**
		 * �������
		 */
		private int rowCount;
		
		/**
		 * ҳ������
		 */
		private int count;
		
		/**
		 * ��ǰҳ�濪ʼ��, ��һ����0��
		 */
		private int startRow;
		
		/**
		 * ��һҳ ҳ��
		 */
		private int first = 1;
		
		/**
		 * ���ҳ ҳ��
		 */
		private int last;
		
		/**
		 * ��һҳ ҳ��
		 */
		private int next;
		
		/**
		 * ǰҳ ҳ��
		 */
		private int prev;
		
		/**
		 * ҳ��ʽ����, ��ʼҳ��
		 */
		private int start;
		
		/**
		 * ҳ��ʽ����, ����ҳ��
		 */
		private int end;
		
		/**
		 * ҳ��ʽ����, ��ʾҳ������
		 */
		private int numCount = 10;

		/**
		 * 
		 * @param size ÿһҳ����ʾ������
		 * @param num ҳ��
		 * @param rowCount ��ݿ���һ���ж��������
		 */
		public Page(int size, int num, int rowCount) {
			this.num = num;
			this.size=size;
			this.rowCount = rowCount;
			this.count = (int) Math.ceil((double)rowCount/size);
			
			this.num = Math.min(this.num, count);
			this.num = Math.max(1, this.num);
			
			this.startRow = (this.num-1) * size ;
			this.last = this.count;
			this.next = Math.min( this.count, this.num+1);
			this.prev = Math.max(1 , this.num-1);
		
			//����page ����
			start = Math.max(this.num-numCount/2, first);
			end = Math.min(start+numCount, last);
			if(end-start < numCount){
				start = Math.max(end-numCount, 1);
			}
			
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public int getFirst() {
			return first;
		}

		public void setFirst(int first) {
			this.first = first;
		}

		public int getLast() {
			return last;
		}

		public void setLast(int last) {
			this.last = last;
		}

		public int getNext() {
			return next;
		}

		public void setNext(int next) {
			this.next = next;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public int getPrev() {
			return prev;
		}

		public void setPrev(int prev) {
			this.prev = prev;
		}

		public int getRowCount() {
			return rowCount;
		}

		public void setRowCount(int rowCount) {
			this.rowCount = rowCount;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public int getStartRow() {
			return startRow;
		}

		public void setStartRow(int startRow) {
			this.startRow = startRow;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int getNumCount() {
			return numCount;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}
}
