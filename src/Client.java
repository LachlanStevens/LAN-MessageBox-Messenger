import javax.swing.*;

import java.io.*;
import java.net.*;

public class Client {

	public static void s(String s){
		
		System.out.println(s);
		
	}
	
	public static void main(String args[]) throws UnknownHostException{
	
		int PortNumber = 5828;
		
		String HostName;
		
        HostName = JOptionPane.showInputDialog("Please Enter Name of computer: ");
		
		try (
	            Socket Socket = new Socket(HostName, PortNumber);
	            PrintWriter out = new PrintWriter(Socket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(
	                new InputStreamReader(Socket.getInputStream()));
	        ) {
	            BufferedReader stdIn =
	                new BufferedReader(new InputStreamReader(System.in));
	            String fromServer;
	            String fromUser;
	            
	            //while(true){
	            	
	            while ((fromServer = in.readLine()) != null) {
	            	
	                System.out.println("Server: " + fromServer);
	                
	                JOptionPane.showMessageDialog(null, fromServer, fromServer, JOptionPane.INFORMATION_MESSAGE);
	            	
	            }
	        } catch (UnknownHostException e) {
	            System.err.println("Don't know about host " + HostName);
	            System.exit(1);
	        } catch (IOException e) {
	            System.err.println("Couldn't get I/O for the connection to " +
	                HostName);
	            System.exit(1);
	        }
	}
	
}