// Given the root of a binary tree, find the maximum average value of any subtree of that tree.
//
//(A subtree of a tree is any node of that tree plus all its descendants. The average value of a tree is the sum of its values, divided by the number of nodes.)

// Post-order traverse:
// Use arr[2] to store arr[0] represents sum of values in subtree, arr[1] represents number of nodes in subtree
// At each node, get that value from left and right subtree, then, calculate the average
// If the average is the max, update it
// Return the max at the end
// Time: O(n), Space: O(n)
class Solution {
    double maxAvg;
    public double maximumAverageSubtree(TreeNode root) {
        maxAvg = 0.0;
        traverse(root);
        return maxAvg;
    }

    private int [] traverse(TreeNode root) {
        if(root == null) {
            return new int[2];
        }

        int [] left = traverse(root.left);
        int [] right = traverse(root.right);

        int sum = left[0] + right[0] + root.val;
        int numOfNodes = left[1] + right[1] + 1;
        double curAvg = (double) sum / (double) numOfNodes; // It's also okay to cast just one of them
        maxAvg = Math.max(maxAvg, curAvg);

        return new int[]{sum, numOfNodes};  // Return arr[current sum, current number of nodes]
    }
}
