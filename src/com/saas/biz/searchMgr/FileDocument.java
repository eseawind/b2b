package com.saas.biz.searchMgr;

import java.io.FileNotFoundException;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;

public class FileDocument
{
  public static Document Document(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws FileNotFoundException
  {
    Document localDocument = new Document();
    localDocument.add(new Field("rage", paramString1, Field.Store.YES, Field.Index.TOKENIZED));
    localDocument.add(new Field("id", paramString2, Field.Store.YES, Field.Index.TOKENIZED));
    localDocument.add(new Field("title", paramString3, Field.Store.YES, Field.Index.TOKENIZED));
    localDocument.add(new Field("contents", paramString4, Field.Store.YES, Field.Index.TOKENIZED));
    localDocument.add(new Field("publisher", paramString5, Field.Store.YES, Field.Index.TOKENIZED));
    localDocument.add(new Field("publish_date", paramString6, Field.Store.YES, Field.Index.TOKENIZED));
    return localDocument;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.saas.biz.searchMgr.FileDocument
 * JD-Core Version:    0.6.0
 */