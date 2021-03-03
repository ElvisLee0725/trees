// Use a dp[n][n]. dp[i][j] represents if course i is course j's prerequisites
// Fill in dp by iterating prerequisites matrix
// Fill in dp from left to right, top to bottom => Check if dp[j][i] is true? If so, that means I can check from dp[i][k], dp[i][k+1]...dp[i][n-1] to see if its true, then dp[j][k] must be true!
// Iterate the queries, all the answers are in dp matrix
// Return the result
// Time: O(n^3), Space: O(n^2)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int [][] pre = {{0,1},{1,2},{2,3},{3,4}};
        int [][] q = {{0,4},{4,0},{1,3},{3,0}};
        List<Boolean> res = new Solution().checkIfPrerequisite(5, pre, q);
        System.out.print(res);
    }
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList();
        if(prerequisites.length == 0) {
            for(int i = 0; i < queries.length; i++) {
                res.add(false);
            }
            return res;
        }
        boolean [][] dp = new boolean[n][n];
        for(int [] a : prerequisites) {
            dp[a[0]][a[1]] = true;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[j][i]) {
                    for(int k = 0; k < n; k++) {
                        if(dp[i][k]) {
                            dp[j][k] = true;
                        }
                    }
                }
            }
        }

        for(int [] q : queries) {
            res.add(dp[q[0]][q[1]]);
        }
        return res;
    }
}
