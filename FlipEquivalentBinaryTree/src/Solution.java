// At each node, if flips tree1's left and right child can make it equals tree2, then that's good
// Otherwise, return false
// Traverse both tree. check:
// Case 1: Both are null, return true
// Case 2: If only one of them are null, return false
// Case 3: If their values are different, return false
// If their left child are not equal, tree1 goes left and tree2 goes right && tree1 goes right and tree2 goes left
// Else, both go to left and both go to right
// Time: O(n), Space: O(n)

class Solution {
    public static void main(String[] args) {

    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        else if(root1 == null || root2 == null) {
            return false;
        }
        else if(root1.val != root2.val) {
            return false;
        }


        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }
}
