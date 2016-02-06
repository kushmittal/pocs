package com.kush;

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
}


class Test
{
  protected void sum()
  {
    System.out.println("");
  }
}