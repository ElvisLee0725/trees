// In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
// If the town judge exists, then:
// The town judge trusts nobody.
// Everybody (except for the town judge) trusts the town judge.
// There is exactly one person that satisfies properties 1 and 2.
// You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
// If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

public class Solution {
    public static void main(String[] args) {
        int [][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.print(new Solution().findJudge(4, trust));
    }
    // Use an arr[N+1], if arr[i] is -1, means it trusts others so it's not a judge. If arr[i] == N - 1, it's the judge
// Iterate trust and set arr[trust[i][0]] to -1
// Iterate trust again and if arr[i] is not -1, arr[trust[i][1]]++
// Iterate arr and if arr[i] == N-1, return i. If there is no such index, return -1 at the end
// Time: O(n), Space: O(n)

        public int findJudge(int N, int[][] trust) {
            if(trust.length == 0) {
                return N == 1 ? 1 : -1;
            }
            int [] arr = new int[N+1];
            for(int i = 0; i < trust.length; i++) {
                arr[trust[i][0]] = -1;
            }

            for(int i = 0; i < trust.length; i++) {
                if(arr[trust[i][1]] != -1) {
                    arr[trust[i][1]]++;
                }
            }

            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == N-1) {
                    return i;
                }
            }

            return -1;
        }
}
