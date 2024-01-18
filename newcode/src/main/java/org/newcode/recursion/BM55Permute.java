package org.newcode.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 没有重复项数字的全排列
 * @link: <a href="https://www.nowcoder.com/practice/4bcf3081067a4d028f95acee3ddcd2b1?tpId=295&tqId=701&ru=%2Fpractice%2Fc215ba61c8b1443b996351df929dc4d4&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 给出一组数字，返回该组数字的所有排列
 * 思路：递归。
 * 将所有可以遍历的下标放入Set，遍历 Set 中的下标：
 *  1. 将对应元素放入 path 中;
 *  2. 从 Set 取出当前下标;
 *  3. 递归 Set 中剩余下标;
 *  4. 当前下标放回 Set;
 *  5. path 弹出最后一个元素。
 */
public class BM55Permute {
    private List<Integer> path = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // write code here
        Set<Integer> indexes = new TreeSet<>();
        for (int i = 0; i < num.length; i++) {
            indexes.add(i);
        }
        dfs(num, indexes);
        return res;
    }

    private void dfs(int[] num, Set<Integer> indexes) {
        if (indexes.isEmpty()) {
            res.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> indexCopy = new TreeSet<>(indexes);
        for (Integer idx : indexes) {
            path.add(num[idx]);
            indexCopy.remove(idx);
            dfs(num, indexCopy);
            indexCopy.add(idx);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        BM55Permute s = new BM55Permute();
        System.out.println(s.permute(new int[]{1, 2, 3}));
    }
}
