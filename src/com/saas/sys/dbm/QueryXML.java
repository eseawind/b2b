package com.saas.sys.dbm;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class QueryXML
{
  private String xmlFilePath;
  private String tableName;
  private String queryName;

  public String getQueryTableXML()
  {
    String str1 = "";
    try
    {
      String str2 = this.xmlFilePath;
      DOMParser localDOMParser = new DOMParser();
      localDOMParser.parse(str2);
      Document localDocument = localDOMParser.getDocument();
      NodeList localNodeList1 = localDocument.getElementsByTagName("query");
      int i = 0;
      int j = 0;
      int k = 0;
      for (int m = 0; m < localNodeList1.getLength(); m++)
      {
        Node localNode1 = localNodeList1.item(m);
        for (Node localNode2 = localNode1.getFirstChild(); localNode2 != null; localNode2 = localNode2.getNextSibling())
        {
          if ((localNode2.getNodeType() != 1) || (!localNode2.getNodeName().equals("table")))
            continue;
          NodeList localNodeList2 = localNode1.getChildNodes();
          for (int n = 0; n < localNodeList2.getLength(); n++)
          {
            Node localNode3 = localNodeList2.item(n);
            for (Node localNode4 = localNode3.getFirstChild(); localNode4 != null; localNode4 = localNode4.getNextSibling())
            {
              if ((localNode4.getNodeType() != 1) || (!localNode4.getNodeName().equals("name")) || (i != 0) || (!localNode4.getFirstChild().getNodeValue().equalsIgnoreCase(this.tableName)))
                continue;
              i = 1;
              NodeList localNodeList3 = localNode3.getChildNodes();
              for (int i1 = 0; i1 < localNodeList3.getLength(); i1++)
              {
                Node localNode5 = localNodeList3.item(i1);
                for (Node localNode6 = localNode5.getFirstChild(); localNode6 != null; localNode6 = localNode6.getNextSibling())
                {
                  if ((localNode6.getNodeType() != 1) || (k != 0))
                    continue;
                  if ((localNode6.getNodeName().equals("qname")) && (localNode6.getFirstChild().getNodeValue().equalsIgnoreCase(this.queryName)))
                    j = 1;
                  if ((j == 0) || (k != 0) || (!localNode6.getNodeName().equals("qstring")))
                    continue;
                  str1 = localNode6.getFirstChild().getNodeValue();
                  k = 1;
                  return str1;
                }
                localNode5 = null;
              }
              localNodeList3 = null;
            }
            localNode3 = null;
          }
        }
        localNode1 = null;
      }
      localNodeList1 = null;
      localDocument = null;
      localDOMParser = null;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("解析saasQuery出错：" + localException);
    }
    return str1;
  }

  public void setXmlFilePath(String paramString)
  {
    this.xmlFilePath = paramString;
  }

  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }

  public void setQueryName(String paramString)
  {
    this.queryName = paramString;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.sys.dbm.QueryXML
 * JD-Core Version:    0.6.0
 */