/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RCMail;

import RCHelper.Helper;
import java.util.ArrayList;
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
    
    final static String from="demosandarbh@gmail.com";
    final static String password="ttvgadvdffhlinxm";
    
    
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
    
    
    
    public static boolean broadcastMail(String subject,String msg,ArrayList<String >address)
    {
         try{
             
             if(address==null||address.size()==0)
                 return false;
             
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
    InternetAddress to[]=new InternetAddress[address.size()];
    for(int i=0;i<address.size();i++)
    {
        to[i]=new InternetAddress(address.get(i));
    }
     MimeMessage message = new MimeMessage(session);    
           message.addRecipients(Message.RecipientType.BCC,to);    
           message.setSubject(subject);    
           message.setText(msg);  
           
           //send message  
           Transport.send(message);  
    
}catch(Exception ex){ex.printStackTrace();return false;}
        
        
        return true;
    }
    
    
     public static int sendOTP(String subject,String to)
    {System.out.println("to : "+to);
    int otp=-1;
            try{
    Properties prop=new Properties();
    prop.put("mail.smtp.host","smtp.gmail.com");
    prop.put("mail.smtp.port","587");
    prop.put("mail.smtp.auth","true");
    prop.put("mail.smtp.starttls.enable","true");
    Session session=Session.getInstance(prop,new javax.mail.Authenticator(){
     @Override
     protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
    });
   otp=Helper.generateOTP();
     MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.BCC,new InternetAddress(to));    
           message.setSubject(subject);    
           message.setText("Hello :) \nYour requested OTP is : "+otp);  
           
           //send message  
           Transport.send(message);  
    
}catch(Exception ex){ex.printStackTrace();return -1;}
        
        
        return otp;
    }
  
       
}
