package com.saas.biz.commen;

import com.saas.sys.log.Logger;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class cookiesMgr implements Filter
{
  public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse, FilterChain paramFilterChain)
    throws ServletException, IOException
  {
    Logger localLogger = new Logger(this);
    HttpServletRequest localHttpServletRequest = (HttpServletRequest)paramServletRequest;
    HttpSession localHttpSession = localHttpServletRequest.getSession(true);
    Cookie[] arrayOfCookie = localHttpServletRequest.getCookies();
    if ((arrayOfCookie != null) && (arrayOfCookie.length > 1))
    {
      String str1 = getCookieValue(arrayOfCookie, "SESSION_USER_ID");
      String str2 = getCookieValue(arrayOfCookie, "SESSION_CUST_ID");
      String str3 = getCookieValue(arrayOfCookie, "SESSION_USER_NAME");
      String str4 = getCookieValue(arrayOfCookie, "SESSION_CUST_NAME");
      String str5 = getCookieValue(arrayOfCookie, "SESSION_CUST_CLASS");
      String str6 = getCookieValue(arrayOfCookie, "DEPART_CODE");
      String str7 = getCookieValue(arrayOfCookie, "SESSION_ROLE_CODE");
      String str8 = getCookieValue(arrayOfCookie, "SESSION_CUST_TYPE");
      String str9 = getCookieValue(arrayOfCookie, "SESSION_USER_TYPE");
      localHttpSession.setAttribute("SESSION_USER_ID", str1);
      localHttpSession.setAttribute("SESSION_CUST_ID", str2);
      localHttpSession.setAttribute("SESSION_USER_NAME", str3);
      localHttpSession.setAttribute("SESSION_CUST_NAME", str4);
      localHttpSession.setAttribute("SESSION_CUST_CLASS", str5);
      localHttpSession.setAttribute("DEPART_CODE", str6);
      localHttpSession.setAttribute("SESSION_ROLE_CODE", str7);
      localHttpSession.setAttribute("SESSION_USER_TYPE", str9);
      localHttpSession.setAttribute("SESSION_CUST_TYPE", str8);
    }
    paramFilterChain.doFilter(paramServletRequest, paramServletResponse);
  }

  public String getCookieValue(Cookie[] paramArrayOfCookie, String paramString)
  {
    String str = "";
    if (paramArrayOfCookie == null)
      str = "";
    else
      for (int i = 0; i < paramArrayOfCookie.length; i++)
      {
        if (!paramString.equalsIgnoreCase(paramArrayOfCookie[i].getName()))
          continue;
        str = paramArrayOfCookie[i].getValue();
        return str;
      }
    return str;
  }

  public void init(FilterConfig paramFilterConfig)
    throws ServletException
  {
  }

  public void destroy()
  {
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.cookiesMgr
 * JD-Core Version:    0.6.0
 */