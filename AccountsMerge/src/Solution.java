// Store the graph of <email, list of related emails> with a HashMap. Also use a <Email, Name> to store the associsted name of that email
// Ex: Key: Value
// johnnybravo@mail.com: johnnybravo@mail.com
// johnsmith@mail.com: johnsmith@mail.com john_newyork@mail.com john00@mail.com
// john00@mail.com: johnsmith@mail.com john00@mail.com
// john_newyork@mail.com: johnsmith@mail.com john_newyork@mail.com
// mary@mail.com: mary@mail.com

// For each key of the map, if it's not seen before, get all it's neighbors and their neighbors to add to
// a list without duplication. Then, sort it and insert name at index 0

import java.util.*;

class Solution {
    public static void main(String[] args) {
        List<String> a = new ArrayList();
        a.add("John");
        a.add("johnsmith@mail.com");
        a.add("john00@mail.com");
        List<String> b = new ArrayList();
        b.add("John");
        b.add("johnnybravo@mail.com");
        List<String> c = new ArrayList();
        c.add("John");
        c.add("johnsmith@mail.com");
        c.add("john_new_york@mail.com");
        List<String> d = new ArrayList();
        d.add("Mary");
        d.add("mary@mail.com");
        List<List<String>> accounts = new ArrayList();
        accounts.add(a);
        accounts.add(b);
        accounts.add(c);
        accounts.add(d);

        List<List<String>> ans = new Solution().accountsMerge(accounts);
        for(List<String> list : ans) {
            for(String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, List<String>> map = new HashMap();
        HashMap<String, String> emailToName = new HashMap();
        for(List<String> a : accounts) {
            String name = a.get(0);
            for(int i = 1; i < a.size(); i++) {
                String email1 = a.get(i);
                map.computeIfAbsent(email1, x -> new ArrayList());
                for(int j = 1; j < a.size(); j++) {
                    String email2 = a.get(j);
                    if(!email1.equals(email2)) {
                        map.computeIfAbsent(email2, x -> new ArrayList());
                        if (!map.get(email1).contains(email2)) {
                            map.get(email1).add(email2);
                        }

                        if (!map.get(email2).contains(email1)) {
                            map.get(email2).add(email1);
                        }
                    }
                }
                emailToName.putIfAbsent(email1, name);
            }
        }

//         for(String email : map.keySet()) {
//             System.out.print(email + ": ");
//             for(String s : map.get(email)) {
//                 System.out.print(s + " ");
//             }
//             System.out.println();
//         }

        List<List<String>> res = new ArrayList();
        HashSet<String> hs = new HashSet();
        for(String email : map.keySet()) {
            if(!hs.contains(email)) {
                hs.add(email);
                Queue<String> q = new LinkedList();
                q.offer(email);
                List<String> list = new ArrayList();
                while(!q.isEmpty()) {
                    String cur = q.poll();
                    list.add(cur);
                    for(String nei : map.get(cur)) {
                        if (!hs.contains(nei)) {
                            hs.add(nei);
                            q.offer(nei);
                        }
                    }
                }
                Collections.sort(list);
                list.add(0, emailToName.get(email));
                res.add(list);
            }
        }
        return res;
    }
}
