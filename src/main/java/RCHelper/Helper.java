/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RCHelper;

import java.util.Random;

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
}
