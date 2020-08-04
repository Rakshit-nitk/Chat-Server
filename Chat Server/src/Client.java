
import java.io.*;
import java.net.*;

public class Client {
	public static void main(String args[]) throws Exception
	{
		Socket s = new Socket("localhost",6666);
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String msgin = "", msgout = "";
		while(!msgin.equals("stop"))
		{
			msgin = dis.readUTF();
			System.out.println("Server: " + msgin);
			msgout = br.readLine();
			dout.writeUTF(msgout);
			dout.flush();
		}
		dis.close();
		dout.close();
		s.close();
	}
}
