package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	
	// whether the string can be converted into number or not
	private static boolean isNumber(String s) {
		boolean flag = false;
		if(s.length() == 0) {
			return flag;
		}
		
		if(s.length() == 1 && !Character.isDigit(s.charAt(0))) {
			return false;
		}
		
		if(s.charAt(0) == '-' || Character.isDigit(s.charAt(0))) {
			flag = true;
		}
		 for (int i = 1; i < s.length(); i++) {
	            if (Character.isDigit(
	                    s.charAt(i))
	                == false) {
	                
	                return false;
	            }
	            
	        }
		 
		 return flag;
	}
	
	
	// conerts the string to number.
	private static int convertToNumber(String s) {
		return Integer.parseInt(s);
	}
	
	
	// checks whether the string is negative or not.
	private static boolean isNegative(String s) {
		
		if(s.length() == 0 || Integer.parseInt(s) >= 0) {
			return false;
		}
		
		return true;
	}
	
	private static boolean getNegativesAndStringIsValid(String[] nums, List<Integer> negatives) {
		boolean isValid = true;
		for(String number : nums) {
			// used trim method to remove spaces.
			if( !isNumber(number.trim()) ) {
				isValid = false;
			}else {
				if(isNegative(number.trim())) {
					negatives.add(Integer.parseInt(number.trim()));
				}
			}

		}
		
		return isValid;
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
					
					
					
					// get the numbers using regex.
					String[] nums = s.split(regex);
					 
					
					// checks if string is valid.
					boolean isValid = true;
					
					// store the negatives
					List<Integer> negatives = new ArrayList<Integer>();
					
					// get negatives and know whether string is valid.
					isValid = getNegativesAndStringIsValid(nums, negatives);
					
					if(negatives.size() > 0) {
						throw new RuntimeException("negatives not allowed:" + negatives);
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

}
