package com.saas.biz.commen;

import java.util.HashMap;

public class FinalStateString
{
  HashMap<String, String> map = new HashMap();

  public FinalStateString()
  {
    this.map.put("0", "新录入无需审批");
    this.map.put("1", "新录入待审批");
    this.map.put("2", "审批通过");
    this.map.put("3", "审批退回");
    this.map.put("4", "被冻结");
    this.map.put("5", "已执行");
    this.map.put("6", "被注销");
    this.map.put("7", "卖方已出库");
    this.map.put("8", "运输在途");
    this.map.put("9", "已经到货");
  }

  public String OpportunityStateToStirng(String paramString)
  {
    String str = "";
    if (this.map.get(paramString) != null)
      str = ((String)this.map.get(paramString)).toString();
    return str;
  }

  public String QuotationStateToString(String paramString)
  {
    String str = "";
    if (this.map.get(paramString) != null)
      str = ((String)this.map.get(paramString)).toString();
    return str;
  }

  public String SaleStateToString(String paramString)
  {
    String str = "";
    this.map.put("f", "待出库");
    this.map.put("g", "已包装");
    this.map.put("h", "已出库");
    this.map.put("i", "运输在途");
    this.map.put("j", "已经到货");
    this.map.put("k", "应收帐款部分结清");
    this.map.put("l", "应付收款全部结清");
    if (this.map.get(paramString) != null)
      str = ((String)this.map.get(paramString)).toString();
    return str;
  }

  public String StockStateToString(String paramString)
  {
    String str = "";
    this.map.put("a", "待入库");
    this.map.put("b", "包装存储");
    this.map.put("c", "已经入库");
    this.map.put("d", "应付帐款部分结清");
    this.map.put("e", "应付帐款全部结清");
    if (this.map.get(paramString) != null)
      str = ((String)this.map.get(paramString)).toString();
    return str;
  }

  public String OutStoreStateToString(String paramString)
  {
    String str = "";
    this.map.put("f", "待出库");
    this.map.put("g", "已包装");
    this.map.put("h", "已出库");
    if (this.map.get(paramString) != null)
      str = ((String)this.map.get(paramString)).toString();
    return str;
  }

  public String InStoreStateToString(String paramString)
  {
    String str = "";
    this.map.put("a", "待入库");
    this.map.put("b", "包装存储");
    this.map.put("c", "已经入库");
    if (this.map.get(paramString) != null)
      str = ((String)this.map.get(paramString)).toString();
    return str;
  }

  public String GiveStoreStateToString(String paramString)
  {
    String str = "";
    if (this.map.get(paramString) != null)
      str = ((String)this.map.get(paramString)).toString();
    return str;
  }

  public String AppStoreStateToString(String paramString)
  {
    String str = "";
    if (this.map.get(paramString) != null)
      str = ((String)this.map.get(paramString)).toString();
    return str;
  }

  public String ControlStoreStateToString(String paramString)
  {
    String str = "";
    if (this.map.get(paramString) != null)
      str = ((String)this.map.get(paramString)).toString();
    return str;
  }

  public String InstructionStoreStateToString(String paramString)
  {
    String str = "";
    if (this.map.get(paramString) != null)
      str = ((String)this.map.get(paramString)).toString();
    return str;
  }

  public String AssignStoreStateToString(String paramString)
  {
    String str = "";
    if (this.map.get(paramString) != null)
      str = ((String)this.map.get(paramString)).toString();
    return str;
  }

  public String RefundGoodsStateToString(String paramString)
  {
    String str = "";
    this.map.put("a", "退货待入库");
    this.map.put("b", "包装存储");
    this.map.put("c", "已经入库");
    this.map.put("d", "应付帐款部分结清");
    this.map.put("e", "应付帐款全部结清");
    if (this.map.get(paramString) != null)
      str = ((String)this.map.get(paramString)).toString();
    return str;
  }

  public String NifferGoodsStateToString(String paramString)
  {
    String str = "";
    this.map.put("a", "退货待入库");
    this.map.put("b", "包装存储");
    this.map.put("c", "已经入库");
    this.map.put("d", "应付帐款部分结清");
    this.map.put("e", "应付帐款全部结清");
    this.map.put("f", "待出库");
    this.map.put("g", "已包装");
    this.map.put("h", "已出库");
    this.map.put("i", "运输在途");
    this.map.put("j", "已经到货");
    this.map.put("k", "应收帐款部分结清");
    this.map.put("l", "应付收款全部结清");
    if (this.map.get(paramString) != null)
      str = ((String)this.map.get(paramString)).toString();
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.FinalStateString
 * JD-Core Version:    0.6.0
 */