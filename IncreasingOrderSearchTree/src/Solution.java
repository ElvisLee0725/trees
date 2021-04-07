
// Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.

// Use 1 global TreeNodes cur and set it to null first.
// Traverse the BST with in-order
// At each node, set the right child to current node, moving cur to right child and set left child to null
// Return the new root (dummy's right child) at the end
// Time: O(n), Space: O(n)
class Solution {
    TreeNode cur = null;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        cur = dummy;
        inorder(root);
        return dummy.right;
    }

    private void inorder(TreeNode root) {
        if(root == null) {
            return ;
        }

        inorder(root.left);

        cur.right = root;
        cur = cur.right;
        cur.left = null;

        inorder(root.right);
    }
}
