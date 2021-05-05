// Given the root of a binary tree and two integers p and q, return the distance between the nodes of value p and value q in the tree.
// The distance between two nodes is the number of edges on the path from one to the other.

// Edge Case: If p equals to q, then return 0 since they are the same node
// Distance Cases:
// a. p and q are parent and child
// b. p and q are not parent and child
// Find the lowest common ancenstor of p and q
// a. The LCA is either p or q, then they are parent and child, get distance from the parent to child
// b. The LCA is neither p nor q, get the sum of the distance between LCA and p and LCA and q
// Time: O(n), Space: O(n)
class Solution {
    public static void main(String[] args) {

    }
    public int findDistance(TreeNode root, int p, int q) {
        if(p == q) {
            return 0;
        }
        TreeNode lcaNode = findLCA(root, p, q);
        if(lcaNode.val == p) {
            return dist(lcaNode, q);
        }
        else if(lcaNode.val == q) {
            return dist(lcaNode, p);
        }

        return dist(lcaNode, p) + dist(lcaNode, q);
    }

    private TreeNode findLCA(TreeNode root, int p, int q) {
        if(root == null) {
            return null;
        }
        else if(root.val == p || root.val == q) {
            return root;
        }

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    private int dist(TreeNode root, int t) {
        if(root == null) {
            return 10001;
        }
        else if(root.val == t) {
            return 0;
        }

        int left = dist(root.left, t);
        int right = dist(root.right, t);

        return 1 + Math.min(left, right);
    }
}
