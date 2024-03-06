package org.newcode.doublePointer;

import org.newcode.common.Interval;

import java.util.ArrayList;

/**
 * @link: <a href="https://www.nowcoder.com/practice/69f4e5b7ad284a478777cb2a17fb5e6a?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description:
 * 给出一组区间，请合并所有重叠的区间。
 * 请保证合并后的区间按区间起点升序排列。
 *
 * 思路：
 * 先对区间排序，再遍历区间列表合并
 */
public class BM89MergeInterval {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // write code here
        ArrayList<Interval> res = new ArrayList<>();
        intervals.sort((a, b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });
        for (Interval interval : intervals) {
            if (res.isEmpty()) {
                res.add(interval);
                continue;
            }
            Interval lastInterval = res.get(res.size() - 1);
            if (interval.start <= lastInterval.end) {
                lastInterval.end = Math.max(lastInterval.end, interval.end);
            } else {
                res.add(interval);
            }
        }
        return res;
    }
}
