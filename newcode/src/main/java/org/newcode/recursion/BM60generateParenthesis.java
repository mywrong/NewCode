package org.newcode.recursion;

import java.util.ArrayList;

/**
 *  括号生成
 *
 * @link: <a href="https://www.nowcoder.com/practice/c9addb265cdf4cdd92c092c655d164ca?tpId=295&tqId=725&ru=%2Fpractice%2Fc76408782512486d91eea181107293b6&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany">...</a>
 *
 * @description:
 * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 * 例如，给出n=3，解集为：
 * "((()))", "(()())", "(())()", "()()()", "()(())"
 *
 * 思路：递归，右括号剩余数量应不小于左括号
 */

public class BM60generateParenthesis {
    private ArrayList<String> res = new ArrayList<>();
    private ArrayList<String> path = new ArrayList<>();

    public ArrayList<String> generateParenthesis(int n) {
        // write code here
        dfs(n,n);
        return res;
    }

    private void dfs(int nLeft, int nRight) {
        if (nLeft > nRight) {
            return;
        }
        if (nLeft == 0 && nRight == 0) {
            res.add(String.join("", path));
            return;
        }
        if (nLeft > 0) {
            path.add("(");
            dfs(nLeft - 1, nRight);
            path.remove(path.size() - 1);
        }
        if (nRight > 0) {
            path.add(")");
            dfs(nLeft, nRight - 1);
            path.remove(path.size() - 1);
        }
    }
}
