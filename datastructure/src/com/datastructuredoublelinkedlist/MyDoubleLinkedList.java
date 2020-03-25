package com.datastructuredoublelinkedlist;
//Adding to last and first can be easy  by declaring global nodes variable which will always stored the address of first and last node
public class MyDoubleLinkedList<E> {
private Node<E> head;
private Node<E> first_node;
private Node<E> last_node;
private int size;
public String toString() {
	StringBuffer sb=new StringBuffer();
	Node<E> temp=first_node;
	while(temp!=null) {
		E item=temp.data;
		sb.append(item+",");
		temp=temp.next;
	}
	String data=sb.toString();
	if(data.isEmpty())
		return "[]";
	return "["+data.substring(0,sb.length()-1)+"]";
}
public boolean isEmpty() {
	return first_node == null & last_node == null;
}
public int size(){
	return size;
}
public synchronized void addLast(E data){
	if(isEmpty()){
		addFirst(data);
		return;
	}
	Node<E> toAdd=new Node<E>(data);
	last_node.next=toAdd;
	toAdd.previous=last_node;
	last_node=toAdd;
	++size;
}
public synchronized E getLast() throws Exception {
	if(isEmpty())
		throw new Exception("Double LinkedList is Empty");
	return last_node.data;
}
public synchronized E removeLast() throws Exception {
	if(isEmpty())
		throw new Exception("Double LinkedList is Empty");
	if(size() == 1) {
		E item=removeFirst();
		return item;
	}
	E item=last_node.data;
	last_node=last_node.previous;
	last_node.next=null;
	--size;
	return item;
}
public synchronized void addFirst(E data){
	Node<E> toAdd=new Node<E>(data);
	if(isEmpty()){
			first_node=toAdd;
			last_node=first_node;
			++size;
			return;
	}
	first_node.previous=toAdd;
	toAdd.next=first_node;
	first_node=toAdd;
	++size;
}
public synchronized E getFirst() throws Exception{
	if(isEmpty())
		throw new Exception("Double Linked List is Empty");
	return first_node.data;
}
public synchronized E removeFirst() throws Exception{
	if(isEmpty())
		throw new Exception("Double Linked List is Empty");
	if(size() == 1) {
		E item=first_node.data;
		first_node=null;
		last_node=null;
		--size;
		return item;
	}
	E item=first_node.data;
	first_node=first_node.next;
	first_node.previous=null;
	--size;
	return item;
}
@SuppressWarnings("hiding")
private class Node<E>{
	private Node<E> next;
	private Node<E> previous;
	private E data;
	Node(E data){
		this.data=data;
		previous=null;
		next=null;
	}
}
}
