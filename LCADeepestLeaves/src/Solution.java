// Find the max depth of the tree and the number of nodes with the max depth
// If the number of nodes with max depth is 1, that node is the target to return
// Else, return the lca of all those nodes
// => Use a HashSet<Integer> to store the values of nodes with max depth
// Run lca to find the lca of all those nodes in the hashset, and return it
// Time: O(n), Space: O(n)

import java.util.HashSet;

class Solution {
    HashSet<Integer> hs;
    int maxDepth;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        hs = new HashSet();
        maxDepth = 0;
        leavesWithMax(root, 0);
        return lca(root);
    }

    private void leavesWithMax(TreeNode root, int curDepth) {
        if(root == null) {
            return ;
        }

        if(root.left == null && root.right == null) {
            if(curDepth == maxDepth) {
                hs.add(root.val);
            }
            else if(curDepth > maxDepth) {
                maxDepth = curDepth;
                hs.clear();
                hs.add(root.val);
            }
        }
        leavesWithMax(root.left, curDepth+1);
        leavesWithMax(root.right, curDepth+1);
    }

    private TreeNode lca(TreeNode root) {
        if(root == null) {
            return null;
        }

        if(hs.contains(root.val)) {
            return root;
        }

        TreeNode left = lca(root.left);
        TreeNode right = lca(root.right);

        if(left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}