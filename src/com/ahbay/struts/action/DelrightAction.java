package com.ahbay.struts.action;

import com.ahbay.RightMgr.RightinfoMgr;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DelrightAction extends Action
{
  public ActionForward execute(ActionMapping paramActionMapping, ActionForm paramActionForm, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws Exception
  {
    RightinfoMgr localRightinfoMgr = new RightinfoMgr();
    String str1 = paramHttpServletRequest.getParameter("menuId");
    String str2 = paramHttpServletRequest.getParameter("staffId");
    localRightinfoMgr.setMenu_id(str1);
    localRightinfoMgr.setStaff_id(str2);
    String str3 = localRightinfoMgr.EndUserRight();
    paramHttpServletRequest.setAttribute("result", str3);
    paramHttpServletRequest.setAttribute("rightStaffId", str2);
    paramHttpServletRequest.setAttribute("order", "28");
    return paramActionMapping.findForward("error");
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.struts.action.DelrightAction
 * JD-Core Version:    0.6.0
 */