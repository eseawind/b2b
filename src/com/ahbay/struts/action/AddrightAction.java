package com.ahbay.struts.action;

import com.ahbay.RightMgr.RightinfoMgr;
import com.ahbay.struts.form.RightinfoForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AddrightAction extends Action
{
  public ActionForward execute(ActionMapping paramActionMapping, ActionForm paramActionForm, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws Exception
  {
    RightinfoForm localRightinfoForm = (RightinfoForm)paramActionForm;
    RightinfoMgr localRightinfoMgr = new RightinfoMgr();
    HttpSession localHttpSession = paramHttpServletRequest.getSession();
    String str1 = (String)localHttpSession.getAttribute("staffId");
    String str2 = paramHttpServletRequest.getParameter("staff_id");
    localRightinfoMgr.setStaff_id(str2);
    localRightinfoMgr.setMenu_id(localRightinfoForm.getMenu_id());
    localRightinfoMgr.setStart_date(localRightinfoForm.getStart_date());
    localRightinfoMgr.setEnd_date(localRightinfoForm.getEnd_date());
    localRightinfoMgr.setRight_attr(localRightinfoForm.getRight_attr());
    localRightinfoMgr.setRsrv_str1(localRightinfoForm.getRsrv_str1());
    localRightinfoMgr.setRsrv_str2(localRightinfoForm.getRsrv_str2());
    localRightinfoMgr.setRsrv_str3(localRightinfoForm.getRsrv_str3());
    localRightinfoMgr.setRsrv_str4(localRightinfoForm.getRsrv_str4());
    localRightinfoMgr.setRsrv_str5(localRightinfoForm.getRsrv_str5());
    localRightinfoMgr.setRsrv_str6(localRightinfoForm.getRsrv_str6());
    localRightinfoMgr.setRsrv_str7(localRightinfoForm.getRsrv_str7());
    localRightinfoMgr.setRsrv_str8(localRightinfoForm.getRsrv_str8());
    localRightinfoMgr.setRsrv_str9(localRightinfoForm.getRsrv_str9());
    localRightinfoMgr.setRsrv_str0(localRightinfoForm.getRsrv_str0());
    localRightinfoMgr.setIn_staff_id(str1);
    localRightinfoMgr.setRemark(localRightinfoForm.getRemark());
    String str3 = localRightinfoMgr.AddRightInfo();
    paramHttpServletRequest.setAttribute("result", str3);
    paramHttpServletRequest.setAttribute("rightStaffId", str2);
    paramHttpServletRequest.setAttribute("order", "28");
    return paramActionMapping.findForward("error");
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.struts.action.AddrightAction
 * JD-Core Version:    0.6.0
 */