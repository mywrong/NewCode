package org.newcode.string;

import java.util.Stack;

/**
 * @link: <a href="https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。字符串仅由'0'~‘9’构成。
 * <p>
 * 思路：
 * 从后向前遍历两个字符串，结果存储在栈中
 */
public class BM86BigIntegerAdd {
    public String solve(String s, String t) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int carry = 0;
        for (int i = s.length() - 1, j = t.length() - 1; i > -1 || j > -1 || carry == 1; ) {
            carry += i > -1 ? s.charAt(i--) - '0' : 0;
            carry += j > -1 ? t.charAt(j--) - '0' : 0;
            stack.add(carry % 10);
            carry = carry / 10;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BM86BigIntegerAdd bm86BigIntegerAdd = new BM86BigIntegerAdd();
        System.out.println(bm86BigIntegerAdd.solve("1", ""));
    }
}
