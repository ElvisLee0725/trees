// Given two binary search trees, return True if and only if there is a node in the first tree and a node in the
// second tree whose values sum up to a given integer target.

// For each node in root1, to traverse nodes in root2 and see if there is a node in root2 contains the val that sum up to target, if so, return true
// Base Case: root1 == null, return false
// If traverse function returns true, then return true
// Return the result of root.left and root.right traverse

// traverse function:
// Base Case: root == null, return false
// At each treenode in root2, check if curVal + root.val = target, return true
// Else if curVal + root.val > target, root goes to the left child. Else, root goes right


// Time: O(mlogn) m is the number of nodes in tree1, n is the number of nodes in tree2
class Solution {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(-10);
        root1.right = new TreeNode(10);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(7);
        root2.left.left = new TreeNode(0);
        root2.left.right = new TreeNode(2);
        System.out.print(new Solution().twoSumBSTs(root1, root2, 17));
    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null) {
            return false;
        }
        if(traverse(root1.val, root2, target)){
            return true;
        }
        return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
    }

    public boolean traverse(int curVal, TreeNode root, int target) {
        if(root == null) {
            return false;
        }
        int sum = curVal + root.val;
        if(sum == target) {
            return true;
        }
        else if(sum > target) {
            return traverse(curVal, root.left, target);
        }
        else {
            return traverse(curVal, root.right, target);
        }
    }

}

