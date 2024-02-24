package org.newcode.string;

/**
 * @link: <a href="https://www.nowcoder.com/practice/c3120c1c1bc44ad986259c0cf0f0b80e?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description:
 * 对于一个长度为 n 字符串，我们需要对它做一些变形。
 *
 * 首先这个字符串中包含着一些空格，就像"Hello World"一样，然后我们要做的是把这个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。
 *
 * 比如"Hello World"变形后就变成了"wORLD hELLO"。
 *
 * 思路：
 * 1. 把所有字母转换大小写
 * 2. 把字符串逆序
 * 3. 以空格为边界,反转各子字符串
 */

public class BM83Trans {
    public String trans(String s, int n) {
        // write code here
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                res.append(c);
            } else if (c <= 'Z' && c >= 'A') {
                res.append((char)(c - 'A' + 'a'));
            } else {
                res.append((char)(c - 'a' + 'A'));
            }
        }
        res = res.reverse();
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && res.charAt(j) != ' ') {
                j++;
            }
            String tmp = res.substring(i, j);
            tmp = new StringBuilder(tmp).reverse().toString();
            res.replace(i, j, tmp);
            i = j;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BM83Trans bm83Trans = new BM83Trans();
        System.out.println(bm83Trans.trans("h  i ", 4));
    }
}
