package com.kushagra;

public class LinkedListImp {
	
	Node first;
	
	LinkedListImp(Node node){
		this.first = node;
	}
	
	public static class Node
	{
		int data;
		Node next;
	}
	
	public void insert(int data, Node root){
		if (root == null)
			return;
		if(root.next != null)
		{
			insert(data, root.next);
		}
		else
		{
			Node d = new Node();
			d.data = data;
			root.next = d;
		}
	}
	
	public void insertCircular(int data, Node root)
	{
	  
	}
	
	public void traverse(Node root){
		while(root != null){
			System.out.println(root.data);
			root = root.next;
		}
	}
	
	public void reverse(Node node)
	{
		Node next,prev = null;
		while(node!=null)
		{
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		node = prev;
		while(node != null){
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	public void reverseRec(Node node)
	{
		if(node.next == null){
			first = node;
			return;
		}
		reverseRec(node.next);
		Node q = first.next;
		q.next = first;
		first.next = null;
	}
	

	public static void main(String[] args) {
	   Node node = new Node();
	   node.data=23;
       LinkedListImp linkedListImp = new LinkedListImp(node);
       linkedListImp.insert(11, node);
       linkedListImp.insert(12, node);
       linkedListImp.insert(13, node);
       linkedListImp.traverse(node);
       System.out.println("REV");
       //linkedListImp.reverse(node);
       linkedListImp.reverseRec(node);
       while(node != null){
			System.out.println(node.data);
			node = node.next;
		}
	}

}
