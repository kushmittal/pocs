package kushagra;

class Deadlocking implements Runnable
{

  @Override
  public void run()
  {
    synchronized(this)
    {
      try
      {
        this.wait();
      }
      catch (InterruptedException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    System.out.println("aaaaass");
  }
  
}
 public class Deadlock
{
  public static void main(String ...args) throws InterruptedException
  {
    Deadlocking deadlocking = new Deadlocking();
    Thread t = new Thread(deadlocking);
    synchronized (t)
    {
      t.wait();
    }
    System.out.println("aaa");
  }
  
}