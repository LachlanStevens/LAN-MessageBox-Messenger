import java.io.*;

public class Decryption {

	public static void main(String args[]) throws IOException{
		//System.out.println(Encryption.encrypt("test"));
		BufferedReader br = new BufferedReader(new FileReader("password.txt"));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append('\n');
	            line = br.readLine();
	        }
	        String everything = sb.toString();
	        String[] everythingarray = everything.split("\\n+");
	        int i = 0;
	        for(String s : everythingarray){
	        System.out.println(Encryption.decrypt(everythingarray[i]));
	        i++;
	        }
	    } finally {
		        br.close();
	    }
	    
	}
}