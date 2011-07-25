package com.saas.biz.roleMgr;

import com.saas.biz.JavaScriptObject.CheckTreeObject;
import com.saas.biz.JavaScriptObject.TreeNode;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.rightsDAO.MenuinfoExt;
import com.saas.biz.dao.rolerightDAO.RoleRightDAO;
import com.saas.biz.dao.rolerightDAO.RoleRightExt;
import com.saas.biz.rightMgr.RightMenu;
import com.saas.biz.rolerightMgr.RolerightInfo;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import net.sf.json.JSONArray;

public class RoleMenu
{
  Dbtable tradeQuery = new Dbtable();
  commMethodMgr comm = new commMethodMgr();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  ArrayList queryResult = new ArrayList();

  public void setTradeQuery(Dbtable paramDbtable)
  {
    this.tradeQuery = paramDbtable;
  }

  public Dbtable getTradeQuery()
  {
    return this.tradeQuery;
  }

  public void setOutBuffer(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }

  public ArrayList getQueryResult()
  {
    return this.queryResult;
  }

  public void setQueryResult(ArrayList paramArrayList)
  {
    this.queryResult = paramArrayList;
  }

  public String getJSONCheckBoxTreeData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getJSONCheckBoxTreeData方法");
    JSONArray localJSONArray = new JSONArray();
    String str1 = "";
    ArrayList localArrayList = getMenuRightInfoByClass(paramString2, paramString3, "1");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = localHashMap.get("menu_name").toString();
        String str3 = localHashMap.get("menu_id").toString();
        CheckTreeObject localCheckTreeObject = new CheckTreeObject();
        localCheckTreeObject.setText(str2);
        localCheckTreeObject.setId(str3);
        localCheckTreeObject.setChecked(checkSendMenu(paramString1, paramString4, str3));
        TreeNode localTreeNode = isLeaf(paramString1, paramString2, paramString4, paramString3, 0, str3);
        localCheckTreeObject.setDepth(0);
        localCheckTreeObject.setIconCls(paramString5);
        localCheckTreeObject.setLeaf(localTreeNode.isLeaf());
        localCheckTreeObject.setChildren(localTreeNode.getChildren());
        localJSONArray.add(localCheckTreeObject);
      }
      str1 = localJSONArray.toString();
    }
    return str1;
  }

  public boolean checkSendMenu(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入checkSendMenu方法...");
    boolean i = false;
    RolerightInfo localRolerightInfo = new RolerightInfo();
    ArrayList localArrayList = localRolerightInfo.getRoleRightByMenuId(paramString1, paramString2, paramString3);
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i =true;
    return i;
  }

  public ArrayList getMenuRightInfoByClass(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getMenuInfoByClass方法");
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString2);
    localMenuinfoExt.setParam(":VMENU_CLASS", paramString3);
    localMenuinfoExt.setParam(":VCUST_CLASS", paramString1);
    localArrayList = localMenuinfoExt.selByList("SEL_BY_RIGHT_JSON");
    return localArrayList;
  }

  public JSONArray getChildrenNodes(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, ArrayList paramArrayList)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getChildrenNodes方法");
    JSONArray localJSONArray = new JSONArray();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
      for (int i = 0; i < paramArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)paramArrayList.get(i);
        CheckTreeObject localCheckTreeObject = new CheckTreeObject();
        String str1 = localHashMap.get("menu_name").toString();
        String str2 = localHashMap.get("menu_id").toString();
        this.log.LOG_INFO("id====" + str2);
        localCheckTreeObject.setId(str2);
        localCheckTreeObject.setText(str1);
        localCheckTreeObject.setChecked(checkSendMenu(paramString1, paramString3, str2));
        localCheckTreeObject.setDepth(paramInt);
        TreeNode localTreeNode = isLeaf(paramString1, paramString2, paramString3, paramString4, paramInt, str2);
        localCheckTreeObject.setChildren(localTreeNode.getChildren());
        localCheckTreeObject.setLeaf(localTreeNode.isLeaf());
        localJSONArray.add(localCheckTreeObject);
      }
    return localJSONArray;
  }

  public TreeNode isLeaf(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入isLeaf方法");
    paramInt += 1;
    ArrayList localArrayList = getDownMenuByUpMenuId(paramString1, paramString2, paramString3, paramString4, paramString5);
    TreeNode localTreeNode = new TreeNode();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localTreeNode.setLeaf(false);
      JSONArray localJSONArray = getChildrenNodes(paramString1, paramString2, paramString3, paramString4, paramInt, localArrayList);
      localTreeNode.setChildren(localJSONArray);
    }
    return localTreeNode;
  }

  public ArrayList getDownMenuByUpMenuId(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入getDownMenuByUpMenuId方法");
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VMENU_ID", paramString5);
    localMenuinfoExt.setParam(":VCUST_CLASS", paramString2);
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString4);
    ArrayList localArrayList = localMenuinfoExt.selByList("SEL_MENU_ID");
    return localArrayList;
  }

  public void addRightMenuInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addRightMenuInfo方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ROLE_CODE");
    String str3 = paramBuffers.getString("MENU_ID");
    String str4 = paramBuffers.getString("START_DATE");
    String str5 = paramBuffers.getString("END_DATE");
    String str6 = paramBuffers.getString("SESSION_USER_ID");
    String str7 = paramBuffers.getString("REMARK");
    try
    {
      RoleRightDAO localRoleRightDAO = new RoleRightDAO();
      localRoleRightDAO.setCust_id(str1);
      localRoleRightDAO.setEnd_date(str5);
      localRoleRightDAO.setStart_date(str4);
      localRoleRightDAO.setOper_user_id(str6);
      localRoleRightDAO.setRemark(str7);
      localRoleRightDAO.setMenu_id(str3);
      localRoleRightDAO.setRole_code(str2);
      i = addRightMenuInfo(localRoleRightDAO);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addRightMenuInfo方法...");
  }

  public int addRightMenuInfo(RoleRightDAO paramRoleRightDAO)
    throws SaasApplicationException
  {
    String str1 = paramRoleRightDAO.getMenu_id();
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str2 = localStringTokenizer.nextToken();
      RoleRightExt localRoleRightExt1 = new RoleRightExt();
      localRoleRightExt1.setParam(":VCUST_ID", paramRoleRightDAO.getCust_id());
      localRoleRightExt1.setParam(":VROLE_CODE", paramRoleRightDAO.getRole_code());
      localRoleRightExt1.setParam(":VMENU_ID", str2);
      localRoleRightExt1.setParam(":VSTART_DATE", paramRoleRightDAO.getStart_date());
      localRoleRightExt1.setParam(":VEND_DATE", paramRoleRightDAO.getEnd_date());
      localRoleRightExt1.setParam(":VOPER_USER_ID", paramRoleRightDAO.getOper_user_id());
      localRoleRightExt1.setParam(":VREMARK", paramRoleRightDAO.getRemark());
      String str3 = getUpMenuId(str2);
      RoleRightExt localRoleRightExt2;
      if ((str3 != "") && (!str3.equals(null)))
      {
    	  boolean bool = getUpRightInfo(paramRoleRightDAO.getEnd_date(), paramRoleRightDAO.getCust_id(), str3);
        if (!bool)
        {
          localRoleRightExt2 = new RoleRightExt();
          localRoleRightExt2.setParam(":VCUST_ID", paramRoleRightDAO.getCust_id());
          localRoleRightExt2.setParam(":VROLE_CODE", paramRoleRightDAO.getRole_code());
          localRoleRightExt2.setParam(":VMENU_ID", str3);
          localRoleRightExt2.setParam(":VSTART_DATE", paramRoleRightDAO.getStart_date());
          localRoleRightExt2.setParam(":VEND_DATE", paramRoleRightDAO.getEnd_date());
          localRoleRightExt2.setParam(":VOPER_USER_ID", paramRoleRightDAO.getOper_user_id());
          localRoleRightExt2.setParam(":VREMARK", paramRoleRightDAO.getRemark());
          this.tradeQuery.executeBy(localRoleRightExt2.insBy("INS_BY_ALL"));
        }
      }
      boolean bool = getUpRightInfo(paramRoleRightDAO.getEnd_date(), paramRoleRightDAO.getCust_id(), str2);
      if (bool)
      {
        localRoleRightExt2 = new RoleRightExt();
        localRoleRightExt2.setParam(":VCUST_ID", paramRoleRightDAO.getCust_id());
        localRoleRightExt2.setParam(":VROLE_CODE", paramRoleRightDAO.getRole_code());
        localRoleRightExt2.setParam(":VMENU_ID", str2);
        this.tradeQuery.executeBy(localRoleRightExt2.insBy("DEL_BY_CODE"));
      }
      this.tradeQuery.executeBy(localRoleRightExt1.insBy("INS_BY_ALL"));
    }
    return 0;
  }

  public String getUpMenuId(String paramString)
    throws SaasApplicationException
  {
    String str = "";
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VMENU_ID", paramString);
    ArrayList localArrayList = localMenuinfoExt.selByList("SEL_BY_PK");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      HashMap localHashMap = (HashMap)localArrayList.get(0);
      if (localHashMap.get("up_menu_id") != null)
        str = localHashMap.get("up_menu_id").toString();
    }
    return str;
  }

  public boolean getUpRightInfo(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
	  boolean i = false;
    ArrayList localArrayList = new ArrayList();
    RoleRightExt localRoleRightExt = new RoleRightExt();
    localRoleRightExt.setParam(":VCUST_ID", paramString2);
    localRoleRightExt.setParam(":VROLE_CODE", paramString1);
    localRoleRightExt.setParam(":VMENU_ID", paramString3);
    localArrayList = localRoleRightExt.selByList("SEL_BY_MENU");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = true;
    return i;
  }

  public void delRightMenuInfo(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delRightMenuInfo方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ROLE_CODE");
    String str3 = paramBuffers.getString("SUB_CODE");
    try
    {
      RoleRightDAO localRoleRightDAO = new RoleRightDAO();
      localRoleRightDAO.setCust_id(str1);
      localRoleRightDAO.setMenu_id(str3);
      localRoleRightDAO.setRole_code(str2);
      i = delRightMenuInfo(localRoleRightDAO);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出delRightMenuInfo方法...");
  }

  public int delRightMenuInfo(RoleRightDAO paramRoleRightDAO)
    throws SaasApplicationException
  {
    RoleRightExt localRoleRightExt = new RoleRightExt();
    localRoleRightExt.setParam(":VCUST_ID", paramRoleRightDAO.getCust_id());
    localRoleRightExt.setParam(":VSUB_CODE", paramRoleRightDAO.getMenu_id());
    localRoleRightExt.setParam(":VROLE_CODE", paramRoleRightDAO.getRole_code());
    this.tradeQuery.executeBy(localRoleRightExt.insBy("DEL_RIGHT_BY_CODE"));
    return 0;
  }

  public int getExistByMenuId(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    RoleRightExt localRoleRightExt = new RoleRightExt();
    localRoleRightExt.setParam(":VCUST_ID", paramString3);
    localRoleRightExt.setParam(":VROLE_CODE", paramString2);
    localRoleRightExt.setParam(":VMENU_ID", paramString1);
    localArrayList = localRoleRightExt.selByList("SEL_BY_MENU");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return 0;
    return 1;
  }

  public void addRightMenuInfoAgain(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addRightMenuInfoAgain方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ALL_MENU_ID");
    String str3 = paramBuffers.getString("CUST_CLASS");
    String str4 = paramBuffers.getString("START_DATE");
    String str5 = paramBuffers.getString("END_DATE");
    String str6 = paramBuffers.getString("MENU_CLASS");
    String str7 = paramBuffers.getString("SUBSYS_CODE");
    String str8 = "";
    String str9 = "";
    String str10 = "";
    String str11 = "";
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    RightMenu localRightMenu = new RightMenu();
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str2, "|");
      while (localStringTokenizer.hasMoreTokens())
      {
        String str12 = localStringTokenizer.nextToken();
        i = addRightMenuInfoAgain(str12, str3, str1, str4, str5);
        int j;
        if (str6.equals("1"))
        {
          localArrayList1 = localRightMenu.getNoExistMenuByCustClass(str3, str7, str12);
          if ((localArrayList1 != null) && (localArrayList1.size() > 0))
            for (j = 0; j < localArrayList1.size(); j++)
            {
              localHashMap1 = (HashMap)localArrayList1.get(j);
              if (localHashMap1.get("menu_id") == null)
                continue;
              str8 = localHashMap1.get("menu_id").toString();
              i = addRightMenuInfoAgain(str8, str3, str1, str4, str5);
              localArrayList2 = localRightMenu.getNoExistMenuByCustClass(str3, str7, str8);
              if ((localArrayList2 == null) || (localArrayList2.size() <= 0))
                continue;
              for (int k = 0; k < localArrayList2.size(); k++)
              {
                localHashMap2 = (HashMap)localArrayList2.get(k);
                if (localHashMap2.get("menu_id") == null)
                  continue;
                str9 = localHashMap2.get("menu_id").toString();
                i = addRightMenuInfoAgain(str9, str3, str1, str4, str5);
              }
            }
        }
        if (str6.equals("2"))
        {
          str10 = localRightMenu.getUpMenuIdById(str12);
          i = addRightMenuInfoAgain(str10, str3, str1, str4, str5);
          localArrayList2 = localRightMenu.getNoExistMenuByCustClass(str3, str7, str12);
          if ((localArrayList2 != null) && (localArrayList2.size() > 0))
            for (j = 0; j < localArrayList2.size(); j++)
            {
              localHashMap2 = (HashMap)localArrayList2.get(j);
              if (localHashMap2.get("menu_id") == null)
                continue;
              str9 = localHashMap2.get("menu_id").toString();
              i = addRightMenuInfoAgain(str9, str3, str1, str4, str5);
            }
        }
        if (str6.equals("3"))
        {
          str11 = localRightMenu.getUpMenuIdById(str12);
          i = addRightMenuInfoAgain(str11, str3, str1, str4, str5);
          str10 = localRightMenu.getUpMenuIdById(str11);
          i = addRightMenuInfoAgain(str10, str3, str1, str4, str5);
        }
      }
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出addRightMenuInfoAgain方法...");
  }

  public int addRightMenuInfoAgain(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    RoleRightExt localRoleRightExt = new RoleRightExt();
    localRoleRightExt.setParam(":VMENU_ID", paramString1);
    localRoleRightExt.setParam(":VROLE_CODE", paramString2);
    localRoleRightExt.setParam(":VCUST_ID", paramString3);
    localRoleRightExt.setParam(":VSTART_DATE", paramString4);
    localRoleRightExt.setParam(":VEND_DATE", paramString5);
    localRoleRightExt.setParam(":VOPER_USER_ID", "");
    localRoleRightExt.setParam(":VREMARK", "");
    this.tradeQuery.executeBy(localRoleRightExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void delRightMenuInfoAgain(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delRightMenuInfoAgain方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("SESSION_CUST_ID");
    String str2 = paramBuffers.getString("ALL_MENU_ID");
    String str3 = paramBuffers.getString("CUST_CLASS");
    String str4 = paramBuffers.getString("SUBSYS_CODE");
    String str5 = paramBuffers.getString("MENU_CLASS");
    String str6 = "";
    String str7 = "";
    String str8 = "";
    String str9 = "";
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    RightMenu localRightMenu = new RightMenu();
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str2, "|");
      while (localStringTokenizer.hasMoreTokens())
      {
        String str10 = localStringTokenizer.nextToken();
        i = delRightMenuInfoAgain(str10, str3, str1);
        int j;
        if (str5.equals("1"))
        {
          localArrayList1 = localRightMenu.getNoExistMenuByCustClass(str3, str4, str10);
          if ((localArrayList1 != null) && (localArrayList1.size() > 0))
            for (j = 0; j < localArrayList1.size(); j++)
            {
              localHashMap1 = (HashMap)localArrayList1.get(j);
              if (localHashMap1.get("menu_id") == null)
                continue;
              str6 = localHashMap1.get("menu_id").toString();
              i = delRightMenuInfoAgain(str6, str3, str1);
              localArrayList2 = localRightMenu.getNoExistMenuByCustClass(str3, str4, str6);
              if ((localArrayList2 == null) || (localArrayList2.size() <= 0))
                continue;
              for (int k = 0; k < localArrayList2.size(); k++)
              {
                localHashMap2 = (HashMap)localArrayList2.get(k);
                if (localHashMap2.get("menu_id") == null)
                  continue;
                str7 = localHashMap2.get("menu_id").toString();
                i = delRightMenuInfoAgain(str7, str3, str1);
              }
            }
        }
        if (str5.equals("2"))
        {
          str8 = localRightMenu.getUpMenuIdById(str10);
          i = delRightMenuInfoAgain(str8, str3, str1);
          localArrayList2 = localRightMenu.getNoExistMenuByCustClass(str3, str4, str10);
          if ((localArrayList2 != null) && (localArrayList2.size() > 0))
            for (j = 0; j < localArrayList2.size(); j++)
            {
              localHashMap2 = (HashMap)localArrayList2.get(j);
              if (localHashMap2.get("menu_id") == null)
                continue;
              str7 = localHashMap2.get("menu_id").toString();
              i = delRightMenuInfoAgain(str7, str3, str1);
            }
        }
        if (str5.equals("3"))
        {
          str9 = localRightMenu.getUpMenuIdById(str10);
          i = delRightMenuInfoAgain(str9, str3, str1);
          str8 = localRightMenu.getUpMenuIdById(str9);
          i = delRightMenuInfoAgain(str8, str3, str1);
        }
      }
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    if (i != 0)
    {
      this.outBuffer.setInt("RESULT_CODE", -1);
      this.outBuffer.setString("RESULT_INFO", "业务处理失败");
    }
    else
    {
      this.outBuffer.setInt("RESULT_CODE", 0);
      this.outBuffer.setString("RESULT_INFO", "业务处理成功！");
    }
    this.log.LOG_INFO("退出delRightMenuInfoAgain方法...");
  }

  public int delRightMenuInfoAgain(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    RoleRightExt localRoleRightExt = new RoleRightExt();
    localRoleRightExt.setParam(":VCUST_ID", paramString3);
    localRoleRightExt.setParam(":VMENU_ID", paramString1);
    localRoleRightExt.setParam(":VROLE_CODE", paramString2);
    this.tradeQuery.executeBy(localRoleRightExt.insBy("DEL_BY_CODE"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.roleMgr.RoleMenu
 * JD-Core Version:    0.6.0
 */