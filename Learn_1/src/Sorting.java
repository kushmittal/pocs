import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Sorting {
	
	public static void main(String ...args){
   HashMap<String, String> hashSort = new HashMap<String, String>();
   hashSort.put("kush", "Kushagra");
   hashSort.put("kush1", "jufg");
   hashSort.put("kush2", "hhjufg");
   List list = new ArrayList<Map.Entry<String, String>>(hashSort.entrySet());
   Collections.sort(list,new ValComparator());
   Iterator iterator = list.iterator();
   while(iterator.hasNext()){
	   System.out.println(iterator.next());
   }
	}
}

class ValComparator implements Comparator<Map.Entry<String, String>>
{

	@Override
	public int compare(Entry<String, String> paramT1,
			Entry<String, String> paramT2) {
		return paramT1.getValue().compareTo(paramT2.getValue());
	}

	
}
