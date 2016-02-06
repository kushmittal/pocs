package kushagra;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class ParseJson {
	
	
	public static void main(String ...args) throws BiffException
	{
		 try
		    {
			 // XLS Location
			 String s = "C:\\Users\\kushagra.mittal\\Desktop\\Salary Slip\\aaaa\\Geeta.txt";
			 OutputStream stream = new FileOutputStream(s);
			 
			 FileWriter writer = new FileWriter(s);
			 
			    writer.append("DisplayName");
			    writer.append(',');
			    writer.append("Age");
			    writer.append('\n');
 
			  
			    //generate whatever data you want
		 
			 // 
//			 WritableWorkbook workbook = Workbook.createWorkbook(stream);
//			 WritableSheet sheet = workbook.createSheet("Sheet1", 0);
//			 sheet.addCell(new Label(0,0, "Name"));
//			 sheet.addCell(new Label(1,0, "Age"));
//			 sheet.addCell(new Label(2,0, "Messages"));
			 
			// Creating JSON Object
			JSONObject obj = new JSONObject();
			obj.put("name", "geeta");
			obj.put("age", new Long(100));

			JSONArray list = new JSONArray();
			list.add("msg 1");
			list.add("msg 2");
			list.add("msg 3");

			obj.put("messages", list);
			
			// Parse JSON
			String name = (String) obj.get("name");
			//sheet.addCell(new Label(0, 1, name));
			writer.append(name);
		    writer.append(',');
		    long age = (Long) obj.get("age");
		    writer.append(String.valueOf(age));
			
			//sheet.addCell(new Label(1, 1, String.valueOf(age)));
			// loop array
			JSONArray msg = (JSONArray) obj.get("messages");
			Iterator<String> iterator = msg.iterator();
			//int index = 1;
			while (iterator.hasNext()) {
				//sheet.addCell(new Label(2, index, iterator.next()));
				//index++;
				writer.append(iterator.next());
			    writer.append(',');
			}
	
//			 workbook.write();
//			 workbook.close();
			 writer.flush();
			    writer.close();
		    }
		    catch (IOException e)
		    {
		    }
	}
    
}
