package com.kush.poc;

import java.util.LinkedList;
import java.util.Queue;


public class TreeImp {
	
	private Node node;
	static Node succ;
	static Node pre;
	
	public TreeImp(Node node) {
		super();
		this.setNode(node);
	}

	public static void main(String ...args)
	{
		Node node = new Node(10);
		TreeImp treeImp = new TreeImp(node);
		
		
		treeImp.insert(treeImp.getNode(), 11);
		treeImp.insert(treeImp.getNode(), 2);
		treeImp.insert(treeImp.getNode(), 4);
		treeImp.insert(treeImp.getNode(), 16);
		treeImp.insert(treeImp.getNode(), 15);
		treeImp.insert(treeImp.getNode(), 12);
		treeImp.insert(treeImp.getNode(), 7);
		treeImp.insert(treeImp.getNode(), 9);
		treeImp.insert(treeImp.getNode(), 66);
		treeImp.insert(treeImp.getNode(), 6);
		//treeImp.delete(treeImp.getNode(), 66);
		//treeImp.delete(treeImp.getNode(), 15);
		//treeImp.delete(treeImp.getNode(), 10);
		//treeImp.bfs(treeImp.getNode());
		//treeImp.inOrder(treeImp.getNode());
		//treeImp.preOrder(treeImp.getNode());
		//treeImp.postOrder(treeImp.getNode());
		//treeImp.rootWithGivenSum(treeImp.getNode(), new int[100], 0, 103);
		treeImp.findSucc(treeImp.getNode(), treeImp.find(treeImp.getNode(), 7));
		System.out.println(succ.getData());
		treeImp.findPre(treeImp.getNode(), treeImp.find(treeImp.getNode(), 7));
		System.out.println(pre.getData());
		//System.out.println(treeImp);
	}
	
	public Node insert(Node root, int value)
	{
		if(root == null)
		{
			root = new Node(value);
		}
		else
		{
			if(root.getData() > value)
			{
				root.leftChild = insert(root.leftChild, value);
			}
			else
			{
				root.rightChild = insert(root.rightChild, value);
			}
		}
		return root;
	}
	
	public Node delete(Node root, int value)
 {
		if (root == null) {
			System.out.println("Nothing to delete");
		} else {
			if (root.getData() > value) {
				root.leftChild = delete(root.leftChild, value);
			} else if (root.getData() < value) {
				root.rightChild = delete(root.rightChild, value);
			} else {
				if (root.leftChild != null && root.rightChild != null) {
					root = deleteWithTwoChild(root, value);
				} else if (root.leftChild != null || root.rightChild != null) {
					root = deleteWithOneChild(root, value);
				} else {
					root = null;
				}
			}
		}
		return root;
	}
	
	public Node deleteWithOneChild(Node root, int value)
	{
		Node node = root.leftChild != null? root.leftChild:root.rightChild;
		root = node;
		System.out.println();
		return root;
	}
	
	public Node deleteWithTwoChild(Node root, int value)
	{
//		Node leftChild = root.leftChild;
		Node rightChild = root.rightChild;
		Node smallestChild = smallestNode(rightChild);
		root.data = smallestChild.data;
//		if(smallestChild.leftChild != null && smallestChild.rightChild != null)
//		{
//			deleteWithTwoChild(smallestChild, smallestChild.getData());
//		}
//		else if(smallestChild.leftChild != null || smallestChild.rightChild != null)
//		{
//			deleteWithOneChild(smallestChild, smallestChild.getData());
//		}
//		else
//		{
		root.rightChild = delete(smallestChild, smallestChild.getData());
		
//		}
		return root;
		
	}
	
	private Node smallestNode(Node root)
	{
		if(root.leftChild != null)
		{
			smallestNode(root.leftChild);	
		}
		return root;
	}
	
	public void inOrder(Node root)
	{
		if(root.leftChild != null)
		{
			inOrder(root.leftChild);
		}
		System.out.println(root.data);
		if(root.rightChild != null)
		{
			inOrder(root.rightChild);
		}
	}
	
	public void preOrder(Node root)
	{
		System.out.println(root.data);
		if(root.leftChild != null)
		{
			preOrder(root.leftChild);
		}
		
		if(root.rightChild != null)
		{
			preOrder(root.rightChild);
		}
	}
	
	public void postOrder(Node root)
	{
		
		if(root.leftChild != null)
		{
			postOrder(root.leftChild);
		}
		if(root.rightChild != null)
		{
			postOrder(root.rightChild);
		}
		System.out.println(root.data);
	}
	
	public Node find(Node root, int num)
	{
		if (root.getData() > num) {
			root = find(root.leftChild, num);
		} else if (root.getData() < num) {
			root = find(root.rightChild, num);
		}
		return root;
	}
	
	public void depth(TreeImp treeImp, Node node)
	{
	}
	
	public void height(TreeImp treeImp, Node node)
	{
	}
	
	public void rootWithGivenSum(Node root, int[] path, int length, int sum) {
		if (root == null) {
			System.out.println("No");
			return;
		}

		path[length] = root.getData();
		length++;

		if (root.leftChild == null && root.rightChild == null) {
			int sumPath = 0;
			for (int i = 0; i < length; i++) {
				sumPath += path[i];
			}
			if (sum == sumPath) {
				for (int i = 0; i < length; i++) {
					if(path[i] != 0)
					System.out.println(path[i]);
				}
			}

		}
		if(root.leftChild != null)
		rootWithGivenSum(root.leftChild, path, length, sum);
		if(root.rightChild != null)
		rootWithGivenSum(root.rightChild, path, length, sum);

	}
	
	
//	public void preAndSucc(Node root, int num)
//	{
//		if(root.getData() > num)
//		{
//			preAndSucc(root.leftChild, num);
//		}
//		else if(root.getData() < num)
//		{
//			preAndSucc(root.rightChild, num);
//		}
//		else
//		{
//			
//		}
//	}
	
	public void bfs(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (queue.size() > 0) {
			Node node = queue.poll();
			System.out.println(node.getData());
			if (node.leftChild != null) {
				queue.add(node.leftChild);
			}
			if(node.rightChild != null) {
				queue.add(node.rightChild);
			}
		}
	}
	
	public void findSucc(Node root,Node node) {
		
			if(node.rightChild != null)
			{
				Node n = new Node(findSmallest(node.rightChild).getData());
				succ = n;
			}
			else if(node.rightChild == null)
			{
				if(node.data > root.data)
				{
					findSucc(root.rightChild, node);
				}
				else if(node.data < root.data)
				{
					succ = root;
					findSucc(root.leftChild, node);
				}
			}
	}
	
	public void findPre(Node root,Node node) {
		
		if(node.rightChild != null)
		{
			Node n = new Node(findSmallest(node.rightChild).getData());
			succ = n;
		}
		else if(node.rightChild == null)
		{
			if(node.data > root.data)
			{
				findSucc(root.rightChild, node);
			}
			else if(node.data < root.data)
			{
				succ = root;
				findSucc(root.leftChild, node);
			}
		}
}

//	public Node bfsSearch(Node root, Queue<Node> queue)
//	{
//		while(queue.size() > 0)
//		{
//			Node node = queue.poll();
//			System.out.println(node.getData());
//		}
//		return root;
//	}
	
	

	private Node findSmallest(Node root) {
		if(root.leftChild != null)
		{
			root = findSmallest(root.leftChild);	
		}
		 return root;
		
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
	
}

class Node
{
	Node leftChild;
	Node rightChild;
	int data;

	public Node(int value) {
		this.data = value;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
}
