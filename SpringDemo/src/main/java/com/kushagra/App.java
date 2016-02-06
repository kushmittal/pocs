package com.kushagra;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
  public static void main(String ...args)
  {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    CustomerService customerService = (CustomerService)applicationContext.getBean("customerServiceProxy");
    customerService.printName();
    customerService.printURL();
    try
    {
      customerService.printThrowException();  
    }
    catch(Exception e)
    {
      
    }
    finally
    {
      if(applicationContext != null)
      {
        ((ClassPathXmlApplicationContext)applicationContext).close();
      }
    }
    
  }
}
