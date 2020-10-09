// Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such
// that their sum is equal to the given target.

// Use a HashSet to store every tree node value traversed
// Use pre-order traverse.
// Base Case: 1. If root is null, return false
// 2. If hashset contains a value equals to k - root.val, return true
// At each level, record the value of current node in hashset

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Integer [] tree = new Integer[]{2, 3, 4, 5, 6, 7};
        TreeNode root = new Solution().buildTree(Arrays.asList(tree));
        new Solution().bstTraverse(root);

        System.out.print(new Solution().findTarget(root, 28));
    }

    public void bstTraverse(TreeNode root) {
        if(root == null) {
            return ;
        }
        bstTraverse(root.left);
        System.out.print(root.val + ", ");
        bstTraverse(root.right);
    }

    public TreeNode buildTree(List<Integer> list) {
        if(list.size() == 0) {
            return null;
        }
        int mid = list.size() / 2;
        TreeNode cur = new TreeNode(list.get(mid));
        cur.left = buildTree(list.subList(0, mid));
        cur.right = buildTree(list.subList(mid+1, list.size()));
        return cur;
    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hs = new HashSet();
        return traverse(root, k, hs);
    }

    public boolean traverse(TreeNode root, int k, HashSet<Integer> hs) {
        if(root == null) {
            return false;
        }
        else if(hs.contains(k - root.val)) {
            return true;
        }

        hs.add(root.val);
        return traverse(root.left, k, hs) || traverse(root.right, k, hs);
    }
}
