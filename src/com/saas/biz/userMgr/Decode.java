package com.saas.biz.userMgr;

import com.saas.sys.buffer.Buffers;
import com.saas.sys.dbm.Dbtable;
import com.saas.sys.log.Logger;

public class Decode
{
  Dbtable tradeQuery = new Dbtable();
  Logger log = new Logger(this);
  Buffers inBuffer;
  Buffers outBuffer;

  public void setTradeQuery(Dbtable paramDbtable)
  {
    this.tradeQuery = paramDbtable;
  }

  public Dbtable getTradeQuery()
  {
    return this.tradeQuery;
  }

  public void setOutBuffer(Buffers paramBuffers)
  {
    this.outBuffer = paramBuffers;
  }

  public Buffers getOutBuffer()
  {
    return this.outBuffer;
  }

  public static String Decrypt(String paramString)
  {
    String str1 = "lsdfoglkwjemc-091324jlkmsda-0sd=1234;l;lsdkOPIER203-4LKJSLDJAS0D925JKNNC,MANSLDJQ32ELK1N4SAIp089er0234lkjo9df82l3kjlknf,nzxc,mn;lasdj9wquelq;d]qowe[;wq;qkwellsdkfj0-0POPOAR0W8RPOp-02@#$sdklj$#)0asdlksadLKJFA9820934)(&$3ij09sdj34-sdfj2po345-09dlkfjlkv,mxncv;laskdkl/a;au093hakjh2389~!@%&*%#&^539478(*&)^(&^_*8-*_+++|78w3ihsdnmnclksdj)(*#%*_@$(+#@$)&@#^*&^#@$()(*#@$HDFIkdhfgkjh098k;ldsk.sdv.c,msd;flkp0w34;2lk-=sd0p121o39-werl2k3;4lj09sdflskjlekfj,mv,mcxvjlksjdflksjdl*(#@!&akhduyqweperilmmdxcasnd*(#@9879327kjhasudfewr kwehriwueyrhc ausdgiq7w8e71 cdsh93ol2q32879y8932qwhdkjanhdskjaoe*&w#jh$)(*dsFshc na89wue32e981yewher12(*&#quds)(*i3o1928osaihdaklsdkalkduqowe3290874kljhklasdhlijhqweio4hwe89(*$#$eriho349oij(#*q$OIJHO)(&*#$_)(IUDSOIUoiOIUSAODFU034liusdrogiuet0lsdmc,.mg;lq-091lk3l;kjsdf--123098fe*(JOKJSFD983345oihjdp0(#*$&#@!HKJH!(@#*&ioysdk@#)uhOA7E98R7239845K(*&(#@*$&HKFDJHWERYIWoi)(*&#@&^%@!dsfoi;.;,p[osklejr230897*(&we2&^%@78*(&#@!(7~&*~^@*&^#(*&auroiqkjwrhoasdf89qlrlkjpour09werk23jh";
    int i;
    try
    {
      i = DecodeChar(paramString, 0);
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      return "";
    }
    int j;
    try
    {
      j = DecodeChar(paramString, 2);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      return "";
    }
    j &= 3;
    String str2 = "";
    int i1 = paramString.length();
    int i2 = str1.length();
    int m = j + j + 4;
    int n = i;
    while (m < i1)
    {
      int k;
      try
      {
        k = DecodeChar(paramString, m);
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        return "";
      }
      int i3 = str1.charAt(n);
      k ^= i3;
      char c = (char)k;
      str2 = str2 + c;
      n++;
      if (n >= i2)
        n = 0;
      m += 2;
    }
    return str2;
  }

  public static String Encrypt(String paramString)
  {
    String str1 = "lsdfoglkwjemc-091324jlkmsda-0sd=1234;l;lsdkOPIER203-4LKJSLDJAS0D925JKNNC,MANSLDJQ32ELK1N4SAIp089er0234lkjo9df82l3kjlknf,nzxc,mn;lasdj9wquelq;d]qowe[;wq;qkwellsdkfj0-0POPOAR0W8RPOp-02@#$sdklj$#)0asdlksadLKJFA9820934)(&$3ij09sdj34-sdfj2po345-09dlkfjlkv,mxncv;laskdkl/a;au093hakjh2389~!@%&*%#&^539478(*&)^(&^_*8-*_+++|78w3ihsdnmnclksdj)(*#%*_@$(+#@$)&@#^*&^#@$()(*#@$HDFIkdhfgkjh098k;ldsk.sdv.c,msd;flkp0w34;2lk-=sd0p121o39-werl2k3;4lj09sdflskjlekfj,mv,mcxvjlksjdflksjdl*(#@!&akhduyqweperilmmdxcasnd*(#@9879327kjhasudfewr kwehriwueyrhc ausdgiq7w8e71 cdsh93ol2q32879y8932qwhdkjanhdskjaoe*&w#jh$)(*dsFshc na89wue32e981yewher12(*&#quds)(*i3o1928osaihdaklsdkalkduqowe3290874kljhklasdhlijhqweio4hwe89(*$#$eriho349oij(#*q$OIJHO)(&*#$_)(IUDSOIUoiOIUSAODFU034liusdrogiuet0lsdmc,.mg;lq-091lk3l;kjsdf--123098fe*(JOKJSFD983345oihjdp0(#*$&#@!HKJH!(@#*&ioysdk@#)uhOA7E98R7239845K(*&(#@*$&HKFDJHWERYIWoi)(*&#@&^%@!dsfoi;.;,p[osklejr230897*(&we2&^%@78*(&#@!(7~&*~^@*&^#(*&auroiqkjwrhoasdf89qlrlkjpour09werk23jh";
    int i = (int)Random(255);
    int j = i & 0x3;
    int k = paramString.length();
    int m = str1.length();
    String str2 = "";
    str2 = str2 + EncodeChar(i);
    str2 = str2 + EncodeChar(((int)Random(255) & 0xFC) + j);
    for (int n = 0; n < j; n++)
      str2 = str2 + EncodeChar((int)Random(255));
    int n = 0;
    int i1 = i;
    while (n < k)
    {
      str2 = str2 + EncodeChar(paramString.charAt(n) ^ str1.charAt(i1));
      i1++;
      if (i1 >= m)
        i1 = 0;
      n++;
    }
    return str2;
  }

  public static double Random(int paramInt)
  {
    return Math.floor(Math.random() * 1000000.0D) % paramInt;
  }

  public static String EncodeChar(int paramInt)
  {
    String str = "";
    double d = Math.floor(paramInt / 16);
    if (d > 9.0D)
      str = str + (char)((int)d - 10 + 97);
    else
      str = str + (int)d;
    d = paramInt % 16;
    if (d > 9.0D)
      str = str + (char)((int)d - 10 + 97);
    else
      str = str + (int)d;
    return str;
  }

  public static int DecodeChar(String paramString, int paramInt)
    throws NumberFormatException
  {
    return Integer.parseInt(paramString.substring(paramInt, paramInt + 2), 16);
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.userMgr.Decode
 * JD-Core Version:    0.6.0
 */