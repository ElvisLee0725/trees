// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

// Recursion:
// Base Case: a. If root is null, return null. b. Else if root is p or q, return root (Found!)
// Get the left and right TreeNode from left and right child
// If both left and right TreeNode are not null, then we are sure current node is LCA, return it
// Return either left or right depending which one is not null

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Integer [] input = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = new Solution().buildTreeByLevel(input);

        TreeNode lcaNode = new Solution().lca(root, root.left, root.left.right);
        if(lcaNode != null) {
            System.out.print(lcaNode.val);
        }
        else {
            System.out.print("null");
        }
    }

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }
        else if(root == p || root == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    // Use a Queue<TreeNode> and initialize with the val at input index 0. Index set to 1
    // Expand from it and add its left and right child from input. Move index
    // If the value at current index is not null, add to the Queue
    // Keep doing it until index reached the end of input array

    public TreeNode buildTreeByLevel(Integer [] input) {
        if(input == null || input.length == 0) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList();
        TreeNode root = new TreeNode(input[0]);
        q.offer(root);
        int index = 1;
        while(index < input.length) {
            TreeNode cur = q.poll();
            cur.left = input[index] != null ? new TreeNode(input[index]) : null;
            if(input[index] != null) {
                q.offer(cur.left);
            }
            index++;

            cur.right = input[index] != null ? new TreeNode(input[index]) : null;
            if(input[index] != null) {
                q.offer(cur.right);
            }
            index++;
        }

        return root;
    }
}
