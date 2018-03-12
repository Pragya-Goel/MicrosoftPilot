/*
 Talk:
 if T is null then a true is returned. (null is always a subtree)
 If S is null then a false is returned.
 Examples:
 T is null , S is non empty : true
 T is non empty, S is null : false
 T and S are null : true
 T is a similar to S subtree : true
 T and S have 1 node and the data of both the nodes is equal : true
 
 */

package Homework;

public class Week5 {
	// tree T is similar to a subtree of S or not
    public static boolean AreSame(TreeNode T, TreeNode S) {
    	if(T==null && S==null) {
    		return true;
    	}
    	if(T==null||S==null) {
    		return false;
    	}
    	return (T.data==S.data && AreSame(T.left,S.left) && AreSame(T.right,S.right));
    }
    public static boolean AreSubtree(TreeNode T, TreeNode S) {
    	if(T==null) {
    		return true;
    	}
    	if(S==null) {
    		return false;
    	}
    	if(AreSame(T,S)) {
    		return true;
    	}
    	return (AreSubtree(T,S.left) || AreSubtree(T,S.right));
    }
    
   
	public static void main(String[] args) {
		TreeNode S = new TreeNode(12);
		/* Tree S
                     12
	                /   \ 
		           18   34
                  /	 \ 	/ \
                 8   10 4  6
                            \
                             2                            
*/
		S.left= new TreeNode(18);
		S.right=new TreeNode(34);
		S.left.left=new TreeNode(8);
		S.left.right=new TreeNode(10);
		S.right.left=new TreeNode(4);
		S.right.right=new TreeNode(6);
		S.right.right.right= new TreeNode(2);

	TreeNode T =new TreeNode(34);
	T.left=new TreeNode(4);
	T.right=new TreeNode(6);
	T.right.right= new TreeNode(2);
	 /*
	             34
               	/   \
                4   6
                      \
                        2        
*/
	if(AreSubtree(T,S)) {
		System.out.println("T is a similar to the structure of S's substree");
	}
	else {
		System.out.println("T is not similar to S's substree");
	}
		
		
		
	}

}
