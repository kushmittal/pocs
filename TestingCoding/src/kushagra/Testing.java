package kushagra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.TreeMap;
import java.util.Vector;

public class Testing {

	public static void main(String... args) throws IOException {
         //String s = new String("kushh");
//         InputStreamReader isInputStreamReader = new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(isInputStreamReader);
//         String s2 = br.readLine();
         //int index = 0;
         //System.out.println(substringTest(s, new StringBuilder("skushkuddfgsggashaee"), index));
//	  List<String> list = new ArrayList<String>();
//	  list.add(null);
//	 // substringTest();
//	  System.out.println(Integer.MAX_VALUE);
//	  int k= Math.abs(-2147483648);
//	  System.out.println("k:"+k);
//	  System.out.println(Math.abs(Integer.MIN_VALUE));
//	  Vector<String> vector = new Vector<String>();
//	  vector.iterator();
//	  vector.elements();
////	  Random random = new  Random();
////	  for(int i =0 ; i< 100;i++)
////	  System.out.println(random.nextInt(2));
//	  System.out.println(System.out);
//	  Map<Person,String> map = new TreeMap<Person,String>();
//	  Person p = new Person();
//	  p.setId(1);
//	  p.setName("yyy");
//	  map.put(p, "11");
//	  Person p1 = new Person();
//	  p1.setId(1);
//      p1.setName("yyy");
//	  map.put(p1, "112");
//	  System.out.println(map.size()+"oooooooooooooooooooooooooooo");
//	  System.out.println(map.get(p1));
//	  System.out.println(map.get(p));
//	  String s1 = "Kushagra";
//	  String s2 = s1;
//	  System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//	  System.out.println("s1==s2"+ s1==s2);
//	  System.out.println("s1==s2"+ s1.equals(s2));
	    /*int size;
	    String str ="kushagra";
	    Testing testing =  new Testing();
	    testing.reverse(str.toCharArray(), 0, 8);
	    PriorityQueue<String> queue = new PriorityQueue<String>();
	    queue.add("Kushgra");
	    queue.add("aKushgra");
	     queue.add("rKushgra");
	     for(Entry<Person, String> entry : map.entrySet()){
	       System.out.println(entry.getKey());
	       System.out.println(entry.getValue());
	     }*/
	     
//	     for(int i =1;i< 12; i++)
//	     {
//	       System.out.println(6-Math.abs(6-i));
//	     }
	     //Testing t = new Testing();
	     //System.out.println(t.abc());
	     Integer h =new Integer(-9);
	     System.out.println(Integer.toBinaryString(h));
	     System.out.println(Integer.toBinaryString(h>>2));
	     System.out.println(Integer.toBinaryString(h>>>2));
	     /*System.out.println(Integer.toBinaryString(h));
	     System.out.println(Integer.toBinaryString(h>>>2));*/
	    // h ^= (h >>> 20) ^ (h >>> 12);
	     
//	     System.out.println(h+":|");
//	       System.out.println(h ^ (h >>> 7) ^ (h >>> 4));
//	       int bitmask = 0x000F;
//	        int val = 0x2222;
//	        // prints "2"
//	        System.out.println(Integer.toBinaryString(bitmask));
//	        System.out.println(Integer.toBinaryString(val));
//	        System.out.println(val & bitmask);
//	        System.out.println(Integer.toBinaryString(val ^ bitmask));
//            System.out.println(Integer.toBinaryString(val | bitmask));
//	        System.out.println(val ^ bitmask);
//	        System.out.println(val | bitmask);
	       
	     int i = 10;
	     int n = i++%5;
	     System.out.println(""+i+"     "+n);
	}

	/**
	 * @param s
	 * @param s2
	 * @param index
	 */
	private  static boolean substringTest(String s, StringBuilder s2, int index) {
		System.out.println("Kushagra");
         for(int i =0 ; i < s.length() ; i++){
        	 int local_index = s2.indexOf(String.valueOf(s.charAt(i)),index);
        	 if(index <= local_index){
        		 index = local_index;
        		  s2.setCharAt(index, '*');
        	 }
        	 else
        	 {
        		 return false;
        	 }
         }
        return true;
	}
	
	private  static boolean substringTest(List<Object> list) {
	  return true;
	}
	
	void reverse(char str1[], int index, int size)
	{
	    char temp;
	    temp = str1[index];
	    str1[index] = str1[size - index];
	    str1[size - index] = temp;
	    if (index == size / 2)
	    {
	        return;
	    }
	    reverse(str1, index + 1, size);
	}
	
	
	public int abc(){
	  try{
	    int i=1/0;
	    return 1;
	  }
	  catch(Exception e){
	    return 2;
	  }
	  finally
	  {
	    return 4;
	  }
	}

}



class Person implements Comparable<Person>
{
  private int id;
  private String name;
  
  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
  {
    System.out.println("hashcode");
    Random random = new Random();
    return random.nextInt();
  }
  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj)
  {
    return true;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public int getId()
  {
    return id;
  }
  public void setId(int id)
  {
    this.id = id;
  }
  @Override
  public int compareTo(Person o)
  {
    return this.getName().compareTo(o.getName());
  }
  
}
