import java.util.*;
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

// Use an array of length numCourses, courseWithPre[i] represents the number of pre for course i
// Count the num of prerequisite for each of the courses
// Use a HashMap<Integer, List<Integer>> to store <course, other courses that takes it as pre>
// BFS:
// Use a queue to store all classes that doesn't have prerequisite, record the number in countNoPre
// While the queue is not empty, expand a class and get all classes that takes cur class as prerequisite, decrease them by 1
// If that course's courseWithPre is down to 0, add it to the queue and countNoPre++ since we unlocked a course!
// Finally, return if countNoPre == numCourses
class Solution {
    public static void main(String[] args) {
        int [][] pre = {{1,0},{0,1}};
        System.out.print(new Solution().canFinish(2, pre));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] courseWithPre = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int i = 0; i < prerequisites.length; i++) {
            courseWithPre[prerequisites[i][0]]++;
            map.putIfAbsent(prerequisites[i][1], new ArrayList());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int countNoPre = 0;
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < courseWithPre.length; i++) {
            if(courseWithPre[i] == 0) {
                countNoPre++;
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(map.containsKey(cur)) {
                List<Integer> courseList = map.get(cur);
                for(int i = 0; i < courseList.size(); i++) {
                    courseWithPre[courseList.get(i)]--;
                    if(courseWithPre[courseList.get(i)] == 0) {
                        q.offer(courseList.get(i));
                        countNoPre++;
                    }
                }
            }
        }
        return countNoPre == numCourses;
    }
}