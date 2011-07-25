package tools.util;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomNum
{
  private Long randomnum = null;
  private Float randomfloat = null;
  private boolean floatvalue = false;
  private long upper = 100L;
  private long lower = 0L;
  private String algorithm = null;
  private String provider = null;
  private boolean secure = false;
  private Random random = null;
  private SecureRandom secrandom = null;

  private final float getFloat()
  {
    if (this.random == null)
      return this.secrandom.nextFloat();
    return this.random.nextFloat();
  }

  public final void generateRandomObject()
    throws Exception
  {
    if (this.secure)
      try
      {
        if (this.provider != null)
          this.secrandom = SecureRandom.getInstance(this.algorithm, this.provider);
        else
          this.secrandom = SecureRandom.getInstance(this.algorithm);
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new Exception(localNoSuchAlgorithmException.getMessage());
      }
      catch (NoSuchProviderException localNoSuchProviderException)
      {
        throw new Exception(localNoSuchProviderException.getMessage());
      }
    else
      this.random = new Random();
  }

  private final void generaterandom()
  {
    if (this.floatvalue)
      this.randomfloat = new Float(getFloat());
    else
      this.randomnum = new Long(this.lower + (int)(getFloat() * (float)(this.upper - this.lower)));
  }

  public final Number getRandom()
  {
    generaterandom();
    if (this.floatvalue)
      return this.randomfloat;
    return this.randomnum;
  }

  public final void setRange(long paramLong1, long paramLong2)
  {
    this.lower = paramLong1;
    this.upper = paramLong2;
    if ((this.lower == 0L) && (this.upper == 1L))
      this.floatvalue = true;
  }

  public final void setAlgorithm(String paramString)
  {
    this.algorithm = paramString;
    this.secure = true;
  }

  public final void setProvider(String paramString)
  {
    this.provider = paramString;
  }

  public final void setRange(String paramString)
    throws Exception
  {
    try
    {
      this.upper = new Integer(paramString.substring(paramString.indexOf('-') + 1)).longValue();
    }
    catch (Exception localException1)
    {
      throw new Exception("upper attribute could not be turned into an Integer default value was used");
    }
    try
    {
      this.lower = new Integer(paramString.substring(0, paramString.indexOf('-'))).longValue();
    }
    catch (Exception localException2)
    {
      throw new Exception("lower attribute could not be turned into an Integer default value was used");
    }
    if ((this.lower == 0L) && (this.upper == 1L))
      this.floatvalue = true;
    if (this.upper < this.lower)
      throw new Exception("You can't have a range where the lowerbound is higher than the upperbound.");
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.RandomNum
 * JD-Core Version:    0.6.0
 */