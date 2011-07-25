package com.saas.sys.bpm;

import com.saas.sys.buffer.Buffers;

public abstract interface TradeRegIntf
{
  public abstract Buffers TradeRegInfo(Buffers paramBuffers);

  public abstract void setCheck_tag(String paramString);
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.bpm.TradeRegIntf
 * JD-Core Version:    0.6.0
 */