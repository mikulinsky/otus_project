package otus.project.notificationService.notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import otus.project.notificationService.model.Notification;
import otus.project.notificationService.model.NotificationSystem;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailNotification extends NotificationSystems{

    private static final String FROM = "no-reply@asdf.com";
    @Value("${smtp.host}")
    private final String HOST = "localhost";

    private final Session session;

    public EmailNotification() {
        system = NotificationSystem.MAIL;
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", HOST);
        session = Session.getDefaultInstance(properties);
    }

    @Override
    protected void notifyUser(Notification notification) {
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(notification.getReceiver()));
            message.setText(notification.getMsg());

            Transport.send(message);
        }catch (MessagingException mex) {mex.printStackTrace();}
    }
}
