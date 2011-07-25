package com.ahbay.struts.action;

import com.ahbay.RightMgr.MenuinfoMgr;
import com.ahbay.commenMgr.commMethodMgr;
import com.ahbay.struts.form.MenuinfoForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AddmenuAction extends Action
{
  public ActionForward execute(ActionMapping paramActionMapping, ActionForm paramActionForm, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws Exception
  {
    MenuinfoForm localMenuinfoForm = (MenuinfoForm)paramActionForm;
    MenuinfoMgr localMenuinfoMgr = new MenuinfoMgr();
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str1 = localcommMethodMgr.GenTradeId();
    HttpSession localHttpSession = paramHttpServletRequest.getSession();
    String str2 = (String)localHttpSession.getAttribute("staffId");
    String str3 = paramHttpServletRequest.getParameter("up_menu_id");
    String str4 = paramHttpServletRequest.getParameter("menu_class");
    localMenuinfoMgr.setSubsys_code(localMenuinfoForm.getSubsys_code());
    localMenuinfoMgr.setMenu_id(str1);
    localMenuinfoMgr.setMenu_name(localMenuinfoForm.getMenu_name());
    localMenuinfoMgr.setUp_menu_id(str3);
    localMenuinfoMgr.setMenu_class(str4);
    localMenuinfoMgr.setMenu_type(localMenuinfoForm.getMenu_type());
    localMenuinfoMgr.setModule_id(localMenuinfoForm.getModule_id());
    localMenuinfoMgr.setIn_param_code1(localMenuinfoForm.getIn_param_code1());
    localMenuinfoMgr.setIn_param_value1(localMenuinfoForm.getIn_param_value1());
    localMenuinfoMgr.setIn_param_code2(localMenuinfoForm.getIn_param_code2());
    localMenuinfoMgr.setIn_param_value2(localMenuinfoForm.getIn_param_value2());
    localMenuinfoMgr.setIn_param_code3(localMenuinfoForm.getIn_param_code3());
    localMenuinfoMgr.setIn_param_value3(localMenuinfoForm.getIn_param_value3());
    localMenuinfoMgr.setRemove_tag("0");
    localMenuinfoMgr.setRsrv_str1(localMenuinfoForm.getRsrv_str1());
    localMenuinfoMgr.setRsrv_str2(localMenuinfoForm.getRsrv_str2());
    localMenuinfoMgr.setRsrv_str3(localMenuinfoForm.getRsrv_str3());
    localMenuinfoMgr.setRsrv_str4(localMenuinfoForm.getRsrv_str4());
    localMenuinfoMgr.setRsrv_str5(localMenuinfoForm.getRsrv_str5());
    localMenuinfoMgr.setRsrv_str6(localMenuinfoForm.getRsrv_str6());
    localMenuinfoMgr.setRsrv_str7(localMenuinfoForm.getRsrv_str7());
    localMenuinfoMgr.setRsrv_str8(localMenuinfoForm.getRsrv_str8());
    localMenuinfoMgr.setRsrv_str9(localMenuinfoForm.getRsrv_str9());
    localMenuinfoMgr.setRsrv_str0(localMenuinfoForm.getRsrv_str0());
    localMenuinfoMgr.setIn_staff_id(str2);
    localMenuinfoMgr.setRemark(localMenuinfoForm.getRemark());
    String str5 = localMenuinfoMgr.AddMenuinfo();
    paramHttpServletRequest.setAttribute("result", str5);
    paramHttpServletRequest.setAttribute("class", str4);
    paramHttpServletRequest.setAttribute("menuId", str3);
    paramHttpServletRequest.setAttribute("order", "27");
    return paramActionMapping.findForward("error");
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.struts.action.AddmenuAction
 * JD-Core Version:    0.6.0
 */