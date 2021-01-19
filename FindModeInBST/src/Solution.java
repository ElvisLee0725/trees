import java.util.ArrayList;
import java.util.List;
// Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
// Assume a BST is defined as follows:
// The left subtree of a node contains only nodes with keys less than or equal to the node's key.
// The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
// Both the left and right subtrees must also be binary search trees.

// Solution:
// Since this is a BST, use in-order traverse can go from small to large
// At each node, if it's val equals to curNum, increase its freq by 1. If its freq is greater than the global max freq, clear and update result arraylist and global max freq with current node value. If freq eqauls to max freq, just add cur node val to the list
// Else, that means we are starting from a new value. Update the result arraylist if the freq equals to global freq and reset freq to 1
// Return values in the arraylist
class Solution {
    public static void main(String[] args) {

    }
    List<Integer> list = new ArrayList();
    Integer curNum = null;
    int freq = 0;
    int maxFreq = 1;
    public int[] findMode(TreeNode root) {
        traverse(root);

        int [] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void traverse(TreeNode root) {
        if(root == null) {
            return ;
        }
        traverse(root.left);
        if(curNum != null && root.val == curNum) {
            freq++;
            if(freq > maxFreq) {
                list.clear();
                list.add(root.val);
            }
            else if(freq == maxFreq) {
                list.add(root.val);
            }
            maxFreq = Math.max(freq, maxFreq);
        }
        else {
            freq = 1;
            if(freq == maxFreq) {
                list.add(root.val);
            }
            curNum = root.val;
        }
        traverse(root.right);
    }
}
