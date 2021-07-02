import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Vertex {
    Character id;
    List<Vertex> edges;
}

public class Solution {
    public static void main(String[] args) {
        
    }
    public static String bfs(Vertex origin) {
        // Write your code here
        Queue<Vertex> q = new LinkedList();
        HashSet<Character> visited = new HashSet();
        q.offer(origin);
        visited.add(origin.id);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            Vertex cur = q.poll();
            sb.append(cur.id);
            for(Vertex nei : cur.edges) {
                if(!visited.contains(nei.id)) {
                    q.offer(nei);
                    visited.add(nei.id);
                }
            }
        }
        return sb.toString();
    }
}
