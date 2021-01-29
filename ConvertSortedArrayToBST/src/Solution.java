// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
// ***For testing purpose, please make sure for any node in the result, its left sub-tree should have equal
// or only one more node than its right sub-tree.

// Get the middle index, and set its value as the root
// Separate the array from left to mid - 1 and mid + 1 to right as the left and right child of root
// Base Case: If the length of array is 0 (left > right), return null


public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{1, 3, 4, 5, 8, 11};
        TreeNode root = new Solution().sortedArrayToBST(arr);
        bstTraverse(root);
    }

    public static void bstTraverse(TreeNode root) {
        if(root == null) {
            return ;
        }
        bstTraverse(root.left);
        System.out.print(root.key + " ");
        bstTraverse(root.right);
    }

    public TreeNode sortedArrayToBST(int[] num) {
        // Write your solution here
        return helper(num, 0, num.length-1);
    }

    public TreeNode helper(int [] num, int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        if((right - left) % 2 == 1) {
            mid++;
        }
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, left, mid - 1);
        node.right = helper(num, mid + 1, right);

        return node;
    }
}