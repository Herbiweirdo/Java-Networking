import java.io.*;  
import java.net.*;
import java.util.Scanner;

public class MyClient 
{  
    public static void main(String[] args) 
    {  
        try
        {   
            String str;   
            Socket s=new Socket("localhost",6666);  
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            Scanner scan = new Scanner(System.in);
            
            System.out.println("Enter Message: ");
            str = scan.nextLine();
            scan.close();

            dout.writeUTF(str);  
            dout.flush();  
            dout.close();  
            s.close();  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
    }  
}  