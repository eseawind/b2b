package tools.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class MacBinaryDecoderOutputStream extends FilterOutputStream
{
  int bytesFiltered = 0;
  int dataForkLength = 0;

  public MacBinaryDecoderOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public void write(int paramInt)
    throws IOException
  {
    if ((this.bytesFiltered <= 86) && (this.bytesFiltered >= 83))
    {
      int i = (86 - this.bytesFiltered) * 8;
      this.dataForkLength |= (paramInt & 0xFF) << i;
    }
    else if ((this.bytesFiltered < 128 + this.dataForkLength) && (this.bytesFiltered >= 128))
    {
      this.out.write(paramInt);
    }
    this.bytesFiltered += 1;
  }

  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.bytesFiltered >= 128 + this.dataForkLength)
    {
      this.bytesFiltered += paramInt2;
    }
    else if ((this.bytesFiltered >= 128) && (this.bytesFiltered + paramInt2 <= 128 + this.dataForkLength))
    {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      this.bytesFiltered += paramInt2;
    }
    else
    {
      for (int i = 0; i < paramInt2; i++)
        write(paramArrayOfByte[(paramInt1 + i)]);
    }
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.MacBinaryDecoderOutputStream
 * JD-Core Version:    0.6.0
 */