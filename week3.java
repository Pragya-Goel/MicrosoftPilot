/************* WEEK3*************/

/*
 Talk:
 Assuming that the word from dictionary can occur multiple times in the string i.e 
 input dictionary: {"pear", "salmon", "foot", "footprints", "leave", "you", "sun","girl", "enjoy"}
 s1:"pearpear" is a possible input whose output should be true.
 
 
 Example:
 input dictionary: {"pear", "salmon", "foot", "footprints", "leave", "you", "sun","girl", "enjoy"}
 s1:""   true(empty string)
 s2:"salmonfoot"   true
 s3:"pearaleave"   false(a is an extra character)
 s4:"sungirlenjoy" true(concatinating more that two strings)
 s5:"you enjoy"    false(space included)  
   
 Implement:-
 Recursive call on string , generating word(each time by incrementing the index), 
 checking if it is present in the dictionary,
 if(present){
 recursive call on the substring(index+1)
 }
 else{
 index++
 } 
 */
 package Homework;
 

import java.util.HashSet;

public class week3 {

	public static boolean test(String s, HashSet<String> input) {
		return WordBreak(s, input);
	}
	public static boolean WordBreak(String s, HashSet<String> input) {
		if(s.length()==0) {
			return true;
		}
		else {
			int index=0;
			String word="";
			while(index<s.length()) {
				word+=s.charAt(index);
				if(input.contains(word)) {
					if(WordBreak(s.substring(index+1), input)) {
					return true;
					}
					else {
					index++;	
					}
				}
				else {
					index++;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		HashSet<String> input= new HashSet<>();
		input.add("pear");
		input.add("salmon");
		input.add("foot");
		input.add("footprints");
		input.add("leave");
		input.add("you");
		input.add("sun");
		input.add("girl");
		input.add("enjoy");

System.out.println(test("",input));
System.out.println(test("salmonfoot",input));
System.out.println(test("pearaleave",input));
System.out.println(test("sungirlenjoy",input));
System.out.println(test("you enjoy",input));
 
	}
}

/*Test
 input dictionary: {"pear", "salmon", "foot", "footprints", "leave", "you", "sun","girl", "enjoy"}
 s1:""   true(empty string)
 s2:"salmonfoot"   true
 s3:"pearaleave"   false(a is an extra character)
 s4:"sungirlenjoy" true(concatinating more that two strings)
 s5:"you enjoy"    false(space included)
 
 */


