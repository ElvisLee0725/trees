// Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].

// BST: All left subtree is smaller then parent node, all right subtrees is greater than parent node
// In-order traverse: traverse from low to high and check if cur node is within range. If so, sum it up
// Time: O(n)
// Optimize: If cur node's value is less than low, no need to traverse left subtree
// If cur node's value is greater than high, no need to traverse right subtress

class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root, low, high);
        return sum;
    }

    public void traverse(TreeNode root, int low, int high) {
        if(root == null) {
            return ;
        }
        if(root.val > low) {
            traverse(root.left, low, high);
        }
        if(root.val <= high && root.val >= low) {
            sum += root.val;
        }
        if(root.val < high) {
            traverse(root.right, low, high);
        }
    }
}
