// You are given all the nodes of an N-ary tree as an array of Node objects, where each node has a unique value.
//
//Return the root of the N-ary tree.
//
//Custom testing:
//
//An N-ary tree can be serialized as represented in its level order traversal where each group of children is separated by the null value (see examples).

// If we traverse the tree and child, each node will show up twice except the root node
// => Find the value that only shows once.
// XOR
// Iterate each node and its children and do XOR. In the end, the value left is the root's value
// Iterate list again to find that node to return


import java.util.List;

// Time: O(n), Space: O(1)
class Solution {

    public Node findRoot(List<Node> tree) {
        int xor = 0;
        for(Node n : tree) {
            xor ^= n.val;
            for(Node child : n.children) {
                xor ^= child.val;
            }
        }
        Node root = null;
        for(Node n : tree) {
            if(xor == n.val) {
                root = n;
                break;
            }
        }

        return root;
    }
}