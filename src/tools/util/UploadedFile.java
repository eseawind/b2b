package tools.util;

import java.io.File;

class UploadedFile
{
  private String dir;
  private String filename;
  private String type;

  UploadedFile(String paramString1, String paramString2, String paramString3)
  {
    this.dir = paramString1;
    this.filename = paramString2;
    this.type = paramString3;
  }

  public String getContentType()
  {
    return this.type;
  }

  public String getFilesystemName()
  {
    return this.filename;
  }

  public File getFile()
  {
    if ((this.dir == null) || (this.filename == null))
      return null;
    return new File(this.dir + File.separator + this.filename);
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.UploadedFile
 * JD-Core Version:    0.6.0
 */