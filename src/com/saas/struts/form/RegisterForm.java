package com.saas.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class RegisterForm extends ActionForm
{
  private String cust_name;
  private String cust_type;
  private String cust_state;
  private String pspt_type_code;
  private String pspt_id;
  private String pspt_addr;
  private String eparchy_code;
  private String city_code;
  private String develope_channel;
  private String develope_man;
  private String class_id;
  private String group_attr;
  private String client_status;
  private String user_count;
  private String company_address;
  private String post_code;
  private String website;
  private String fax_nbr;
  private String email;
  private String group_contact_phone;
  private String enterprise_scope;
  private String province;
  private String city;
  private String calling_type_code;
  private String calling_sub_type_code;
  private String trade_class1;
  private String trade_class2;
  private String calling_area_code;
  private String enterprise_type_code;
  private String enterprise_size_code;
  private String juristic_cust_id;
  private String juristic;
  private String juristic_type_code;
  private String all_emp_count;
  private String china_emp_count;
  private String local_emp_count;
  private String group_memo;
  private String reg_money;
  private String cust_aim;
  private String scope;

  public String getAll_emp_count()
  {
    return this.all_emp_count;
  }

  public void setAll_emp_count(String paramString)
  {
    this.all_emp_count = paramString;
  }

  public String getCalling_area_code()
  {
    return this.calling_area_code;
  }

  public void setCalling_area_code(String paramString)
  {
    this.calling_area_code = paramString;
  }

  public String getCalling_sub_type_code()
  {
    return this.calling_sub_type_code;
  }

  public void setCalling_sub_type_code(String paramString)
  {
    this.calling_sub_type_code = paramString;
  }

  public String getCalling_type_code()
  {
    return this.calling_type_code;
  }

  public void setCalling_type_code(String paramString)
  {
    this.calling_type_code = paramString;
  }

  public String getChina_emp_count()
  {
    return this.china_emp_count;
  }

  public void setChina_emp_count(String paramString)
  {
    this.china_emp_count = paramString;
  }

  public String getCity()
  {
    return this.city;
  }

  public void setCity(String paramString)
  {
    this.city = paramString;
  }

  public String getCity_code()
  {
    return this.city_code;
  }

  public void setCity_code(String paramString)
  {
    this.city_code = paramString;
  }

  public String getClass_id()
  {
    return this.class_id;
  }

  public void setClass_id(String paramString)
  {
    this.class_id = paramString;
  }

  public String getClient_status()
  {
    return this.client_status;
  }

  public void setClient_status(String paramString)
  {
    this.client_status = paramString;
  }

  public String getCompany_address()
  {
    return this.company_address;
  }

  public void setCompany_address(String paramString)
  {
    this.company_address = paramString;
  }

  public String getCust_aim()
  {
    return this.cust_aim;
  }

  public void setCust_aim(String paramString)
  {
    this.cust_aim = paramString;
  }

  public String getCust_name()
  {
    return this.cust_name;
  }

  public void setCust_name(String paramString)
  {
    this.cust_name = paramString;
  }

  public String getCust_state()
  {
    return this.cust_state;
  }

  public void setCust_state(String paramString)
  {
    this.cust_state = paramString;
  }

  public String getCust_type()
  {
    return this.cust_type;
  }

  public void setCust_type(String paramString)
  {
    this.cust_type = paramString;
  }

  public String getDevelope_channel()
  {
    return this.develope_channel;
  }

  public void setDevelope_channel(String paramString)
  {
    this.develope_channel = paramString;
  }

  public String getDevelope_man()
  {
    return this.develope_man;
  }

  public void setDevelope_man(String paramString)
  {
    this.develope_man = paramString;
  }

  public String getEmail()
  {
    return this.email;
  }

  public void setEmail(String paramString)
  {
    this.email = paramString;
  }

  public String getEnterprise_scope()
  {
    return this.enterprise_scope;
  }

  public void setEnterprise_scope(String paramString)
  {
    this.enterprise_scope = paramString;
  }

  public String getEnterprise_size_code()
  {
    return this.enterprise_size_code;
  }

  public void setEnterprise_size_code(String paramString)
  {
    this.enterprise_size_code = paramString;
  }

  public String getEnterprise_type_code()
  {
    return this.enterprise_type_code;
  }

  public void setEnterprise_type_code(String paramString)
  {
    this.enterprise_type_code = paramString;
  }

  public String getEparchy_code()
  {
    return this.eparchy_code;
  }

  public void setEparchy_code(String paramString)
  {
    this.eparchy_code = paramString;
  }

  public String getFax_nbr()
  {
    return this.fax_nbr;
  }

  public void setFax_nbr(String paramString)
  {
    this.fax_nbr = paramString;
  }

  public String getGroup_attr()
  {
    return this.group_attr;
  }

  public void setGroup_attr(String paramString)
  {
    this.group_attr = paramString;
  }

  public String getGroup_contact_phone()
  {
    return this.group_contact_phone;
  }

  public void setGroup_contact_phone(String paramString)
  {
    this.group_contact_phone = paramString;
  }

  public String getGroup_memo()
  {
    return this.group_memo;
  }

  public void setGroup_memo(String paramString)
  {
    this.group_memo = paramString;
  }

  public String getJuristic()
  {
    return this.juristic;
  }

  public void setJuristic(String paramString)
  {
    this.juristic = paramString;
  }

  public String getJuristic_cust_id()
  {
    return this.juristic_cust_id;
  }

  public void setJuristic_cust_id(String paramString)
  {
    this.juristic_cust_id = paramString;
  }

  public String getJuristic_type_code()
  {
    return this.juristic_type_code;
  }

  public void setJuristic_type_code(String paramString)
  {
    this.juristic_type_code = paramString;
  }

  public String getLocal_emp_count()
  {
    return this.local_emp_count;
  }

  public void setLocal_emp_count(String paramString)
  {
    this.local_emp_count = paramString;
  }

  public String getPost_code()
  {
    return this.post_code;
  }

  public void setPost_code(String paramString)
  {
    this.post_code = paramString;
  }

  public String getProvince()
  {
    return this.province;
  }

  public void setProvince(String paramString)
  {
    this.province = paramString;
  }

  public String getPspt_addr()
  {
    return this.pspt_addr;
  }

  public void setPspt_addr(String paramString)
  {
    this.pspt_addr = paramString;
  }

  public String getPspt_id()
  {
    return this.pspt_id;
  }

  public void setPspt_id(String paramString)
  {
    this.pspt_id = paramString;
  }

  public String getPspt_type_code()
  {
    return this.pspt_type_code;
  }

  public void setPspt_type_code(String paramString)
  {
    this.pspt_type_code = paramString;
  }

  public String getReg_money()
  {
    return this.reg_money;
  }

  public void setReg_money(String paramString)
  {
    this.reg_money = paramString;
  }

  public String getScope()
  {
    return this.scope;
  }

  public void setScope(String paramString)
  {
    this.scope = paramString;
  }

  public String getTrade_class1()
  {
    return this.trade_class1;
  }

  public void setTrade_class1(String paramString)
  {
    this.trade_class1 = paramString;
  }

  public String getTrade_class2()
  {
    return this.trade_class2;
  }

  public void setTrade_class2(String paramString)
  {
    this.trade_class2 = paramString;
  }

  public String getUser_count()
  {
    return this.user_count;
  }

  public void setUser_count(String paramString)
  {
    this.user_count = paramString;
  }

  public String getWebsite()
  {
    return this.website;
  }

  public void setWebsite(String paramString)
  {
    this.website = paramString;
  }

  public ActionErrors validate(ActionMapping paramActionMapping, HttpServletRequest paramHttpServletRequest)
  {
    return null;
  }

  public void reset(ActionMapping paramActionMapping, HttpServletRequest paramHttpServletRequest)
  {
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.struts.form.RegisterForm
 * JD-Core Version:    0.6.0
 */