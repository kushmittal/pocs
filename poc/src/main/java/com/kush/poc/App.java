package com.kush.poc;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private final int i;
	
	public App()
	{
		i =5;
	}
	
    public static void main( String[] args )
    {
    	Node node = new Node(40);
        TreeImp treeImp = new TreeImp(node);
        treeImp.insert(treeImp.getNode(), 20);
        treeImp.insert(treeImp.getNode(), 60);
        treeImp.insert(treeImp.getNode(), 10);
        treeImp.insert(treeImp.getNode(), 30);
        treeImp.insert(treeImp.getNode(), 50);
        treeImp.insert(treeImp.getNode(), 70);
        treeImp.insert(treeImp.getNode(), 5);
        treeImp.insert(treeImp.getNode(), 55);
        treeImp.inOrder(treeImp.getNode());
        treeImp.preOrder(treeImp.getNode());
        treeImp.postOrder(treeImp.getNode());
    }
}
