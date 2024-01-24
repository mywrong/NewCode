package org.newcode.dp;

/**
 * @link: <a href="https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 思路：动态规划，fn = f(n-1) + f(n-2)
 */
public class BM63JumpFloor {
    public int jumpFloor(int number) {
        // write code here
        if (number == 1) {
            return 1;
        }
        if (number == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int res = 0;
        for (int i = 2; i < number; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
