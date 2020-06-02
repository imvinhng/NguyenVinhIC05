/*
 * ==========================================
 * CS211, Spring 2020, 6/2
 * Vinh T. Nguyen
 * In-Class Exercise #5 - getMin() and remove(target) method
 * getMin() method returns the minimum value of the search tree
 * remove(target) remove the value from the tree, or prints -1 if not found
 * ==========================================
 */
// Class for storing a single node of a binary tree of ints

public class IntTreeNode {
    public int data;
    public IntTreeNode left;
    public IntTreeNode right;
                
    // constructs a leaf node with given data
    public IntTreeNode(int data) {
        this(data, null, null);
    }
                        
    // constructs a branch node with given data, left subtree,
    // right subtree
    public IntTreeNode(int data, IntTreeNode left, 
                       IntTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
