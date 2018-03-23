import java.io.*;
import java.util.*;

public class Login {

	public static void main(String args[]) throws FileNotFoundException{
		
		File usernamefile = new File("username.txt");
		String username = "stevlach";
		int i = countWord(username, usernamefile);
		
		File passwordfile = new File("password.txt");
		String password = Encryption.encrypt("password");
		System.out.println(System.getProperty("user.dir"));
		int j = countWord(password, passwordfile);
		
		if (i != 0 && j != 0){
			
			System.out.println("Username and Password correct");
			
		} else {
			
			System.out.println("Incorrect");
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
}