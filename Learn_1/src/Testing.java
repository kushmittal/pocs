import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Testing extends Test implements Cloneable
{
  public void sum()
  {
    System.out.println("");
  }
  
  @Override
  protected Object clone() throws CloneNotSupportedException
  {
    return super.clone();
    
  }
  
  private void writeObject(ObjectOutputStream os)
  {
    // throws IOException { // 1
    try
    {
      os.defaultWriteObject(); // 2
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void readObject(ObjectInputStream is)
  {
    // throws IOException, ClassNotFoundException { // 4
    try
    {
      is.defaultReadObject(); // 5
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}

class Test
{
  protected void sum()
  {
    System.out.println("");
  }
}