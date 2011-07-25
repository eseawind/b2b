package com.saas.biz.saveTemplateFile;

import com.saas.biz.commen.commMethodMgr;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.exp.SaasApplicationException;
import com.saas.sys.log.Logger;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class saveTemplate
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

  public void saveTempFile(Buffers paramBuffers)
    throws SaasApplicationException
  {
    this.log.LOG_INFO("进入addClewTrackInfo方法...");
    this.outBuffer = paramBuffers;
    this.inBuffer = paramBuffers;
    int i = -1;
    String str1 = paramBuffers.getString("CONTENT");
    String str2 = paramBuffers.getString("PATH");
    try
    {
      i = saveTempFile(str2, str1);
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
    this.log.LOG_INFO("退出addClewTrackInfo方法...");
  }

  public int saveTempFile(String paramString1, String paramString2)
    throws SaasApplicationException, IOException
  {
    FileOutputStream localFileOutputStream = null;
    try
    {
      localFileOutputStream = new FileOutputStream(paramString1);
      byte[] arrayOfByte = paramString2.getBytes();
      localFileOutputStream.write(arrayOfByte);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
    finally
    {
      localFileOutputStream.close();
    }
    return 0;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.saveTemplateFile.saveTemplate
 * JD-Core Version:    0.6.0
 */