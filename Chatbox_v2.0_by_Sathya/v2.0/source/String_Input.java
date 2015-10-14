/*
 * This class will receive input string from the user
 * and sends to parse.java for parsing the sting.This 
 * continues until user enters BYE.
 */
import java.io.*;
 
class String_Input
{
   
public static void main(String args[])
   {
      String user_input = null;
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("********Please type BYE to end the conversation*********");
      System.out.println("Hello, This is Dr.Tom.");
      Parse obj = new Parse();
      do
      {
    	   try {
            user_input = reader.readLine();
    	   }
    	   catch (IOException e) {
            e.printStackTrace();
    	   } 
    	   if(!user_input.equals("BYE")){
    		   obj.regular_expression(user_input);
    	   }
    	       	
    	}while(!user_input.equals("BYE"));
      System.out.println("Had a nice chat with you.\nThanks for sharing your thoughts.\nHave a good day\n");
   }   
      
   
}