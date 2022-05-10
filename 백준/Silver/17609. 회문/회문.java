import java.util.*;

public class Main {
	
	public static boolean innerFunc(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
		
		
	}
	
	public static int func(String s) {
		
		int len = s.length();

		boolean minus = true;
		
		for (int i = 0; i < len/2; i++) {
			
			if (s.charAt(i) != s.charAt(len-1-i)) {
				if (minus) {
					minus = false;
					
					if (s.charAt(i+1) == s.charAt(len-1-i)) {
						if (innerFunc(s, i+1, len-1-i)) return 1;
					} 
					if (s.charAt(i) == s.charAt(len-2-i)) {
						if (innerFunc(s, i, len-2-i)) return 1;
						else return 2;
					}
					if (s.charAt(i+1) != s.charAt(len-1-i) && s.charAt(i) != s.charAt(len-2-i))
						return 2;
					
				}
				else 
					return 2;
				
			}

		}
		
		if (!minus) return 1;
		else return 0;
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for (int i = 0; i < num; i++) {
			String s = sc.next();
			
			System.out.println(func(s));
			
		}
		
		
	}
	
}