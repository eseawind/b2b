package com.ahbay.mailMgr;

import com.saas.biz.dao.custDAO.CustomerExt;
import com.saas.biz.dao.userdetailDAO.UserdetailExt;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CRM_SendMailInfo
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;
  ArrayList queryResult = new ArrayList();
  String currentDate = "";

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

  public void sendMessageToCustomerUsers(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入sendMessageToCustomerUsers方法...");
    String str1 = paramBuffers.getString("CUST_NAME");
    String str2 = paramBuffers.getString("TITLE");
    String str3 = paramBuffers.getString("CONTENT");
    String str4 = paramBuffers.getString("CUST_ID");
    String str5 = paramBuffers.getString("EMAIL");
    try
    {
      if ((str5 != null) && (!str5.trim().equals("")))
        sendMessageToCustomerUsers(str4, str1, str2, str3, str5);
      else
        this.log.LOG_INFO("所选择客户的邮件地址不存在，无法发送邮件...");
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
    }
    this.log.LOG_INFO("退出sendMessageToCustomerUsers方法...");
  }

  public void sendMessageToCustomerUsers(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws SaasApplicationException
  {
    String str1 = "";
    ArrayList localArrayList = new ArrayList();
    UserdetailExt localUserdetailExt = new UserdetailExt();
    localUserdetailExt.setParam(":VCUST_ID", paramString1);
    String str2 = "";
    try
    {
      localArrayList = localUserdetailExt.selByList("SEL_BY_USERDETAIL_CUST");
    }
    catch (Exception localException1)
    {
      this.log.LOG_INFO(localException1.getMessage() + "Execute SQL 语句执行时出错...");
    }
    try
    {
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          HashMap localHashMap = new HashMap();
          localHashMap = (HashMap)localIterator.next();
          str2 = localHashMap.get("user_id").toString();
          this.log.LOG_INFO("hadfsfsdfsdfdsfdsf" + str2);
          if (localHashMap.get("email") != null)
          {
            str1 = localHashMap.get("email").toString();
            sendEmail(paramString5, str1, paramString3, paramString4);
            this.log.LOG_INFO("开始List 循环行发邮件给......" + str1);
          }
          else
          {
            sendEmail(paramString5, paramString5, "系统退信...", "你于 " + this.currentDate + "给" + str2 + "发送的邮件失败！！!");
            this.log.LOG_INFO("不能发邮件给......" + str2);
          }
        }
      }
    }
    catch (Exception localException2)
    {
      this.log.LOG_INFO(localException2.getMessage() + "发送邮件时出错...");
    }
  }

  public void sendEmail(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      mail localmail = new mail();
      localmail.setStrTo(paramString2);
      localmail.setStrFrom(paramString1);
      localmail.setStrSubject(paramString3);
      localmail.setStrText(paramString4);
      localmail.setStrUsername("liuy");
      localmail.setStrPassword("liuy");
      localmail.setStrSmtp("mail.saasdev.com");
      localmail.sendSimpleMail();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void sendMessageToAllCustomers(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    this.log.LOG_INFO("进入sendMessageToAllCustomers方法...");
    String str1 = paramBuffers.getString("TITLE");
    String str2 = paramBuffers.getString("CONTENT");
    try
    {
      sendMessageToAllCustomers(str1, str2);
    }
    catch (Exception localException)
    {
      this.log.LOG_INFO(localException.getMessage());
    }
    this.log.LOG_INFO("退出sendMessageToAllCustomers方法...");
  }

  public void sendMessageToAllCustomers(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    String str1 = "liuy@saasdev.com";
    String str2 = "";
    String str3 = "";
    ArrayList localArrayList = new ArrayList();
    CustomerExt localCustomerExt = new CustomerExt();
    localArrayList = localCustomerExt.selByList("SEL_BY_CUST_ID");
    try
    {
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          HashMap localHashMap = (HashMap)localIterator.next();
          str3 = localHashMap.get("cust_name").toString();
          if (localHashMap.get("email") != null)
          {
            str2 = localHashMap.get("email").toString();
            sendEmail(str1, str2, paramString1, paramString2);
          }
          else
          {
            sendEmail(str1, str1, "系统退信...", "你于 " + this.currentDate + "给" + str3 + "发送的邮件失败！！!");
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.mailMgr.CRM_SendMailInfo
 * JD-Core Version:    0.6.0
 */