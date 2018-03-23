import java.io.*;
import java.net.*;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DebugMessengerAdmin{

	public static void main(String args[]) throws FileNotFoundException, IOException{
		
		Properties prop = new Properties();
		System.out.println(System.getProperty("user.dir"));
		File file = new File(System.getProperty("user.dir") + "\\" + "config.properties");
		prop.load(new FileInputStream("config.properties"));
        boolean exists = file.exists();
        if (!exists ){

        	ifexist();
			
        } else {
        	
        	String HostName = prop.getProperty("hostname");
        	URL URL = DebugMessengerAdmin.class.getResource("thinking.png");
        	String[] buttons = { "Yes", "No" }; 
        	ImageIcon icon = new ImageIcon("Ironman.jpg", "MessageBox Icon");
        	
        	int returnValue = JOptionPane.showOptionDialog(null, "You have previously had:  " + HostName + " as the HostName; Would you like to change it?", "Warning",
			        JOptionPane.WARNING_MESSAGE, 0, icon, buttons, buttons[1]);
        	
			if(returnValue == 0){
        	
				ifexist();
				
			} else if(returnValue == JOptionPane.CLOSED_OPTION){
				
				return;
			
			} else {
				
				sendMessage();
				
			}
        }
        
	}
	
	public static int countWord(String word, File file) throws FileNotFoundException {
		int count = 0;
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
		    String nextToken = scanner.next();
		    if (nextToken.equalsIgnoreCase(word))
		    count++;
		}
		return count;
		}
	
	public static void ifexist() throws FileNotFoundException, IOException{
		
		Properties prop = new Properties();
		URL URL = DebugMessengerAdmin.class.getResource("iron_man.png");
    	ImageIcon icon = new ImageIcon("Ironman.jpg", "MessageBox Icon");
    	
    	Object outputline = JOptionPane.showInputDialog (null, "Enter hostname of computer: ", "Enter Computer", JOptionPane.PLAIN_MESSAGE, icon, null, null);
    	
    	String HostName = (String)outputline;

		if(HostName == null){
			return;
		}
		if(isReachableByPing(HostName) == true){
			
			HostName = HostName.toUpperCase();
			prop.setProperty("hostname", HostName);	
			
			prop.store(new FileOutputStream("config.properties"), null);
			
			sendMessage();
			
		} else {
			
			String[] buttons = { "Ok" }; 
			URL URL1 = DebugMessengerAdmin.class.getResource("thinking.png");
        	ImageIcon icon1 = new ImageIcon("Ironman.jpg", "MessageBox Icon");
        	
        	int returnValue = JOptionPane.showOptionDialog(null, "Host can't be found (Is Name correct?) \n \n By Lachlan Stevens", "Warning",
			        JOptionPane.WARNING_MESSAGE, 0, icon1, buttons, buttons[0]);
		
			ifexist();
			
		}
		
	}
	
	
	public static void sendMessage() throws FileNotFoundException, IOException{
		
		Properties prop = new Properties();
		
		prop.load(new FileInputStream("config.properties"));
		
		String HostName = prop.getProperty("hostname");
		System.out.println(HostName);
		
		int PortNumber = 44455;
		
		Socket Socket;
		
		String[] buttons = { "Yes", "No" }; 
    	
		URL URL = DebugMessengerAdmin.class.getResource("iron_man.png");
    	ImageIcon icon = new ImageIcon("Ironman.jpg", "MessageBox Icon");
    	
    	Object outputline = JOptionPane.showInputDialog (null, "Please Enter Message Text: ", "Message", JOptionPane.PLAIN_MESSAGE, icon, null, null);
    	
    	String outputLine = (String)outputline;
    	
		if(outputLine == null || outputLine.length() == 0){
			
			return;
			
		}
		
		try {
			
			Socket = new Socket(HostName, PortNumber);
	        PrintWriter out = new PrintWriter(Socket.getOutputStream(), true);
	        String computername = InetAddress.getLocalHost().getHostName();
	        out.println(computername);
	        out.println(outputLine);
	        
		} catch (UnknownHostException e ){
			URL URL1 = DebugMessengerAdmin.class.getResource("thinking.png");
        	ImageIcon icon1 = new ImageIcon("Ironman.jpg", "MessageBox Icon");
        	
        	int returnValue = JOptionPane.showOptionDialog(null, "Host can't be found (Is Name correct?) \n \n By Lachlan Stevens", "Warning",
			        JOptionPane.WARNING_MESSAGE, 0, icon1, buttons, buttons[0]);
			
			ifexist();
			
		}

		
	}
	
	public static boolean isReachableByPing(String host) {
	    try{
	            String cmd = "";
	            if(System.getProperty("os.name").startsWith("Windows")) {   
	                    // For Windows
	                    cmd = "ping -n 1 " + host;
	            } else {
	                    // For Linux and OSX
	                    cmd = "ping -c 1 " + host;
	            }

	            Process myProcess = Runtime.getRuntime().exec(cmd);
	            myProcess.waitFor();

	            if(myProcess.exitValue() == 0) {

	                    return true;
	            } else {

	                    return false;
	            }
	            

	    } catch( Exception e ) {

	            e.printStackTrace();
	            return false;
	    }
	    
	}
	
	public static void reply(String HostName){
		
		int PortNumber = 44455;
		
		Socket Socket;
		
		String[] buttons = { "Yes", "No" }; 
		URL URL = DebugMessengerAdmin.class.getResource("iron_man.png");
    	ImageIcon icon = new ImageIcon("Ironman.jpg", "MessageBox Icon");
    	
    	Object outputline = JOptionPane.showInputDialog (null, "Please Enter Message Text: ", "Message", JOptionPane.PLAIN_MESSAGE, icon, null, null);
    	
    	String outputLine = (String)outputline;
		
		if(outputLine == null) {
			
			return;
			
		}
		try {
			
			Socket = new Socket(HostName, PortNumber);
	        PrintWriter out = new PrintWriter(Socket.getOutputStream(), true);
	        String computername = InetAddress.getLocalHost().getHostName();
	        out.println(computername);
	        out.println(outputLine);
	    
		} catch( Exception e ) {
		
            e.printStackTrace();
		}
	
	}
	
	public static void sendInfo(String HostName){
		System.out.println("test123");
		int PortNumber = 44455;

		String 	outputLine = System.getProperty("user.name") + " " + System.getProperty("os.name") + " " + System.getProperty("os.arch");
		
		Socket Socket;
		
		try {
			Socket = new Socket(HostName, PortNumber);
			PrintWriter out = new PrintWriter(Socket.getOutputStream(), true);
			String computername = InetAddress.getLocalHost().getHostName();
			out.println(computername);
			out.println(outputLine);
			System.out.println(HostName);
			System.out.println(computername);
		} catch( Exception e ) {
			
			e.printStackTrace();
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
	
	public static String getFilePathToSave() {
		 
		Properties prop = new Properties();
		String filePath = "";
	 
		try {
	 
		  InputStream inputStream =
				  DebugMessengerAdmin.class.getClassLoader().getResourceAsStream("config.properties");	  
	 
		  prop.load(inputStream);
		  filePath = prop.getProperty("json.filepath");
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
		return filePath;
	 
	  }
}