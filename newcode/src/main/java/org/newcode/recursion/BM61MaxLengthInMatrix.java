package org.newcode.recursion;

/**
 * @link: <a href="https://www.nowcoder.com/practice/7a71a88cdf294ce6bdf54c899be967a2?tpId=295&tqId=1076860&ru=%2Fpractice%2Ff23604257af94d939848729b1a5cda08&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany">...</a>
 *
 * @description: 给定一个 n 行 m 列矩阵 matrix ，矩阵内所有数均为非负整数。 你需要在矩阵中找到一条最长路径，使这条路径上的元素是递增的。并输出这条最长路径的长度。
 * 这个路径必须满足以下条件：
 * <p>
 * 1. 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外。
 * 2. 你不能走重复的单元格。即每个格子最多只能走一次。
 *
 * 思路：
 * 深度优先搜索，结合记忆数组，记录每个下标出发的最大递增序列长度。
 */
public class BM61MaxLengthInMatrix {
    public int solve(int[][] matrix) {
        // write code here
        int res = 0;
        int[][] memory = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            memory[i] = new int[matrix[i].length];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res = Math.max(res, dfs(matrix, memory, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int[][] memory, int row, int col) {
        if (row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0) {
            return 0;
        }
        if (memory[row][col] != 0) {
            return memory[row][col];
        }
        memory[row][col] = 1;
        if (row - 1 > -1 && matrix[row - 1][col] > matrix[row][col]) {
            memory[row][col] = Math.max(dfs(matrix, memory, row - 1, col) + 1, memory[row][col]);
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] > matrix[row][col]) {
            memory[row][col] = Math.max(dfs(matrix, memory, row + 1, col) + 1, memory[row][col]);
        }
        if (col - 1 > -1 && matrix[row][col - 1] > matrix[row][col]) {
            memory[row][col] = Math.max(dfs(matrix, memory, row, col - 1) + 1, memory[row][col]);
        }
        if (col + 1 < matrix[row].length && matrix[row][col + 1] > matrix[row][col]) {
            memory[row][col] = Math.max(dfs(matrix, memory, row, col + 1) + 1, memory[row][col]);
        }
        return memory[row][col];
    }

}
