import java.util.Arrays;

// Find the largest number in current array and use it as the root value
// For every prefix subarray, goes to the left child
// For every suffix subarray, goes to the right child
// Base Case: If the input array's length is 0, return null
// Time: O(n^2), Space: O(n)
class Solution {
    public static void main(String[] args) {
        new Solution().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traverse(nums);
    }

    private TreeNode traverse(int [] arr) {
        if(arr.length == 0) {
            return null;
        }
        else if(arr.length == 1) {
            return new TreeNode(arr[0]);
        }

        int max = 0;
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = traverse(Arrays.copyOfRange(arr, 0, index));
        node.right = traverse(Arrays.copyOfRange(arr, index+1, arr.length));

        return node;
    }
}
