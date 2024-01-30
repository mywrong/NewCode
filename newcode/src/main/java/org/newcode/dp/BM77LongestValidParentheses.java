package org.newcode.dp;

import java.util.Stack;

/**
 * @link: <a href="https://www.nowcoder.com/practice/45fd68024a4c4e97a8d6c45fc61dc6ad?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 给出一个长度为 n 的，仅包含字符 '(' 和 ')' 的字符串，计算最长的格式正确的括号子串的长度。
 * 例1: 对于字符串 "(()" 来说，最长的格式正确的子串是 "()" ，长度为 2 .
 * 例2：对于字符串 ")()())" , 来说, 最长的格式正确的子串是 "()()" ，长度为 4 .
 *
 * 思路：
 * 在用栈检查字符串是否合法时，记录最后一个未被匹配的右括号。保持栈底为最后一个未被匹配的右括号下标，初始化为 -1。
 * 1. 当前为 ( ，下标入栈
 * 2. 当前为 )，出栈
 *      a. 栈为空，说明当前当前下标入栈
 *      b. 栈不为空，则以当前下标为结尾的字串最大匹配长度为 i-stack.peek()。
 */
public class BM77LongestValidParentheses {
    public int longestValidParentheses(String s) {
        // write code here
        if (s.length() < 2) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.add(i);
                } else {
                    int idx = stack.peek();
                    res = Math.max(res, i - idx);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        BM77LongestValidParentheses s = new BM77LongestValidParentheses();
        System.out.println(s.longestValidParentheses("()(())"));
    }
}
