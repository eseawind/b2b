package com.saas.biz.rightMgr;

import com.saas.biz.JavaScriptObject.CheckTreeObject;
import com.saas.biz.JavaScriptObject.TreeNode;
import com.saas.biz.commen.commMethodMgr;
import com.saas.biz.dao.rightsDAO.MenuinfoExt;
import com.saas.biz.dao.rightsDAO.RightinfoExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import net.sf.json.JSONArray;

public class RightTreeMenu
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

  public String getJSONCheckBoxTreeData(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    JSONArray localJSONArray = new JSONArray();
    String str1 = "";
    ArrayList localArrayList = getMenuInfoByClass(paramString2, "1");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      for (int i = 0; i < localArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        String str2 = localHashMap.get("menu_name").toString();
        String str3 = localHashMap.get("menu_id").toString();
        this.log.LOG_INFO("=========menu_id====" + str3 + "===========menu_name===" + str2 + "===========");
        CheckTreeObject localCheckTreeObject = new CheckTreeObject();
        localCheckTreeObject.setText(str2);
        localCheckTreeObject.setId(str3);
        localCheckTreeObject.setChecked(checkSendMenu(paramString1, str3));
        TreeNode localTreeNode = isLeaf(paramString1, paramString2, 0, str3);
        localCheckTreeObject.setDepth(0);
        localCheckTreeObject.setIconCls(paramString3);
        localCheckTreeObject.setLeaf(localTreeNode.isLeaf());
        localCheckTreeObject.setChildren(localTreeNode.getChildren());
        localJSONArray.add(localCheckTreeObject);
      }
      str1 = localJSONArray.toString();
    }
    return str1;
  }

  public boolean checkSendMenu(String paramString1, String paramString2)
    throws SaasApplicationException
  {
	  boolean i = false;
    RightinfoExt localRightinfoExt = new RightinfoExt();
    localRightinfoExt.setParam(":VCUST_CLASS", paramString1);
    localRightinfoExt.setParam(":VMENU_ID", paramString2);
    ArrayList localArrayList = localRightinfoExt.selByList("SEL_BY_MENU");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      i = true;
    return i;
  }

  public ArrayList getMenuInfoByClass(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString1);
    localMenuinfoExt.setParam(":VMENU_CLASS", paramString2);
    localArrayList = localMenuinfoExt.selByList("SEL_BY_CLASS_JSON");
    return localArrayList;
  }

  public JSONArray getChildrenNodes(String paramString1, String paramString2, int paramInt, ArrayList paramArrayList)
    throws SaasApplicationException
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
      for (int i = 0; i < paramArrayList.size(); i++)
      {
        HashMap localHashMap = (HashMap)paramArrayList.get(i);
        CheckTreeObject localCheckTreeObject = new CheckTreeObject();
        String str1 = localHashMap.get("menu_name").toString();
        String str2 = localHashMap.get("menu_id").toString();
        localCheckTreeObject.setId(str2);
        localCheckTreeObject.setText(str1);
        localCheckTreeObject.setChecked(checkSendMenu(paramString1, str2));
        localCheckTreeObject.setDepth(paramInt);
        TreeNode localTreeNode = isLeaf(paramString1, paramString2, paramInt, str2);
        localCheckTreeObject.setChildren(localTreeNode.getChildren());
        localCheckTreeObject.setLeaf(localTreeNode.isLeaf());
        localJSONArray.add(localCheckTreeObject);
      }
    return localJSONArray;
  }

  public TreeNode isLeaf(String paramString1, String paramString2, int paramInt, String paramString3)
    throws SaasApplicationException
  {
    paramInt += 1;
    ArrayList localArrayList = getDownMenuByUpMenuId(paramString2, paramString3);
    TreeNode localTreeNode = new TreeNode();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localTreeNode.setLeaf(false);
      JSONArray localJSONArray = getChildrenNodes(paramString1, paramString2, paramInt, localArrayList);
      localTreeNode.setChildren(localJSONArray);
    }
    return localTreeNode;
  }

  public ArrayList getDownMenuByUpMenuId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    ArrayList localArrayList = new ArrayList();
    MenuinfoExt localMenuinfoExt = new MenuinfoExt();
    localMenuinfoExt.setParam(":VSUBSYS_CODE", paramString1);
    localMenuinfoExt.setParam(":VMENU_ID", paramString2);
    localArrayList = localMenuinfoExt.selByList("SEL_BY_UP_JSON");
    return localArrayList;
  }

  public void addRightMenuInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("MENU_ID");
    String str2 = paramBuffers.getString("CUST_CLASS");
    String str3 = paramBuffers.getString("START_DATE");
    String str4 = paramBuffers.getString("END_DATE");
    try
    {
      i = addRightMenuInfo(str1, str2, str3, str4);
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
  }

  public int addRightMenuInfo(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString1, "|");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str1 = localStringTokenizer.nextToken();
      RightinfoExt localRightinfoExt1 = new RightinfoExt();
      localRightinfoExt1.setParam(":VMENU_ID", str1);
      localRightinfoExt1.setParam(":VCUST_CLASS", paramString2);
      localRightinfoExt1.setParam(":VSTART_DATE", paramString3);
      localRightinfoExt1.setParam(":VEND_DATE", paramString4);
      String str2 = getUpMenuId(str1);
      if (!checkSendMenu(paramString2, str1))
        this.tradeQuery.executeBy(localRightinfoExt1.insBy("INS_BY_ALL"));
      if ((str2 != null) && (!str2.equals("")) && (!checkSendMenu(paramString2, str2)))
      {
        RightinfoExt localRightinfoExt2 = new RightinfoExt();
        localRightinfoExt2.setParam(":VMENU_ID", str2);
        localRightinfoExt2.setParam(":VCUST_CLASS", paramString2);
        localRightinfoExt2.setParam(":VSTART_DATE", paramString3);
        localRightinfoExt2.setParam(":VEND_DATE", paramString4);
        this.tradeQuery.executeBy(localRightinfoExt2.insBy("INS_BY_ALL"));
      }
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

  public int getExistByMenuId(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    RightinfoExt localRightinfoExt = new RightinfoExt();
    localRightinfoExt.setParam(":VMENU_ID", paramString1);
    localRightinfoExt.setParam(":VCUST_CLASS", paramString2);
    ArrayList localArrayList = localRightinfoExt.selByList("SEL_BY_MENU");
    if ((localArrayList != null) && (localArrayList.size() > 0))
      return 0;
    return 1;
  }

  public void delRightMenuInfo(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("MENU_ID");
    String str2 = paramBuffers.getString("CUST_CLASS");
    String str3 = paramBuffers.getString("SUB_CODE");
    try
    {
      i = delRightMenuInfo(str1, str2, str3);
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
  }

  public int delRightMenuInfo(String paramString1, String paramString2, String paramString3)
    throws SaasApplicationException
  {
    RightinfoExt localRightinfoExt = new RightinfoExt();
    localRightinfoExt.setParam(":VSUB_CODE", paramString3);
    localRightinfoExt.setParam(":VCUST_CLASS", paramString2);
    this.tradeQuery.executeBy(localRightinfoExt.insBy("DEL_RIGHT_BY_MENU"));
    return 0;
  }

  public void addRightMenuInfoAgain(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入addRightMenuInfoAgain方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("ALL_MENU_ID");
    String str2 = paramBuffers.getString("CUST_CLASS");
    String str3 = paramBuffers.getString("START_DATE");
    String str4 = paramBuffers.getString("END_DATE");
    String str5 = paramBuffers.getString("MENU_CLASS");
    String str6 = paramBuffers.getString("SUBSYS_CODE");
    this.log.LOG_INFO("===" + str1 + "===" + str2 + "===" + str3 + "===" + str4 + "===" + str5 + "===" + str6 + "===");
    String str7 = "";
    String str8 = "";
    String str9 = "";
    String str10 = "";
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    RightMenu localRightMenu = new RightMenu();
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      while (localStringTokenizer.hasMoreTokens())
      {
        String str11 = localStringTokenizer.nextToken();
        i = addRightMenuInfoAgain(str11, str2, str3, str4);
        int j;
        if (str5.equals("1"))
        {
          localArrayList1 = localRightMenu.getNoExistMenuByCustClass(str2, str6, str11);
          if ((localArrayList1 != null) && (localArrayList1.size() > 0))
            for (j = 0; j < localArrayList1.size(); j++)
            {
              localHashMap1 = (HashMap)localArrayList1.get(j);
              if (localHashMap1.get("menu_id") == null)
                continue;
              str7 = localHashMap1.get("menu_id").toString();
              i = addRightMenuInfoAgain(str7, str2, str3, str4);
              localArrayList2 = localRightMenu.getNoExistMenuByCustClass(str2, str6, str7);
              if ((localArrayList2 == null) || (localArrayList2.size() <= 0))
                continue;
              for (int k = 0; k < localArrayList2.size(); k++)
              {
                localHashMap2 = (HashMap)localArrayList2.get(k);
                if (localHashMap2.get("menu_id") == null)
                  continue;
                str8 = localHashMap2.get("menu_id").toString();
                i = addRightMenuInfoAgain(str8, str2, str3, str4);
              }
            }
        }
        if (str5.equals("2"))
        {
          str9 = localRightMenu.getUpMenuIdById(str11);
          i = addRightMenuInfoAgain(str9, str2, str3, str4);
          localArrayList2 = localRightMenu.getNoExistMenuByCustClass(str2, str6, str11);
          if ((localArrayList2 != null) && (localArrayList2.size() > 0))
            for (j = 0; j < localArrayList2.size(); j++)
            {
              localHashMap2 = (HashMap)localArrayList2.get(j);
              if (localHashMap2.get("menu_id") == null)
                continue;
              str8 = localHashMap2.get("menu_id").toString();
              i = addRightMenuInfoAgain(str8, str2, str3, str4);
            }
        }
        if (str5.equals("3"))
        {
          str10 = localRightMenu.getUpMenuIdById(str11);
          i = addRightMenuInfoAgain(str10, str2, str3, str4);
          str9 = localRightMenu.getUpMenuIdById(str10);
          i = addRightMenuInfoAgain(str9, str2, str3, str4);
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

  public int addRightMenuInfoAgain(String paramString1, String paramString2, String paramString3, String paramString4)
    throws SaasApplicationException
  {
    RightinfoExt localRightinfoExt = new RightinfoExt();
    localRightinfoExt.setParam(":VMENU_ID", paramString1);
    localRightinfoExt.setParam(":VCUST_CLASS", paramString2);
    localRightinfoExt.setParam(":VSTART_DATE", paramString3);
    localRightinfoExt.setParam(":VEND_DATE", paramString4);
    this.tradeQuery.executeBy(localRightinfoExt.insBy("INS_BY_ALL"));
    return 0;
  }

  public void delRightMenuInfoAgain(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入delRightMenuInfoAgain方法...");
    this.outBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("ALL_MENU_ID");
    String str2 = paramBuffers.getString("CUST_CLASS");
    String str3 = paramBuffers.getString("SUBSYS_CODE");
    String str4 = paramBuffers.getString("MENU_CLASS");
    String str5 = "";
    String str6 = "";
    String str7 = "";
    String str8 = "";
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    RightMenu localRightMenu = new RightMenu();
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(str1, "|");
      while (localStringTokenizer.hasMoreTokens())
      {
        String str9 = localStringTokenizer.nextToken();
        i = delRightMenuInfoAgain(str9, str2);
        int j;
        if (str4.equals("1"))
        {
          localArrayList1 = localRightMenu.getNoExistMenuByCustClass(str2, str3, str9);
          if ((localArrayList1 != null) && (localArrayList1.size() > 0))
            for (j = 0; j < localArrayList1.size(); j++)
            {
              localHashMap1 = (HashMap)localArrayList1.get(j);
              if (localHashMap1.get("menu_id") == null)
                continue;
              str5 = localHashMap1.get("menu_id").toString();
              i = delRightMenuInfoAgain(str5, str2);
              localArrayList2 = localRightMenu.getNoExistMenuByCustClass(str2, str3, str5);
              if ((localArrayList2 == null) || (localArrayList2.size() <= 0))
                continue;
              for (int k = 0; k < localArrayList2.size(); k++)
              {
                localHashMap2 = (HashMap)localArrayList2.get(k);
                if (localHashMap2.get("menu_id") == null)
                  continue;
                str6 = localHashMap2.get("menu_id").toString();
                i = delRightMenuInfoAgain(str6, str2);
              }
            }
        }
        if (str4.equals("2"))
        {
          str7 = localRightMenu.getUpMenuIdById(str9);
          i = delRightMenuInfoAgain(str7, str2);
          localArrayList2 = localRightMenu.getNoExistMenuByCustClass(str2, str3, str9);
          if ((localArrayList2 != null) && (localArrayList2.size() > 0))
            for (j = 0; j < localArrayList2.size(); j++)
            {
              localHashMap2 = (HashMap)localArrayList2.get(j);
              if (localHashMap2.get("menu_id") == null)
                continue;
              str6 = localHashMap2.get("menu_id").toString();
              i = delRightMenuInfoAgain(str6, str2);
            }
        }
        if (str4.equals("3"))
        {
          str8 = localRightMenu.getUpMenuIdById(str9);
          i = delRightMenuInfoAgain(str8, str2);
          str7 = localRightMenu.getUpMenuIdById(str8);
          i = delRightMenuInfoAgain(str7, str2);
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

  public int delRightMenuInfoAgain(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    RightinfoExt localRightinfoExt = new RightinfoExt();
    localRightinfoExt.setParam(":VMENU_ID", paramString1);
    localRightinfoExt.setParam(":VCUST_CLASS", paramString2);
    this.tradeQuery.executeBy(localRightinfoExt.insBy("DEL_BY_ONE"));
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.rightMgr.RightTreeMenu
 * JD-Core Version:    0.6.0
 */