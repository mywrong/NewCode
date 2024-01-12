package org.newcode.hsq;

import java.util.*;
/**
 * @program: <a href="https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=295&tqId=23458&ru=%2Fpractice%2F1624bc35a45c42c0bc17d17fa0cba788&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description:
 * 给定一个长度为 n 的数组 num 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度或窗口长度为0的时候，返回空。
 * 空间复杂度O(n),时间复杂度O(n)
 */
public class BM45MaxInWindows {
    /**
     * 解法一
     * 用了优先级队列，堆顶为当前遍历过的最大元素及下标。
     * 遍历数组时，将当前元素入队列。不断弹出堆顶元素直到堆顶元素的下标在区间内，则此区间的最大值为堆顶的值。
     * 时间复杂度 O(nlogn)，空间复杂度O(n)
     */
    public ArrayList<Integer> maxInWindows1 (int[] num, int size) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        if(num.length < size || size == 0){
            return res;
        }

        Queue<List<Integer>> queue = new PriorityQueue<>(num.length, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(0).compareTo(o1.get(0));
            }
        });

        for(int i = 0; i < num.length; i++){
            List<Integer> iterm = new ArrayList<>(Arrays.asList(num[i],i));
            queue.add(iterm);
            if(i >= size -1){
                while(queue.peek().get(1) < i - size + 1){
                    queue.poll();
                }
                res.add(queue.peek().get(0));
            }
        }
        return res;
    }

    /**
     * 官方解法：单调队列
     * 思路：在遍历数组时，如果 num[i-1] < num[i],那么 num[i-1] 肯定不是当前窗口的最大值。
     * 维护一个双端单调队列。
     * 遍历数组时，弹出所有小于当前元素的队尾元素，插入当前元素到队尾。
     * 当前窗口的最大值就是在区间内的第一个队头元素。
     */
    public ArrayList<Integer> maxInWindows (int[] num, int size){
        ArrayList<Integer> res = new ArrayList<>();
        if(num.length < size || size == 0){
            return res;
        }
        LinkedList<List<Integer>> queue = new LinkedList<>();
        for(int i = 0;i<num.length;i++){
            List<Integer> iterm = new ArrayList<>();
            iterm.add(num[i]);
            iterm.add(i);
            while(!queue.isEmpty() && queue.getLast().get(0) <= num[i]){
                queue.removeLast();
            }
            queue.addLast(iterm);
            if(i >= size-1){
                while(queue.getFirst().get(1) < i-size+1){
                    queue.removeFirst();
                }
                res.add(queue.getFirst().get(0));
            }
        }
        return res;
    }

}
