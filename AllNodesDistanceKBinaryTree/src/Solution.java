import java.util.*;

// Create adjacency list for each node and store in hash map <TreeNode, List of TreeNode neighbors>
// BFS:
// Start from target, generate all neighbors from current node into a queue and do not regenerate duplicate nodes
// If the current expand equals K, then all nodes in queue are the answer
// If all nodes are expanded before reaching K, return empty List
// Time: O(n), Space: O(n+e)
class Solution {
    public static void main(String[] args) {

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        List<Integer> res = new ArrayList();
        traverse(root, null, map);

        Queue<Integer> q = new LinkedList();
        q.offer(target.val);
        HashSet<Integer> hs = new HashSet();
        hs.add(target.val);
        while(!q.isEmpty()) {
            int size = q.size();
            if(K == 0) {
                while(!q.isEmpty()) {
                    res.add(q.poll());
                }
            }
            else {
                for(int i = 0; i < size; i++) {
                    int cur = q.poll();
                    for(Integer nei : map.get(cur)) {
                        if(!hs.contains(nei)) {
                            q.offer(nei);
                            hs.add(nei);
                        }
                    }
                }
                K--;
            }
        }
        return res;
    }

    public void traverse(TreeNode root, TreeNode parent, HashMap<Integer, List<Integer>> map) {
        if(root == null) {
            return ;
        }
        map.computeIfAbsent(root.val, x -> new ArrayList());
        // Add parent and child(s) into map
        if(parent != null) {
            map.get(root.val).add(parent.val);
        }
        if(root.left != null) {
            map.get(root.val).add(root.left.val);
        }
        if(root.right != null) {
            map.get(root.val).add(root.right.val);
        }

        traverse(root.left, root, map);
        traverse(root.right, root, map);
    }
}
