package tools.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class XMLProperties
{
  private File file;
  private Document doc;
  private Map propertyCache = new HashMap();

  public XMLProperties(String paramString)
  {
    this.file = new File(paramString);
    try
    {
      SAXBuilder localSAXBuilder = new SAXBuilder();
      DataUnformatFilter localDataUnformatFilter = new DataUnformatFilter();
      localSAXBuilder.setXMLFilter(localDataUnformatFilter);
      this.doc = localSAXBuilder.build(new File(paramString));
    }
    catch (Exception localException)
    {
      System.err.println("Error creating XML parser in PropertyManager.java");
      localException.printStackTrace();
    }
  }

  public String getAttributeValue(String paramString1, String paramString2)
  {
    return getAttributeValue(paramString1, paramString2, null);
  }

  public String getAttributeValue(String paramString1, String paramString2, String paramString3)
  {
    String[] arrayOfString = parsePropertyName(paramString1);
    Element localElement = this.doc.getRootElement();
    for (int i = 0; i < arrayOfString.length; i++)
    {
      localElement = localElement.getChild(arrayOfString[i]);
      if (localElement == null)
        return null;
    }
    return localElement.getAttributeValue(paramString2, paramString3);
  }

  public List getAttributes(String paramString)
  {
    String[] arrayOfString = parsePropertyName(paramString);
    Element localElement = this.doc.getRootElement();
    for (int i = 0; i < arrayOfString.length; i++)
    {
      localElement = localElement.getChild(arrayOfString[i]);
      if (localElement == null)
        return null;
    }
    return localElement.getAttributes();
  }

  public String getProperty(String paramString)
  {
    if (this.propertyCache.containsKey(paramString))
      return (String)this.propertyCache.get(paramString);
    String[] arrayOfString = parsePropertyName(paramString);
    Element localElement = this.doc.getRootElement();
    for (int i = 0; i < arrayOfString.length; i++)
    {
      localElement = localElement.getChild(arrayOfString[i]);
      if (localElement == null)
        return null;
    }
    String str = localElement.getText();
    str = str.trim();
    this.propertyCache.put(paramString, str);
    return str;
  }

  public String[] getChildrenProperties(String paramString)
  {
    String[] arrayOfString1 = parsePropertyName(paramString);
    Element localElement = this.doc.getRootElement();
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      localElement = localElement.getChild(arrayOfString1[i]);
      if (localElement == null)
        return new String[0];
    }
    List localList = localElement.getChildren();
    int j = localList.size();
    String[] arrayOfString2 = new String[j];
    for (int k = 0; k < j; k++)
      arrayOfString2[k] = ((Element)localList.get(k)).getName();
    return arrayOfString2;
  }

  public void setProperty(String paramString1, String paramString2)
  {
    this.propertyCache.put(paramString1, paramString2);
    String[] arrayOfString = parsePropertyName(paramString1);
    Element localElement = this.doc.getRootElement();
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if (localElement.getChild(arrayOfString[i]) == null)
        localElement.addContent(new Element(arrayOfString[i]));
      localElement = localElement.getChild(arrayOfString[i]);
    }
    localElement.setText(paramString2);
    saveProperties();
  }

  public void deleteProperty(String paramString)
  {
    String[] arrayOfString = parsePropertyName(paramString);
    Element localElement = this.doc.getRootElement();
    for (int i = 0; i < arrayOfString.length - 1; i++)
    {
      localElement = localElement.getChild(arrayOfString[i]);
      if (localElement == null)
        return;
    }
    localElement.removeChild(arrayOfString[(arrayOfString.length - 1)]);
    saveProperties();
  }

  private synchronized void saveProperties()
  {
    BufferedOutputStream localBufferedOutputStream = null;
    int i = 0;
    File localFile = null;
    try
    {
      localFile = new File(this.file.getParentFile(), this.file.getName() + ".tmp");
      XMLOutputter localXMLOutputter = new XMLOutputter("    ", true);
      localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localFile));
      localXMLOutputter.output(this.doc, localBufferedOutputStream);
    }
    catch (Exception localException3)
    {
      localException3.printStackTrace();
      i = 1;
    }
    finally
    {
      try
      {
        localBufferedOutputStream.close();
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
        i = 1;
      }
    }
    if (i == 0)
    {
      this.file.delete();
      localFile.renameTo(this.file);
    }
  }

  private String[] parsePropertyName(String paramString)
  {
    int i = 1;
    for (int j = 0; j < paramString.length(); j++)
    {
      if (paramString.charAt(j) != '.')
        continue;
      i++;
    }
    String[] arrayOfString = new String[i];
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ".");
    for (int k = 0; localStringTokenizer.hasMoreTokens(); k++)
      arrayOfString[k] = localStringTokenizer.nextToken();
    return arrayOfString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.XMLProperties
 * JD-Core Version:    0.6.0
 */