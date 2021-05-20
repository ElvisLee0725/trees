// Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
//
//As a reminder, a binary search tree is a tree that satisfies these constraints:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.

// Greater Tree: Each node's value is it's own value + the sum of all node's value greater than it
// Node 4: 4 + Greater Tree Node's value that's 1 greater than current node
// Traverse the BST using in-order so it goes from large to small
// Create a global prev variable and set it to Integer.MIN_VALUE
// At each node, set the node's value to curr value + prev, update the prev to the new node's value
// Finally, return root
// Time: O(n), Space: O(1)
class Solution {
    int prev;
    public TreeNode bstToGst(TreeNode root) {
        prev = Integer.MIN_VALUE;
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if(root == null) {
            return ;
        }

        traverse(root.right);

        if(prev != Integer.MIN_VALUE) {
            root.val += prev;
        }
        prev = root.val;

        traverse(root.left);
    }
}
