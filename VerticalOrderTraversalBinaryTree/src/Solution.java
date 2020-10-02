// Given a binary tree, return the vertical order traversal of its nodes values.
// For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
// Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
// If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
// Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

// Solution: BFS
// Use a custom class Node with x, y and val to record its position and value
// Create a minHeap and rewrite the comparator for x (small to big), y (big to small) and val (small to big)
// In-order traverse the tree and convert each TreeNode into Node and add to a minHeap
// BFS: Initialize a coorX variable of the top Node's x value. We use x coordinate as the level of BFS
// While minHeap is not empty, poll out a Node and check if the cur x value is different, if so, record the cur list and empty it, update coorX.
// Then, add the cur Node's value to list
// Don't forget to add the last list into result. Return the result lists

// Time: O(n), Space: O(n)

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = new Solution().createTree(arr);
        
        List<List<Integer>> res = new Solution().verticalTraversal(root);

        for(List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public class Node {
        int x;
        int y;
        int val;
        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }



    public TreeNode createTree(int [] arr) {
        int index = 0;
        Queue<TreeNode> q = new LinkedList();
        TreeNode root = new TreeNode(arr[index]);
        index++;
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(index < arr.length) {
                cur.left = new TreeNode(arr[index]);
                q.offer(cur.left);
                index++;
            }

            if(index < arr.length) {
                cur.right = new TreeNode(arr[index]);
                q.offer(cur.right);
                index++;
            }
        }

        return root;
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Node> minHeap = new PriorityQueue(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if(n1.x < n2.x) {
                    return -1;
                }
                else if(n1.x > n2.x) {
                    return 1;
                }
                else{
                    if(n1.y < n2.y) {
                        return 1;
                    }
                    else if(n1.y > n2.y) {
                        return -1;
                    }
                    else {
                        if(n1.val < n2.val) {
                            return 1;
                        }
                        else if(n1.val > n2.val) {
                            return -1;
                        }
                    }
                }
                return 0;
            }
        });

        traverse(root, 0, 0, minHeap);

        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        int coorX = minHeap.peek().x;
        while(!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            if(coorX != cur.x) {
                res.add(new ArrayList(list));
                list.clear();
                coorX = cur.x;
            }
            list.add(cur.val);
        }
        res.add(list);

        return res;
    }

    public void traverse(TreeNode root, int x, int y, PriorityQueue<Node> minHeap) {
        if(root == null) {
            return ;
        }
        traverse(root.left, x-1, y-1, minHeap);
        minHeap.offer(new Node(x, y, root.val));
        traverse(root.right, x+1, y-1, minHeap);
    }
}
