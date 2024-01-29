package org.newcode.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @link: <a href="https://www.nowcoder.com/practice/3911a20b3f8743058214ceaa099eeb45?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
 * 如果无解，请返回-1.
 * 时间 O(aim),空间O(n*aim)
 *
 * 思路：
 * d[i] 记录 i 元的最少货币数
 *  d[i] = min(d[i-arr[k]] + 1)
 *  0<= k < arr.length && i-arr[k] >=0 && d[i-arr[k]] != -1
 */
public class BM70MinMoney {
    public int minMoney(int[] arr, int aim) {
        // write code here
        int[] d = new int[aim + 1];
        Set<Integer> money = new HashSet<>();
        for (int j : arr) {
            money.add(j);
        }
        for (int i = 1; i < aim + 1; i++) {
            d[i] = Integer.MAX_VALUE;
            for (Integer m : money) {
                if (i - m >= 0 && d[i - m] != -1) {
                    d[i] = Math.min(d[i], d[i - m] + 1);
                }
            }
            if (d[i] == Integer.MAX_VALUE) {
                d[i] = -1;
            }
        }
        return d[aim];
    }
}
