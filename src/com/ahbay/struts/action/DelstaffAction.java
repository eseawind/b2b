package com.ahbay.struts.action;

import com.ahbay.UserMgr.StaffMgr;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DelstaffAction extends Action
{
  public ActionForward execute(ActionMapping paramActionMapping, ActionForm paramActionForm, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws Exception
  {
    StaffMgr localStaffMgr = new StaffMgr();
    String str1 = paramHttpServletRequest.getParameter("staffId");
    localStaffMgr.setStaff_id(str1);
    String str2 = localStaffMgr.DelStaff();
    paramHttpServletRequest.setAttribute("result", str2);
    paramHttpServletRequest.setAttribute("order", "26");
    return paramActionMapping.findForward("error");
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.struts.action.DelstaffAction
 * JD-Core Version:    0.6.0
 */