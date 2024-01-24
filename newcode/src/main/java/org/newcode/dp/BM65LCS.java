package org.newcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定两个字符串str1和str2，输出两个字符串的最长公共子序列。如果最长公共子序列为空，则返回"-1"。
 * 目前给出的数据，仅仅会存在一个最长的公共子序列
 *
 * 思路：
 * 用两个二维数组 d 和 w ：
 * d[i][j]：记录 str1.subString(0,i) 与 str2.subString(0,j) 的最长公共子序列长度;
 *  若str1[i]==str2[j]，则 d[i][j] = d[i-1][j-1] + 1;
 *  若str1[i]！=str2[j]，则 d[i][j] = max(d[i-1][j], d[i][j-1])。
 *
 * w[i][j]：记录 d[i][j] 状态转移的方向：
 *  若 d[i][j] 由 d[i-1][j-1] + 1 得到，则 w[i][j] = 1，代表转移方向为左上；
 *  若 d[i][j] 由 d[i][j-1] 得到，则 w[i][j] = 2, 代表转移方向为左；
 *  若 d[i][j] 由 d[i-1][j] 得到，则 w[i][j] =3 ，代表转移方向为上。
 *
 *  遍历 str1 和 str2 ，完成 d 和 w 的计算，然后 w 从后往前根据状态转移方向寻找子序列，w[i][j] = 1 时 str1[i] 为子序列的中的值。
 */
public class BM65LCS {
    public String LCS(String s1, String s2) {
        // write code here
        int m = s1.length(), n = s2.length();
        int[][] d = new int[m + 1][];
        int[][] w = new int[m + 1][]; //1为左上，2为左，3为上
        for (int i = 0; i < m + 1; i++) {
            d[i] = new int[n + 1];
            w[i] = new int[n + 1];
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    d[i][j] = d[i - 1][j - 1] + 1;
                    w[i][j] = 1;
                } else {
                    if (d[i - 1][j] > d[i][j - 1]) {
                        d[i][j] = d[i - 1][j];
                        w[i][j] = 3;
                    } else {
                        d[i][j] = d[i][j - 1];
                        w[i][j] = 2;
                    }
                }
            }
        }

        List<Character> list = new ArrayList<>();
        for (int i = m, j = n; i > 0 && j > 0; ) {
            if (w[i][j] == 1) {
                list.add(s1.charAt(i-1));
                i--;
                j--;
            } else if (w[i][j] == 2) {
                j--;
            } else {
                i--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i > -1; i--) {
            sb.append(list.get(i));
        }
        String res = sb.toString();
        if (res.length() == 0) {
            return "-1";
        }
        return res;
    }
}
