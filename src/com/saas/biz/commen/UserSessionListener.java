package com.saas.biz.commen;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserSessionListener
  implements HttpSessionBindingListener
{
  private String userName;

  public UserSessionListener(String paramString)
  {
    this.userName = paramString;
  }

  private String getNow()
  {
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    return localSimpleDateFormat.format(localDate);
  }

  public void valueBound(HttpSessionBindingEvent paramHttpSessionBindingEvent)
  {
    paramHttpSessionBindingEvent.getSession().setMaxInactiveInterval(-1);
    ServletContext localServletContext = paramHttpSessionBindingEvent.getSession().getServletContext();
    synchronized (localServletContext)
    {
      LinkedList localLinkedList1 = (LinkedList)localServletContext.getAttribute("UserList");
      if (localLinkedList1 == null)
        localLinkedList1 = new LinkedList();
      localLinkedList1.add(this.userName);
      localServletContext.setAttribute("UserList", localLinkedList1);
      LinkedList localLinkedList2 = (LinkedList)localServletContext.getAttribute("ChatMessage");
      if (localLinkedList2 == null)
        localLinkedList2 = new LinkedList();
      localServletContext.setAttribute("ChatMessage", localLinkedList2);
    }
  }

  public void valueUnbound(HttpSessionBindingEvent paramHttpSessionBindingEvent)
  {
    ServletContext localServletContext = paramHttpSessionBindingEvent.getSession().getServletContext();
    synchronized (localServletContext)
    {
      LinkedList localLinkedList1 = (LinkedList)localServletContext.getAttribute("UserList");
      localLinkedList1.remove(this.userName);
      localServletContext.setAttribute("UserList", localLinkedList1);
      LinkedList localLinkedList2 = (LinkedList)localServletContext.getAttribute("ChatMessage");
      if (localLinkedList2 == null)
        localLinkedList2 = new LinkedList();
      localServletContext.setAttribute("ChatMessage", localLinkedList2);
    }
  }

  public String getUserName()
  {
    return this.userName;
  }

  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }

  public String toString()
  {
    return this.userName;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.UserSessionListener
 * JD-Core Version:    0.6.0
 */