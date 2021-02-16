// Traverse the tree, if the current node has 0 child or 2 children, do nothing
// Else, add it's lonely child's value to the result array
// Return the result array in the end
// Time: O(n), Space: O(n)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {

    }
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new ArrayList();
        traverse(root, res);
        return res;
    }

    public void traverse(TreeNode root, List<Integer> res) {
        if(root == null) {
            return ;
        }

        if(root.left == null && root.right != null) {
            res.add(root.right.val);
        }
        else if(root.left != null && root.right == null) {
            res.add(root.left.val);
        }

        traverse(root.left, res);
        traverse(root.right, res);
    }
}