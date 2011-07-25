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

public class SendMail extends Thread
{
  private InternetAddress[] toAddress;
  private InternetAddress fromAddress;
  private String SMTPServer = "smtp.163.com";
  private String username = "eatba";
  private String password = "05568925952";
  private String subject = "";
  private String content = "";
  private Vector attachment = new Vector();
  private boolean bHTML = true;
  private String[][] addressArray = { { "eatba@163.com", "false" }, { "xboss.wang@gmail.com", "false" }, { "eatba.com@gmail.com", "false" }, { "wongzy2000@sohu.com", "false" }, { "eatba.com@gmail.com", "false" }, { "wongzy2000@sohu.com", "false" } };

  public void run()
  {
    int i = 0;
    for (int j = 0; j < this.addressArray.length; j++)
    {
      if (!this.addressArray[j][1].equals("false"))
        continue;
      i = 1;
      break;
    }
    while (i != 0)
      try
      {
        sendEmail();
        Thread.sleep(2000L);
      }
      catch (Exception localException)
      {
        System.out.println(localException);
      }
  }

  public SendMail(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      this.fromAddress = new InternetAddress(paramString1);
      this.subject = paramString2;
      this.content = paramString3;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
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
        System.out.println("success");
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
 * Qualified Name:     tools.util.SendMail
 * JD-Core Version:    0.6.0
 */