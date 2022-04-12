/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RCHelper;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sanda
 */
public class Validations {
    
    public static boolean passwordValidation(String password)
    {
         if(password.length()>=8)
        {
            Pattern small_letter=Pattern.compile("[a-z]");
            Pattern capital_letter=Pattern.compile("[A-Z]");
        Pattern digits=Pattern.compile("[0-9]");
        Pattern special=Pattern.compile("[!@#$%^&*()_?]");
        Matcher has_small_letter=small_letter.matcher(password);
        Matcher has_capital_letter=capital_letter.matcher(password);
        Matcher has_digit=digits.matcher(password);
        Matcher has_special=special.matcher(password);
   
          return (has_small_letter.find()&&has_capital_letter.find()&&has_digit.find()&&has_special.find());
        }
         return false;
   }
     public static boolean mobNoValidation(String mob)
    {
        char ch=mob.charAt(0);
        if(mob.length()>=10)
        {

            
            if(ch=='9'||ch=='8'||ch=='7'||ch=='6')
            {
                return true;
            }
        }
        
        return false;
    }
     
     
     public static boolean emailValidation(String email)
    {
        Pattern special=Pattern.compile("[@.]");
        Matcher has_special=special.matcher(email);
        return has_special.find();
    }
     
     
    
}
