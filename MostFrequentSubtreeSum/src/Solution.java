import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
- Get the sum of subtree from each node, store that into HashMap<Sum, Frequency>, and update the maxFreq global variable
        - Iterate the map, if the freq of that entry equals maxFreq, add to result array
        - Time: O(N), Space: O(N)
 */
class Solution {

    int maxFreq;
    List<Integer> list;
    public int[] findFrequentTreeSum(TreeNode root) {
        maxFreq = 0;
        HashMap<Integer, Integer> map = new HashMap();
        list = new ArrayList();

        traverse(root, map);

        int [] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int traverse(TreeNode root, HashMap<Integer, Integer> map) {
        if(root == null) {
            return 0;
        }

        int sum = traverse(root.left, map) + root.val + traverse(root.right, map);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        int curFreq = map.get(sum);
        if(curFreq > maxFreq) {
            list.clear();
            list.add(sum);
        }
        else if(curFreq == maxFreq) {
            list.add(sum);
        }

        maxFreq = Math.max(maxFreq, curFreq);

        return sum;
    }
}