**********WEEK1************

//IMPLEMENT
package Homework;

import java.util.HashMap;
import java.util.Scanner;
import java.lang.*;

public class Week1 {
	// validating the string for null and spaces. 
	public static boolean ValidateString(String s) {
		if(s.isEmpty() || s.contains(" ")) {
			return false;
		}
		return true;
	}
	public static int LongestLengthSubstring(String s) {
		int maxlength=0,i=0,count,j;
		while(i<s.length()) {
			count=0;
			j=i;
			HashMap<Character,Boolean> visited=new HashMap<>();
			while(j<s.length() && !visited.containsKey(s.charAt(j))) {
				visited.put(s.charAt(j), true);
				count++;
				j++;
			}
			// maxlength keeps the maximum length substring of non repeating characters 
			if(count>maxlength) {
				maxlength=count;
			}
			i++;
		}
		return maxlength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		System.out.println("enter an input string");
		String input=s.nextLine();
		if(ValidateString(input)){
			System.out.print(" The length of the longest subtring with non repeating characters is: "+LongestLengthSubstring(input));
		}
		else {
			System.out.print("invalid string");
		}
	}

}
/*TEST
Input String : output
ababba       : 2
frffrtf      : 3 
gath aha     : invalid string (spaces are considered)
@ah.ala/     : 4 (special characters considered)
""           : invalid string (empty string considered)
AbcDa        : 5  (case sentivity considered)
*/
