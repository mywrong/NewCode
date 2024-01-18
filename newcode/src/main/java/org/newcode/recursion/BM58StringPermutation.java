package org.newcode.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


/**
 * @link: <a href="https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 输入一个长度为 n 字符串，打印出该字符串中字符的所有排列，你可以以任意顺序返回这个字符串数组。
 * 例如输入字符串ABC,则输出由字符A,B,C所能排列出来的所有字符串ABC,ACB,BAC,BCA,CBA和CAB
 *
 * 思路：和全排列思路一样。
 */
public class BM58StringPermutation {

    private List<Character> path = new ArrayList<>();
    private ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        // write code here
        char[] arr = str.toCharArray();
        Set<Integer> indexes = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            indexes.add(i);
        }
       dfs(arr,indexes);
        return res;
    }

    private void dfs(char[] arr, Set<Integer> indexes) {
        if (indexes.isEmpty()) {
            res.add(path.stream().map(String::valueOf).collect(Collectors.joining()));
        }
        Set<Integer> indexesCopy = new TreeSet<>((a, b) -> {
            if (arr[a] == arr[b]) {
                return 0;
            } else {
                return a.compareTo(b);
            }
        });
        indexesCopy.addAll(indexes);
        for (Integer idx : indexesCopy) {
            path.add(arr[idx]);
            indexes.remove(idx);
            dfs(arr, indexes);
            indexes.add(idx);
            path.remove(path.size() - 1);
        }
    }
}
