//有一堆石头，每块石头的重量都是正整数。 
//
// 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下： 
//
// 
// 如果 x == y，那么两块石头都会被完全粉碎； 
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 
// 
//
// 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。 
//
// 
//
// 示例： 
//
// 输入：[2,7,4,1,8,1]
//输出：1
//解释：
//先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
//再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
//接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
//最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 1000 
// 
// Related Topics 堆 贪心算法 
// 👍 127 👎 0


package leetcode.editor.cn;

//最后一块石头的重量

import javax.swing.*;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class P1046_LastStoneWeight{
    public static void main(String[] args) throws NoSuchMethodException {
        //测试代码
        //Solution solution = new P1046_LastStoneWeight().new Solution();
        //System.out.println(solution.lastStoneWeight(new int[]{3, 1}));
    
        JButton jButton = new JButton();
        Method addActionListener = jButton.getClass().getMethod("addActionListener", ActionListener.class);
    
        Proxy.newProxyInstance(null, new Class[]{ActionListener.class}, (proxy, method, args1) -> method.invoke(args1));
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    @SuppressWarnings("ConstantConditions")
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> priorityQueue = Arrays.stream(stones).boxed().collect(Collectors.toCollection(() -> new PriorityQueue<Integer>(Comparator.reverseOrder())));
        int poll = priorityQueue.poll();
        
        while (!priorityQueue.isEmpty()) {
            int mid = poll - priorityQueue.poll();
            if (mid != 0) {
                priorityQueue.add(mid);
            }
            if (priorityQueue.isEmpty()) {
                return 0;
            } else {
                poll = priorityQueue.poll();
            }
        }
        return poll;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}