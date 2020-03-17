package com.datastructure.linkedlist;
public class MyLinkedList<E> {
	private static final String EMPTY="LinkedList is Empty";
	private Node<E> head;
	public boolean isEmpty() {
		return head == null;
	}
	//removes all object
	public void clear() {
		head=null;
	}
	//checks if a particular elements is present or not
	public boolean contains(E item){
		Node<E> temp=head;
		while(temp != null) {
			if(temp.data.equals(item))
				return true;
				temp=temp.next;
		}
		return false;
	}
	//replace old element with new element
	public synchronized E replace(E oldObject,E newObject){
		Node<E> temp=head;
		E item_to_returned=null;
		while(temp !=null) {
			if(temp.data.equals(oldObject)) {
				item_to_returned=oldObject;
				temp.data=newObject;
				break;
			}
			temp=temp.next;	
		}
		return item_to_returned;
	}
	public String toString() {
		StringBuffer sb=new StringBuffer();
		if(isEmpty())
			return "[]";
		Node<E> temp=head;
		while(temp != null) {
			sb.append(temp.data);
			sb.append(',');
			temp=temp.next;
		}
		return "["+sb.toString().substring(0,sb.length()-1)+"]";
	}
	// returns  no of object
	public int size() {
		int index=0;
		Node<E> temp=head;
		while(temp != null) {
			++index;
			temp=temp.next;
		}
		return index; 
	}
	//insert at begin
	public synchronized void addFirst(E data){
		Node<E> item=new Node<>(data);
		item.next=head;
		head=item;
		item=null;
	}
	//insert at the end
	public synchronized void addLast(E data) {
		Node<E> item=new Node<>(data);
		if(isEmpty()) {
			head=item;
			return;
		}
		Node<E> temp=head;
		while(temp.next != null) {
			temp=temp.next;
		}
		temp.next=item;
	}
	public synchronized void add(E data){
		addLast(data);
	}
	//get First Item
	public   E getFirst() throws Exception{
		if(isEmpty()) {
			throw new Exception(EMPTY);
		}
		E item=head.data;
		return item;
	}
	//get Last Item
	public E getLast() throws Exception{
		if(isEmpty())
			throw new Exception(EMPTY);
		if(size() == 1)
			return head.data;
		Node<E> temp=head;
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		return temp.next.data;
	}
	//insert at particular index 
	public synchronized void inserAt(int index,E data) throws Exception
	{
		if(index >= size()+1  || index < 0)
			throw new Exception("Index Cannot be greater than size");
		if(index == size() || (index ==0 && isEmpty())) {
			addLast(data);
			return;
		}
		Node<E> temp=head;
		Node<E> item=new Node<>(data);
		if(index == 0 && !isEmpty()){
			item.next=temp;
			head=item;
			return;
		}
		int current_index=0;	
		Node<E> prev=temp;
		while(current_index != index)
		{
			prev=temp;
			temp=temp.next;
			++current_index;
		}
		item.next=temp;
		prev.next=item;
	}
	public synchronized E removeFirst() throws Exception {
		if(isEmpty())
			throw new Exception("Linked List is Empty");
		E item=head.data;
		head=head.next;
			return item;
	}
	public synchronized E removeLast() throws Exception {
		if(isEmpty())
			throw new Exception(EMPTY);
		Node<E> temp=head;
		Node<E> prev=null;
		while(temp.next != null) {
			prev=temp;
			temp=temp.next;
		}
		E data=null;
		if(temp == head) {
		data=temp.data;
		head=null;
		}else {
		data=temp.data;	
		prev.next=null;
		}
		return data;
	}
	public synchronized E deleteAt(int index) throws Exception
	{
		if(index < 0 || index >= size())
			throw new IllegalArgumentException("Index cannot be greater than size or less than zero");
		if(index == 0) {
			return removeFirst();
		}
		if(index == size()-1)
			return removeLast();
		Node<E> temp=head;
		Node<E> prev=null;
		int current_index=0;
		while(current_index!=index) {
			prev=temp;
			temp=temp.next;
			++current_index;
		}
		prev.next=temp.next;
		return temp.data;
}
	@SuppressWarnings("hiding")
	private class Node<E>
	{
		E data;
		Node<E> next;
		private Node(E data){
			this.data=data;
			this.next=null
					;
		}
	}
	
}
