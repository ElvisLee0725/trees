import java.util.*;

// BFS
// Start from room 0. Check the keys I can get from current room that is not visited, add it to the queue
// Keep doing until the queue is empty
// Finally, check if visited set's size equals to number of rooms? If so, return true. Else return false
// Time: O(n), Space: O(n)
class Solution {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(new Integer[]{1, 3});
        List<Integer> list2 = Arrays.asList(new Integer[]{1, 3, 0});
        List<Integer> list3 = Arrays.asList(new Integer[]{2});
        List<Integer> list4 = Arrays.asList(new Integer[]{0});
        List<List<Integer>> rooms = new ArrayList();
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);
        System.out.print(new Solution().canVisitAllRooms(rooms));
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet();
        Queue<Integer> q = new LinkedList();
        q.offer(0);
        visited.add(0);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int key : rooms.get(cur)) {
                if(!visited.contains(key)) {
                    q.offer(key);
                    visited.add(key);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}
