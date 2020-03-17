package com.datastructure.stack;
public class MyStack<T>{
	private Object[] arr;
	private int top=-1;
	private static int max_size;
	private T popped_item;
	MyStack(){
		arr=new Object[10];
		max_size=10;
	}
	MyStack(int size) {
		max_size=size;
		arr=new Object[max_size];
	}
	public String toString() {
		StringBuffer s=new StringBuffer();
		for(int i=0;i<=top;i++) {
			s.append(arr[i]);
			s.append(',');
		}
		return "["+s.toString().substring(0,s.length()-1)+"]";
	}
	public boolean isEmpty() {
		return top == -1;
	}
	//return no of element
	public int size() {
		return top+1;
	}
	// return top element without removal
	public T peek() throws Exception {
		if(isEmpty())
			throw new Exception("Stack is empty");
		return (T)arr[top];
	}
	public int search(T t) {
		int temp=top;
		int index=0;
		if(!(isEmpty())) {
			while(temp >= 0) {
				index++;
				if(((T)arr[temp--]).equals(t))
					return index;
			}
		}
		return -1;
	}
	public synchronized void push(T item) {
		if(top == max_size) {
			System.out.println("OVERFLOW");
			System.exit(0);
		}else {
			arr[++top]=item;
		}
	}
	public synchronized T pop() throws Exception{
		if(isEmpty()) {
			//System.out.println("UnderFlow");
			//System.exit(0);
			throw new Exception("Stack is empty");
		}
		else {
			popped_item=(T)arr[top--];
			Object[] temp_array=new Object[max_size-1];
			for(int i=0;i<arr.length-1;i++) {
				if(i != top+1)
					temp_array[i]=arr[i];
			}
			arr=temp_array;
			temp_array=null;
		}
		return popped_item;
	}
}
