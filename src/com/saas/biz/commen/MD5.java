package com.saas.biz.commen;

import java.security.MessageDigest;

public class MD5
{
  public String getMD5(byte[] paramArrayOfByte)
  {
    String str = null;
    char[] arrayOfChar1 = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      byte[] arrayOfByte = localMessageDigest.digest();
      char[] arrayOfChar2 = new char[32];
      int i = 0;
      for (int j = 0; j < 16; j++)
      {
        int k = arrayOfByte[j];
        arrayOfChar2[(i++)] = arrayOfChar1[(k >>> 4 & 0xF)];
        arrayOfChar2[(i++)] = arrayOfChar1[(k & 0xF)];
      }
      str = new String(arrayOfChar2);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.commen.MD5
 * JD-Core Version:    0.6.0
 */