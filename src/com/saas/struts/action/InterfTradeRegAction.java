package com.saas.struts.action;

import com.saas.sys.bpm.TradeCheckIntf;
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

public class InterfTradeRegAction extends BaseAction
{
  public ActionForward executeAction(ActionMapping paramActionMapping, ActionForm paramActionForm, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
  {
    Logger localLogger = new Logger(this);
    XmlBeanFactory localXmlBeanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
    TradeRegIntf localTradeRegIntf = (TradeRegIntf)localXmlBeanFactory.getBean("trade");
    TradeCheckIntf localTradeCheckIntf = (TradeCheckIntf)localXmlBeanFactory.getBean("checktrade");
    Buffers localBuffers1 = new Buffers();
    Buffers localBuffers2 = new Buffers();
    Buffers localBuffers3 = new Buffers();
    ArrayList localArrayList1 = new ArrayList();
    HttpSession localHttpSession = paramHttpServletRequest.getSession();
    localBuffers1.convert(paramHttpServletRequest, paramActionForm, localHttpSession);
    localBuffers1.convertInterfceData(paramHttpServletRequest);
    localBuffers2 = localTradeRegIntf.TradeRegInfo(localBuffers1);
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2 = localBuffers2.getSessionList();
    Object localObject = localArrayList2.iterator();
    while (((Iterator)localObject).hasNext())
    {
      HashMap localHashMap = (HashMap)((Iterator)localObject).next();
      String str;
      if ((localHashMap.get("name") != null) && (localHashMap.get("name") != ""))
      {
        str = localBuffers2.getString(localHashMap.get("name").toString());
        localHttpSession.setAttribute(localHashMap.get("name").toString(), str);
      }
      if ((localHashMap.get("name") != null) && (localHashMap.get("name") != ""))
      {
        str = localBuffers2.getString(localHashMap.get("name").toString());
        Cookie localCookie = new Cookie(localHashMap.get("name").toString(), URLEncoder.encode(str));
        paramHttpServletResponse.addCookie(localCookie);
      }
    }
    localObject = localBuffers2.BuffersToBuffer(localBuffers2);
    paramHttpServletRequest.setAttribute("backQ", localObject);
    if (localBuffers2.getInt("RESULT_CODE") == 0)
      return paramActionMapping.findForward(localBuffers2.getString("SUCCEED_FWD"));
    return (ActionForward)paramActionMapping.findForward(localBuffers2.getString("ERROR_FWD"));
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.struts.action.InterfTradeRegAction
 * JD-Core Version:    0.6.0
 */