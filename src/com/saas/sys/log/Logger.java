package com.saas.sys.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Logger
{
  private Log logger;

  public Logger(Object paramObject)
  {
    this.logger = LogFactory.getLog(paramObject.getClass());
  }

  public void LOG_INFO(String paramString)
  {
    if (this.logger.isInfoEnabled())
      this.logger.info(paramString);
  }

  public void LOG_DEBUG(String paramString)
  {
    if (this.logger.isDebugEnabled())
      this.logger.debug(paramString);
  }

  public void LOG_TRACE(String paramString)
  {
    if (this.logger.isTraceEnabled())
      this.logger.trace(paramString);
  }

  public void LOG_ERROR(String paramString)
  {
    if (this.logger.isErrorEnabled())
      this.logger.error(paramString);
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.log.Logger
 * JD-Core Version:    0.6.0
 */