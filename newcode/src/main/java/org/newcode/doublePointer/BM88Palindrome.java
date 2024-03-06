package org.newcode.doublePointer;

/**
 * @link: <a href="https://www.nowcoder.com/practice/e297fdd8e9f543059b0b5f05f3a7f3b2?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description:
 * 给定一个长度为 n 的字符串，请编写一个函数判断该字符串是否回文。如果是回文请返回true，否则返回false。
 *
 * 字符串回文指该字符串正序与其逆序逐字符一致。
 *
 * 思路：
 * 头尾指针比较
 */
public class BM88Palindrome {
    public boolean judge(String str) {
        // write code here
        if (str.length() == 0) {
            return true;
        }
        int i = 0, j = str.length() - 1;
        while (i <= j && str.charAt(i) == str.charAt(j)) {
            i++;
            j--;
        }
        return i > j;
    }
}
