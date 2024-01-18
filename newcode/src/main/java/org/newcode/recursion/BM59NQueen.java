package org.newcode.recursion;

import java.util.*;

/**
 * N 皇后
 * N 皇后问题是指在 n * n 的棋盘上要摆 n 个皇后，
 * 要求：任何两个皇后不同行，不同列也不在同一条斜线上，
 * 空间O(n),时间 O(n!)
 *
 * 思路：
 * 逐行遍历皇后可能的位置，将皇后的位置放入Set中。空间复杂度 O(n)
 */

public class BM59NQueen {
    private int res = 0;

    public int Nqueen(int n) {
        // write code here
        Set<List<Integer>> pos = new HashSet<>();
        dfs(n, 0, pos);
        return res;
    }

    private boolean isVaild(int row, int col, Set<List<Integer>> pos) {
        for (List<Integer> queen : pos) {
            if (row == queen.get(0) || col == queen.get(1) || Math.abs(queen.get(0) - row) == Math.abs(queen.get(1) - col)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int n, int row, Set<List<Integer>> pos) {
        if (row == n) {
            res++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isVaild(row, col, pos)) {
                List<Integer> p = new ArrayList<>(Arrays.asList(row, col));
                pos.add(p);
                dfs(n, row + 1, pos);
                pos.remove(p);
            }
        }
    }


    public static void main(String[] args) {
        BM59NQueen s = new BM59NQueen();
        System.out.println(s.Nqueen(8));
    }

}
