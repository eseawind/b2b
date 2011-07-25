package tools.util;

import java.io.File;
import java.util.Properties;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ParseXML
{
  private Properties props;

  public Properties getProps()
  {
    return this.props;
  }

  public void parse(String paramString)
    throws Exception
  {
    ConfigParser localConfigParser = new ConfigParser();
    SAXParserFactory localSAXParserFactory = SAXParserFactory.newInstance();
    localSAXParserFactory.setNamespaceAware(false);
    localSAXParserFactory.setValidating(false);
    SAXParser localSAXParser = localSAXParserFactory.newSAXParser();
    try
    {
      localSAXParser.parse(new File(paramString), localConfigParser);
      this.props = localConfigParser.getProps();
    }
    finally
    {
      localSAXParserFactory = null;
      localSAXParser = null;
      localConfigParser = null;
    }
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.ParseXML
 * JD-Core Version:    0.6.0
 */