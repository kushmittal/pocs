package kushagra;

import java.util.HashMap;

public class TestingSubArray {
	public static void main(String... args) {
          int []arr = new int[]{2,4,5,7,3,6,9,22};
          int required_sum = 12;
          
          StringBuffer sb = new StringBuffer();
          StringBuilder sbu = new StringBuilder();
          System.out.println(sb.capacity());
          System.out.println(sbu.capacity());
          
	}
}

class KushagraMap<K,V> extends HashMap<String, String>
{
 
   public String get(String paramObject)
   {
     return super.get(paramObject.toString().toLowerCase());
   }
   
   
   public String put(String paramOne,String paramTwo)
   {
     return super.put(paramOne.toLowerCase(), paramTwo);
   }
   
   public int size()
   {
     return super.size();
   }
   
   public static void main(String ...args)
   {
     KushagraMap<String,String> kushagraMap = new KushagraMap<String, String>();
     kushagraMap.put("KUSHAGRA", "Good");
     kushagraMap.put("kushAg", "Gooood");
     System.out.println(kushagraMap.size());
     System.out.println(kushagraMap.get("kushagra"));
     System.out.println(kushagraMap.get("kushag"));
     
   }
}
