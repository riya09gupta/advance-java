package chatappl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Clientchat {
	Socket connection;
	DataInputStream dis;
	DataOutputStream dos;
	DataInputStream disi;
	public Clientchat() throws Exception, IOException {
		connection = new Socket(InetAddress.getLocalHost(),2000);
		System.out.println("request sent!!!!!!!!!!!!!!");
		
	}
	public void talk() throws IOException {
		dis=new DataInputStream(connection.getInputStream());
		dos = new DataOutputStream(connection.getOutputStream());
		disi =new DataInputStream(System.in);
		while(true) {
			dos.writeUTF(disi.readLine());
			System.out.println("server :" +dis.readUTF());
		}
		
	}
	public static void main(String [] args) {
		try {
			Clientchat cc = new Clientchat();
			cc.talk();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
