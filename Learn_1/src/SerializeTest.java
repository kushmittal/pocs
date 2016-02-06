import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class SerializeTest
{
  /**
   * @param args
   */
  public static void main(String[] args)
  {
   Cat c = new Cat();
   c.setId(1);
   c.setName("psssssss");
   c.setAge(2);
   char ca = 'a';
   int i = ca;
   FileInputStream fis;
   /*try
   {
     FileOutputStream fos = new FileOutputStream("E:\\TestProjects2\\Learn\\test.ser");
     ObjectOutputStream objectInputStream = new ObjectOutputStream(fos);
     objectInputStream.writeObject(c);
   }
   catch (FileNotFoundException e)
   {
     // TODO Auto-generated catch block
     e.printStackTrace();
   }
   catch (IOException e)
   {
     // TODO Auto-generated catch block
     e.printStackTrace();
   }*/
  try
  {
    fis = new FileInputStream("E:\\TestProjects2\\Learn\\test.ser");
    ObjectInputStream objectInputStream = new ObjectInputStream(fis);
    Cat cat = (Cat) objectInputStream.readObject();
    System.out.println(cat.getId());
    objectInputStream.close();
  }
  catch (FileNotFoundException e)
  {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
  catch (IOException e)
  {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
  catch (ClassNotFoundException e)
  {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
  }
}

class Cat implements Serializable
{
  /**
   * 
   */
  private static final long serialVersionUID = 12L;
  
  private int id;
  private String name;
  private int age;
  
  public int getId()
  {
    return id;
  }
  public void setId(int id)
  {
    this.id = id;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public int getAge()
  {
    return age;
  }
  public void setAge(int age)
  {
    this.age = age;
  }
}
