// Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.
//Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.
//Notice that you can return the vertices in any order.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Goal: Get a minimum set of nodes that can reach all nodes in the graph
// Find all nodes that can not be reached, return them
// Create an boolean array of length n, arr[i] represents if node i can be reached from other node. Ex. arr[0] is true, means it can be reached from other
// Iterate the input edges and check at index 1, then mark arr[edges.get(1)] to true
// Iterate the arr and add those indexs that has value of false
// Time: O(n), Space: O(n)
class Solution {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(new Integer[]{0,1});
        List<Integer> list2 = Arrays.asList(new Integer[]{0,2});
        List<Integer> list3 = Arrays.asList(new Integer[]{2,5});
        List<Integer> list4 = Arrays.asList(new Integer[]{3,4});
        List<Integer> list5 = Arrays.asList(new Integer[]{4,2});
        List<List<Integer>> edges = new ArrayList();
        edges.add(list1);
        edges.add(list2);
        edges.add(list3);
        edges.add(list4);
        edges.add(list5);

        List<Integer> res = new Solution().findSmallestSetOfVertices(6, edges);
        System.out.print(res);
    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean [] arr = new boolean[n];
        for(List<Integer> list : edges) {
            arr[list.get(1)] = true;
        }
        List<Integer> res = new ArrayList();
        for(int i = 0; i < arr.length; i++) {
            if(!arr[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
