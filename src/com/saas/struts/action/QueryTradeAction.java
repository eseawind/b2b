package com.saas.struts.action;

import com.saas.sys.bpm.TradeQueryIntf;
import com.saas.sys.buffer.Buffers;
import com.saas.sys.log.Logger;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class QueryTradeAction extends BaseAction
{
  public ActionForward executeAction(ActionMapping paramActionMapping, ActionForm paramActionForm, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
  {
    Logger localLogger = new Logger(this);
    XmlBeanFactory localXmlBeanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
    TradeQueryIntf localTradeQueryIntf = (TradeQueryIntf)localXmlBeanFactory.getBean("query");
    Buffers localBuffers1 = new Buffers();
    Buffers localBuffers2 = new Buffers();
    HttpSession localHttpSession = paramHttpServletRequest.getSession();
    System.out.println(localHttpSession);
    localBuffers1.convert(paramHttpServletRequest, paramActionForm, localHttpSession);
    ArrayList localArrayList = new ArrayList();
    localArrayList = localTradeQueryIntf.ExecTradeQuery(localBuffers1);
    localBuffers2 = localTradeQueryIntf.getOutBuffer();
    Map localMap = paramHttpServletRequest.getParameterMap();
    paramHttpServletRequest.setAttribute("query", localMap);
    paramHttpServletRequest.setAttribute("result", localArrayList);
    paramHttpServletRequest.setAttribute("outBuffer", localBuffers2);
    String str = "";
    if (localHttpSession.getAttribute("SESSION_CUST_ID") != null)
      str = localHttpSession.getAttribute("SESSION_CUST_ID").toString();
    if (str.equals(""))
      return paramActionMapping.findForward("ERROR_PAGE");
    return paramActionMapping.findForward("QUERY_PAGE");
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.struts.action.QueryTradeAction
 * JD-Core Version:    0.6.0
 */