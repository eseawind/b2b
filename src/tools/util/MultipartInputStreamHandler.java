package tools.util;

import java.io.IOException;
import javax.servlet.ServletInputStream;

class MultipartInputStreamHandler
{
  ServletInputStream in;
  int totalExpected;
  int totalRead = 0;
  byte[] buf = new byte[8192];

  public MultipartInputStreamHandler(ServletInputStream paramServletInputStream, int paramInt)
  {
    this.in = paramServletInputStream;
    this.totalExpected = paramInt;
  }

  public String readLine()
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i;
    do
    {
      i = readLine(this.buf, 0, this.buf.length);
      if (i == -1)
        continue;
      localStringBuffer.append(new String(this.buf, 0, i, "ISO-8859-1"));
    }
    while (i == this.buf.length);
    if (localStringBuffer.length() == 0)
      return null;
    localStringBuffer.setLength(localStringBuffer.length() - 2);
    return localStringBuffer.toString();
  }

  public int readLine(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.totalRead >= this.totalExpected)
      return -1;
    if (paramInt2 > this.totalExpected - this.totalRead)
      paramInt2 = this.totalExpected - this.totalRead;
    int i = this.in.readLine(paramArrayOfByte, paramInt1, paramInt2);
    if (i > 0)
      this.totalRead += i;
    return i;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.MultipartInputStreamHandler
 * JD-Core Version:    0.6.0
 */