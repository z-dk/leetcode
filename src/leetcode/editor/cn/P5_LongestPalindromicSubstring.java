//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2846 👎 0


package leetcode.editor.cn;

//最长回文子串

public class P5_LongestPalindromicSubstring{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String result = "";
        boolean[][] p = new boolean[n][n];
        // l为子串的长度-1，i为子串起始位置，j为子串末尾位置
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    p[i][j] = true;
                } else {
                    boolean next = s.charAt(i) == s.charAt(j);
                    if (l == 1) {
                        p[i][j] = next;
                    } else {
                        p[i][j] = (next && p[i+1][j-1]);
                    }
                }
                if (p[i][j] && l + 1 > result.length()) {
                    result = s.substring(i,j+1);
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}