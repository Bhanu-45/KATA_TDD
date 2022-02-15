package calculator;

public class StringCalculator {
	
	// whether the string can be converted into number or not
	public static boolean isNumber(String s) {
		
		if(s.length() == 0) {
			return false;
		}
		 for (int i = 0; i < s.length(); i++) {
	            if (Character.isDigit(
	                    s.charAt(i))
	                == false) {
	                
	                return false;
	            }
	        }
		 
		 return true;
	}
	
	// conerts the string to number.
	public static int convertToNumber(String s) {
		return Integer.parseInt(s);
	}
	
	
	public static int add(String s) {
		if(s.length() == 0) {
			return 0;
		}else {
			if(s.length() == 1 && Character.isDigit(s.charAt(0))){
				return Integer.parseInt(s);
			}else {
				
				if(s.length() > 1) {
					// default delimiter is comma
					String regex = ",";
					
					if(s.startsWith("//")) {
						String[] parts = s.split("\n", 2);
						regex = "";
						regex = parts[0].substring(2);
						s = parts[1];
					}
					
					// adding new line delimiter to regex.
					regex += "\n";
					regex = "[" + regex + "]" + "+";
					
					
					String[] nums = s.split(regex);
					
					/*
					 * for(String number : nums) { System.out.println(number); }
					 */
					
					// checks if string is valid.
					boolean isValid = true;
					
					for(String number : nums) {
						// used trim method to remove spaces.
						if( !isNumber(number.trim()) ) {
							isValid = false;
							break;
						}
					}
					
					if(isValid) {
						int sum = 0;
						
						for(String number : nums) {
							sum += convertToNumber(number.trim());
						}
						return sum;   
					}
					
				}

			}
		}
		
		return -1;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
