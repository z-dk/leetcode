//我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”： 
//
// 
// B.length >= 3 
// 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B
//[B.length - 1] 
// 
//
// （注意：B 可以是 A 的任意子数组，包括整个数组 A。） 
//
// 给出一个整数数组 A，返回最长 “山脉” 的长度。 
//
// 如果不含有 “山脉” 则返回 0。 
//
// 
//
// 示例 1： 
//
// 输入：[2,1,4,7,3,2,5]
//输出：5
//解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
// 
//
// 示例 2： 
//
// 输入：[2,2,2]
//输出：0
//解释：不含 “山脉”。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
// Related Topics 双指针 
// 👍 91 👎 0


package leetcode.editor.cn;

//数组中的最长山脉

public class P845_LongestMountainInArray{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P845_LongestMountainInArray().new Solution();
        int[] A = {3,2,4,3};
        System.out.println(solution.longestMountain(A));
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestMountain(int[] A) {
        int res = 0;
        int cal = 0;
        boolean up = true;
        for (int i=1;i<A.length;i++){
            if ((up && A[i] > A[i-1]) || (!up && A[i] <A[i-1])){
                cal = (cal == 0 ? 1 : cal) + 1;
                //System.out.println(A[i-1]+"==="+A[i]);
            } else if (up && cal != 0 && A[i] < A[i-1]){
                up = false;
                cal++;
                //System.out.println(A[i-1]+"==="+A[i]);
            } else if (up){
                cal = 0;
            } else if (cal != 0){
                res = Math.max(res,cal);
                cal = 0;
                up = true;
                i--;
            }
        }
        return up?res:Math.max(res,cal);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}