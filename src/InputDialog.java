import javax.swing.JOptionPane; 

public class InputDialog {

	public static String outputLine(String outputLine){
		

		
		return outputLine;
		
	}
	
	public static void main(String [] args){
		
		String outputLine = JOptionPane.showInputDialog("Please Enter Message Text ");
		Admin.outputLine(outputLine);

    }

}