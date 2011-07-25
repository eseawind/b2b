package com.saas.sys.bpm;

public class TradeInit
{
  private TradeTypeDAO tradeTypeDao;

  public String GetTest()
  {
    TradeTypeDAO localTradeTypeDAO = new TradeTypeDAO();
    localTradeTypeDAO = localTradeTypeDAO.selByInfo("select * from tradetype where trade_type_code = '123'");
    return localTradeTypeDAO.getTrade_name();
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.bpm.TradeInit
 * JD-Core Version:    0.6.0
 */