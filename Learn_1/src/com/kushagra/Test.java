package com.kushagra;

import java.util.HashMap;

public class Test
{
  public Test()
  {
    // TODO Auto-generated constructor stub
  }
  
  
  
  public void sum(byte b)
  {
    System.out.println("byte");
  }
  public void sum(int a)
  {
    System.out.println("int");
  }
  
   public static void main(String ...args)
  {
     float f = -123;
//    String a = "newspaper";
//    a = a.substring ( 5,7 ) ;
//    char b = a.charAt ( 1 ) ;
//    a = a + b;
//    System.out.println ( a ) ;
    
//     Testing testing = new Testing();
//     System.out.println(0x10 + 10 + 010);
//     op(false, false); op(true, false); op(false, true); op(true, true); 
     //char c = 'A'; int i = c;
    //outer: for (int i = 0; i < 3; i++) { for (int j = 0; j < 2; j++) { if (i == j) { continue outer; } System.out.println("i=" + i + ", j=" + j); } }
    //String a, b, c; c = new String("mouse"); a = new String("cat"); b = a; a = new String("dog"); c = b; System.out.println(c);
//     int i = 0; int j = 0; boolean t = true; boolean r;
//     r = (t & 0 < (i+=1)); 
//     r = (t && 0 < (i+=2));
//     r = (t | 0 < (j+=1));
//     r = (t || 0 < (j+=2)); 
    // System.out.println(i + " " + j);
    // int[] array = { 4, 8, 16 }; int i=1; array[++i] = --i; System.out.println(array[0] + array[1] + array[2]);
//     int k = 1; int i = ++k + k++ + + k; 
//     System.out.println(i);
//     Integer[] ar = new Integer[0];
     HashMap<Person, String> map = new HashMap<Person, String>();
     Person p1 = new Person();
     p1.setId(1);
     Person p2 = new Person();
     p1.setId(2);
     map.put(p1, "a");
     map.put(p2, "b");
     System.out.println(map.size());
     Test test = new Test();
     byte b = 0;
     test.sum(b);
//     map.put("qq", "zzzz");
//     map.put(null, "aa");
//     map.put("qq", "ss");
//     map.get("qq");
//     map.get(null);
  }
  
  static void op(boolean a, boolean b)
  {
    boolean c = a != b;
    boolean d = a ^ b;
    boolean e = c == d;
    System.out.println(e);
  }
}
