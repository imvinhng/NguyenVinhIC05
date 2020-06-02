/*
 * ==========================================
 * CS211, Spring 2020, 6/2
 * Vinh T. Nguyen
 * In-Class Exercise #5 - getMin() and remove(target) method
 * getMin() method returns the minimum value of the search tree
 * remove(target) remove the value from the tree, or prints -1 if not found
 * ==========================================
 */
// This class stores int values in a binary search tree.
// Duplicates are allowed.  Each node of the tree has the binary
// search tree property.

import java.util.*;

public class IntSearchTree {
    private IntTreeNode overallRoot;

    // post: constructs an empty tree
    public IntSearchTree() {
        overallRoot = null;
    }

    // post: value is added to overall tree so as to preserve the
    //       binary search tree property
    public void add(int value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value is added to given tree so as to preserve the
    //       binary search tree property
    private IntTreeNode add(IntTreeNode root, int value) {
        if (root == null) {
            root = new IntTreeNode(value);
        } else if (value < root.data) {
            root.left = add(root.left, value);
        } else if (value > root.data) {
            root.right = add(root.right, value);
        }
        return root;
    }

    // post: returns true if overall tree contains value
    public boolean contains(int value) {
        return contains(overallRoot, value);
    }   

    // post: returns true if given tree contains value
    private boolean contains(IntTreeNode root, int value) {
        if (root == null) {
            return false;
        } else if (value == root.data) {
            return true;
        } else if (value < root.data) {
            return contains(root.left, value);
        } else {  // value > root.data
            return contains(root.right, value);
        }
    }
    
    // post: counts the nodes of the tree via inorder traversal
    //       and returns the count 
    public int countNodes() {
       return countNodes(overallRoot);
    }

    // post: returns the node count using an inorder traversal
    //       using the given root
    private int countNodes(IntTreeNode root) {
        if (root != null) {
            return 1 + countNodes(root.left) + countNodes(root.right);
        } else {
            return 0;
        }
    }

    // post: prints the tree contents using an inorder traversal
    public void print() {
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints contents of the tree with given root using an
    //       inorder traversal
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " " );
            printInorder(root.right);
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
    
    // getMin()
    public void getMin() {
      System.out.println("Min: "+ getMin(overallRoot));
    }
    
    private int getMin(IntTreeNode root) {
      if (root.left == null) 
         return root.data;
      return getMin(root.left);
    }
    
    // remove()
    public void remove(int target) {
      remove(overallRoot, target);
    }
    
    private void remove(IntTreeNode root, int target) {
      if (root == null) {
         return;
      } else if(root.data == target) {
         root.data = 0;
         return;
      } else if (root.data < target) {
         remove(root.right, target);
      } else if (root.data > target) {
         remove(root.left, target);
      }
      
    }
}