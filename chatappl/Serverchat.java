package chatappl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Serverchat {
	ServerSocket server;
	Socket connection;
	DataInputStream dis;
	DataOutputStream dos;
	DataInputStream disi;
	public Serverchat() {
		try {
			server =new ServerSocket(2000, 1,InetAddress.getLocalHost());
			System.out.println("serverstarted .....!!!!!!!!!!!!!!!!");
			connection =server.accept();
			System.out.println("request recieved");
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public void talk() throws IOException {
		dis = new DataInputStream(connection.getInputStream());
		dos = new DataOutputStream(connection.getOutputStream());
		disi = new DataInputStream(System.in);
		while(true) {
			System.out.println("client :" +dis.readUTF());
			dos.writeUTF(disi.readLine());
		}
		
	}
	public static void main(String [] args) {
		
		Serverchat ch = new Serverchat();
		try {
			ch.talk();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
