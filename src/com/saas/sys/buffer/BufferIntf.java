package com.saas.sys.buffer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;

public abstract interface BufferIntf
{
  public abstract Buffer convert(HttpServletRequest paramHttpServletRequest, ActionForm paramActionForm, HttpSession paramHttpSession);

  public abstract void setHttpBuffer(Buffer paramBuffer);

  public abstract Buffer getHttpBuffer();

  public abstract void clear();

  public abstract void setString(String paramString1, String paramString2);

  public abstract void setInt(String paramString, int paramInt);

  public abstract String getString(String paramString);

  public abstract int getInt(String paramString);

  public abstract Buffer copyFrom(Buffer paramBuffer);
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.buffer.BufferIntf
 * JD-Core Version:    0.6.0
 */