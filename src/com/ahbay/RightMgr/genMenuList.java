package com.ahbay.RightMgr;

import java.util.ArrayList;
import org.apache.struts.action.Action;

public class genMenuList extends Action
{
  public String genStaffMenuList(String paramString)
  {
    String str1 = "";
    MenuinfoMgr localMenuinfoMgr1 = new MenuinfoMgr();
    MenuinfoMgr localMenuinfoMgr2 = new MenuinfoMgr();
    ModuleMgr localModuleMgr = new ModuleMgr();
    localMenuinfoMgr1.setRsrv_str0(paramString);
    ArrayList localArrayList1 = localMenuinfoMgr1.GetMenuList("SEL_BY_STAFF_RIGHT_1");
    MenuinfoMgr[] arrayOfMenuinfoMgr1 = localMenuinfoMgr1.GetList(localArrayList1);
    for (int i = 0; i < arrayOfMenuinfoMgr1.length; i++)
    {
      String str2 = arrayOfMenuinfoMgr1[i].getMenu_id();
      String str3 = arrayOfMenuinfoMgr1[i].getMenu_name();
      String str4 = String.valueOf(i);
      str1 = str1 + "<TR>" + "<TD class=buttoncolor onclick=javascript:menu_display(table" + str4 + "); style=cursor:hand>" + "<font color=ffffff>" + str3 + "</font>" + "</TD>" + "</TR>" + "<TBODY id=table" + str4 + " style=display:none;>" + "<TR>" + "<TD align=center class=norightbuttonborder>" + "<table border=0 cellspacing=1 cellpadding=5 width=100%>";
      localMenuinfoMgr2.setRsrv_str0(paramString);
      localMenuinfoMgr2.setUp_menu_id(str2);
      ArrayList localArrayList2 = localMenuinfoMgr2.GetMenuList("SEL_BY_STAFF_RIGHT_UP");
      MenuinfoMgr[] arrayOfMenuinfoMgr2 = localMenuinfoMgr2.GetList(localArrayList2);
      for (int j = 0; j < arrayOfMenuinfoMgr2.length; j++)
      {
        String str5 = arrayOfMenuinfoMgr2[j].getMenu_id();
        String str6 = arrayOfMenuinfoMgr2[j].getMenu_name();
        String str7 = arrayOfMenuinfoMgr2[j].getModule_id();
        String str8 = "";
        if (!arrayOfMenuinfoMgr2[j].getIn_param_code1().equalsIgnoreCase(""))
          str8 = str8 + "?" + arrayOfMenuinfoMgr2[j].getIn_param_code1() + "=" + arrayOfMenuinfoMgr2[j].getIn_param_value1();
        if (!arrayOfMenuinfoMgr2[j].getIn_param_code2().equalsIgnoreCase(""))
          str8 = str8 + "&" + arrayOfMenuinfoMgr2[j].getIn_param_code2() + "=" + arrayOfMenuinfoMgr2[j].getIn_param_value2();
        if (!arrayOfMenuinfoMgr2[j].getIn_param_code3().equalsIgnoreCase(""))
          str8 = str8 + "&" + arrayOfMenuinfoMgr2[j].getIn_param_code3() + "=" + arrayOfMenuinfoMgr2[j].getIn_param_value3();
        localModuleMgr.setModule_id(str7);
        localModuleMgr = localModuleMgr.GetModuleInfo("SEL_BY_ID");
        str1 = str1 + "<tr>" + "<td class=grayD onMouseover=this.className='grayE'; onMouseout=this.className='grayD' align=left>" + "<img src=img/aer1.gif> " + " <a href=" + localModuleMgr.getModule_dir() + "/" + localModuleMgr.getModule_file() + str8 + " target=right>" + str6 + "</a>" + "</td>" + "</tr>";
      }
      str1 = str1 + "</table></TD></TR></TBODY>";
    }
    return str1;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.RightMgr.genMenuList
 * JD-Core Version:    0.6.0
 */