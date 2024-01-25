package org.newcode.dp;


/**
 * @description: 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和.
 * 输出所有的路径中最小的路径和
 *
 * 思路：
 * 动态规划记录每个格子到终点的最小路径和。
 * d[i][j] = min(d[i+1][j],d[i][j+1]) + matrix[i][j]
 */
public class BM68MinPathSum {
    public int minPathSum(int[][] matrix) {
        // write code here
        int m = matrix.length, n = matrix[0].length;
        int[][] d = new int[m][];
        for (int i = 0; i < m; i++) {
            d[i] = new int[n];
        }
        d[m - 1][n - 1] = matrix[m - 1][n - 1];
        for (int i = m - 2; i > -1; i--) {
            d[i][n - 1] = d[i + 1][n - 1] + matrix[i][n - 1];
        }
        for (int i = n - 2; i > -1; i--) {
            d[m - 1][i] = d[m - 1][i + 1] + matrix[m - 1][i];
        }
        for (int i = m - 2; i > -1; i--) {
            for (int j = n - 2; j > -1; j--) {
                d[i][j] = Math.min(d[i + 1][j], d[i][j + 1]) + matrix[i][j];
            }
        }
        return d[0][0];
    }
}
