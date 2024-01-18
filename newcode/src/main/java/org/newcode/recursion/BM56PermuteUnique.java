package org.newcode.recursion;

import java.util.*;


/**
 * 有重复项数字的全排列
 * @link: <a href="https://www.nowcoder.com/practice/a43a2b986ef34843ac4fdd9159b69863?tpId=295&tqId=700&ru=%2Fpractice%2F4bcf3081067a4d028f95acee3ddcd2b1&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 给出一组可能包含重复项的数字，返回该组数字的所有排列。结果以字典序升序排列。
 *思路：
 * 基于 BM55 递归的思路，重写 Set 的比较器，过滤值相同的下标。
 */
public class BM56PermuteUnique {
    private List<Integer> path = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
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
        Set<Integer> indexCopy = new TreeSet<>((a, b) -> {
            if (num[a] == num[b]) {
                return 0;
            } else if (num[a] < num[b]) {
                return -1;
            } else {
                return 1;
            }
        });
        indexCopy.addAll(indexes);
        for (Integer idx : indexCopy) {
            path.add(num[idx]);
            indexes.remove(idx);
            dfs(num, indexes);
            indexes.add(idx);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        BM56PermuteUnique s = new BM56PermuteUnique();
        System.out.println(s.permuteUnique(new int[]{0,-1}));
    }
}
