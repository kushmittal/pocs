package com.kush.poc;

public class PalindromeTest {
	
	private static SinglyList singlyList;

	public static void main(String ...args)
	{
	    singlyList = new SinglyList();
	    singlyList.addNode(4);
	    singlyList.addNode(5);
	    //singlyList.addNode(6);
	    singlyList.addNode(6);
	    singlyList.addNode(5);
	    singlyList.addNode(4);
	    singlyList.addNode(8);
	    //System.out.println(singlyList);
	    //singlyList.findMiddle();
	    singlyList.checkPalindrome();
	    
	    System.out.println("Finished");
	}
	
}
