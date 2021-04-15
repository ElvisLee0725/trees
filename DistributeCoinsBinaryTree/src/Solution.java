// You are given the root of a binary tree with n nodes where each node in the tree has node.val coins and there are n coins total.
//
// In one move, we may choose two adjacent nodes and move one coin from one node to another. (A move may be from parent to child, or from child to parent.)
//
// Return the number of moves required to make every node have exactly one coin.

// Post-order:
// At leaf, if a node has 0 coin, it needs 1 move from parent.
// If a node has more than 1 coins, it needs node.val - 1 moves to distribute its coins
// From left and right, get the number of moves below current node
// Sum up the absolute value of left and right
// Return current node's val + left + right - 1 (left or right could have negative nubmer)
// Time: O(n), Space: O(n)
class Solution {
    int res;
    public int distributeCoins(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        res += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}