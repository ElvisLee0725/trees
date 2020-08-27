// Method 1:
// Use a helper function with min and max value
// At each node, check if min and max are not null and if current node's val is smaller or greater than it?
// If so, return false since it is not a BST
// Recurse to the left and right child and set root.val to min and max
// Time: O(n), Space: O(logn)

// Method 2:
// Use a prev TreeNode to record the current node. In-order traverse and check if cur node's value is smaller or
// equal to prev's val. If so, return false
// Return the result from left and right child
// Time: O(n), Space: O(logn)

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(6);
        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;

        System.out.print(new Solution().isValidBSTInOrder(root));
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }
        else if((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    TreeNode prev = null;
    public boolean isValidBSTInOrder(TreeNode root) {
        if(root == null) {
            return true;
        }

        boolean left = isValidBSTInOrder(root.left);

        if(prev != null && root.val <= prev.val) {
            return false;
        }
        prev = root;

        boolean right = isValidBSTInOrder(root.right);

        return left && right;
    }
}
