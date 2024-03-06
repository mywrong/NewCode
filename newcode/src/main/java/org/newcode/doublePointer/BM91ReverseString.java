package org.newcode.doublePointer;

/**
 * @link: <a href="https://www.nowcoder.com/practice/c3a6afee325e472386a1c4eb1ef987f3?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description:
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 */
public class BM91ReverseString {
    public String solve (String str) {
        // write code here
        StringBuilder res = new StringBuilder(str);
        return res.reverse().toString();
    }
    
}
