import java.io.*;  
import java.net.*;

public class MyClient 
{  
    public static void main(String[] args) 
    {  
        try
        {   
            String str = "", str2 = "";

            Socket s = new Socket("localhost",3333);  

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            while(!str.equals("stop"))
            {  
                str = br.readLine();  
                dout.writeUTF(str);  
                dout.flush();  
                str2 = din.readUTF();  
                System.out.println("Server says: "+str2);  
            }   

            dout.close();
            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
    }  
}  