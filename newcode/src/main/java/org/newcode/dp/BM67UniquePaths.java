package org.newcode.dp;

/**
 * @link: <a href="https://www.nowcoder.com/practice/166eaff8439d4cd898e3ba933fbc6358?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 一个机器人在m×n大小的地图的左上角（起点）。
 * 机器人每次可以向下或向右移动。机器人要到达地图的右下角（终点）。
 * 可以有多少种不同的路径从起点走到终点？
 * <p>
 * 思路：
 * 动态规划记录每个格子到终点的路径数
 * d[i][j] = d[i+1][j] + d[i][j+1]
 */
public class BM67UniquePaths {
    public int uniquePaths(int m, int n) {
        // write code here
        int[][] d = new int[m][];
        for (int i = 0; i < m; i++) {
            d[i] = new int[n];
        }
        for (int i = 0; i < m; i++) {
            d[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            d[m - 1][i] = 1;
        }
        for (int i = m - 2; i > -1; i--) {
            for (int j = n - 2; j > -1; j--) {
                d[i][j] = d[i + 1][j] + d[i][j + 1];
            }
        }
        return d[0][0];

    }
}
