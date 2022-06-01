/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RCHelper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sanda
 */
public class Helper {
     public static int generateOTP()
     {
         Random rd=new Random();
         
         return rd.nextInt(100000);
     }
     
     
     
     public static void setMessage(HttpSession httpsess,String msg,String type)
     {
         httpsess.setAttribute("message",msg);
         httpsess.setAttribute("dispcol", type);
     }
     
     public static String todaysDate(String format)
     {
         SimpleDateFormat ft=new SimpleDateFormat(format);
         return ft.format(new Date());
     }
     
     public static String formatDate(String date)
     {
         SimpleDateFormat ft=new SimpleDateFormat("dd/MM/yyyy");
         return ft.format(date);
     }
}
