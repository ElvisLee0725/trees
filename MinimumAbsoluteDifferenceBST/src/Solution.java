// Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values
// of any two different nodes in the tree.

/*
- Keep track of a prev TreeNode
- Inorder Traverse:
    - If prev is null, assign current node to prev
    - Else, get the difference between current node and prev node's value. Update min diff if possible

Time: O(N), Space: O(N) call stack
*/
class Solution {
    TreeNode prev;
    int minDiff;
    public int getMinimumDifference(TreeNode root) {
        prev = null;
        minDiff = Integer.MAX_VALUE;

        helper(root);
        return minDiff;
    }

    public void helper(TreeNode root) {
        if(root == null) {
            return ;
        }

        helper(root.left);

        if(prev != null) {
            minDiff = Math.min(minDiff, root.val - prev.val);
        }
        prev = root;

        helper(root.right);
    }
}

