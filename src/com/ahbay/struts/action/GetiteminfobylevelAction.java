package com.ahbay.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class GetiteminfobylevelAction extends Action
{
  public ActionForward execute(ActionMapping paramActionMapping, ActionForm paramActionForm, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
  {
    String str1 = paramHttpServletRequest.getParameter("ThisItemLevel");
    String str2 = paramHttpServletRequest.getParameter("ThisItemId");
    String str3 = paramHttpServletRequest.getParameter("ThisItemName");
    String str4 = paramHttpServletRequest.getParameter("StaffId");
    String str5 = paramHttpServletRequest.getParameter("Modify_Tag");
    String str6 = "";
    if (str5.equalsIgnoreCase("0"))
    {
      paramHttpServletRequest.setAttribute("ThisItemId", str2);
      paramHttpServletRequest.setAttribute("StaffId", str4);
      paramHttpServletRequest.setAttribute("ThisItemLevel", str1);
      paramHttpServletRequest.setAttribute("ThisItemName", str3);
      str6 = "list";
    }
    if (str5.equalsIgnoreCase("1"))
    {
      paramHttpServletRequest.setAttribute("ThisItemId", str2);
      paramHttpServletRequest.setAttribute("StaffId", str4);
      paramHttpServletRequest.setAttribute("ThisItemLevel", str1);
      paramHttpServletRequest.setAttribute("ThisItemName", str3);
      str6 = "list_modify";
    }
    if (str5.equalsIgnoreCase("2"))
    {
      paramHttpServletRequest.setAttribute("ThisItemId", str2);
      paramHttpServletRequest.setAttribute("StaffId", str4);
      paramHttpServletRequest.setAttribute("ThisItemLevel", str1);
      paramHttpServletRequest.setAttribute("ThisItemName", str3);
      str6 = "oldItemInfo";
    }
    if (str5.equalsIgnoreCase("3"))
    {
      paramHttpServletRequest.setAttribute("ThisItemId", str2);
      paramHttpServletRequest.setAttribute("StaffId", str4);
      paramHttpServletRequest.setAttribute("ThisItemLevel", str1);
      paramHttpServletRequest.setAttribute("ThisItemName", str3);
      str6 = "oldItemInfo";
    }
    if (str5.equalsIgnoreCase("4"))
    {
      paramHttpServletRequest.setAttribute("ThisItemId", str2);
      paramHttpServletRequest.setAttribute("StaffId", str4);
      paramHttpServletRequest.setAttribute("ThisItemLevel", str1);
      paramHttpServletRequest.setAttribute("ThisItemName", str3);
      str6 = "issue";
    }
    if (str5.equalsIgnoreCase("5"))
    {
      paramHttpServletRequest.setAttribute("ThisItemId", str2);
      paramHttpServletRequest.setAttribute("StaffId", str4);
      paramHttpServletRequest.setAttribute("ThisItemLevel", str1);
      paramHttpServletRequest.setAttribute("ThisItemName", str3);
      str6 = "modifyissue";
    }
    if (str5.equalsIgnoreCase("6"))
    {
      paramHttpServletRequest.setAttribute("ThisItemId", str2);
      paramHttpServletRequest.setAttribute("StaffId", str4);
      paramHttpServletRequest.setAttribute("ThisItemLevel", str1);
      paramHttpServletRequest.setAttribute("ThisItemName", str3);
      str6 = "copinfo";
    }
    if (str5.equalsIgnoreCase("7"))
    {
      paramHttpServletRequest.setAttribute("ThisItemId", str2);
      paramHttpServletRequest.setAttribute("StaffId", str4);
      paramHttpServletRequest.setAttribute("ThisItemLevel", str1);
      paramHttpServletRequest.setAttribute("ThisItemName", str3);
      str6 = "addcopinfo";
    }
    return paramActionMapping.findForward(str6);
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.struts.action.GetiteminfobylevelAction
 * JD-Core Version:    0.6.0
 */