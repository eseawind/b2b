package com.saas.struts.action;

import com.saas.sys.bpm.TradeCheckIntf;
import com.saas.sys.bpm.TradeLoggerIntf;
import com.saas.sys.bpm.TradeRegIntf;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.log.Logger;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TradeRegAction extends BaseAction
{
  public ActionForward executeAction(ActionMapping paramActionMapping, ActionForm paramActionForm, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
  {
    Logger localLogger = new Logger(this);
    XmlBeanFactory localXmlBeanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
    TradeRegIntf localTradeRegIntf = (TradeRegIntf)localXmlBeanFactory.getBean("trade");
    TradeCheckIntf localTradeCheckIntf = (TradeCheckIntf)localXmlBeanFactory.getBean("checktrade");
    TradeLoggerIntf localTradeLoggerIntf = (TradeLoggerIntf)localXmlBeanFactory.getBean("loggertrade");
    Buffers localBuffers1 = new Buffers();
    Buffers localBuffers2 = new Buffers();
    Buffers localBuffers3 = new Buffers();
    Buffers localBuffers4 = new Buffers();
    ArrayList localArrayList1 = new ArrayList();
    HttpSession localHttpSession = paramHttpServletRequest.getSession();
    localBuffers1.convert(paramHttpServletRequest, paramActionForm, localHttpSession);
    localArrayList1 = localTradeCheckIntf.ExecTradeCheck(localBuffers1);
    localBuffers3 = localTradeCheckIntf.getOutBuffer();
    ArrayList localArrayList2 = localBuffers3.BuffersToBuffer(localBuffers3);
    if (localBuffers3.getInt("RESULT_CODE") != 0)
    {
      paramHttpServletRequest.setAttribute("outBuffer", localBuffers3);
      paramHttpServletRequest.setAttribute("backQ", localArrayList2);
      return paramActionMapping.findForward(localBuffers3.getString("ERROR_FWD"));
    }
    localBuffers2 = localTradeRegIntf.TradeRegInfo(localBuffers1);
    ArrayList localArrayList3 = new ArrayList();
    localArrayList3 = localBuffers2.getSessionList();
    Object localObject1 = localArrayList3.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      HashMap localObject2 = (HashMap)((Iterator)localObject1).next();
      if ((((HashMap)localObject2).get("name") != null) && (((HashMap)localObject2).get("name") != ""))
      {
       Object localObject3 = localBuffers2.getString(((HashMap)localObject2).get("name").toString());
        localHttpSession.setAttribute(((HashMap)localObject2).get("name").toString(), localObject3);
      }
      if ((((HashMap)localObject2).get("name") != null) && (((HashMap)localObject2).get("name") != ""))
      {
       Object localObject3 = localBuffers2.getString(((HashMap)localObject2).get("name").toString());
        Cookie localCookie = new Cookie(((HashMap)localObject2).get("name").toString(), URLEncoder.encode((String)localObject3));
        paramHttpServletResponse.addCookie(localCookie);
      }
    }
    localObject1 = localBuffers2.getString("SUCCEED_FWD");
    Object localObject2 = localBuffers2.getString("ERROR_FWD");
    localLogger.LOG_INFO("业务登记结束！");
    if (localBuffers2.getInt("RESULT_CODE") == 0)
    {
      localLogger.LOG_INFO("开始记录业务日志......");
      localTradeRegIntf.setCheck_tag("1");
      localBuffers4 = localTradeRegIntf.TradeRegInfo(localBuffers2);
      localLogger.LOG_INFO("业务日志记录结束！");
    }
    localLogger.LOG_INFO("开始设置返回数据.......");
    Object localObject3 = localBuffers2.BuffersToBuffer(localBuffers2);
    paramHttpServletRequest.setAttribute("backQ", localObject3);
    localLogger.LOG_INFO("全部业务结束，转向表示层！");
    if (localBuffers2.getInt("RESULT_CODE") == 0)
      return paramActionMapping.findForward((String)localObject1);
    return (ActionForward)(ActionForward)(ActionForward)paramActionMapping.findForward((String)localObject2);
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.struts.action.TradeRegAction
 * JD-Core Version:    0.6.0
 */