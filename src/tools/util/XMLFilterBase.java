package tools.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.XMLFilterImpl;

class XMLFilterBase extends XMLFilterImpl
{
  protected static final Attributes EMPTY_ATTS = new AttributesImpl();

  public XMLFilterBase()
  {
  }

  public XMLFilterBase(XMLReader paramXMLReader)
  {
    super(paramXMLReader);
  }

  public void startElement(String paramString1, String paramString2)
    throws SAXException
  {
    startElement(paramString1, paramString2, "", EMPTY_ATTS);
  }

  public void startElement(String paramString)
    throws SAXException
  {
    startElement("", paramString, "", EMPTY_ATTS);
  }

  public void endElement(String paramString1, String paramString2)
    throws SAXException
  {
    endElement(paramString1, paramString2, "");
  }

  public void endElement(String paramString)
    throws SAXException
  {
    endElement("", paramString, "");
  }

  public void emptyElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    startElement(paramString1, paramString2, paramString3, paramAttributes);
    endElement(paramString1, paramString2, paramString3);
  }

  public void emptyElement(String paramString1, String paramString2)
    throws SAXException
  {
    emptyElement(paramString1, paramString2, "", EMPTY_ATTS);
  }

  public void emptyElement(String paramString)
    throws SAXException
  {
    emptyElement("", paramString, "", EMPTY_ATTS);
  }

  public void dataElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes, String paramString4)
    throws SAXException
  {
    startElement(paramString1, paramString2, paramString3, paramAttributes);
    characters(paramString4);
    endElement(paramString1, paramString2, paramString3);
  }

  public void dataElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    dataElement(paramString1, paramString2, "", EMPTY_ATTS, paramString3);
  }

  public void dataElement(String paramString1, String paramString2)
    throws SAXException
  {
    dataElement("", paramString1, "", EMPTY_ATTS, paramString2);
  }

  public void characters(String paramString)
    throws SAXException
  {
    char[] arrayOfChar = paramString.toCharArray();
    characters(arrayOfChar, 0, arrayOfChar.length);
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.XMLFilterBase
 * JD-Core Version:    0.6.0
 */