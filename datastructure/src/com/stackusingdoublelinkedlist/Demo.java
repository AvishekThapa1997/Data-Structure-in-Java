package com.stackusingdoublelinkedlist;

public class Demo {
public static void main(String[] args) throws Exception {
	MyStackUsingDoubleLinkedList<Integer> myStackUsingDoubleLinkedList=new MyStackUsingDoubleLinkedList<Integer>();
	System.out.println(myStackUsingDoubleLinkedList.pop());
	for(int i=0;i<10;i++) {
		myStackUsingDoubleLinkedList.push(i);
	}
	System.out.println(myStackUsingDoubleLinkedList);
	System.out.println(myStackUsingDoubleLinkedList.size());
	System.out.println(myStackUsingDoubleLinkedList.pop());
	System.out.println(myStackUsingDoubleLinkedList.pop());
	System.out.println(myStackUsingDoubleLinkedList.size());
}
}
