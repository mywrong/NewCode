package org.newcode.dp;

/**
 * @link: <a href="https://www.nowcoder.com/practice/6fe0302a058a4e4a834ee44af88435c7?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 给定一个整数数组 cost,其中cost[i]是从楼梯第 i 个台阶向上爬需要支付的费用，下标从0开始。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。请你计算并返回达到楼梯顶部的最低花费。
 *
 * 思路：
 * 顶部的两个楼梯的最小花费是已知的，就是cost对应下标的值，向前倒退即可。
 */
public class BM64MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        // write code here
        int n = cost.length;
        if (n < 3) {
            return Math.min(cost[0], cost[1]);
        }

        int a = cost[n - 1];
        int b = cost[n - 2];
        int res = 0;
        for (int i = n - 3; i > -1; i--) {
            res = cost[i] + Math.min(a, b);
            a = b;
            b = res;
        }
        return Math.min(res, a);

    }
}
