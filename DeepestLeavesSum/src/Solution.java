// Given a binary tree, return the sum of values of its deepest leaves.


// Recursion:
// Base Case: When reaching a leaf node. If its depth is greater than current max depth, update
// the current max depth and the sum to current leaf's value
// Else if its depth is equal to the current max depth, sum up the leaf's value
// Else, just return and do nothing
// Iterate the left and right child
// Time: O(n), Space: O(logn)

class Solution {
    int maxDepth = 0;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    public void helper(TreeNode root, int curDepth) {
        if(root == null) {
            return ;
        }
        if(root.left == null && root.right == null) {
            if(curDepth > maxDepth) {
                maxDepth = curDepth;
                sum = root.val;
            }
            else if(curDepth == maxDepth) {
                sum += root.val;
            }
            return ;
        }

        helper(root.left, curDepth + 1);
        helper(root.right, curDepth + 1);
    }
}
