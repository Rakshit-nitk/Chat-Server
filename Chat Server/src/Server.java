import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss = new ServerSocket(6666);
		Socket s = ss.accept();
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String msgin = "", msgout = "";
		while(!msgin.equals("stop"))
		{
			msgin = dis.readUTF();
			System.out.println("Client: " + msgin);
			msgout = br.readLine();
			dout.writeUTF(msgout);
			dout.flush();
		}
		dis.close();
		dout.close();
		s.close();
		ss.close();
	}
	
}
