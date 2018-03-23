import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class AddUsers {

	public static void main(String args[]) throws IOException{
		
		BufferedWriter output = new BufferedWriter(new FileWriter("username.txt", true));
		//PrintWriter writer = new PrintWriter("username.txt", "UTF-8");
		
		String UserName = JOptionPane.showInputDialog("Enter UserName: ");
		
		output.write(UserName + "\r\n");
		
		output.close();
		
		BufferedWriter output1 = new BufferedWriter(new FileWriter("password.txt", true));
		
		String UserInput1 = JOptionPane.showInputDialog("Enter Password: ");
		
		String Password = Encryption.encrypt(UserInput1);
		
		output1.write(Password + "\r\n");
		
		output1.close();
	}
	
}