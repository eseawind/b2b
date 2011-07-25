package com.ahbay.mailMgr;

import java.io.PrintStream;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message.RecipientType;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class mail
{
  public String strTo = "";
  public String strFrom = "";
  public String strSubject = "";
  public String strText = "";
  public String strUsername = "";
  public String strPassword = "";
  public String strSmtp = "";
  public String strFilename = "";
  public boolean needAuth = false;
  private MimeMessage mimeMsg;
  private Session session;
  private Properties props;
  private Multipart mptMailContent;

  public void setStrTo(String paramString)
  {
    this.strTo = paramString;
  }

  public void setStrFrom(String paramString)
  {
    this.strFrom = paramString;
  }

  public void setStrSubject(String paramString)
  {
    this.strSubject = paramString;
  }

  public void setStrText(String paramString)
  {
    this.strText = paramString;
  }

  public void setStrUsername(String paramString)
  {
    this.strUsername = paramString;
  }

  public void setStrPassword(String paramString)
  {
    this.strPassword = paramString;
  }

  public void setStrSmtp(String paramString)
  {
    this.strSmtp = paramString;
  }

  public void setStrFilename(String paramString)
  {
    this.strFilename = paramString;
  }

  public boolean sendSimpleMail()
  {
    if (this.props == null)
      this.props = new Properties();
    if (!setSmtpHost())
      return false;
    if (!createMimeMessage())
      return false;
    if (!setNeedAuth())
      return false;
    if (!setMailBody())
      return false;
    try
    {
      this.mimeMsg.setFrom(new InternetAddress(this.strFrom));
      this.mimeMsg.setRecipient(Message.RecipientType.TO, new InternetAddress(this.strTo));
      this.mimeMsg.setSubject(this.strSubject);
      this.mimeMsg.setSentDate(new Date());
      this.mimeMsg.setContent(this.mptMailContent);
      this.mimeMsg.saveChanges();
      Transport localTransport = this.session.getTransport("smtp");
      if (this.needAuth)
        localTransport.connect((String)this.props.get("mail.smtp.host"), this.strUsername, this.strPassword);
      Transport.send(this.mimeMsg);
      localTransport.close();
    }
    catch (MessagingException localMessagingException)
    {
      System.err.println(localMessagingException.getMessage());
      return false;
    }
    return true;
  }

  public boolean setMailFileAffix()
  {
    try
    {
      MimeBodyPart localMimeBodyPart1 = new MimeBodyPart();
      FileDataSource localFileDataSource = new FileDataSource(this.strFilename);
      localMimeBodyPart1.setFileName(localFileDataSource.getName());
      localMimeBodyPart1.setDataHandler(new DataHandler(localFileDataSource));
      this.mptMailContent.addBodyPart(localMimeBodyPart1);
      MimeBodyPart localMimeBodyPart2 = new MimeBodyPart();
      DataHandler localDataHandler = new DataHandler("JavaMail附件测试", "text/plain;charset=gb2312");
      localMimeBodyPart2.setFileName("xxf.txt");
      localMimeBodyPart2.setDataHandler(localDataHandler);
      this.mptMailContent.addBodyPart(localMimeBodyPart2);
    }
    catch (Exception localException)
    {
      System.err.println("增加邮件附件：" + this.strFilename + "发生错误！" + localException);
      return false;
    }
    return true;
  }

  private boolean setSmtpHost()
  {
    this.props.put("mail.smtp.host", this.strSmtp);
    return true;
  }

  private boolean createMimeMessage()
  {
    try
    {
      this.session = Session.getDefaultInstance(this.props, null);
    }
    catch (Exception localException1)
    {
      System.err.println("获取邮件会话对象时发生错误！" + localException1);
      return false;
    }
    try
    {
      this.mimeMsg = new MimeMessage(this.session);
      this.mptMailContent = new MimeMultipart();
    }
    catch (Exception localException2)
    {
      System.err.println("创建MIME邮件对象失败！" + localException2);
      return false;
    }
    return true;
  }

  private boolean setNeedAuth()
  {
    if (this.needAuth)
      this.props.put("mail.smtp.auth", "true");
    else
      this.props.put("mail.smtp.auth", "false");
    return true;
  }

  private boolean setMailBody()
  {
    try
    {
      MimeBodyPart localMimeBodyPart = new MimeBodyPart();
      localMimeBodyPart.setContent("<meta http-equiv=Content-Type content=text/html; charset=gb2312>" + this.strText, "text/html;charset=GB2312");
      this.mptMailContent.addBodyPart(localMimeBodyPart);
    }
    catch (Exception localException)
    {
      System.err.println("设置邮件正文时发生错误！" + localException);
      return false;
    }
    return true;
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     com.ahbay.mailMgr.mail
 * JD-Core Version:    0.6.0
 */