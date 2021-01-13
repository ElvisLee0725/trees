import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

    }

    // Use an ArrayList to store the average of each level of tree
    // Iterate each level with BFS:
    // Initiate a queue with the root node
    // While the queue is not empty, get the size of current queue, expand from the queue size times
    // Sum up the treenode's value and get average after the for loop
    // Check if the current treenode has left child add it to queue, do the same for the right child
    // After the tree is iterated level by level, turn the ArrayList to an int [] and return.
    // Time: O(n), Space: O(n)
    public int [] getTreeLevelAverage(TreeNode root) {
        if(root == null) {
            return new int [];
        }
        List<Integer> list = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                sum += cur.val;
                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
            list.add(sum / size);
        }
        int [] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
