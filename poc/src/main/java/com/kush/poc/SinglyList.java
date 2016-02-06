package com.kush.poc;

public class SinglyList {
	
	private Node start;
	private static boolean isEven = false;
	
	class Node
	{
		private int data;
		private Node next;
	}
	
	protected Node findMiddle()
	{
		Node slowPointer = start;
		Node fastPointer = start;
		while(fastPointer.next != null && fastPointer.next.next != null)
		{
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		if(fastPointer.next != null && fastPointer.next.next == null)
		{
			isEven = true;
		}
		if(isEven)
		{
			System.out.println(slowPointer.next.data);
			return slowPointer.next;
		}
		else
		{
			System.out.println(slowPointer.data);
			return slowPointer;
		}
	}
	
	protected Node reverse(Node startNode)
	{
		Node next = null;
		Node prev = null;
		Node current = startNode;
		while(current != null )
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		startNode = prev;
		return startNode;
	}
	
	void addNode(int data)
	{
		Node current = start;
		Node node = new Node();
		node.data = data;
		if(start == null)
		{
			start = node;
			return;
		}
		while(current.next != null)
		{
			current = current.next;
		}
		current.next = node;
	}
	
	Node getList()
	{
		return start;
	}
	
	@Override
	public String toString() {
		if(start != null)
		{
			while(start.next != null)
			{
				System.out.println(start.data);
				start = start.next;
			}
			System.out.println(start.data);
		}
		else
		{
			return "Blank List";
		}
		return "";
	}
	
	public void checkPalindrome()
	{
		Node node = findMiddle();
	    if(SinglyList.isEven())
	    {
	    	node = reverse(node);	
	    }
	    else
	    {
	    	node = node.next;
	    	node = reverse(node);
	    }
	    System.out.println(compare(start, node));
	}
	
	private boolean compare(Node head, Node reverse)
	{
		boolean equal = true;
		while(reverse != null)
		{
			if(reverse.data != head.data)
			{
				equal = false;
				break;
			}
			reverse = reverse.next;
			head = head.next;
		}
		return equal;
	}

	public static boolean isEven() {
		return isEven;
	}

	public static void setEven(boolean isEven) {
		SinglyList.isEven = isEven;
	}

}
