package com.saas.biz.commen;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChatRoomServlet extends HttpServlet
  implements Servlet
{
  static final long serialVersionUID = 1L;
  private String userName = "";

  private String getNow()
  {
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    return localSimpleDateFormat.format(localDate);
  }

  protected void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    String str = paramHttpServletRequest.getParameter("Action");
    if (str != null)
    {
      Object localObject;
      if (str.equals("GetMessage"))
      {
        localObject = paramHttpServletResponse.getWriter();
        ((PrintWriter)localObject).print(new StringBuilder().append(getMessages()).append("!@#").append(getOnlineUsers()).toString());
      }
      else if (str.equals("AddMessage"))
      {
        localObject = paramHttpServletRequest.getParameter("Message");
        this.userName = ((UserSessionListener)paramHttpServletRequest.getSession().getAttribute("UserName")).toString();
        addMessage(new StringBuilder().append(getNow()).append(" ").append(this.userName).append(" Says: ").append((String)localObject).toString());
      }
      else if (str.equals("Logout"))
      {
        paramHttpServletRequest.getSession().removeAttribute("UserName");
      }
      else if (str.equals("Login"))
      {
        paramHttpServletRequest.getSession().setAttribute("UserName", new UserSessionListener(paramHttpServletRequest.getParameter("UserName")));
      }
    }
  }

  protected void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    doGet(paramHttpServletRequest, paramHttpServletResponse);
  }

  private String getMessages()
  {
    String str1 = null;
    ServletContext localServletContext = getServletContext();
    LinkedList localLinkedList = (LinkedList)localServletContext.getAttribute("ChatMessage");
    if (localLinkedList == null)
    {
      str1 = "";
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        localStringBuilder.append(str2);
        localStringBuilder.append("<br>");
      }
      str1 = localStringBuilder.toString();
    }
    return str1;
  }

  private String getOnlineUsers()
  {
    LinkedList localLinkedList = (LinkedList)getServletContext().getAttribute("UserList");
    String str1;
    if (localLinkedList == null)
    {
      str1 = "";
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        localStringBuilder.append(str2);
        localStringBuilder.append("  ");
      }
      str1 = localStringBuilder.toString();
    }
    return str1;
  }

  private void addMessage(String paramString)
  {
    ServletContext localServletContext = getServletContext();
    synchronized (localServletContext)
    {
      LinkedList localLinkedList = (LinkedList)localServletContext.getAttribute("ChatMessage");
      if (localLinkedList == null)
        localLinkedList = new LinkedList();
      if (localLinkedList.size() > 10)
        localLinkedList.removeFirst();
      localLinkedList.add(paramString);
      localServletContext.setAttribute("ChatMessage", localLinkedList);
    }
  }

  public void destroy()
  {
    super.destroy();
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.ChatRoomServlet
 * JD-Core Version:    0.6.0
 */