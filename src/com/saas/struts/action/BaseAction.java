package com.saas.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public abstract class BaseAction extends Action
{
  public ActionForward execute(ActionMapping paramActionMapping, ActionForm paramActionForm, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
  {
    if (!userIsLoggedIn(paramHttpServletRequest))
    {
      ActionErrors localActionErrors = new ActionErrors();
      localActionErrors.add("error", new ActionError("logon.sessionEnded"));
      saveErrors(paramHttpServletRequest, localActionErrors);
      return paramActionMapping.findForward("sessionEnded");
    }
    return executeAction(paramActionMapping, paramActionForm, paramHttpServletRequest, paramHttpServletResponse);
  }

  protected abstract ActionForward executeAction(ActionMapping paramActionMapping, ActionForm paramActionForm, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);

  private boolean userIsLoggedIn(HttpServletRequest paramHttpServletRequest)
  {
    return true;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.struts.action.BaseAction
 * JD-Core Version:    0.6.0
 */