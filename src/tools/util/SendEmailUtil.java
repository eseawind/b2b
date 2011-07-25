package tools.util;

import java.io.PrintStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmailUtil
{
  private InternetAddress[] toAddress;
  private InternetAddress[] ccAddress;
  private InternetAddress[] bccAddress;
  private InternetAddress fromAddress;
  private InternetAddress[] replyTo;
  private String SMTPServer = "smtp.163.com";
  private String username = "";
  private String password = "";
  private String subject = "";
  private String content = "";
  private Vector attachment = new Vector();
  private boolean bHTML = true;
  private String[] eaddress;
  private String[][] addressArray;

  public SendEmailUtil(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    try
    {
      this.toAddress = InternetAddress.parse(paramString1);
      this.fromAddress = new InternetAddress(paramString2);
      this.username = paramString3;
      this.password = paramString4;
      this.subject = paramString5;
      this.content = paramString6;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public SendEmailUtil(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      this.eaddress = paramArrayOfString;
      this.fromAddress = new InternetAddress(paramString1);
      this.username = paramString2;
      this.password = paramString3;
      this.subject = paramString4;
      this.content = paramString5;
      String[][] arrayOfString = new String[this.eaddress.length][2];
      for (int i = 0; i < this.eaddress.length; i++)
      {
        arrayOfString[i][0] = paramArrayOfString[i];
        arrayOfString[i][1] = "false";
      }
      this.addressArray = arrayOfString;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void setSMTPServer(String paramString)
  {
    this.SMTPServer = paramString;
  }

  public void setAttachment(String paramString)
  {
    this.attachment = explore(paramString, ";");
  }

  public void setHTML(boolean paramBoolean)
  {
    this.bHTML = paramBoolean;
  }

  public void setReplyTo(String paramString)
  {
    try
    {
      this.replyTo = InternetAddress.parse(paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public Vector explore(String paramString1, String paramString2)
  {
    Vector localVector = new Vector();
    try
    {
      if (paramString1.length() > 0)
      {
        int i = paramString1.indexOf(paramString2);
        int j = 0;
        while (i != -1)
        {
          localVector.addElement(paramString1.substring(j, i));
          j = i + paramString2.length();
          i = paramString1.indexOf(paramString2, j);
        }
        localVector.addElement(paramString1.substring(j));
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localVector;
  }

  public String sendEmail()
    throws MessagingException
  {
    String str = getOneAddress();
    if (str != null)
    {
      this.toAddress = InternetAddress.parse(str);
      Properties localProperties = new Properties();
      localProperties.put("mail.smtp.host", this.SMTPServer);
      localProperties.put("mail.smtp.auth", "true");
      PopupAuthenticator localPopupAuthenticator = new PopupAuthenticator();
      PasswordAuthentication localPasswordAuthentication = localPopupAuthenticator.performCheck(this.username, this.password);
      Session localSession = Session.getInstance(localProperties, localPopupAuthenticator);
      try
      {
        MimeMessage localMimeMessage = new MimeMessage(localSession);
        localMimeMessage.setFrom(this.fromAddress);
        localMimeMessage.setRecipients(Message.RecipientType.TO, this.toAddress);
        if (this.ccAddress != null)
          localMimeMessage.setRecipients(Message.RecipientType.CC, this.ccAddress);
        if (this.bccAddress != null)
          localMimeMessage.setRecipients(Message.RecipientType.BCC, this.bccAddress);
        if (this.replyTo != null)
          localMimeMessage.setReplyTo(this.replyTo);
        localMimeMessage.setSubject(this.subject);
        localMimeMessage.setSentDate(new Date());
        MimeBodyPart localMimeBodyPart1;
        MimeMultipart localMimeMultipart;
        if (this.attachment.isEmpty())
        {
          if (!this.bHTML)
          {
            localMimeMessage.setText(this.content);
          }
          else
          {
            localMimeBodyPart1 = new MimeBodyPart();
            localMimeBodyPart1.setContent(this.content, "text/html; charset=gb2312");
            localMimeMultipart = new MimeMultipart();
            localMimeMultipart.addBodyPart(localMimeBodyPart1);
            localMimeMessage.setContent(localMimeMultipart);
          }
        }
        else
        {
          localMimeBodyPart1 = new MimeBodyPart();
          if (!this.bHTML)
            localMimeBodyPart1.setText(this.content);
          else
            localMimeBodyPart1.setContent(this.content, "text/html");
          localMimeMultipart = new MimeMultipart();
          localMimeMultipart.addBodyPart(localMimeBodyPart1);
          Enumeration localEnumeration = this.attachment.elements();
          while (localEnumeration.hasMoreElements())
          {
            MimeBodyPart localMimeBodyPart2 = new MimeBodyPart();
            FileDataSource localFileDataSource = new FileDataSource(localEnumeration.nextElement().toString());
            localMimeBodyPart2.setDataHandler(new DataHandler(localFileDataSource));
            localMimeBodyPart2.setFileName(localFileDataSource.getName());
            localMimeMultipart.addBodyPart(localMimeBodyPart2);
          }
          localMimeMessage.setContent(localMimeMultipart);
        }
        Transport.send(localMimeMessage);
        return "Success";
      }
      catch (Exception localException)
      {
        System.out.println("Error: " + localException.getMessage());
        localException.printStackTrace();
        return localException.getMessage();
      }
    }
    System.out.println("发送完毕");
    return "发送完毕";
  }

  public String sendHTMLEmail(String paramString)
    throws MessagingException
  {
    Properties localProperties = new Properties();
    localProperties.put("mail.smtp.host", this.SMTPServer);
    localProperties.put("mail.smtp.auth", "true");
    PopupAuthenticator localPopupAuthenticator = new PopupAuthenticator();
    PasswordAuthentication localPasswordAuthentication = localPopupAuthenticator.performCheck("eatba", "05568925952");
    Session localSession = Session.getInstance(localProperties, localPopupAuthenticator);
    try
    {
      MimeMessage localMimeMessage = new MimeMessage(localSession);
      localMimeMessage.setFrom(this.fromAddress);
      localMimeMessage.setRecipients(Message.RecipientType.TO, this.toAddress);
      if (this.ccAddress != null)
        localMimeMessage.setRecipients(Message.RecipientType.CC, this.ccAddress);
      if (this.bccAddress != null)
        localMimeMessage.setRecipients(Message.RecipientType.BCC, this.bccAddress);
      if (this.replyTo != null)
        localMimeMessage.setReplyTo(this.replyTo);
      localMimeMessage.setSubject(this.subject);
      localMimeMessage.setSentDate(new Date());
      MimeBodyPart localMimeBodyPart = new MimeBodyPart();
      localMimeBodyPart.setDataHandler(new DataHandler(new FileDataSource(paramString)));
      MimeMultipart localMimeMultipart = new MimeMultipart();
      localMimeMultipart.addBodyPart(localMimeBodyPart);
      Transport.send(localMimeMessage);
      return "Success";
    }
    catch (Exception localException)
    {return localException.getMessage();
    }
    
  }

  public String getOneAddress()
  {
    String str = null;
    for (int i = 0; i < this.addressArray.length; i++)
    {
      if (!this.addressArray[i][1].equals("false"))
        continue;
      str = this.addressArray[i][0];
      this.addressArray[i][1] = "true";
      if (isEmail(str))
        return str;
    }
    return str;
  }

  public void sendMailThreads(int paramInt)
  {
    try
    {
      Thread[] arrayOfThread = new Thread[paramInt];
      for (int i = 0; i < paramInt; i++)
        arrayOfThread[i] = new Thread(sendEmail());
      for (int i = 0; i < paramInt; i++)
        arrayOfThread[i].start();
    }
    catch (MessagingException localMessagingException)
    {
      localMessagingException.printStackTrace();
    }
  }

  public boolean isEmail(String paramString)
  {
    paramString = paramString.trim();
    String str = "\\w+(\\.\\w+)*@\\w+(\\.\\w+)+";
    return paramString.matches(str);
  }

  public class PopupAuthenticator extends Authenticator
  {
    String username = null;
    String password = null;

    public PopupAuthenticator()
    {
    }

    public PasswordAuthentication performCheck(String paramString1, String paramString2)
    {
      this.username = paramString1;
      this.password = paramString2;
      return getPasswordAuthentication();
    }

    protected PasswordAuthentication getPasswordAuthentication()
    {
      return new PasswordAuthentication(this.username, this.password);
    }
  }
}

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     tools.util.SendEmailUtil
 * JD-Core Version:    0.6.0
 */