import java.util.*;
// There are a total of n courses you have to take labelled from 0 to n - 1.
// Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.

// Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.

// If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

// Use a hashamp to create adjacency list <Course, List of courses need it as pre>
// Use an array to store the number of prerequisites needs for course i
// BFS:
// Use a queue to store all courses that has 0 prerequisites
// While queue is not empty, expand a course from it and store that course to the result array. Get the list of cur courses
// Iterate the list and reduce the number in pre[i] by 1. If it reaches 0, that course's pre is finished. So, we can add that course to queue.
// After the while loop. If the result array's size is less than numCourses, return []. Else, return result
// Time: O(n * (n + e)) n is number of courses, e is the edge number. Space: O(n+e)
class Solution {
    public static void main(String[] args) {
        int [][] prere = {{1,0},{2,0},{3,1},{3,2}};
        int [] res = new Solution().findOrder(4, prere);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] res = new int[numCourses];
        // Edge Case: prerequisite is empty
        if(prerequisites.length == 0) {
            for(int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
        }

        HashMap<Integer, List<Integer>> map = new HashMap();
        int [] pre = new int[numCourses];
        for(int [] a : prerequisites) {
            pre[a[0]]++;
            map.computeIfAbsent(a[1], x -> new ArrayList());
            map.get(a[1]).add(a[0]);
        }

        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < pre.length; i++) {
            if(pre[i] == 0) {
                q.offer(i);
            }
        }

        int idx = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            res[idx++] = cur;
            if(map.containsKey(cur)) {
                List<Integer> list = map.get(cur);
                for(int course : list) {
                    pre[course]--;
                    if(pre[course] == 0) {
                        q.offer(course);
                    }
                }
            }
        }

        return idx == numCourses ? res : new int[0];
    }
}
