package com.saas.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class AccountForm extends ActionForm
{
  private String account_name;
  private String bank_code;
  private String bank_id;
  private String contract_no;
  private String account_state;
  private String reg_date;
  private String account_class;
  private String rsrv_str1;
  private String rsrv_str2;
  private String rsrv_str3;
  private String rsrv_num1;
  private String rsrv_num2;
  private String remark;

  public ActionErrors validate(ActionMapping paramActionMapping, HttpServletRequest paramHttpServletRequest)
  {
    return null;
  }

  public void reset(ActionMapping paramActionMapping, HttpServletRequest paramHttpServletRequest)
  {
  }

  public String getAccount_class()
  {
    return this.account_class;
  }

  public void setAccount_class(String paramString)
  {
    this.account_class = paramString;
  }

  public String getAccount_name()
  {
    return this.account_name;
  }

  public void setAccount_name(String paramString)
  {
    this.account_name = paramString;
  }

  public String getAccount_state()
  {
    return this.account_state;
  }

  public void setAccount_state(String paramString)
  {
    this.account_state = paramString;
  }

  public String getBank_code()
  {
    return this.bank_code;
  }

  public void setBank_code(String paramString)
  {
    this.bank_code = paramString;
  }

  public String getBank_id()
  {
    return this.bank_id;
  }

  public void setBank_id(String paramString)
  {
    this.bank_id = paramString;
  }

  public String getContract_no()
  {
    return this.contract_no;
  }

  public void setContract_no(String paramString)
  {
    this.contract_no = paramString;
  }

  public String getReg_date()
  {
    return this.reg_date;
  }

  public void setReg_date(String paramString)
  {
    this.reg_date = paramString;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }

  public String getRsrv_num1()
  {
    return this.rsrv_num1;
  }

  public void setRsrv_num1(String paramString)
  {
    this.rsrv_num1 = paramString;
  }

  public String getRsrv_num2()
  {
    return this.rsrv_num2;
  }

  public void setRsrv_num2(String paramString)
  {
    this.rsrv_num2 = paramString;
  }

  public String getRsrv_str1()
  {
    return this.rsrv_str1;
  }

  public void setRsrv_str1(String paramString)
  {
    this.rsrv_str1 = paramString;
  }

  public String getRsrv_str2()
  {
    return this.rsrv_str2;
  }

  public void setRsrv_str2(String paramString)
  {
    this.rsrv_str2 = paramString;
  }

  public String getRsrv_str3()
  {
    return this.rsrv_str3;
  }

  public void setRsrv_str3(String paramString)
  {
    this.rsrv_str3 = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.struts.form.AccountForm
 * JD-Core Version:    0.6.0
 */