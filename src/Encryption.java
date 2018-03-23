import java.util.Arrays;

public class Encryption {

	public static void main(String args[]){

		System.out.println(encrypt("Passw0rd"));
		
		System.out.println(decrypt("386832322403462"));
		
	}
	
	public static String encrypt(String arg){
		
		String plain = arg;
		
		plain = plain.toLowerCase();
		
		String[] result = plain.split("(?!^)");
		
		for(int i = 0; i < result.length; i++){
			
			switch(result[i]){
			
			case "a" :{
				
				int test = 68;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("a", sum);
				
			}
			case "b" :{
			
				int test = 66;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("b", sum);
			}
			case "c" :{
			
				int test = 64;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("c", sum);
			}
			case "d" :{
			
				int test = 62;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("d", sum);
			}
			case "e" :{
			
				int test = 60;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("e", sum);
			}
			case "f" :{
				
				int test = 58;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("f", sum);
			}
			case "g" :{
			
				int test = 56;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("g", sum);
			}
			case "h" :{
			
				int test = 54;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("h", sum);
			}
			case "i" :{
				
				int test = 52;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("i", sum);
			}
			case "j" :{
			
				int test = 50;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("j", sum);
			}
			case "k" :{
				
				int test = 48;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("k", sum);
			}
			case "l" :{
			
				int test = 46;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("l", sum);
			}
			case "m" :{
			
				int test = 44;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("m", sum);
			}
			case "n" :{
			
				int test = 42;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("n", sum);
			}
			case "o" :{
			
				int test = 40;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("o", sum);
			}
			case "p" :{
			
				int test = 38;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("p", sum);
			}
			case "q" :{
			
				int test = 36;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("q", sum);
			}
			case "r" :{
			
				int test = 34;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("r", sum);
			}
			case "s" :{
			
				int test = 32;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("s", sum);
			}
			case "t" :{
			
				int test = 30;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("t", sum);
			}
			case "u" :{
			
				int test = 28;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("u", sum);
			}
			case "v" :{
			
				int test = 26;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("v", sum);
			}
			case "w" :{
			
				int test = 24;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("w", sum);
			}
			case "x" :{
			
				int test = 22;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("x", sum);
			}
			case "y" :{
			
				int test = 20;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("y", sum);
			}
			case "z" :{
			
				int test = 18;
				String sum = String.valueOf(test);
				result[i] = result[i].replaceFirst("z", sum);
			}
	
			default:{
				
				//Do Nothing
			}
			
			}
			
		}
		
		String output = Arrays.toString(result).replace(", ", "").replace("[", "").replace("]", "");
		
		return output;
	}

	public static String decrypt(String arg){
		//split string into two characters for use in decrypting
		
		String result[] = arg.split("(?<=\\G..)");
		//System.out.println(result[1]);
		for(int i = 0; i < result.length; i++){
			
			switch(result[i]){
		
				case "68" :{
						result[i] = result[i].replaceFirst("68", "a");
				}
				case "66" :{
						result[i] = result[i].replaceFirst("66", "b");
				}
				case "64" :{
						result[i] = result[i].replaceFirst("64", "c");
				}
				case "62" :{
						result[i] = result[i].replaceFirst("62", "d");
				}
				case "60" :{
						result[i] = result[i].replaceFirst("60", "e");
				}
				case "58" :{
						result[i] = result[i].replaceFirst("58", "f");
				}
				case "56" :{
						result[i] = result[i].replaceFirst("56", "g");
				}
				case "54" :{
						result[i] = result[i].replaceFirst("54", "h");
				}
				case "52" :{
						result[i] = result[i].replaceFirst("52", "i");
				}
				case "50" :{
						result[i] = result[i].replaceFirst("50", "j");
				}
				case "48" :{
						result[i] = result[i].replaceFirst("48", "k");
				}
				case "46" :{
						result[i] = result[i].replaceFirst("46", "l");
				}
				case "44" :{
						result[i] = result[i].replaceFirst("44", "m");
				}
				case "42" :{
						result[i] = result[i].replaceFirst("42", "n");
				}
				case "40" :{
						result[i] = result[i].replaceFirst("40", "o");
				}
				case "38" :{
						result[i] = result[i].replaceFirst("38", "p");
				}
				case "36" :{
						result[i] = result[i].replaceFirst("36", "q");
				}
				case "34" :{
						result[i] = result[i].replaceFirst("34", "r");
				}
				case "32" :{
						result[i] = result[i].replaceFirst("32", "s");
				}
				case "30" :{
						result[i] = result[i].replaceFirst("30", "t");
				}
				case "28" :{
						result[i] = result[i].replaceFirst("28", "u");
				}
				case "26" :{
						result[i] = result[i].replaceFirst("26", "v");
				}
				case "24" :{
						result[i] = result[i].replaceFirst("24", "w");
				}
				case "22" :{
						result[i] = result[i].replaceFirst("22", "x");
				}
				case "20" :{
						result[i] = result[i].replaceFirst("20", "y");
				}
				case "18" :{
						result[i] = result[i].replaceFirst("18", "z");
				}

				default:{
					
					
					
				}
				
			}
		}
		
		String output = Arrays.toString(result).replace(", ", "").replace("[", "").replace("]", "");
		
		return output;
	}
}