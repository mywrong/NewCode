package org.newcode.dp;

/**
 * @link: <a href="https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 斐波那契数列 f1,f2=1, fn = f(n-1) + f(n-2),求 fn
 * 思路：简单没啥可说的
 */
public class BM62Fibonacci {
    public int Fibonacci(int n) {
        // write code here
        if (n < 3) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int res = 2;
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

    public static void main(String[] args) {
        BM62Fibonacci s = new BM62Fibonacci();
        System.out.println(s.Fibonacci(3));
    }
}
