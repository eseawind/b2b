package com.saas.biz.commen;

import com.saas.biz.channelMgr.ChannelInfo;
import com.saas.sys.log.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChannelRightMgr
  implements Filter
{
  public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse, FilterChain paramFilterChain)
    throws ServletException, IOException
  {
    Logger localLogger = new Logger(this);
    HttpServletRequest localHttpServletRequest = (HttpServletRequest)paramServletRequest;
    HttpServletResponse localHttpServletResponse = (HttpServletResponse)paramServletResponse;
    HttpSession localHttpSession = localHttpServletRequest.getSession(true);
    config localconfig = new config();
    ChannelInfo localChannelInfo = new ChannelInfo();
    ArrayList localArrayList = new ArrayList();
    String str1 = localconfig.getString("mysqlbase.rootpath");
    String str2 = localHttpSession.getAttribute("SESSION_CUST_ID").toString();
    String str3 = localHttpServletRequest.getRequestURL().substring(str1.length(), localHttpServletRequest.getRequestURL().length());
    String str4 = "";
    if (str2.equals(""))
    {
      localArrayList = localChannelInfo.getChannelBySaveDir(str3);
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        HashMap localHashMap = (HashMap)localArrayList.get(0);
        if (localHashMap.get("right_tag") != null)
          str4 = localHashMap.get("right_tag").toString();
        if (str4.equals("2"))
          localHttpServletResponse.sendRedirect("/member/index.jsp");
      }
    }
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
 * Qualified Name:     com.saas.biz.commen.ChannelRightMgr
 * JD-Core Version:    0.6.0
 */