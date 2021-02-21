// DFS
// Start from node 0, run dfs to traverse each node and update the min level that current node can reach. If the current
// node's min level is not different from it's original value, this node and its parent's edge is critical connection!
// Use an array of length n to store the min level that node i can reach, initialize at -1
// At each node, update minLevel[cur Node] with its level, then check its children
// Case 1: child is parent, skip it
// Case 2: child has not been visited (minLevel[child] == -1), call dfs function and update minLevel if it returns smaller value
// Case 3: child has been visited, update min level if child's min level is smaller
// At the end of each node, check if its min level value is the same as it was at the beginning and that is not node 0? If so, add it to result  
// Return the current nodes min level, which is the min it can reach
// Time: O(n), Space: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static void main(String[] args) {

    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(List<Integer> list : connections) {
            int a = list.get(0);
            int b = list.get(1);
            map.computeIfAbsent(a, x -> new ArrayList());
            map.computeIfAbsent(b, x -> new ArrayList());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int [] minLevel = new int[n];
        Arrays.fill(minLevel, -1);
        List<List<Integer>> res = new ArrayList();
        dfs(0, -1, 0, minLevel, map, res);   // Give parent a dummy value -1
        return res;
    }

    public int dfs(int cur, int parent, int level, int [] minLevel, HashMap<Integer, List<Integer>> map,  List<List<Integer>> res) {
        minLevel[cur] = level;
        for(Integer child : map.get(cur)) {
            if(child == parent) {
                continue;
            }
            else if(minLevel[child] == -1) {
                minLevel[cur] = Math.min(minLevel[cur], dfs(child, cur, level+1, minLevel, map, res));
            }
            else {
                minLevel[cur] = Math.min(minLevel[cur], minLevel[child]);
            }
        }
        if(minLevel[cur] == level && cur != 0) {
            List<Integer> list = new ArrayList();
            list.add(parent);
            list.add(cur);
            res.add(list);
        }
        return minLevel[cur];
    }
}