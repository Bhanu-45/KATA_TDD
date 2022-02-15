package calculator;

public class StringCalculator {
	
	
	public static boolean isNumber(String s) {
		 for (int i = 0; i < s.length(); i++) {
	            if (Character.isDigit(
	                    s.charAt(i))
	                == false) {
	                
	                return false;
	            }
	        }
		 
		 return true;
	}
	
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
					String[] nums = s.split(",");
					
					
					
					if(isNumber(nums[0]) && isNumber(nums[1])) {
						return convertToNumber(nums[0]) + convertToNumber(nums[1]);
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
