import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Create a global index to represent the unique id. It increases each time when there is a new subtree
// The unique id of each subtree is "node_val,left_id,right_id"
// Use a HashMap<"node_val,left_id,right_id", unique id> to store each subtree and its uid
// Use a HashMap<unique id, frequency> to count the number of unique id shows up. Only when it's value is 2, we add the TreeNode to result list to prevent from adding more than 1 subtree into it.
// Time: O(n), Space: O(n)
class Solution {
    public static void main(String[] args) {

    }
    int index;
    HashMap<String, Integer> trees;
    HashMap<Integer, Integer> countSameTree;
    List<TreeNode> res;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        index = 1;  // This is the uid. Must start from 1, since 0 could mean null
        trees = new HashMap();
        countSameTree = new HashMap();
        res = new ArrayList();
        traverse(root);
        return res;
    }

    public int traverse(TreeNode root) {
        if(root == null) {
            return 0;
        }
        String serial = root.val + "," + traverse(root.left) + "," + traverse(root.right);
        if(!trees.containsKey(serial)) {
            trees.put(serial, index);
            countSameTree.put(index, 1);
            index++;
        }
        else {
            int uid = trees.get(serial);
            countSameTree.put(uid, countSameTree.get(uid) + 1);
            if(countSameTree.get(uid) == 2) {
                res.add(root);
            }
        }
        return trees.get(serial);
    }
}
