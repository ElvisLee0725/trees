import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// BFS
// Use a Queue with initial value of root TreeNode
// Expand from the queue with q.size() times, if the current node has left child, add to queue. If has right child, add to queue
// Keep doing until queue is empty.

// Time: O(n), Space: O(n)

public class Solution {
    public static void main(String[] args) {
        Integer [] input = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = new Solution().buildTreeByLevel(input);
        List<List<Integer>> res = new Solution().levelOrder(root);

        for(List list : res) {
            for(int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if(i != list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                list.add(cur.val);
                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(list);
        }
        return res;
    }

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
