// You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
//
// Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

// At each node, check if the current node's value is greater than val? If so, go to left subtree. Else, go to right subtree. Assign node's left and right to the recusion call. Then, return the node itself
// Base Case: When we reach null, this is the place for the inserted node. return the new node
// Time: O(logn), Space: O(logn)
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }

        if(root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}

