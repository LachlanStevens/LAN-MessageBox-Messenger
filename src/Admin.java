import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class Admin {

	public static String outputLine(String outputLine){
		
		outputLine = JOptionPane.showInputDialog("Please Enter Message Text ");
		
		return outputLine;
	}
	
	public static void main(String args[]){
		
		String inputLine, outputLine, hostname;
        
		
		String test = "1";
		if (test.length() != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
        

        int PortNumber = 5828;
        outputLine = JOptionPane.showInputDialog("Please Enter Message Text ");
        try ( 
                ServerSocket serverSocket = new ServerSocket(PortNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
        		
            ) {
           
                // Initiate conversation with client
                // KnockKnockProtocol kkp = new KnockKnockProtocol();
                // outputLine = kkp.processInput(null);
        	
                //outputLine = "test123";
        	
        		
                outputLine = outputLine(outputLine);
                
        		out.println(outputLine);
        		
        	
              	while ((inputLine = in.readLine()) != null) {
                	
                    //outputLine = kkp.processInput(inputLine);
                	
                    //outputLine = "test1234";
                    
                	out.println(outputLine);
                	
                	break;
                	
                	// if (outputLine.equals("Bye."))
                       // break;
                	
                	}  
                } catch (IOException e) {
        	
            System.out.println("Exception caught when trying to listen on port "
                + PortNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
		
	}
	
}