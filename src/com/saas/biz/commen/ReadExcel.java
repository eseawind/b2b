package com.saas.biz.commen;

import com.saas.biz.AreaInfoMgr.AreaInfo;
import com.saas.biz.productclassMgr.Productclass;
import com.saas.sys.exp.SaasApplicationException;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel
{
  private Connection conn = null;
  private Statement pst = null;
  private static String filePath;

  public static ArrayList readExcel(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      Workbook localWorkbook = Workbook.getWorkbook(localFileInputStream);
      Sheet[] arrayOfSheet = localWorkbook.getSheets();
      for (int i = 1; i < arrayOfSheet[0].getRows(); i++)
      {
        HashMap localHashMap = new HashMap();
        for (int j = 0; j < arrayOfSheet[0].getColumns(); j++)
        {
          Cell localCell = arrayOfSheet[0].getCell(j, i);
          String str = localCell.getContents().trim();
          if (str.equals(""))
            continue;
          localHashMap.put("title" + j, str);
        }
        localArrayList.add(localHashMap);
        if (localHashMap.size() == 0)
          break;
      }
      localWorkbook.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localArrayList;
  }

  public String getFilePath()
  {
    return filePath;
  }

  public void setFilePath(String paramString)
  {
    filePath = paramString;
  }

  public static ArrayList getDisplayData(ArrayList paramArrayList)
  {
    ArrayList localArrayList1 = new ArrayList();
    for (int i = 0; i < paramArrayList.size(); i++)
    {
      ArrayList localArrayList2 = (ArrayList)((ArrayList)paramArrayList.get(i)).get(1);
      for (int j = 0; j < localArrayList2.size(); j++)
        localArrayList1.add(localArrayList2.get(j));
    }
    return localArrayList1;
  }

  public void insertDB(ArrayList paramArrayList)
    throws SQLException, SaasApplicationException
  {
    commMethodMgr localcommMethodMgr = new commMethodMgr();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    String str8 = "";
    String str9 = "";
    String str10 = "";
    String str11 = "";
    String str12 = "";
    String str13 = "";
    String str14 = "";
    String str15 = "";
    String str16 = "";
    String str17 = "";
    String str18 = "";
    String str19 = "";
    String str20 = "";
    String str21 = "";
    String str22 = "";
    String str23 = "";
    String str24 = "";
    String str25 = "";
    String str26 = "";
    String str27 = "";
    String str28 = "";
    String str29 = "";
    String str30 = "";
    String str31 = "";
    String str32 = "";
    try
    {
      this.conn = getConnection();
      this.pst = this.conn.createStatement();
    }
    catch (Exception localException1)
    {
      throw new RuntimeException("创建数据库链接失败：" + localException1);
    }
    if (paramArrayList != null)
      for (int i = 0; i < paramArrayList.size(); i++)
      {
        HashMap localHashMap1 = (HashMap)paramArrayList.get(i);
        if (localHashMap1.get("title0") != null)
          str4 = localHashMap1.get("title0").toString();
        if (localHashMap1.get("title1") != null)
          str5 = localHashMap1.get("title1").toString();
        MD5 localMD5 = new MD5();
        str6 = localMD5.getMD5(str5.getBytes());
        if (localHashMap1.get("title2") != null)
          str7 = localHashMap1.get("title2").toString();
        if (localHashMap1.get("title3") != null)
          str8 = localHashMap1.get("title3").toString();
        if (localHashMap1.get("title4") != null)
          str9 = localHashMap1.get("title4").toString();
        if (localHashMap1.get("title5") != null)
          str10 = localHashMap1.get("title5").toString();
        if (localHashMap1.get("title6") != null)
          str11 = localHashMap1.get("title6").toString();
        if (localHashMap1.get("title7") != null)
          str12 = localHashMap1.get("title7").toString();
        if (localHashMap1.get("title8") != null)
          str13 = localHashMap1.get("title8").toString();
        if (localHashMap1.get("title9") != null)
          str14 = localHashMap1.get("title9").toString();
        if (localHashMap1.get("title10") != null)
          str15 = localHashMap1.get("title10").toString();
        if (localHashMap1.get("title11") != null)
          str16 = localHashMap1.get("title11").toString();
        if (localHashMap1.get("title12") != null)
          str17 = localHashMap1.get("title12").toString();
        if (localHashMap1.get("title13") != null)
          str18 = localHashMap1.get("title13").toString();
        if (localHashMap1.get("title14") != null)
          str19 = localHashMap1.get("title14").toString();
        if (localHashMap1.get("title15") != null)
          str20 = localHashMap1.get("title15").toString();
        if (localHashMap1.get("title16") != null)
          str22 = localHashMap1.get("title16").toString();
        if (localHashMap1.get("title17") != null)
          str23 = localHashMap1.get("title17").toString();
        if (localHashMap1.get("title18") != null)
          str24 = localHashMap1.get("title18").toString();
        if (localHashMap1.get("title19") != null)
          str25 = localHashMap1.get("title19").toString();
        str1 = localcommMethodMgr.GenTradeId();
        str2 = localcommMethodMgr.GenTradeId();
        this.pst.addBatch("insert into tf_f_user (user_id,user_name,cust_id,user_state,passwd,user_type,web_login_tag,oper_date) values ('" + str1 + "','" + str4 + "','" + str2 + "','0','" + str6 + "','0','1',now());");
        Productclass localProductclass = new Productclass();
        str27 = localProductclass.getInfoClassIdByClassName(str22);
        str28 = localProductclass.getInfoClassIdByClassName(str23);
        str29 = localProductclass.getInfoClassIdByClassName(str24);
        str30 = localProductclass.getInfoClassIdByClassName(str25);
        str31 = "00000000000000|" + str27 + "|" + str28 + "|" + str29 + "|" + str30;
        str32 = "00000000000000|" + str22 + "|" + str23 + "|" + str24 + "|" + str25;
        String str33 = "";
        String str34 = "";
        String str35 = "";
        AreaInfo localAreaInfo = new AreaInfo();
        str33 = localAreaInfo.getAreaId(str14);
        str34 = localAreaInfo.getAreaId(str15);
        str35 = localAreaInfo.getAreaId(str13);
        this.pst.addBatch("insert into tf_f_customer (cust_id,cust_name,cust_type,cust_state,pspt_type_code,pspt_id,pspt_addr,eparchy_code,city_code,develope_channel,develope_man,class_id,user_count,company_address,post_code,website,fax_nbr,email,group_contact_phone,province,city,calling_type_code,juristic,group_memo,cust_aim,scope,publish_date)  values ('" + str2 + "','" + str7 + "','0','0','0','0000','','" + str33 + "','" + str34 + "','0','','" + str26 + "','1','" + str16 + "','','" + str20 + "','" + str11 + "','" + str9 + "','" + str10 + "','" + str35 + "','','','" + str7 + "','" + str17 + "','" + str12 + "','" + str18 + "',now())");
        this.pst.addBatch("insert into tf_f_cust_level (cust_id,cust_start_date,cust_end_date,cust_oper_person,cust_class,cust_oper_date,cust_desc) values ('" + str2 + "',now(),'2050-12-11','" + str1 + "','2',now(),'')");
        this.pst.addBatch("insert into tf_f_infolist (cust_id,info_id,title,contents,tag,src,author,mini_img,ch_id,mimi_title,user_temp,pub_date,rsrv_str1,in_date) values ('','" + str2 + "','" + str12 + "','00','','','','','5563378845','','',now(),'0',now())");
        this.pst.addBatch("insert into tf_b_infoclass (root_id,web_id,info_type,class_id,class_name,class_id_grp,class_name_grp) values ('" + str2 + "','00000000000000','0','" + str30 + "','" + str21 + "','" + str31 + "','" + str32 + "')");
        this.pst.addBatch("insert into tf_f_user_detail (user_id,cust_id,cust_name,sex,post_addr,qq,email) values ('" + str2 + "','" + str1 + "','" + str7 + "','" + str8 + "','" + str16 + "','" + str19 + "','" + str9 + "')");
        this.pst.addBatch("insert into tf_f_property_u (user_id,acct_id,property_type,property_value,enable_tag) values ('" + str1 + "','1111111111','0','0','0')");
        String str36 = "";
        String str37 = "";
        String str38 = "";
        String str39 = "";
        String str40 = "";
        String str41 = "";
        ParamethodMgr localParamethodMgr = new ParamethodMgr();
        ArrayList localArrayList = new ArrayList();
        String str42 = "";
        try
        {
          localArrayList = localParamethodMgr.getCompareInfoByAttr("124");
        }
        catch (SaasApplicationException localSaasApplicationException)
        {
          localSaasApplicationException.printStackTrace();
        }
        if ((localArrayList != null) && (localArrayList.size() > 0))
          for (int j = 0; j < localArrayList.size(); j++)
          {
            HashMap localHashMap2 = (HashMap)localArrayList.get(j);
            if (localHashMap2.get("para_code1") != null)
              str36 = localHashMap2.get("para_code1").toString();
            if (localHashMap2.get("para_code2") != null)
              str37 = localHashMap2.get("para_code2").toString();
            if (localHashMap2.get("para_code4") != null)
              str38 = localHashMap2.get("para_code4").toString();
            if (localHashMap2.get("para_code5") != null)
              str39 = localHashMap2.get("para_code5").toString();
            if (localHashMap2.get("para_code6") != null)
              str40 = localHashMap2.get("para_code6").toString();
            if (localHashMap2.get("para_code7") != null)
              str41 = localHashMap2.get("para_code7").toString();
            str42 = localcommMethodMgr.GenNumTradeId();
            this.pst.addBatch("insert into tf_b_channel (cust_id,ch_id,ch_name,up_ch_id,ch_level,state_code,state_code_date,show_no,right_tag,save_dir,dir_pos,cont_mod,default_page,ch_attr,index_temp,list_temp,article_temp,ch_img,list_type,ch_key,ch_desc,index_view,in_date,remark) values ('" + str2 + "','" + str42 + "','" + str37 + "','0000000000','1','0',now(),'" + str36 + "','0','" + "company/web/" + str2 + "','0','" + str38 + "','" + str39 + "','0','" + "company/enterprise/customer/" + str2 + "/default/" + str39 + "','" + "company/enterprise/customer/" + str2 + "/default/" + str40 + "','" + "company/enterprise/customer/" + str2 + "/default/" + str41 + "','','0','','','0',now(),'')");
          }
        this.pst.executeBatch();
      }
    try
    {
      this.pst.close();
      this.conn.close();
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }

  public Connection getConnection()
  {
    config localconfig = new config();
    localconfig.init();
    String str1 = localconfig.getString("mysqlbase.user");
    String str2 = localconfig.getString("mysqlbase.password");
    String str3 = "org.gjt.mm.mysql.Driver";
    String str4 = "jdbc:mysql://" + localconfig.getString("mysqlbase.host") + ":" + localconfig.getString("mysqlbase.port") + "/" + localconfig.getString("mysqlbase.sid") + "?useUnicode=true&characterEncoding=GBK&useOldAliasMetadataBehavior=true";
    try
    {
      Class.forName(str3).newInstance();
    }
    catch (InstantiationException localInstantiationException)
    {
      localInstantiationException.printStackTrace();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
    try
    {
      this.conn = DriverManager.getConnection(str4, str1, str2);
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return this.conn;
  }

  public static void main(String[] paramArrayOfString)
    throws SaasApplicationException
  {
    ReadExcel localReadExcel = new ReadExcel();
    ArrayList localArrayList = readExcel("E:/db.xls");
    try
    {
      localReadExcel.insertDB(localArrayList);
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.ReadExcel
 * JD-Core Version:    0.6.0
 */