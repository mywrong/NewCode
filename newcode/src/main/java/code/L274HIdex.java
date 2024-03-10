package code;

import java.util.Arrays;

/**
 * @link: <a href="https://leetcode.cn/problems/h-index/solutions/869042/h-zhi-shu-by-leetcode-solution-fnhl/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @description:
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * 根据维基百科上 h 指数的定义：
 * h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。
 * 如果 h 有多种可能的值，h 指数 是其中最大的那个。
 *
 * 思路：
 * 先排序，h 初始化为 0，可以发现最高处最容易满足 c[i] >= h + 1，因此从右往左遍历 i，累加 h,直到不能满足 c[i] >= h + 1 条件。
 */
public class L274HIdex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int h = 0;
        int i = n - 1;
        while (i > -1 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }


    public static void main(String[] args) {
        L274HIdex l274HIdex = new L274HIdex();
        int[] c = new int[]{0};
        System.out.println(l274HIdex.hIndex(c));
    }
}
