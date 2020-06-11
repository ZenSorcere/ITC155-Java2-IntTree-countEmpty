 //*******************************************************************
 // countEmpty - Ch17, Ex2, p1077
 //  
 // isEmpty -  A method that is added to the IntTree class.
 //  Write a method called countEmpty that returns the number of empty
 //    branches in a tree. An empty tree is considered to have one empty
 //    branch (the tree itself). For nonempty trees, your methods should
 //    count the total number of empty branches among the nodes of the tree.
 //    A leaf node has two empty branches, a node with one nonempty child
 //    has one empty branch, and a node with two nonempty childred has no
 //    empty branches.
 // 
 // By: Michael Gilson
 // Date: 6/11/2020
 //*******************************************************************

import java.util.*;


public class IntTree {
    private IntTreeNode overallRoot;

// Constructor to create Empty IntTree
    public IntTree() {
    	overallRoot = null;
    }
    
    // pre : max > 0
    // post: constructs a sequential tree with given number of
    //       nodes
    public IntTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    // post: returns a sequential tree with n as its root unless
    //       n is greater than max, in which case it returns an
    //       empty tree
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max),
                                   buildTree(2 * n + 1, max));
        }
    }
    

 
//*************************************************
    
    // Constructor for no parameters that redirects to private constructor
    public int countEmpty() {
    	return countEmpty(overallRoot);
    }
    
    // Constructor with IntTreeNode parameter
    private int countEmpty(IntTreeNode root) {
    	
    // If the tree is empty, then it returns 1, as per instructions
    	if (root == null) {
    		return 1;
    		
    // If a node has no left branch, it returns 1, then recursively goes down
    //   the right branch.
    	} else if (root.left == null) {
    		return 1 + countEmpty(root.right);
    
    // If a node has no right branch, it returns 1, then recursively goes down
    //   the left branch.
    	} else if (root.right == null) {
    		return 1 + countEmpty(root.left);
    		
    // Otherwise, it will recursively go down both the left and right branches.
    //   Eventually, it will encounter a branch that is null, and return the 
    //   "1" + any recursive numbers acquired, and returning the total of the 
    //   number of empty branches.
    	} else {
    		return countEmpty(root.left) + countEmpty(root.right);
    	}
    }

//*************************************************
    
    
    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints the tree contents using a preorder traversal
    // post: prints in preorder the tree with given root
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using a inorder traversal
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }
}