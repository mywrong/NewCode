package org.newcode.hsq;


import java.util.*;

/**
 * 数据流中的中位数
 *
 * @link: <a href="https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=295&tqId=23457&ru=%2Fpractice%2Fe016ad9b7f0b45048c58a9f27ba618bf&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * <p>
 * 时间O(nlogn),空间O(n)
 *
 * 思路：
 * 吐血！！！大小两个堆入堆规则搞了半天！
 * 先入小堆，再把小堆的最大值入大堆
 * 如果小堆比大堆少，就把大堆的最小值入小堆。
 */
public class BM48MedianInStream {
    private long size = 0;
    private Queue<Integer> leftQueue = new PriorityQueue<>(Comparator.reverseOrder());
    private Queue<Integer> rightQueue = new PriorityQueue<>();

    public void Insert(Integer num) {
        size++;
        leftQueue.add(num);
        rightQueue.add(leftQueue.poll());
        if (leftQueue.size() < rightQueue.size()) {
            leftQueue.add(rightQueue.poll());
        }
    }

    public Double GetMedian() {
        if (size % 2 == 0) {
            int a = leftQueue.isEmpty() ? 0 : leftQueue.peek();
            int b = rightQueue.isEmpty() ? 0 : rightQueue.peek();
            return (double) (a + b) / 2;
        } else {
            return (double) leftQueue.peek();
        }
    }
}
