// Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
//Note: A leaf is a node with no children.

// Traverse the whole tree, if a leaf node is reached, update the global min depth if possible
// Time: O(n), Space: O(n)
class Solution {
    int minDepth;
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        minDepth = Integer.MAX_VALUE;
        helper(root, 1);
        return minDepth;
    }
    public void helper(TreeNode root, int curDepth) {
        if(root == null) {
            return ;
        }
        // Find a leaf node
        if(root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, curDepth);
            return;
        }

        helper(root.left, curDepth + 1);
        helper(root.right, curDepth + 1);
    }
}
