// Given a binary tree root and an integer target, delete all the leaf nodes with value target.

// Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you can't).


// Find leaf nodes in the tree that has value equals the target, delete it!
// Traverse the tree with post-order. If the current node is a leaf and its value equals target, return null;
// Else, return the current node with new left and right
// Base Case: When the current node is null, just return it.
// Time: O(n), Space: O(n)
class Solution {
    public static void main(String[] args) {

    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) {
            return null;
        }

        // At current node
        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);

        root.left = left;
        root.right = right;

        if(root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }
}