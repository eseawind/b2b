package tools.util;

import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

class DataUnformatFilter extends XMLFilterBase
{
  private static final Object SEEN_NOTHING = new Object();
  private static final Object SEEN_ELEMENT = new Object();
  private static final Object SEEN_DATA = new Object();
  private Object state = SEEN_NOTHING;
  private Stack stateStack = new Stack();
  private StringBuffer whitespace = new StringBuffer();

  public DataUnformatFilter()
  {
  }

  public DataUnformatFilter(XMLReader paramXMLReader)
  {
    super(paramXMLReader);
  }

  public void reset()
  {
    this.state = SEEN_NOTHING;
    this.stateStack = new Stack();
    this.whitespace = new StringBuffer();
  }

  public void startDocument()
    throws SAXException
  {
    reset();
    super.startDocument();
  }

  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    clearWhitespace();
    this.stateStack.push(SEEN_ELEMENT);
    this.state = SEEN_NOTHING;
    super.startElement(paramString1, paramString2, paramString3, paramAttributes);
  }

  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    if (this.state == SEEN_ELEMENT)
      clearWhitespace();
    else
      emitWhitespace();
    this.state = this.stateStack.pop();
    super.endElement(paramString1, paramString2, paramString3);
  }

  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    if (this.state != SEEN_DATA)
    {
      int i = paramInt1 + paramInt2;
      while (i-- > paramInt1)
        if (isXMLWhitespace(paramArrayOfChar[i]))
          continue;
      if (i < paramInt1)
      {
        saveWhitespace(paramArrayOfChar, paramInt1, paramInt2);
      }
      else
      {
        this.state = SEEN_DATA;
        emitWhitespace();
      }
    }
    if (this.state == SEEN_DATA)
      super.characters(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void ignorableWhitespace(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    emitWhitespace();
  }

  public void processingInstruction(String paramString1, String paramString2)
    throws SAXException
  {
    emitWhitespace();
    super.processingInstruction(paramString1, paramString2);
  }

  protected void saveWhitespace(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.whitespace.append(paramArrayOfChar, paramInt1, paramInt2);
  }

  protected void emitWhitespace()
    throws SAXException
  {
    char[] arrayOfChar = new char[this.whitespace.length()];
    if (this.whitespace.length() > 0)
    {
      this.whitespace.getChars(0, arrayOfChar.length, arrayOfChar, 0);
      this.whitespace.setLength(0);
      super.characters(arrayOfChar, 0, arrayOfChar.length);
    }
  }

  protected void clearWhitespace()
  {
    this.whitespace.setLength(0);
  }

  private boolean isXMLWhitespace(char paramChar)
  {
    return (paramChar == ' ') || (paramChar == '\t') || (paramChar == '\r') || (paramChar == '\n');
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.DataUnformatFilter
 * JD-Core Version:    0.6.0
 */