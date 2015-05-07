package com.ftpha.sqltake2;

/**
 * Created by Fernando on 2015-05-06.
 * Originally created as part of: SQLTake2
 * You will love this code and be awed by it's magnificence
 */

import android.util.EventLogTags;
import android.util.Log;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class emailerFT
{

    private static final String LOGTAG = "ftpha - sca c r ";

    public emailerFT() {
    }

    public static void sendTestEM(){

        String host="smtpout.secureserver.net";
        final String user="ft@ftpha.com";//change accordingly
        final String password="ls123456";//change accordingly

        String to="ft@ftpha.com";//change accordingly

        //Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");


        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("javatpoint");
            message.setText("This is simple program of sending email using JavaMail API");

            //send the message
            Transport.send(message);

            Log.i(LOGTAG,"message sent successfully...");

        }
        catch (Exception e) {
            e.printStackTrace();


        Log.i(LOGTAG,"La Cagada...");
        }
    }
}
//
//    public static void sendTestEM(){
//        String to = "ft@ftpha.com";//change accordingly
//        String from = "fmtoro@gmail.com";//change accordingly
//        String host = "localhost";//or IP address
//
//        //Get the session object
//        Properties properties = System.getProperties();
//        properties.setProperty("smtpout.secureserver.net", host);//mail.smtp.host
//        Session session = Session.getDefaultInstance(properties);
//
//        //compose the message
//        try{
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            message.setSubject("FT Ping");
//            message.setText("Hello, this is example of sending email  ");
//
//            // Send message
//            Transport.send(message);
//            //System.out.println("message sent successfully....");
//
//        }catch (MessagingException mex) {mex.printStackTrace();}
//    }
