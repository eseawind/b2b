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

public class AddstaffAction extends Action
{
  public ActionForward execute(ActionMapping paramActionMapping, ActionForm paramActionForm, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws Exception
  {
    StaffinfoForm localStaffinfoForm = (StaffinfoForm)paramActionForm;
    StaffMgr localStaffMgr = new StaffMgr();
    HttpSession localHttpSession = paramHttpServletRequest.getSession();
    String str1 = (String)localHttpSession.getAttribute("staffId");
    localStaffMgr.setStaff_id(localStaffinfoForm.getStaff_id());
    localStaffMgr.setDepart_id(localStaffinfoForm.getDepart_id());
    localStaffMgr.setStaff_name(localStaffinfoForm.getStaff_name());
    localStaffMgr.setPasswd(localStaffinfoForm.getPasswd());
    localStaffMgr.setJob_info(localStaffinfoForm.getJob_info());
    localStaffMgr.setManager_info(localStaffinfoForm.getManager_info());
    localStaffMgr.setSex(localStaffinfoForm.getSex());
    localStaffMgr.setEmail(localStaffinfoForm.getEmail());
    localStaffMgr.setUser_pid(localStaffinfoForm.getUser_pid());
    localStaffMgr.setSerial_number(localStaffinfoForm.getSerial_number());
    localStaffMgr.setCust_id(localStaffinfoForm.getCust_id());
    localStaffMgr.setDimission_tag("0");
    localStaffMgr.setBirthday(localStaffinfoForm.getBirthday());
    localStaffMgr.setStaff_group_id(localStaffinfoForm.getStaff_group_id());
    localStaffMgr.setCust_hobyy(localStaffinfoForm.getCust_hobyy());
    localStaffMgr.setRemark(localStaffinfoForm.getRemark());
    localStaffMgr.setRsvalue1(localStaffinfoForm.getRsvalue1());
    localStaffMgr.setRsvalue2(localStaffinfoForm.getRsvalue2());
    localStaffMgr.setUpdate_time(localStaffinfoForm.getUpdate_time());
    localStaffMgr.setUpdate_staff_id(str1);
    localStaffMgr.setUpdate_depart_id(localStaffinfoForm.getUpdate_depart_id());
    String str2 = localStaffMgr.AddStaff();
    paramHttpServletRequest.setAttribute("result", str2);
    paramHttpServletRequest.setAttribute("order", "26");
    return paramActionMapping.findForward("error");
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.struts.action.AddstaffAction
 * JD-Core Version:    0.6.0
 */