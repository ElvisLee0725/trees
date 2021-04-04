// Deep Copy: DFS
// Traverse the tree with post-order and at each node, use a HashMap to store <Node, NodeCopy> as we traverse the tree. Get NodeCopy's left, right and random from its left, right and random node.
//
// Base Case: If current node is null, return null. If the current node is already in HashMap, then it has been visited before, return its value (NodeCopy)
// Return the NodeCopy of current node
// Time: O(n), Space: O(n)

import java.util.HashMap;

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root == null) {
            return null;
        }

        HashMap<Node, NodeCopy> map = new HashMap();
        return dfs(root, map);
    }

    private NodeCopy dfs(Node root, HashMap<Node, NodeCopy> map) {
        if(root == null) {
            return null;
        }
        else if(map.containsKey(root)) {
            return map.get(root);
        }

        NodeCopy copied = new NodeCopy(root.val);
        map.put(root, copied);

        copied.left = dfs(root.left, map);
        copied.right = dfs(root.right, map);
        copied.random = dfs(root.random, map);

        return copied;
    }
}
