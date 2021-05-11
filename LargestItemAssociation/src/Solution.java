import java.util.*;

class Solution {
    // Create Adjacency List for items, Ex. <Item Name, List of adjacent items>
    // For each item in the adjacency map, call dfs to find all its union.
    // Update the largest union or if size is tie, compare the first item of sorted result
    public static void main(String[] args) {
        System.out.println(new Solution().largestItemAssociation(Arrays.asList(
                new PairString("Item1", "Item6"),
                new PairString("Item6", "Item2"),
                new PairString("Item3", "Item4"),
                new PairString("Item3", "Item5")
        )));
    }

    public List<String> largestItemAssociation(List<PairString> itemAssociation) {
        HashMap<String, List<String>> map = new HashMap();
        for(PairString p : itemAssociation) {
            map.computeIfAbsent(p.first, x -> new ArrayList()).add(p.second);
            map.computeIfAbsent(p.second, x -> new ArrayList()).add(p.first);
        }

        int max = 0;
        List<String> res = new ArrayList();
        HashSet<String> hs = new HashSet();
        for(String cur : map.keySet()) {
            List<String> tmp = new ArrayList();
            if(!hs.contains(cur)) {
                tmp.add(cur);
                dfs(cur, tmp, map, hs);
            }

            if(tmp.size() > max) {
                res = new ArrayList(tmp);
                max = res.size();
            }
            else if(tmp.size() == max) {
                Collections.sort(res);
                Collections.sort(tmp);

                if(res.get(0).compareTo(tmp.get(0)) > 0) {
                    res = new ArrayList(tmp);
                }
            }
        }
        return res;
    }

    private void dfs(String cur, List<String> tmp, HashMap<String, List<String>> map, HashSet<String> hs) {
        hs.add(cur);
        for(String nei : map.get(cur)) {
            if(!hs.contains(nei)) {
                tmp.add(nei);
                dfs(nei, tmp, map, hs);
            }
        }
    }
}
