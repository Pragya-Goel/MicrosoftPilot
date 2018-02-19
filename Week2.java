package Homework;


/*******************WEEK2****************************/

/*Problem: triplets that sum to zero. 
  TALK:
Assuming unique elements in the array.
taking size of the array as input.

 EXAMPLES:
 array of size=0, output: no triplet 
 array of size<3 ([1,2]), output: no triplet  
size= 5  [1,2,3,-1,-2],    output: -2 -1 3
size=6   [5,-1,-4,-2,6],   output: -4 -1 5
                                   -4 -2 6
 size=4  [1,2,3,4],        output: no triplet                                   

BRUTE FORCE:
considering all the triplets.
complexity: O(n3)

OPTIMIZED SOLUTION AS BELOW 
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//IMPLEMENT

public class Week2 {
    
	 public static void TakeInput(int[] array, int size) {
	    	if(size==0) {
	    		return;
	    	}
	    	System.out.print("do");
	    	Scanner s=new Scanner(System.in);
	    	for(int i=0;i<size;i++) {
	    		array[i]=s.nextInt();
	    	}
	    }
	public static void SumOfTriplets(int []input, ArrayList<Variable> solution) {
    	int j,k;
    	for(int i=0;i<input.length-2;i++) {
    		j=i+1;
    		k=input.length-1;
    		while(j<k) {
    			int sum=input[j]+input[k]+input[i];
    			if(sum>0) {
    			k--;	
    			}
    			else if(sum<0) {
    				j++;
    			}
    			else {
    				Variable ans=new Variable();
    				ans.Add(input[i], input[j], input[k]);
    				solution.add(ans);
    				j++;
    				k--;
    			}
    		}
    		
    	}
    }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
        int input[]=new int[size];
        TakeInput(input,size);
        Arrays.sort(input);
        ArrayList<Variable> solution = new ArrayList<>();
        if(size>=3)
        SumOfTriplets(input,solution);
        if(solution.size()==0)
        	System.out.print("no triplet");
        for(int i=0;i<solution.size();i++) {
        	System.out.println(solution.get(i).x+" "+solution.get(i).y+" "+solution.get(i).z);
        }
        

	}

}
/* TEST
INPUT  :  OUTPUT
0          no triplet
2          no triplet
5 [1,2,3,-1,-2] : -2 -1 3
6 [5,-4,-1,-2,6] : -4 -2 6
                   -4 -1 5
4 [1,2,3,4]      : no triplet
*/
		   

