package org.newcode.recursion;


/**岛屿数量
 * @link: <a href="https://www.nowcoder.com/practice/0c9664d1554e466aa107d899418e814e?tpId=295&tqId=1024684&ru=%2Fpractice%2Ff23604257af94d939848729b1a5cda08&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
 *
 * 思路：深度遍搜索。
 * 先遍历grid，遇到未遍历过的下标且是岛屿的则结果+1，并深度搜索此下标，将所有与此下标相邻的下标标记为已访问。
 */
public class BM57NumberOfIslands {
    public int solve(char[][] grid) {
        // write code here
        if (grid.length == 0) {
            return 0;
        }
        int res = 0;
        int[][] visited = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            visited[i] = new int[grid[i].length];
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    res++;
                    mark(i, j, grid, visited);
                }
            }
        }
        return res;
    }

    public void mark(int row, int col, char[][] grid, int[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            return;
        }
        if (visited[row][col] == 1 || grid[row][col] == '0') {
            return;
        }
        visited[row][col] = 1;
        mark(row - 1, col, grid, visited);
        mark(row + 1, col, grid, visited);
        mark(row, col - 1, grid, visited);
        mark(row, col + 1, grid, visited);

    }

    public static void main(String[] args) {
        char[][] grid = new char[5][];

        grid[0] = "110000".toCharArray();
        grid[1] = "010110".toCharArray();
        grid[2] = "000110".toCharArray();
        grid[3] = "000000".toCharArray();
        grid[4] = "001110".toCharArray();
        BM57NumberOfIslands s = new BM57NumberOfIslands();
        System.out.println(s.solve(grid));

    }
}
