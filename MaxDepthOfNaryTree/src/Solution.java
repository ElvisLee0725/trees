// Given a n-ary tree, find its maximum depth.
// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
// Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

// DFS
// Use a global variable to store the max depth
// Create a dfs function starts with the current level 1
// At each level, update the global max depth if there is a new depth found
// Iterate each child node and call dfs with depth + 1
// Edge Case: root is null, return 0
// Time: O(n), Space: O(n)

import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        Node one = new Node(1, new ArrayList());
        Node two = new Node(1, new ArrayList());
        Node three = new Node(1, new ArrayList());
        Node four = new Node(1, new ArrayList());
        Node five = new Node(1, new ArrayList());
        Node six = new Node(1, new ArrayList());
        one.children.add(three);
        one.children.add(two);
        one.children.add(four);
        three.children.add(five);
        three.children.add(six);
        System.out.print(new Solution().maxDepth(one));
    }

    int maxDepth = 0;
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        dfs(root, 1);
        return maxDepth;
    }

    public void dfs(Node root, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        for(Node child : root.children) {
            dfs(child, depth + 1);
        }
    }
}