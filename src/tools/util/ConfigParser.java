package tools.util;

import java.util.Properties;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ConfigParser extends DefaultHandler
{
  private Properties props = new Properties();
  private String currentSet;
  private String currentName;
  private StringBuffer currentValue = new StringBuffer();

  public Properties getProps()
  {
    return this.props;
  }

  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    this.currentValue.delete(0, this.currentValue.length());
    this.currentName = paramString3;
  }

  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    this.currentValue.append(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    this.props.put(paramString3.toLowerCase(), this.currentValue.toString().trim());
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.ConfigParser
 * JD-Core Version:    0.6.0
 */