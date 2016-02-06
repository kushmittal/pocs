package com.kushagra;

public class CustomerService
{
  private int id;
  private String name;
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

  public void printName()
  {
    System.out.println("Customer name : " + this.name);
  }

  public void printURL()
  {
    System.out.println("Customer website : " + this.id);
  }

  public void printThrowException()
  {
    throw new IllegalArgumentException();
  }
  
}
