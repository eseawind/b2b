package com.saas.biz.rightMgr;

import com.saas.biz.JavaScriptObject.TreeNode;
import com.saas.biz.JavaScriptObject.TreeObject;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.commenDAO.CommparaExt;
import com.saas.biz.dao.rightsDAO.MenuinfoDAO;
import com.saas.biz.dao.rightsDAO.MenuinfoExt;
import com.saas.biz.dao.rightsDAO.RightinfoExt;
import com.saas.biz.dao.rolerightDAO.RoleRightExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONArray;

public class RightMenu
{
  Logger log = new Logger(this);
  ArrayList queryResult = new ArrayList();
  Dbtable tradeQuery = new Dbtable();
  Buffers inBuffer;
  Buffers outBuffer = new Buffers();
  commMethodMgr commen = new commMethodMgr();

  public ArrayList getQueryResult()
  {
    return this.queryResult;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public void setOutBuffer(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }

  public void setTradeQuery(Dbtable paramDbtable)
  {
    this.tradeQuery = paramDbtable;
  }

  public Dbtable getTradeQuery()
  {
    return this.tradeQuery;
  }

  public void genSuperRightMenuList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genSuperRightMenuList方法...");
    String str1 = paramBuffers.getString("SESSION_USER_NAME");
    String str2 = paramBuffers.getString("SESSION_CUST_CLASS");
    String str3 = paramBuffers.getString("MENU_CLASS");
    String str4 = paramBuffers.getString("SUBSYS_CODE");
    String str5 = paramBuffers.getString("SESSION_USER_ID");
    String str6 = "";
    if (paramBuffers.getString("SESSION_ROLE_CODE") != "")
      str6 = paramBuffers.getString("SESSION_ROLE_CODE");
    String str7 = paramBuffers.getString("SESSION_USER_TYPE");
    try
    {
      this.queryResult = genSuperRightMenuList(str5, str1, str3, str2, str4, str7, str6);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genRightMenuList方法...");
  }

  public ArrayList genSuperRightMenuList(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
    throws SaasApplicationException
  {
    if (paramString1 == null)
      throw new SaasApplicationException("登陆用户名为空，无法获取权限菜单！");
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VSTAFF_ID", paramString1);
    localMenuinfoExt.setParam(":VSTAFFID", paramString2);
    localMenuinfoExt.setParam(":VUSER_CLASS", paramString4);
    localMenuinfoExt.setParam(":VRIGHT_TYPE", "0");
    localMenuinfoExt.setParam(":VCLASS", paramString3);
    localMenuinfoExt.setParam(":VROLE_CODE", paramString7);
    localMenuinfoExt.setParam(":VUSER_TYPE", paramString6);
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString5);
    localArrayList = localMenuinfoExt.selByList("SEL_BY_CLASS_SYS");
    return localArrayList;
  }

  public ArrayList<MenuInfo> getLeftMenuList(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = genSuperRightMenuList(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    ArrayList localArrayList2 = new ArrayList();
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList1.get(i);
        MenuInfo localMenuInfo = new MenuInfo();
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (localHashMap.get("menu_id") != null)
          str1 = localHashMap.get("menu_id").toString();
        if (localHashMap.get("menu_name") != null)
          str2 = localHashMap.get("menu_name").toString();
        if (localHashMap.get("subsys_code") != null)
          str3 = localHashMap.get("subsys_code").toString();
        if (localHashMap.get("menu_class") != null)
          str4 = localHashMap.get("menu_class").toString();
        if (localHashMap.get("up_menu_id") != null)
          str5 = localHashMap.get("up_menu_id").toString();
        if (localHashMap.get("rsrv_str4") != null)
          str6 = localHashMap.get("rsrv_str4").toString();
        localMenuInfo.setMenu_class(str4);
        localMenuInfo.setMenu_desc(str6);
        localMenuInfo.setMenu_id(str1);
        localMenuInfo.setMenu_name(str2);
        localMenuInfo.setSubsys_code(str3);
        localMenuInfo.setUp_menu_id(str5);
        ArrayList localArrayList3 = getSecendMenuList(paramString2, paramString3, str1, paramString4, paramString7, paramString6);
        localMenuInfo.setChildren(localArrayList3);
        localArrayList2.add(localMenuInfo);
      }
    return localArrayList2;
  }

  public ArrayList getSpecMenuIdInfo(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VUP_MENU_ID", paramString1);
    localMenuinfoExt.setParam(":VMENU_ID", paramString2);
    ArrayList localArrayList = localMenuinfoExt.selByList("SEL_SPEC_MENU_ID");
    return localArrayList;
  }

  public Map getAreaByParentById(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VUP_MENU_ID", paramString);
    ArrayList localArrayList = localMenuinfoExt.selByList("SEL_BY_UP_MENU_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str1 = "";
        String str2 = "";
        if (localHashMap2.get("menu_id") != null)
          str1 = localHashMap2.get("menu_id").toString();
        if (localHashMap2.get("menu_name") != null)
          str2 = localHashMap2.get("menu_name").toString();
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public Map getAreaByParent(String paramString)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString);
    ArrayList localArrayList = localMenuinfoExt.selByList("SEL_BY_SUBSYSCODE");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str1 = "";
        String str2 = "";
        if (localHashMap2.get("menu_id") != null)
          str1 = localHashMap2.get("menu_id").toString();
        if (localHashMap2.get("menu_name") != null)
          str2 = localHashMap2.get("menu_name").toString();
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public ArrayList getMenuInfoByUpMenuId(String paramString)
    throws SaasApplicationException
  {
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VUP_MENU_ID", paramString);
    ArrayList localArrayList = localMenuinfoExt.selByList("SEL_BY_UP_MENU_ID");
    return localArrayList;
  }

  public ArrayList<MenuInfo> getSecendMenuList(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = genchildRightMenuList(paramString1, "2", paramString3, paramString4, paramString5, paramString6);
    ArrayList localArrayList2 = new ArrayList();
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList1.get(i);
        MenuInfo localMenuInfo = new MenuInfo();
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        ArrayList localArrayList3 = new ArrayList();
        if (localHashMap.get("menu_id") != null)
          str1 = localHashMap.get("menu_id").toString();
        if (localHashMap.get("menu_name") != null)
          str2 = localHashMap.get("menu_name").toString();
        if (localHashMap.get("subsys_code") != null)
          str3 = localHashMap.get("subsys_code").toString();
        if (localHashMap.get("menu_class") != null)
          str4 = localHashMap.get("menu_class").toString();
        if (localHashMap.get("up_menu_id") != null)
          str5 = localHashMap.get("up_menu_id").toString();
        if (localHashMap.get("rsrv_str4") != null)
          str6 = localHashMap.get("rsrv_str4").toString();
        localMenuInfo.setMenu_class(str4);
        localMenuInfo.setMenu_desc(str6);
        localMenuInfo.setMenu_id(str1);
        localMenuInfo.setMenu_name(str2);
        localMenuInfo.setSubsys_code(str3);
        localMenuInfo.setUp_menu_id(str5);
        localMenuInfo.setChildren(localArrayList3);
        localArrayList2.add(localMenuInfo);
      }
    return localArrayList2;
  }

  public void genchildRightMenuList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genchildRightMenuList方法...");
    String str1 = paramBuffers.getString("SESSION_USER_NAME");
    String str2 = paramBuffers.getString("MENU_CLASS");
    String str3 = paramBuffers.getString("UP_MENU_ID");
    String str4 = paramBuffers.getString("SESSION_CUST_CLASS");
    String str5 = "";
    if (paramBuffers.getString("SESSION_ROLE_CODE") != "")
      str5 = paramBuffers.getString("SESSION_ROLE_CODE");
    String str6 = paramBuffers.getString("SESSION_USER_TYPE");
    try
    {
      this.queryResult = genchildRightMenuList(str1, str2, str3, str4, str5, str6);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genchildRightMenuList方法...");
  }

  public ArrayList genchildRightMenuList(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws SaasApplicationException
  {
    if (paramString1 == null)
      throw new SaasApplicationException("登陆用户名为空，无法获取权限菜单！");
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VCUST_CLASS", paramString4);
    localMenuinfoExt.setParam(":VSTAFF_ID", paramString1);
    localMenuinfoExt.setParam(":VSTAFFID", paramString1);
    localMenuinfoExt.setParam(":VCLASS", paramString2);
    localMenuinfoExt.setParam(":VROLE_CODE", paramString5);
    localMenuinfoExt.setParam(":VUSER_TYPE", paramString6);
    localMenuinfoExt.setParam(":VUP_ITEM_ID", paramString3);
    localArrayList = localMenuinfoExt.selByList("SEL_BY_CLASS_STAFF_UP");
    return localArrayList;
  }

  public void genRightMenuOneList(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入genchildRightMenuList方法...");
    try
    {
      this.queryResult = genRightMenuOneList();
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出genchildRightMenuList方法...");
  }

  public ArrayList genRightMenuOneList()
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VMENU_CLASS", "1");
    localArrayList = localMenuinfoExt.selByList("SEL_BY_CLASSONE");
    return localArrayList;
  }

  public ArrayList genMenuRight(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VMENU_CLASS", "1");
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString1);
    localArrayList = localMenuinfoExt.selByList("SEL_BY_CLASSONE");
    return localArrayList;
  }

  public ArrayList getMenuInfo(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VMENU_ID", paramString);
    localArrayList = localMenuinfoExt.selByList("SEL_BY_PK");
    return localArrayList;
  }

  public ArrayList getMenuRight(int paramInt, String paramString1, String paramString2)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 9;
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VMENU_CLASS", paramString2);
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString1);
    localArrayList = localMenuinfoExt.selByList("SEL_BY_MENU_CLASS", paramInt, 200);
    return localArrayList;
  }

  public int getMenuRight(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VMENU_CLASS", paramString2);
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString1);
    localArrayList = localMenuinfoExt.selByList("SEL_BY_MENU_CLASS");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getMenuRightByUpMenuId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VMENU_ID", paramString2);
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString1);
    localArrayList = localMenuinfoExt.selByList("SEL_BY_UP_JSON");
    return localArrayList;
  }

  public ArrayList getDownMenuRight(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 9;
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VUP_MENU_ID", paramString);
    localArrayList = localMenuinfoExt.selByList("SEL_BY_UP_MENU_ID", paramInt, 9);
    return localArrayList;
  }

  public int getDownMenuRight(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VUP_MENU_ID", paramString);
    localArrayList = localMenuinfoExt.selByList("SEL_BY_UP_MENU_ID");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public ArrayList getDownMenu(int paramInt, String paramString)
    throws SaasApplicationException
  {
    if (paramInt == 0)
      paramInt = 0;
    else
      paramInt = (paramInt - 1) * 9;
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VUP_MENU_ID", paramString);
    localArrayList = localMenuinfoExt.selByList("SEL_THREE_BY_UP", paramInt, 9);
    return localArrayList;
  }

  public int getDownMenu(String paramString)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VUP_MENU_ID", paramString);
    localArrayList = localMenuinfoExt.selByList("SEL_THREE_BY_UP");
    if (localArrayList != null)
      return localArrayList.size();
    return 0;
  }

  public String getMenuClassLevel(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VMENU_ID", paramString);
    localArrayList = localMenuinfoExt.selByList("SEL_CLASS_BY_MENU_ID");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("menu_class") != null)
        str = localHashMap.get("menu_class").toString();
    }
    return str;
  }

  public ArrayList genDownMenu(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VUP_MENU_ID", paramString2);
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString1);
    localArrayList = localMenuinfoExt.selByList("SEL_BY_DOWN");
    return localArrayList;
  }

  public String getfirstMenuId(String paramString)
    throws SaasApplicationException
  {
    MenuinfoDAO localMenuinfoDAO1 = new MenuinfoDAO();
    MenuinfoExt localMenuinfoExt1 = new MenuinfoExt();
    MenuinfoDAO localMenuinfoDAO2 = new MenuinfoDAO();
    MenuinfoExt localMenuinfoExt2 = new MenuinfoExt();
    MenuinfoDAO localMenuinfoDAO3 = new MenuinfoDAO();
    MenuinfoExt localMenuinfoExt3 = new MenuinfoExt();
    Object localObject = "";
    String str1 = "";
    String str2 = "";
    String str3 = "";
    localMenuinfoExt1.setParam(":VMENU_ID", paramString);
    localMenuinfoDAO1 = localMenuinfoExt1.selByInfo("SEL_BY_PK");
    if (localMenuinfoDAO1 != null)
    {
      str2 = localMenuinfoDAO1.getMenu_class();
      str3 = localMenuinfoDAO1.getUp_menu_id();
      if (str2.equals("2"))
      {
        localObject = str3;
      }
      else if (str2.equals("3"))
      {
        localMenuinfoExt2.setParam(":VMENU_ID", localMenuinfoDAO1.getMenu_id());
        localMenuinfoDAO2 = localMenuinfoExt2.selByInfo("SEL_BY_PK");
        if (localMenuinfoDAO2 != null)
        {
          localMenuinfoExt3.setParam(":VMENU_ID", localMenuinfoDAO2.getUp_menu_id());
          localMenuinfoDAO3 = localMenuinfoExt3.selByInfo("SEL_BY_PK");
          if (localMenuinfoDAO3 != null)
            localObject = localMenuinfoDAO3.getUp_menu_id();
        }
      }
    }
    return (String)localObject;
  }

  public String getMenuNameById(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = getMenuInfo(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("menu_name") != null)
        str = localHashMap.get("menu_name").toString();
    }
    return str;
  }

  public String getSeviceNameById(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = getMenuInfo(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("subsys_code") != null)
        str = localHashMap.get("subsys_code").toString();
    }
    return str;
  }

  public ArrayList genSysServ(String paramString)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    ArrayList localArrayList = new ArrayList();
    localCommparaExt.setParam(":VSUBSYS_CODE", paramString);
    localCommparaExt.setParam(":VPARAM_ATTR", "41");
    localArrayList = localCommparaExt.selByList("SEL_BY_ATTR");
    return localArrayList;
  }

  public ArrayList genSysServ()
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    ArrayList localArrayList = new ArrayList();
    localCommparaExt.setParam(":VSUBSYS_CODE", "SYS");
    localCommparaExt.setParam(":VPARAM_ATTR", "41");
    localArrayList = localCommparaExt.selByList("SEL_BY_ATTR");
    return localArrayList;
  }

  public ArrayList genSysServByCust(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    ArrayList localArrayList = new ArrayList();
    localCommparaExt.setParam(":VSUBSYS_CODE", "SYS");
    localCommparaExt.setParam(":VCUST_ID", paramString1);
    localCommparaExt.setParam(":VADMIN", paramString2);
    localCommparaExt.setParam(":VPARAM_ATTR", "41");
    localArrayList = localCommparaExt.selByList("SEL_BY_ATTR_CUST");
    return localArrayList;
  }

  public ArrayList genSysServByCust2(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    CommparaExt localCommparaExt = new CommparaExt();
    ArrayList localArrayList = new ArrayList();
    localCommparaExt.setParam(":VSUBSYS_CODE", "SYS");
    localCommparaExt.setParam(":VCUST_ID", paramString1);
    localCommparaExt.setParam(":VADMIN", paramString2);
    localCommparaExt.setParam(":VPARAM_ATTR", "41");
    localArrayList = localCommparaExt.selByList("SEL_BY_ATTR_CUST_TWO");
    return localArrayList;
  }

  public HashMap getMenuByCodeAndClass(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = getRoleRightInfoByRole(paramString4, paramString3);
    HashMap localHashMap1 = new HashMap();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString1);
    localMenuinfoExt.setParam(":VMENU_CLASS", paramString2);
    localArrayList1 = localMenuinfoExt.selByList("SEL_BY_CLASSONE");
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList1.get(i);
        if ((localHashMap2.get("rsrv_str1") != null) && (localHashMap2.get("rsrv_str1").equals("sys")))
          continue;
        String str1 = localHashMap2.get("menu_id").toString();
        String str2 = localHashMap2.get("menu_name").toString();
        if (localArrayList2.contains(str1))
          str2 = str2 + "[已分配]";
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public HashMap getMenuByUpmenId(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList2 = getRoleRightInfoByRole(paramString3, paramString4);
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString1);
    localMenuinfoExt.setParam(":VUP_MENU_ID", paramString2);
    localArrayList1 = localMenuinfoExt.selByList("SEL_BY_DOWN");
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList1.get(i);
        String str1 = localHashMap2.get("menu_id").toString();
        String str2 = localHashMap2.get("menu_name").toString();
        if (localArrayList2.contains(str1))
          str2 = str2 + "[已分配]";
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public ArrayList getRoleRightInfoByRole(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    RoleRightExt localRoleRightExt = new RoleRightExt();
    localRoleRightExt.setParam(":VCUST_ID", paramString1);
    localRoleRightExt.setParam(":VROLE_CODE", paramString2);
    localArrayList1 = localRoleRightExt.selByList("SEL_BY_ROLE");
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList1.get(i);
        String str = localHashMap.get("menu_id").toString();
        localArrayList2.add(str);
      }
    return localArrayList2;
  }

  public HashMap getRoleByCodeAndClass(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = getRoleRightInfoByRole(paramString4, paramString3);
    HashMap localHashMap1 = new HashMap();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString1);
    localMenuinfoExt.setParam(":VMENU_CLASS", paramString2);
    localArrayList1 = localMenuinfoExt.selByList("SEL_BY_CLASSONE");
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList1.get(i);
        if ((localHashMap2.get("rsrv_str1") != null) && (localHashMap2.get("rsrv_str1").equals("sys")))
          continue;
        String str1 = localHashMap2.get("menu_id").toString();
        String str2 = localHashMap2.get("menu_name").toString();
        if (!localArrayList2.contains(str1))
          continue;
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public HashMap getRoleByUpmenId(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    ArrayList localArrayList1 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList2 = getRoleRightInfoByRole(paramString3, paramString4);
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString1);
    localMenuinfoExt.setParam(":VUP_MENU_ID", paramString2);
    localArrayList1 = localMenuinfoExt.selByList("SEL_BY_DOWN");
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      for (int i = 0; i < localArrayList1.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList1.get(i);
        String str1 = localHashMap2.get("menu_id").toString();
        String str2 = localHashMap2.get("menu_name").toString();
        if (!localArrayList2.contains(str1))
          continue;
        localHashMap1.put(str1, str2);
      }
    return localHashMap1;
  }

  public String getMenupath(String paramString)
    throws SaasApplicationException
  {
    String str1 = "";
    String str2 = "";
    ArrayList localArrayList = getMenuInfo(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("up_menu_id") != null)
        str2 = localHashMap.get("up_menu_id").toString();
      if (localHashMap.get("menu_name") != null)
        str1 = getMenupath(str2) + "&nbsp;&gt;&nbsp;" + localHashMap.get("menu_name").toString();
    }
    return str1;
  }

  public ArrayList getMeunByClass(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString1);
    localMenuinfoExt.setParam(":VCUST_CLASS", paramString2);
    localMenuinfoExt.setParam(":VMENU_CLASS", paramString3);
    if (paramBoolean)
      localArrayList = localMenuinfoExt.selByList("SEL_BY_IN_CLASS");
    else
      localArrayList = localMenuinfoExt.selByList("SEL_BY_NOT_CLASS");
    this.log.LOG_INFO(paramBoolean + "结束getMeunByClass=>>>list==");
    return localArrayList;
  }

  public ArrayList getRightMenByUpMenu(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList(0);
    RightinfoExt localRightinfoExt = new RightinfoExt();
    localRightinfoExt.setParam(":VCUST_CLASS", paramString1);
    localRightinfoExt.setParam(":VMENU_CLASS", paramString2);
    localRightinfoExt.setParam(":VUP_MENU_ID", paramString3);
    if (paramBoolean)
      localArrayList = localRightinfoExt.selByList("SEL_BY_CLASSDOWN");
    else
      localArrayList = localRightinfoExt.selByList("SEL_BY_NOT_CLASSDOWN");
    this.log.LOG_INFO(paramBoolean + "结束getRightMenByUpMenu=>>>up_menu_id=" + paramString3 + "==========");
    return localArrayList;
  }

  public HashMap getRefundMenuMap(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList = getMeunByClass(paramString2, paramString1, "1", true);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        TreeObject localTreeObject = new TreeObject();
        String str1 = localHashMap2.get("menu_name").toString();
        String str2 = localHashMap2.get("menu_id").toString();
        localHashMap1.put(str2, str1);
      }
    this.log.LOG_INFO("结束getRefundMenuJson=>>>");
    return localHashMap1;
  }

  public HashMap getMapMenByUpMenu(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList = new ArrayList(0);
    RightinfoExt localRightinfoExt = new RightinfoExt();
    localRightinfoExt.setParam(":VCUST_CLASS", paramString1);
    localRightinfoExt.setParam(":VMENU_CLASS", paramString2);
    localRightinfoExt.setParam(":VUP_MENU_ID", paramString3);
    if (paramBoolean)
      localArrayList = localRightinfoExt.selByList("SEL_BY_CLASSDOWN");
    else
      localArrayList = localRightinfoExt.selByList("SEL_BY_NOT_CLASSDOWN");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        TreeObject localTreeObject = new TreeObject();
        String str1 = localHashMap2.get("menu_name").toString();
        String str2 = localHashMap2.get("menu_id").toString();
        localHashMap1.put(str2, str1);
      }
    return localHashMap1;
  }

  public JSONArray getChildrenNodes(String paramString1, String paramString2, ArrayList paramArrayList)
    throws SaasApplicationException
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
      for (int i = 0; i < paramArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)paramArrayList.get(i);
        TreeObject localTreeObject = new TreeObject();
        String str1 = localHashMap.get("menu_name").toString();
        String str2 = localHashMap.get("menu_id").toString();
        localTreeObject.setId(str2);
        localTreeObject.setText(str1);
        TreeNode localTreeNode = isRefundLeaf(paramString1, paramString2, str2);
        localTreeObject.setChildren(localTreeNode.getChildren());
        localTreeObject.setLeaf(localTreeNode.isLeaf());
        localJSONArray.add(localTreeObject);
      }
    this.log.LOG_INFO("结束getChildrenNodes=>>>");
    return localJSONArray;
  }

  public TreeNode isRefundLeaf(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    int i = Integer.parseInt(paramString2);
    paramString2 = String.valueOf(i + 1);
    ArrayList localArrayList = getRightMenByUpMenu(paramString1, paramString2, paramString3, true);
    TreeNode localTreeNode = new TreeNode();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localTreeNode.setLeaf(false);
      JSONArray localJSONArray = getChildrenNodes(paramString1, paramString2, localArrayList);
      localTreeNode.setChildren(localJSONArray);
    }
    this.log.LOG_INFO("结束isRefundLeaf=>>>");
    return localTreeNode;
  }

  public HashMap getMenuForSend(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList = getMeunByClass(paramString2, paramString1, "1", false);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap2 = (HashMap)localArrayList.get(i);
        String str1 = localHashMap2.get("menu_name").toString();
        String str2 = localHashMap2.get("menu_id").toString();
        localHashMap1.put(str2, str1);
      }
    this.log.LOG_INFO("结束getSendMenuJson=>>>");
    return localHashMap1;
  }

  public JSONArray getSendChildrenNodes(String paramString1, String paramString2, ArrayList paramArrayList)
    throws SaasApplicationException
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
      for (int i = 0; i < paramArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)paramArrayList.get(i);
        TreeObject localTreeObject = new TreeObject();
        String str1 = localHashMap.get("menu_name").toString();
        String str2 = localHashMap.get("menu_id").toString();
        localTreeObject.setId(str2);
        localTreeObject.setText(str1);
        TreeNode localTreeNode = isSendLeaf(paramString1, paramString2, str2);
        localTreeObject.setChildren(localTreeNode.getChildren());
        localTreeObject.setLeaf(localTreeNode.isLeaf());
        localJSONArray.add(localTreeObject);
      }
    this.log.LOG_INFO("结束getSendChildrenNodes=>>>");
    return localJSONArray;
  }

  public TreeNode isSendLeaf(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    int i = Integer.parseInt(paramString2);
    paramString2 = String.valueOf(i + 1);
    ArrayList localArrayList = getRightMenByUpMenu(paramString1, paramString2, paramString3, false);
    TreeNode localTreeNode = new TreeNode();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localTreeNode.setLeaf(false);
      JSONArray localJSONArray = getSendChildrenNodes(paramString1, paramString2, localArrayList);
      localTreeNode.setChildren(localJSONArray);
    }
    this.log.LOG_INFO("结束isSendLeaf=>>>");
    return localTreeNode;
  }

  public ArrayList getOneClassMenuBySer(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VSERVER_ID", paramString2);
    localMenuinfoExt.setParam(":VUP_MENU_ID", paramString1);
    localArrayList = localMenuinfoExt.selByList("SEL_All_ONE_CLASS_MENU");
    return localArrayList;
  }

  public ArrayList getRightInfoMenuMessage(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RoleRightExt localRoleRightExt = new RoleRightExt();
    localRoleRightExt.setParam(":VCUST_ID", paramString1);
    localRoleRightExt.setParam(":VROLE_CODE", paramString2);
    localArrayList = localRoleRightExt.selByList("SEL_BY_ROLE");
    return localArrayList;
  }

  public ArrayList getNoExistMenuByCustClass(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VCUST_CLASS", paramString1);
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString2);
    localMenuinfoExt.setParam(":VUP_MENU_ID", paramString3);
    localArrayList = localMenuinfoExt.selByList("SEL_NOEXIST_MENU_BY_CUSTCLASS");
    return localArrayList;
  }

  public ArrayList getNoExistMenuByCustClassForMumber(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VCUST_ID", paramString1);
    localMenuinfoExt.setParam(":VCUST_CLASS", paramString2);
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString3);
    localMenuinfoExt.setParam(":VUP_MENU_ID", paramString4);
    localArrayList = localMenuinfoExt.selByList("SEL_NOEXIST_MENU_BY_CUSTCLASS_FOR");
    return localArrayList;
  }

  public String getUpMenuIdById(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    ArrayList localArrayList = getMenuInfo(paramString);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("up_menu_id") != null)
        str = localHashMap.get("up_menu_id").toString();
    }
    return str;
  }

  public void addMenuInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addMenuInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SUBSYS_CODE");
    String str2 = paramBuffers.getString("MENU_ID");
    String str3 = paramBuffers.getString("MENU_NAME");
    String str4 = paramBuffers.getString("UP_MENU_ID");
    String str5 = paramBuffers.getString("MENU_CLASS");
    String str6 = paramBuffers.getString("MENU_TYPE");
    String str7 = paramBuffers.getString("MODULE_ID");
    String str8 = paramBuffers.getString("IN_PARAM_CODE1");
    String str9 = paramBuffers.getString("IN_PARAM_VALUE1");
    String str10 = paramBuffers.getString("IN_PARAM_CODE2");
    String str11 = paramBuffers.getString("IN_PARAM_VALUE2");
    String str12 = paramBuffers.getString("IN_PARAM_CODE3");
    String str13 = paramBuffers.getString("IN_PARAM_VALUE3");
    String str14 = paramBuffers.getString("REMOVE_TAG");
    String str15 = paramBuffers.getString("RSRV_STR1");
    String str16 = paramBuffers.getString("RSRV_STR2");
    String str17 = paramBuffers.getString("RSRV_STR3");
    String str18 = paramBuffers.getString("RSRV_STR4");
    String str19 = paramBuffers.getString("RSRV_STR5");
    String str20 = paramBuffers.getString("RSRV_STR6");
    String str21 = paramBuffers.getString("RSRV_STR7");
    String str22 = paramBuffers.getString("RSRV_STR8");
    String str23 = paramBuffers.getString("RSRV_STR9");
    String str24 = paramBuffers.getString("RSRV_STR0");
    String str25 = paramBuffers.getString("IN_STAFF_ID");
    String str26 = paramBuffers.getString("REMARK");
    try
    {
      i = addMenuInfo(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addMenuInfo方法...");
  }

  public int addMenuInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26)
    throws SaasApplicationException
  {
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    String str = paramString2;
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString1);
    localMenuinfoExt.setParam(":VMENU_ID", paramString2);
    localMenuinfoExt.setParam(":VMENU_NAME", paramString3);
    localMenuinfoExt.setParam(":VUP_MENU_ID", paramString4);
    localMenuinfoExt.setParam(":VMENU_CLASS", paramString5);
    localMenuinfoExt.setParam(":VMENU_TYPE", paramString6);
    localMenuinfoExt.setParam(":VMODULE_ID", paramString7);
    localMenuinfoExt.setParam(":VIN_PARAM_CODE1", paramString8);
    localMenuinfoExt.setParam(":VIN_PARAM_VALUE1", paramString9);
    localMenuinfoExt.setParam(":VIN_PARAM_CODE2", paramString10);
    localMenuinfoExt.setParam(":VIN_PARAM_VALUE2", paramString11);
    localMenuinfoExt.setParam(":VIN_PARAM_CODE3", paramString12);
    localMenuinfoExt.setParam(":VIN_PARAM_VALUE3", paramString13);
    localMenuinfoExt.setParam(":VREMOVE_TAG", paramString14);
    localMenuinfoExt.setParam(":VRSRV_STR1", paramString15);
    localMenuinfoExt.setParam(":VRSRV_STR2", paramString16);
    localMenuinfoExt.setParam(":VRSRV_STR3", paramString17);
    localMenuinfoExt.setParam(":VRSRV_STR4", paramString18);
    localMenuinfoExt.setParam(":VRSRV_STR5", paramString19);
    localMenuinfoExt.setParam(":VRSRV_STR6", paramString20);
    localMenuinfoExt.setParam(":VRSRV_STR7", paramString21);
    localMenuinfoExt.setParam(":VRSRV_STR8", paramString22);
    localMenuinfoExt.setParam(":VRSRV_STR9", paramString23);
    localMenuinfoExt.setParam(":VRSRV_STR0", paramString24);
    localMenuinfoExt.setParam(":VIN_STAFF_ID", paramString25);
    localMenuinfoExt.setParam(":VREMARK", paramString26);
    if (checkright(str) == 0)
      this.tradeQuery.executeBy(localMenuinfoExt.insBy("INS_BY_ALL_MENU"));
    else
      this.tradeQuery.executeBy(localMenuinfoExt.insBy("UPDATE_BY_ALL_MENU"));
    return 0;
  }

  public int checkright(String paramString)
    throws SaasApplicationException
  {
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    ArrayList localArrayList = new ArrayList();
    localMenuinfoExt.setParam(":VMENU_ID", paramString);
    localArrayList = localMenuinfoExt.selByList("CHECK_MENU_ID");
    if (localArrayList == null)
      return 0;
    return 1;
  }

  public void deleteMenuInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入deleteMenuInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str = paramBuffers.getString("MENU_ID");
    try
    {
      i = deleteMenuInfo(str);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败！");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出deleteMenuInfo方法...");
  }

  public int deleteMenuInfo(String paramString)
    throws SaasApplicationException
  {
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VMENU_ID", paramString);
    this.tradeQuery.executeBy(localMenuinfoExt.insBy("DEL_BY_ALL_MENU"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.rightMgr.RightMenu
 * JD-Core Version:    0.6.0
 */