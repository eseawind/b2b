package com.saas.biz.staffMgr;

import com.saas.biz.dao.staffDAO.SatffExt;
import com.saas.biz.dao.staffDAO.StaffDAO;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;

public class StaffCheckMgr
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;

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

  public void CheckLogin(Buffers paramBuffers)
  {
    this.log.LOG_INFO("进入CheckLogin方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    String str1 = paramBuffers.getString("STAFF_ID");
    String str2 = paramBuffers.getString("STAFF_PWD");
    int i = -1;
    try
    {
      i = CheckLogin(str1, str2);
    }
    catch (SaasApplicationException localSaasApplicationException)
    {
      this.log.LOG_INFO(localSaasApplicationException.getMessage());
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
    this.log.LOG_INFO("退出CheckLogin方法...");
  }

  private int CheckLogin(String paramString1, String paramString2)
    throws SaasApplicationException
  {
    SatffExt localSatffExt = new SatffExt();
    StaffDAO localStaffDAO = new StaffDAO();
    localSatffExt.setParam(":VSTAFFID", paramString1);
    localStaffDAO = localSatffExt.selByInfo("SEL_BY_CHECK");
    if (localStaffDAO == null)
      throw new SaasApplicationException("该用户不存在[" + paramString1 + "]");
    if (!localStaffDAO.getPasswd().equalsIgnoreCase(paramString2))
      throw new SaasApplicationException("该用户密码错误[" + paramString1 + "]");
    this.outBuffer.setString("STAFF_NAME", localStaffDAO.getStaff_name());
    this.outBuffer.setSessionField("STAFF_ID");
    this.outBuffer.setSessionField("STAFF_NAME");
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.staffMgr.StaffCheckMgr
 * JD-Core Version:    0.6.0
 */