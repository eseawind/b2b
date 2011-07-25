package com.ahbay.struts.action;

import com.ahbay.UserMgr.StaffMgr;
import com.ahbay.struts.form.StaffinfoForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ModifyuserpwdAction extends Action
{
  public ActionForward execute(ActionMapping paramActionMapping, ActionForm paramActionForm, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws Exception
  {
    StaffinfoForm localStaffinfoForm = (StaffinfoForm)paramActionForm;
    StaffMgr localStaffMgr = new StaffMgr();
    HttpSession localHttpSession = paramHttpServletRequest.getSession();
    String str = (String)localHttpSession.getAttribute("staffId");
    localStaffMgr.setStaff_id(str);
    localStaffMgr = localStaffMgr.GetUserInfo("SEL_BY_ID");
    if (!localStaffMgr.getPasswd().equalsIgnoreCase(localStaffinfoForm.getRsvalue1()))
    {
      paramHttpServletRequest.setAttribute("result", "0" + localStaffMgr.getPasswd() + "|" + localStaffinfoForm.getRsvalue1());
      paramHttpServletRequest.setAttribute("order", "22");
    }
    else
    {
      localStaffMgr.setPasswd(localStaffinfoForm.getPasswd());
      localStaffMgr.ModifyPwd();
      paramHttpServletRequest.setAttribute("result", "1");
      paramHttpServletRequest.setAttribute("order", "22");
    }
    return paramActionMapping.findForward("error");
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.struts.action.ModifyuserpwdAction
 * JD-Core Version:    0.6.0
 */