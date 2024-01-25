package org.newcode.dp;

/**
 * @link: <a href="https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 给定两个字符串str1和str2, 输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 * <p>
 * 思路：
 * d[i][j] 表示str1.subString(0,i) 与 str2.subString(0,j) 中以str1[i-1]和 str2[j-1] 结尾的公共子串长度。
 * 若 str1[i-1] == str2[j-1] ，则 d[i][j] = d[i-1][j-1] + 1;
 * 若 str1[i-1] ！= str2[j-1]，则 d[i][j] = 0；
 * 找到 d 的最大值，对应下标往前推即可。
 */
public class BM66LCS2 {
    public String LCS(String str1, String str2) {
        // write code here
        int m = str1.length(), n = str2.length();
        int[][] d = new int[m + 1][];
        for (int i = 0; i < m + 1; i++) {
            d[i] = new int[n + 1];
        }

        int maxLength = 0;
        int max_idx = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1] + 1;
                    if (d[i][j] > maxLength) {
                        maxLength = d[i][j];
                        max_idx = i;
                    }
                } else {
                    d[i][j] = 0;
                }
            }
        }
        return str1.substring(max_idx - maxLength, max_idx);
    }

    public static void main(String[] args) {
        BM66LCS2 s = new BM66LCS2();
        System.out.println(s.LCS("1AB2345CD","12345EF"));
    }
}
