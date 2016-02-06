public class TestClone
{
  
  public static void main(String ...args)
  {
//    Stack stack = new 
  }
}

class Stack
{
  private Object[] elements;
  private int size = 0;
  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  public Stack()
  {
    this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
  }

  public void push(Object e)
  {
    elements[size++] = e;
  }

  public Object pop()
  {
    Object result = elements[--size];
    elements[size] = null; // Eliminate obsolete reference
    return result;
  }
  
  @Override public Stack clone() {
    try {
    Stack result = (Stack) super.clone();
    //result.elements = elements.clone();
    return result;
    } catch (CloneNotSupportedException e) {
    throw new AssertionError();
    }
    }
}
