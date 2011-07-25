package com.ahbay.struts.action;

import com.ahbay.RightMgr.MenuinfoMgr;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DelmenuAction extends Action
{
  public ActionForward execute(ActionMapping paramActionMapping, ActionForm paramActionForm, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws Exception
  {
    MenuinfoMgr localMenuinfoMgr = new MenuinfoMgr();
    String str1 = paramHttpServletRequest.getParameter("menuId");
    String str2 = paramHttpServletRequest.getParameter("upMenuId");
    String str3 = paramHttpServletRequest.getParameter("class");
    localMenuinfoMgr.setMenu_id(str1);
    String str4 = localMenuinfoMgr.DelMenu();
    paramHttpServletRequest.setAttribute("result", str4);
    paramHttpServletRequest.setAttribute("class", str3);
    paramHttpServletRequest.setAttribute("menuId", str2);
    paramHttpServletRequest.setAttribute("order", "27");
    return paramActionMapping.findForward("error");
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.struts.action.DelmenuAction
 * JD-Core Version:    0.6.0
 */