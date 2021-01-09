//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 105 
// 
// Related Topics 数组 动态规划 
// 👍 611 👎 0


package leetcode.editor.cn;

//买卖股票的最佳时机 III

import java.util.*;

public class P123_BestTimeToBuyAndSellStockIii{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P123_BestTimeToBuyAndSellStockIii().new Solution();
        //System.out.println(solution.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        //System.out.println(solution.maxProfit(new int[]{1,2,3,4,5}));
        //System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
        //System.out.println(solution.maxProfit(new int[]{1}));
        long now = System.currentTimeMillis();
        System.out.println(solution.maxProfit(new int[]{10000,9999,9998,9997,9996,9995,9994,9993,9992,9991,9990,9989,9988,9987,9986,9985,9984,9983,9982,9981,9980,9979,9978,9977,9976,9975,9974,9973,9972,9971,9970,9969,9968,9967,9966,9965,9964,9963,9962,9961,9960,9959,9958,9957,9956,9955,9954,9953,9952,9951,9950,9949,9948,9947,9946,9945,9944,9943,9942,9941,9940,9939,9938,9937,9936,9935,9934,9933,9932,9931,9930,9929,9928,9927,9926,9925,9924,9923,9922,9921,9920,9919,9918,9917,9916,9915,9914,9913,9912,9911,9910,9909,9908,9907,9906,9905,9904,9903,9902,9901,9900,9899,9898,9897,9896,9895,9894,9893,9892,9891,9890,9889,9888,9887,9886,9885,9884,9883,9882,9881,9880,9879,9878,9877,9876,9875,9874,9873,9872,9871,9870,9869,9868,9867,9866,9865,9864,9863,9862,9861,9860,9859,9858,9857,9856,9855,9854,9853,9852,9851,9850,9849,9848,9847,9846,9845,9844,9843,9842,9841,9840,9839,9838,9837,9836,9835,9834,9833,9832,9831,9830,9829,9828,9827,9826,9825,9824,9823,9822,9821,9820,9819,9818,9817,9816,9815,9814,9813,9812,9811,9810,9809,9808
}));
        System.out.println(System.currentTimeMillis()-now);
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 2) {
            return n == 1 ? 0 : Math.max(0,prices[1]-prices[0]);
        }
        int[][] valueArray = new int[n][2];
        valueArray[0][0] = 0;
        valueArray[0][1] = maxValue(Arrays.copyOfRange(prices,0,n));
        for (int i = 1; i < n; i++) {
            valueArray[i][0] = maxValue(Arrays.copyOfRange(prices,0,i));
            valueArray[i][1] = maxValue(Arrays.copyOfRange(prices,i,n));
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, valueArray[i][0] + valueArray[i][1]);
        }
        return max;
    }
    
    public int maxValue(int[] prices) {
        int max = 0;
        TreeMap<Integer, Integer> minMap = new TreeMap<>();
        
        for (int i = 0; i < prices.length; i++) {
            minMap.putIfAbsent(prices[i],i);
        }
        Map.Entry<Integer, Integer> entry = minMap.pollFirstEntry();
        for (int j = prices.length-1; j > 0; j--) {
            while (entry.getValue() >= j && minMap.size() > 0) {
                entry = minMap.pollFirstEntry();
            }
            
            max = Math.max(max, minMap.size() == 0 ? 0 : prices[j] - entry.getKey());
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}