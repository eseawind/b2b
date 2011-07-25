package tools.util;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

public class RandomStrg
{
  private static Integer length = new Integer(8);
  private static String randomstr;
  private static boolean allchars = false;
  private static HashMap hmap;
  private static ArrayList lower = null;
  private static ArrayList upper = null;
  private static char[] single = null;
  private static int singlecount = 0;
  private static boolean singles = false;
  private static String algorithm = null;
  private static String provider = null;
  private static boolean secure = false;
  private static Random random = null;
  private static SecureRandom secrandom = null;

  public static void setLength(int paramInt)
  {
    length = new Integer(paramInt);
  }

  private static float getFloat()
  {
    if (random == null)
      return secrandom.nextFloat();
    return random.nextFloat();
  }

  public static void generateRandomObject()
    throws Exception
  {
    if (secure)
      try
      {
        if (provider != null)
          random = SecureRandom.getInstance(algorithm, provider);
        else
          random = SecureRandom.getInstance(algorithm);
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
      random = new Random();
  }

  private static void generaterandom()
  {
    int i;
    if (allchars)
      for (i = 0; i < length.intValue(); i++)
        randomstr += new Character((char)(34 + (int)(getFloat() * 93.0F))).toString();
    else if (singles)
    {
      if (upper.size() == 3)
        for (i = 0; i < length.intValue(); i++)
          if ((int)(getFloat() * 100.0F) % 2 == 0)
          {
            if ((int)(getFloat() * 100.0F) % 2 == 0)
              randomstr += randomSingle().toString();
            else
              randomstr += randomChar((Character)lower.get(2), (Character)upper.get(2)).toString();
          }
          else if ((int)(getFloat() * 100.0F) % 2 == 0)
            randomstr += randomChar((Character)lower.get(1), (Character)upper.get(1)).toString();
          else
            randomstr += randomChar((Character)lower.get(0), (Character)upper.get(0)).toString();
      else if (upper.size() == 2)
        for (i = 0; i < length.intValue(); i++)
          if ((int)(getFloat() * 100.0F) % 2 == 0)
            randomstr += randomSingle().toString();
          else if ((int)(getFloat() * 100.0F) % 2 == 0)
            randomstr += randomChar((Character)lower.get(1), (Character)upper.get(1)).toString();
          else
            randomstr += randomChar((Character)lower.get(0), (Character)upper.get(0)).toString();
      else if (upper.size() == 1)
        for (i = 0; i < length.intValue(); i++)
          if ((int)getFloat() * 100 % 2 == 0)
            randomstr += randomSingle().toString();
          else
            randomstr += randomChar((Character)lower.get(0), (Character)upper.get(0)).toString();
      else
        for (i = 0; i < length.intValue(); i++)
          randomstr += randomSingle().toString();
    }
    else if (upper.size() == 3)
      for (i = 0; i < length.intValue(); i++)
        if ((int)(getFloat() * 100.0F) % 2 == 0)
          randomstr += randomChar((Character)lower.get(2), (Character)upper.get(2)).toString();
        else if ((int)(getFloat() * 100.0F) % 2 == 0)
          randomstr += randomChar((Character)lower.get(1), (Character)upper.get(1)).toString();
        else
          randomstr += randomChar((Character)lower.get(0), (Character)upper.get(0)).toString();
    else if (upper.size() == 2)
      for (i = 0; i < length.intValue(); i++)
        if ((int)(getFloat() * 100.0F) % 2 == 0)
          randomstr += randomChar((Character)lower.get(1), (Character)upper.get(1)).toString();
        else
          randomstr += randomChar((Character)lower.get(0), (Character)upper.get(0)).toString();
    else
      for (i = 0; i < length.intValue(); i++)
        randomstr += randomChar((Character)lower.get(0), (Character)upper.get(0)).toString();
  }

  private static Character randomSingle()
  {
    return new Character(single[(int)(getFloat() * singlecount - 1.0F)]);
  }

  private static Character randomChar(Character paramCharacter1, Character paramCharacter2)
  {
    int j = paramCharacter1.charValue();
    int k = paramCharacter2.charValue();
    int i = (int)(j + getFloat() * (k - j));
    return new Character((char)i);
  }

  public static String getRandom()
  {
    randomstr = new String();
    generaterandom();
    if (hmap != null)
    {
      while (hmap.containsKey(randomstr))
        generaterandom();
      hmap.put(randomstr, null);
    }
    return randomstr;
  }

  public static void setRanges(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    lower = paramArrayList1;
    upper = paramArrayList2;
  }

  public static void setHmap(HashMap paramHashMap)
  {
    hmap = paramHashMap;
  }

  public static void setLength(String paramString)
  {
    length = new Integer(paramString);
  }

  public static void setAlgorithm(String paramString)
  {
    algorithm = paramString;
    secure = true;
  }

  public static void setProvider(String paramString)
  {
    provider = paramString;
  }

  public static void setAllchars(boolean paramBoolean)
  {
    allchars = paramBoolean;
  }

  public static void setSingle(char[] paramArrayOfChar, int paramInt)
  {
    single = paramArrayOfChar;
    singlecount = paramInt;
    singles = true;
  }

  public static void setCharset(String paramString)
  {
    int i = 1;
    lower = new ArrayList(3);
    upper = new ArrayList(3);
    if (paramString.compareTo("all") == 0)
    {
      allchars = true;
      i = 0;
    }
    else if ((paramString.charAt(1) == '-') && (paramString.charAt(0) != '\\'))
    {
      while ((i != 0) && (paramString.charAt(1) == '-') && (paramString.charAt(0) != '\\'))
      {
        lower.add(new Character(paramString.charAt(0)));
        upper.add(new Character(paramString.charAt(2)));
        if (paramString.length() <= 3)
        {
          i = 0;
          continue;
        }
        paramString = paramString.substring(3);
      }
    }
    if (i != 0)
    {
      single = new char[30];
      StringTokenizer localStringTokenizer = new StringTokenizer(paramString);
      while (localStringTokenizer.hasMoreTokens())
      {
        String str = localStringTokenizer.nextToken();
        if (str.length() > 1)
          single[(singlecount++)] = '-';
        single[(singlecount++)] = str.charAt(0);
      }
    }
    if ((lower == null) && (single == null))
      setCharset("a-zA-Z0-9");
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.RandomStrg
 * JD-Core Version:    0.6.0
 */