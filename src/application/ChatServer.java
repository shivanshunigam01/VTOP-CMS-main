package application;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import chat.ClientHandler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/*
 * Title : ChatServer.java
 * Purpose : Main Chat Server
 * Created by: Devyansh Rajput
 */

@SuppressWarnings("serial")
public class ChatServer extends JFrame implements Runnable
{
	public final static int port=2003;
	public static Vector<ClientHandler> clientlist=new Vector<ClientHandler>();
	
	public ChatServer()
	{
		setSize(400,200);
		setTitle("VTOP-CMS: Chat Server");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.white);
		
		JLabel label=new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBackground(Color.white);
		label.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		label.setText("Active Users  : "+clientlist.size());
		getContentPane().add(label,BorderLayout.CENTER);
		ActionListener countuser=e->
		{
			label.setText("Active Users  : "+clientlist.size());
		};
		Timer timer=new Timer(1000,countuser);
		timer.start();
		this.setVisible(true);
	}
	
	public static void main(String args[])
	{
		ChatServer server=new ChatServer();
		Thread thread=new Thread(server);
		thread.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			@SuppressWarnings("resource")
			ServerSocket server=new ServerSocket(ChatServer.port);
			System.out.println("Server Started");
			while(true)
			{
				Socket socket=server.accept();
				
				ClientHandler client=new ClientHandler(socket);
				client.position=clientlist.size();
				clientlist.add(client);
				System.out.println("Active User  :"+clientlist.size());
				Thread thread=new Thread(client);
				thread.start();
			}
			
		}
		catch(BindException exp)
		{
			System.exit(0);
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
	}
}