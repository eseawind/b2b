package tools.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail
{
  public void send(String paramString)
  {
    try
    {
      Properties localProperties = new Properties();
      localProperties.put("mail.smtp.auth", "true");
      localProperties.put("mail.smtp.host", "smtp.163.com");
      PopupAuthenticator localPopupAuthenticator = new PopupAuthenticator();
      localPopupAuthenticator.performCheck("eatba", "05568925952");
      Session localSession = Session.getInstance(localProperties, localPopupAuthenticator);
      MimeMessage localMimeMessage = new MimeMessage(localSession);
      localMimeMessage.setDescription("合肥吃吧");
      localMimeMessage.setFrom(new InternetAddress("eatba@163.com"));
      localMimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(paramString));
      String str1 = "邮件主题subject";
      String str2 = new String(str1.getBytes("GBK"));
      localMimeMessage.setSubject(str2);
      localMimeMessage.setSentDate(new Date());
      String str3 = "邮件正文";
      localMimeMessage.setText(new String(str3.getBytes("GBK")));
      Transport localTransport = localSession.getTransport("smtp");
      Transport.send(localMimeMessage);
    }
    catch (MessagingException localMessagingException)
    {
      localMessagingException.printStackTrace();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
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
 * Qualified Name:     tools.util.SendEmail
 * JD-Core Version:    0.6.0
 */