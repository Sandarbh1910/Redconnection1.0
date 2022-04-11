/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RCMail;

import static com.sun.javafx.animation.TickCalculation.sub;
import static java.lang.ProcessBuilder.Redirect.to;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author sanda
 */
public class Mailer {
    
    final static String from="sandarbhoct2001@gmail.com";
    final static String password="sandarbhGOOGLEaccount@2021";
    
    
    public static boolean sendMail(String subject,String msg,String to)
    {System.out.println("to : "+to);
            try{
    Properties prop=new Properties();
    prop.put("mail.smtp.host","smtp.gmail.com");
    prop.put("mail.smtp.port","587");
    prop.put("mail.smtp.auth","true");
    prop.put("mail.smtp.starttls.enable","true");
    Session session=Session.getInstance(prop,new javax.mail.Authenticator(){
     protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
    });
   
     MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(subject);    
           message.setText(msg);  
           
           //send message  
           Transport.send(message);  
    
}catch(Exception ex){ex.printStackTrace();return false;}
        
        
        return true;
    }
    
    
    
    public static boolean broadcastMail(String subject,String msg,String[]address)
    {
         try{
    Properties prop=new Properties();
    prop.put("mail.smtp.host","smtp.gmail.com");
    prop.put("mail.smtp.port","587");
    prop.put("mail.smtp.auth","true");
    prop.put("mail.smtp.starttls.enable","true");
    Session session=Session.getInstance(prop,new javax.mail.Authenticator(){
     protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
    });
    InternetAddress to[]=new InternetAddress[address.length];
    for(int i=0;i<address.length;i++)
    {
        to[i]=new InternetAddress(address[i]);
    }
     MimeMessage message = new MimeMessage(session);    
           message.addRecipients(Message.RecipientType.TO,to);    
           message.setSubject(subject);    
           message.setText(msg);  
           
           //send message  
           Transport.send(message);  
    
}catch(Exception ex){ex.printStackTrace();return false;}
        
        
        return true;
    }
    
    
    
  
       
}
