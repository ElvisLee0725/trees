// Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)

// If there are no nodes with an even-valued grandparent, return 0.

// Post-order solution:
// At each node, if it has grandparent, sum it's value up
// Then, use post-order to go to left and right child and sum up the returning values
// Return the sum at the end of each node
// Time: O(n), Space: O(n)

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        // Root node, parent node with even value, grandparent with even value
        return helper(root, false, false);
    }

    private int helper(TreeNode root, boolean parent, boolean grandparent) {
        if(root == null) {
            return 0;
        }

        int sum = 0;
        if(grandparent) {
            sum += root.val;
        }

        sum += helper(root.left, root.val % 2 == 0, parent);
        sum += helper(root.right, root.val % 2 == 0, parent);

        return sum;
    }
}
