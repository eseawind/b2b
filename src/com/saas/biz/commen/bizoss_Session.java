package com.saas.biz.commen;

import com.saas.sys.log.Logger;
import java.io.Serializable;
import javax.servlet.http.HttpSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

public class bizoss_Session
  implements Serializable
{
  Logger log = new Logger(this);
  private static final long serialVersionUID = -1787364793228041847L;
  private String session_user_id;
  private String session_cust_id;
  private String session_user_name;
  private String session_cust_class;
  private String depart_code;

  public bizoss_Session getbizoss_Session()
  {
    this.log.LOG_INFO("===getSession begin....");
    bizoss_Session localbizoss_Session = new bizoss_Session();
    try
    {
      WebContext localWebContext = WebContextFactory.get();
      HttpSession localHttpSession = localWebContext.getSession();
      if (localHttpSession.getAttribute("DEPART") != null)
        localbizoss_Session.setDepart_code((String)localHttpSession.getAttribute("DEPART_CODE"));
      if (localHttpSession.getAttribute("SESSION_USER_ID") != null)
        localbizoss_Session.setSession_user_id((String)localHttpSession.getAttribute("SESSION_USER_ID"));
      if (localHttpSession.getAttribute("SESSION_CUST_ID") != null)
        localbizoss_Session.setSession_cust_id((String)localHttpSession.getAttribute("SESSION_CUST_ID"));
      if (localHttpSession.getAttribute("SESSION_CUST_CLASS") != null)
        localbizoss_Session.setSession_cust_class((String)localHttpSession.getAttribute("SESSION_CUST_CLASS"));
      if (localHttpSession.getAttribute("SESSION_USER_NAME") != null)
        localbizoss_Session.setSession_user_name((String)localHttpSession.getAttribute("SESSION_USER_NAME"));
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO("session 出错==" + localException.getMessage());
    }
    return localbizoss_Session;
  }

  public String getDepart_code()
  {
    return this.depart_code;
  }

  public void setDepart_code(String paramString)
  {
    this.depart_code = paramString;
  }

  public String getSession_cust_class()
  {
    return this.session_cust_class;
  }

  public void setSession_cust_class(String paramString)
  {
    this.session_cust_class = paramString;
  }

  public String getSession_cust_id()
  {
    return this.session_cust_id;
  }

  public void setSession_cust_id(String paramString)
  {
    this.session_cust_id = paramString;
  }

  public String getSession_user_id()
  {
    return this.session_user_id;
  }

  public void setSession_user_id(String paramString)
  {
    this.session_user_id = paramString;
  }

  public String getSession_user_name()
  {
    return this.session_user_name;
  }

  public void setSession_user_name(String paramString)
  {
    this.session_user_name = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.bizoss_Session
 * JD-Core Version:    0.6.0
 */