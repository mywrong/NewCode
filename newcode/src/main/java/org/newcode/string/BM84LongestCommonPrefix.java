package org.newcode.string;

/**
 * @link: <a href="https://www.nowcoder.com/practice/28eb3175488f4434a4a6207f6f484f47?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description:
 * 给你一个大小为 n 的字符串数组 strs ，其中包含n个字符串 , 编写一个函数来查找字符串数组中的最长公共前缀，返回这个公共前缀。
 *
 * 思路：
 * 逐列比较所有行的字符是否相等，超出长度或不相等则返回。
 */
public class BM84LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // write code here
        if (strs.length == 0 || strs == null) {
            return "";
        }
        int rows = strs.length;
        int cols = strs[0].length();
        for (int c = 0; c < cols; c++) {
            char firstChar = strs[0].charAt(c);
            for (int r = 1; r < rows; r++) {
                if(c>=strs[r].length() || strs[r].charAt(c) != firstChar){
                    return strs[0].substring(0,c);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        BM84LongestCommonPrefix bm84LongestCommonPrefix = new BM84LongestCommonPrefix();
        System.out.println(bm84LongestCommonPrefix.longestCommonPrefix(new String[]{"a"}));
    }
}
