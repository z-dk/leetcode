//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 737 👎 0


package leetcode.editor.cn;

//最大矩形

public class P85_MaximalRectangle{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P85_MaximalRectangle().new Solution();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(solution.maximalRectangle(matrix));
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            col1:for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                // i,j为矩形左上角，i2,j2为矩形右下角
                int colLength = matrix[0].length;
                row2:for (int i2 = i; i2 < matrix.length; i2++) {
                    for (int j2 = j; j2 < colLength; j2++) {
                        if (matrix[i2][j2] == '0' && j2 == i) {
                            continue col1;
                        } else if (matrix[i2][j2] == '0') {
                            colLength = j2;
                            continue row2;
                        }
                        int s = (i2-i+1) * (j2-j+1);
                        if (s > result) {
                            result = s;
                        }
                    }
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}