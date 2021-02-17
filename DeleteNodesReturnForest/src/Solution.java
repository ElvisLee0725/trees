// Given the root of a binary tree, each node in the tree has a distinct value.
// After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
// Return the roots of the trees in the remaining forest.  You may return the result in any order.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// At first, if the root is not in to_delete, add root to list
// Traverse the tree with post-order, if the current node is in to_delete, get its left and right child to the result list if they are not null. Then, return null since the node is deleted
// If the node to delete is a leaf, then just return null
// If cur node is not in to delete array, get its new left and right leaf, then return it.
// Edge Case: to_delete's length is 0, just add root to list and return
// Time: O(n), Space: (n)
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList();
        if(to_delete == null || to_delete.length == 0) {
            res.add(root);
            return res;
        }

        HashSet<Integer> hs = new HashSet();
        for(int n : to_delete) {
            hs.add(n);
        }
        if(!hs.contains(root.val)) {
            res.add(root);
        }
        traverse(root, hs, res);
        return res;
    }

    public TreeNode traverse(TreeNode root, HashSet<Integer> hs, List<TreeNode> res) {
        if(root == null) {
            return null;
        }

        TreeNode left = traverse(root.left, hs, res);
        TreeNode right = traverse(root.right, hs, res);

        if(hs.contains(root.val)) {
            if(root.left == null && root.right == null) {
                return null;
            }
            if(left != null) {
                res.add(left);
            }
            if(right != null) {
                res.add(right);
            }
            return null;
        }

        root.left = left;
        root.right = right;

        return root;
    }
}