package com.saas.sys.log;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAdvisor
  implements MethodInterceptor
{
  public Logger Log;

  public Object invoke(MethodInvocation paramMethodInvocation)
    throws Throwable
  {
    this.Log = new Logger(this);
    try
    {
      this.Log.LOG_INFO("进入方法: " + paramMethodInvocation.getMethod().getDeclaringClass() + "." + paramMethodInvocation.getMethod().getName() + "()");
      Object localObject = paramMethodInvocation.proceed();
      this.Log.LOG_INFO("正常退出方法: " + paramMethodInvocation.getMethod().getDeclaringClass() + "." + paramMethodInvocation.getMethod().getName() + "()");
      return localObject;
    }
    catch (Exception localException)
    {
      this.Log.LOG_INFO("异常退出: " + paramMethodInvocation.getMethod().getDeclaringClass() + "." + paramMethodInvocation.getMethod().getName() + "()");
      throw new RuntimeException(localException);
    }
   
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.log.LogAdvisor
 * JD-Core Version:    0.6.0
 */