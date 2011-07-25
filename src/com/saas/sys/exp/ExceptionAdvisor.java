package com.saas.sys.exp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

public class ExceptionAdvisor
  implements ThrowsAdvice
{
  private final Log logger = LogFactory.getLog(getClass());

  public void afterThrowing(RuntimeException paramRuntimeException)
    throws Throwable
  {
    this.logger.error("[程序执行异常]： " + paramRuntimeException.getMessage());
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.exp.ExceptionAdvisor
 * JD-Core Version:    0.6.0
 */