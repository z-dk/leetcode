//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 708 👎 0


package leetcode.editor.cn;

//N 皇后

import java.util.*;

public class P51_NQueens{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P51_NQueens().new Solution();
        List<List<String>> lists = solution.solveNQueens(8);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(String.format("结果%d",i+1));
            lists.get(i).forEach(System.out::println);
        }
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        
        backtrack(result,new int[n],n,0,columns,diagonals1,diagonals2);
        return result;
    }
    
    public void backtrack(List<List<String>> result, int[] rows, int n, int row, 
                          Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> rs = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                char[] cs = new char[n];
                Arrays.fill(cs,'.');
                cs[rows[i]] = 'Q';
                rs.add(String.valueOf(cs));
            }
            result.add(rs);
        } else {
            // 该行每一列的可能值
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                if (diagonals1.contains(row + i)) {
                    continue;
                }
                if (diagonals2.contains(i - row)) {
                    continue;
                }
                columns.add(i);
                diagonals1.add(row + i);
                diagonals2.add(i - row);
                rows[row] = i;
                backtrack(result, rows, n, row + 1, columns, diagonals1, diagonals2);
                columns.remove(i);
                diagonals1.remove(row + i);
                diagonals2.remove(i - row);
                rows[row] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}