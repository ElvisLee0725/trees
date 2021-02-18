// Use a StringBuilder to build up the result string
// Use a custom class to store the position {i, j} while i is row, j is column
// Iterate the target string, check if the row of current char is at the top, bottom or same row with the prev char? If it's at top, add "U" to result until reaches the same row. Else, add "D" to result until reaches the same row.
// Then, adjust the column to reach the current char's column by adding "L" or "R"
// Once reaches the current char's position, add "!" to result and assgin cur to prev
// Edge Case: If the current char is 'z', always move to column 0 first, then going to row 5
// Time: O(n), Space: O(n)

class Solution {
    class Pos {
        int i;
        int j;
        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        System.out.print(new Solution().alphabetBoardPath("zezezezezzz"));
    }
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        Pos prev = new Pos(0, 0);
        for(int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            Pos cur = new Pos((ch - 'a') / 5, (ch - 'a') % 5);
            if(ch != 'z') {
                while(prev.i != cur.i) {
                    if(prev.i < cur.i) {
                        prev.i++;
                        sb.append("D");
                    }
                    else if(prev.i > cur.i) {
                        prev.i--;
                        sb.append("U");
                    }
                }
                while(prev.j != cur.j) {
                    if(prev.j < cur.j) {
                        prev.j++;
                        sb.append("R");
                    }
                    else if(prev.j > cur.j) {
                        prev.j--;
                        sb.append("L");
                    }
                }
            }
            else {
                while(prev.j != cur.j) {
                    prev.j--;
                    sb.append("L");
                }
                while(prev.i != cur.i) {
                    prev.i++;
                    sb.append("D");
                }
            }
            sb.append("!");
            prev = cur;
        }
        return sb.toString();
    }
}
