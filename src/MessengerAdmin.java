import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MessengerAdmin{

	public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		Properties prop = new Properties();
		System.out.println(System.getProperty("user.dir"));
		File file = new File(System.getProperty("user.dir") + "\\" + "config.properties");
		prop.load(new FileInputStream("config.properties"));
        boolean exists = file.exists();
        if (!exists ){
        	System.out.println("doesnt exist");
        	ifexist();
			
        } else {
        	System.out.println("exists");
        	String HostName = prop.getProperty("hostname");
        	System.out.println("Getting resource");
        	URL URL = MessengerAdmin.class.getResource("thinking.png");
        	System.out.println("Got it from: " + URL);
        	String[] buttons = { "Yes", "No" }; 
        	ImageIcon icon = new ImageIcon(URL, "MessageBox Icon");
        	
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
		URL URL = MessengerAdmin.class.getResource("iron_man.png");
    	ImageIcon icon = new ImageIcon(URL, "MessageBox Icon");
    	
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
			URL URL1 = MessengerAdmin.class.getResource("thinking.png");
        	ImageIcon icon1 = new ImageIcon(URL1, "MessageBox Icon");
        	
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
    	
		URL URL = MessengerAdmin.class.getResource("iron_man.png");
    	ImageIcon icon = new ImageIcon(URL, "MessageBox Icon");
    	
    	Object outputline = JOptionPane.showInputDialog (null, "Please Enter Message Text: ", "Message", JOptionPane.PLAIN_MESSAGE, icon, null, null);
    	
    	String outputLine = (String)outputline;
    	
		if(outputLine == null || outputLine.length() == 0){
			
			return;
			
		}
		String username = "MarkTHarris";
		try {
			
			Socket = new Socket(HostName, PortNumber);
	        PrintWriter out = new PrintWriter(Socket.getOutputStream(), true);
	        String computername = InetAddress.getLocalHost().getHostName();
	        out.println(computername);
	        out.println(outputLine);
	        out.println(username);
	        
		} catch (UnknownHostException e ){
			URL URL1 = MessengerAdmin.class.getResource("thinking.png");
        	ImageIcon icon1 = new ImageIcon(URL1, "MessageBox Icon");
        	String[] buttons1 = { "Ok" }; 
        	int returnValue = JOptionPane.showOptionDialog(null, "Host can't be found (Is Name correct?) \n \n By Lachlan Stevens", "Warning",
			        JOptionPane.WARNING_MESSAGE, 0, icon1, buttons1, buttons1[0]);
			
			ifexist();
			
		} catch (ConnectException e ){
			
			URL URL1 = MessengerAdmin.class.getResource("thinking.png");
        	ImageIcon icon1 = new ImageIcon(URL1, "MessageBox Icon");
        	String[] buttons1 = { "Ok" }; 
        	int returnValue = JOptionPane.showOptionDialog(null, "Message can't be sent. (Are they running client?) \n \n By Lachlan Stevens", "Warning",
			        JOptionPane.WARNING_MESSAGE, 0, icon1, buttons1, buttons1[0]);
        	
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
	
	public static void reply(String HostName, String username) throws UnknownHostException{
		
		int PortNumber = 44455;
		
		Socket Socket;
		
		String[] buttons = { "Yes", "No" }; 
		URL URL = MessengerAdmin.class.getResource("iron_man.png");
    	ImageIcon icon = new ImageIcon(URL, "MessageBox Icon");
    	
    	Object outputline = JOptionPane.showInputDialog (null, "Please Enter Message Text: ", "Message", JOptionPane.PLAIN_MESSAGE, icon, null, null);
    	
    	String outputLine = (String)outputline;
		
		if(outputLine == null) {
			
			return;
			
		}
		String computername = InetAddress.getLocalHost().getHostName();
/*		if(computername == "STEVLACH_2012B"){
			username = "MarkTHarris";
		} else if (computername == "RILLNINA_2012B"){
			username = "Cooki3ZaWarrior";
		} else {
			username = System.getProperty("user.name");
		}
*/
		try {
			Logger logger = Logger.getLogger("MyLog");  
		    FileHandler fh;  

		    try {  
		    	System.out.println("In Admin");
		        // This block configure the logger with handler and formatter  
		    	logger.setUseParentHandlers(false);
		    	File file =new File("C:\\users\\" + System.getProperty("user.name") + "\\AppData\\Log.log");
		    	 
	    		//if file doesnt exists, then create it
	    		if(!file.exists()){
	    			file.createNewFile();
	    		}
		        fh = new FileHandler("C:\\users\\" + System.getProperty("user.name") + "\\AppData\\Log.log");  
		        logger.addHandler(fh);
		        SimpleFormatter formatter = new SimpleFormatter();  
		        fh.setFormatter(formatter);  

		        // the following statement is used to log any messages  
		        logger.info(computername + " " + username + " " + outputLine);

		    } catch (SecurityException e) {  
		        e.printStackTrace();  
		    } catch (IOException e) {  
		    	e.printStackTrace();
		    }  

			Socket = new Socket(HostName, PortNumber);
	        PrintWriter out = new PrintWriter(Socket.getOutputStream(), true);
	        out.println(computername);
	        out.println(outputLine);
	        out.println(username);
		} catch( Exception e ) {
			URL URL1 = MessengerAdmin.class.getResource("error.png");
			String[] buttons1 = { "Ok" };
			ImageIcon icon1 = new ImageIcon(URL1, "MessageBox Icon");
			int returnValue = JOptionPane.showOptionDialog(null, "User has signed off.", "User Offline",
			        JOptionPane.WARNING_MESSAGE, 0, icon1, buttons1, buttons1[0]);
            //e.printStackTrace();
		}
	
	}
	
	public static void sendInfo(String HostName){
		System.out.println("test123");
		int PortNumber = 44455;

		String 	outputLine = System.getProperty("user.name") + " " + System.getProperty("os.name") + " " + System.getProperty("os.version") + " " + System.getProperty("os.arch");
		
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
	
	public static void tasklist(String HostName){
		
		int PortNumber = 44455;
		String[] tasklist = TaskList.tasklist();
		String 	outputLine = "Running Processes are: \n" + tasklist[0] + "\n \n Amount of processes are: " + tasklist[1];
				
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
				  MessengerAdmin.class.getClassLoader().getResourceAsStream("config.properties");	  
	 
		  prop.load(inputStream);
		  filePath = prop.getProperty("json.filepath");
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
		return filePath;
	 
	  }
}