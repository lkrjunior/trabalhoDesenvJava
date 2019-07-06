package com.bo;

import com.contracts.INotification;
import com.model.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class AlertEmailBO implements INotification
{
    private static final Logger logger = LoggerFactory.getLogger(AlertEmailBO.class);

    @Autowired
    private Environment env;

    private String host;
    private String socketFactoryPort;
    private String socketFactoryClass;
    private String auth;
    private String port;
    private String email;
    private String password;
    private String from;
    private String subject;

    private void LoadConfig()
    {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("alertmessage.properties"))
        {
            logger.info("Load Configuration for e-mail");
            Properties prop = new Properties();

            if (input == null)
            {
                System.out.println("Unable to find properties to e-mail");
                return;
            }

            prop.load(input);

            host = prop.getProperty("alertmessage.host");
            socketFactoryPort = prop.getProperty("alertmessage.socketFactory.port");
            socketFactoryClass = prop.getProperty("alertmessage.socketFactory.class");
            auth = prop.getProperty("alertmessage.auth");
            port = prop.getProperty("alertmessage.port");
            email = prop.getProperty("alertmessage.email");
            password = prop.getProperty("alertmessage.password");
            from = prop.getProperty("alertmessage.from");
            subject = prop.getProperty("alertmessage.subject");

        }
        catch (IOException ex)
        {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public Boolean Send(RulesBO rulesBO)
    {
        Group group = new Group();
        LoadConfig();

        try
        {
            group = rulesBO.GetGroupForAlert();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", socketFactoryPort);
        props.put("mail.smtp.socketFactory.class", socketFactoryClass);
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.port", port);

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator()
                {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(email, password);
                    }
                });

        session.setDebug(true);

        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));

            //separate by comma
            Address[] toUser = InternetAddress.parse(group.GetEmail());

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(subject);
            message.setText(rulesBO.GetMessage());

            Transport.send(message);

            logger.info("Email sent successfully!");

        }
        catch (MessagingException ex)
        {
            logger.error(ex.getMessage());
        }

        return true;
    }
}
