package code;


/**
 * @link: <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/submissions/508472410/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @description: 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在同一天出售。
 * 返回 你能获得的最大利润 。
 *
 * 思路：动态规划
 *  第 i 天没有股票： d[i][0] = Math.max(d[i - 1][0], d[i - 1][1] + prices[i]);
 *  第 i 天有股票： d[i][1] = Math.max(d[i - 1][1], d[i - 1][0] - prices[i]);
 */
public class L122MaxProfit2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] d = new int[n][];
        for (int i = 0; i < n; i++) {
            d[i] = new int[2];
        }
        d[0][0] = 0;
        d[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            d[i][0] = Math.max(d[i - 1][0], d[i - 1][1] + prices[i]);
            d[i][1] = Math.max(d[i - 1][1], d[i - 1][0] - prices[i]);
        }
        return d[n - 1][0];
    }

    public static void main(String[] args) {
        L122MaxProfit2 l122MaxProfit2 = new L122MaxProfit2();
        System.out.println(l122MaxProfit2.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
