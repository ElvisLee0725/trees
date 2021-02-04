// You are given the root of a binary tree where each node has a value 0 or 1.  Each root-to-leaf path
// represents a binary number starting with the most significant bit.  For example, if the path
// is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
// For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
// Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.


// Finding all Binary Numbers from root to leaf, store it into ArrayList
// Iterate the arraylist and translate each binary number to integer, sum each number up
// Return the sum up result
// Time: O(n), Space: O(n)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        String input = "01010";
        int n = input.charAt(0) - '0';
        for(int i = 1; i < input.length(); i++) {
            n = (n << 1) | input.charAt(i) - '0';
        }
        System.out.print(n);
    }
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        List<String> list = new ArrayList();
        findBN(root, -1, list);
        return sum;
    }

    public void findBN(TreeNode root, int cur, List<String> list) {
        // Base Case: current node is null, return
        if(root == null) {
            return ;
        }

        // If cur is -1, we are at the root of tree
        if(cur == -1) {
            cur = root.val;
        }
        else {
            cur = (cur << 1) | root.val;
        }

        if(root.left == null && root.right == null) {
            sum += cur;
        }

        findBN(root.left, cur, list);
        findBN(root.right, cur, list);
    }
}
