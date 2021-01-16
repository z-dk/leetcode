//给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。 
//
//
// 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。 
//
// 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。 
//
// 
//
// 示例 1: 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2]]
//输出："bacd"
//解释： 
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[1] 和 s[2], s = "bacd"
// 
//
// 示例 2： 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
//输出："abcd"
//解释：
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[0] 和 s[2], s = "acbd"
//交换 s[1] 和 s[2], s = "abcd" 
//
// 示例 3： 
//
// 输入：s = "cba", pairs = [[0,1],[1,2]]
//输出："abc"
//解释：
//交换 s[0] 和 s[1], s = "bca"
//交换 s[1] 和 s[2], s = "bac"
//交换 s[0] 和 s[1], s = "abc"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// 0 <= pairs.length <= 10^5 
// 0 <= pairs[i][0], pairs[i][1] < s.length 
// s 中只含有小写英文字母 
// 
// Related Topics 并查集 数组 
// 👍 106 👎 0


package leetcode.editor.cn;

//交换字符串中的元素

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class P1202_SmallestStringWithSwaps{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1202_SmallestStringWithSwaps().new Solution();
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0,1));
        pairs.add(Arrays.asList(1,2));
        System.out.println(solution.smallestStringWithSwaps("cba",pairs));
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        if (n == 1 || pairs.size() == 0) {
            return s;
        }
        
        UF uf = new UF(n);
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        
        Map<Integer,PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(uf.find(i), key -> new PriorityQueue<>()).offer(s.charAt(i));
        }
        
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = map.get(uf.find(i)).poll();
        }
        
        return String.valueOf(chars);
    }
}

    class UF {
        
        private int[] id;
        
        private int count;
        
        
        public UF(int n) {
            count = n;
            id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
        }
        
        public void union(int p, int q) {
            int qID = find(q);
            int pID = find(p);
            if (qID == pID) {
                return;
            }
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pID) {
                    id[i] = qID;
                }
            }
        }
        
        public int find(int p) {
            return id[p];
        }
        
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
        
        public int count() {
            return count;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}