import java.io.*;  
import java.net.*;  

public class MyServer 
{

    public static void main(String[] args)
    {  
        try
        {  
            String str = "", str2 = "";

            ServerSocket ss = new ServerSocket(3333);  
            Socket s = ss.accept();//establishes connection 
            
            DataOutputStream dous = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

            /* String str = (String)dis.readUTF();  
            System.out.println("message = "+str);  
            ss.close(); */
            
            while(!str.equals("stop"))
            {  
                str = dis.readUTF();  
                System.out.println("client says: "+str);  
                str2 = rd.readLine();  
                dous.writeUTF(str2);  
                dous.flush();  
            } 
            
            dis.close();
            ss.close();
            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
    }  
}  