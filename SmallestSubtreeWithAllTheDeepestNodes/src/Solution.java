import java.util.ArrayList;
import java.util.List;

// Get all nodes that are the deepest and store them in a List<TreeNode>
// If the list has length one, return that only treenode
// Else, get the lowerset common ancestor of all the treenodes in the list!
// Time: O(n), Space: O(n)
class Solution {
    int maxDepth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        List<TreeNode> list = new ArrayList();
        maxDepth = 0;
        traverse(root, list, 0);
        if(list.size() == 1) {
            return list.get(0);
        }
        return lca(root, list);
    }

    private void traverse(TreeNode root, List<TreeNode> list, int curDepth) {
        if(root == null) {
            return ;
        }

        if(curDepth > maxDepth) {
            maxDepth = curDepth;
            list.clear();
            list.add(root);
        }
        else if(curDepth == maxDepth) {
            list.add(root);
        }

        traverse(root.left, list, curDepth + 1);
        traverse(root.right, list, curDepth + 1);
    }

    private TreeNode lca(TreeNode root, List<TreeNode> list) {
        if(root == null) {
            return null;
        }
        else if(list.contains(root)) {
            return root;
        }

        TreeNode left = lca(root.left, list);
        TreeNode right = lca(root.right, list);

        if(left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
