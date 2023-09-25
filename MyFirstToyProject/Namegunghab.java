package practice;

import java.util.Scanner;

public class Namegunghab {
	
	static final String[] CHO = {"2", "4", "2", "3", "6", "5", "4", 				
			"4", "8", "2", "4", "1", "3", "6", "4", "3", "4", "4", "3"};  			

	static final String[] JOONG = {"2","3","3","4","2","3","3","4","2","4",
			"5","3","3","2","4","5","3","3","1","2","1"};							

	static final String[] JONG = {"0","2","4","4","2","5","5","3","5","7","9","9",
			"7","9","9","8","4","4","6","2","4","1","3","4","3","4","4","3"};     	
	
	public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
	
			System.out.print("첫 번째 이름을 입력하세요 : ");            			 	
			String nam1 = sc.next();
	
			System.out.print("두 번째 이름을 입력하세요 : ");
			String nam2 = sc.next();
	
			char[] nameArray1 = nam1.toCharArray();								 
	        																	
	        char[] nameArray2 = nam2.toCharArray();
	
	        int maxLength = Math.max(nameArray1.length, nameArray2.length); 	
	
	        
	        System.out.println("----------------------");
	        
	        
	        StringBuilder s = new StringBuilder();								
	        
	        for (int i = 0; i < maxLength; i++) {
	            if (i < nameArray1.length) {
	                char c = nameArray1[i];										
	                
	                int choIndex = (c - 44032) / 588;							
	                int joongIndex = ((c - 44032) % 588) / 28;					
	                int jongIndex = (c - 44032) % 28;
	                
	                int choStroke = Integer.parseInt(CHO[choIndex]);			
	                int joongStroke = Integer.parseInt(JOONG[joongIndex]);
	                int jongStroke = Integer.parseInt(JONG[jongIndex]);
	                
	                int totalStroke = choStroke + joongStroke + jongStroke; 	
	                
	                s.append(totalStroke).append(" ");							
	            	}
	            
	            if (i < nameArray2.length) {									
	                char c = nameArray2[i];
	                
	                int choIndex = (c - 44032) / 588;
	                int joongIndex = ((c - 44032) % 588) / 28;
	                int jongIndex = (c - 44032) % 28;
	                
	                int choStroke = Integer.parseInt(CHO[choIndex]);
	                int joongStroke = Integer.parseInt(JOONG[joongIndex]);
	                int jongStroke = Integer.parseInt(JONG[jongIndex]);
	                
	                int totalStroke = choStroke + joongStroke + jongStroke;
	                
	                s.append(totalStroke).append(" ");
	            	}
	        
	        		}
	        
			        System.out.println(s.toString().trim());
			      
			        String[] strokes = s.toString().trim().split(" ");					
			        
			        int[] numbers = new int[strokes.length];            				
			        for (int i = 0; i < strokes.length; i++) {							 
			        	numbers[i] = Integer.parseInt(strokes[i]);
			
			        }
			
			        while (numbers.length > 2) {										
			        	int[] newNumbers = new int[numbers.length - 1];
			        	for (int i = 1; i < numbers.length; i++) {
			
			                int mark = (numbers[i - 1] + numbers[i]);					
			                int remain = mark % 10;										
			                newNumbers[i - 1] = remain;									
			               
			                System.out.print(remain + " ");	
			
			              
			        	}
		
		        		System.out.println();
		        		numbers = newNumbers;								
		        		
		        }
		        System.out.println("----------------------");
		        System.out.println("♥ 둘의 궁합은 "  + numbers[0] + numbers[1] + "점 입니다 ♥");
        
    }

}