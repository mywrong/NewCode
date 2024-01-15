package org.newcode.hsq;

/**
 * 寻找第K大
 *
 * @link: <a href="https://www.nowcoder.com/practice/e016ad9b7f0b45048c58a9f27ba618bf?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 有一个整数数组，请你根据快速排序的思路，找出数组中第 k 大的数。
 * 给定一个整数数组 a ,同时给定它的大小n和要找的 k ，请返回第 k 大的数(包括重复的元素，不用去重)，保证答案存在。
 * <p>
 * 时间O(nlogn),空间O(1)
 *
 * 思路：快排，当枢轴下标为K时结束。
 *
 * 快排：
 * 1. 选第一个数为枢轴 x;
 * 2. l=begin,r=end;
 * 3. r从右向左找到第一个 l < r 且 num[r] < x 的数，赋值给 num[l], l++;
 * 4. l 从左往右找到第一个 l < r 且 num[l] >= x 的数，赋值给 num[r], r--;
 * 5. 循环步骤 3 和 4 ,直到 l == r;
 * 6. num[l] = x。
 * 7. 递归快排左右子数组。
 */
public class BM47findKth {
    public int findKth(int[] a, int n, int K) {
        // write code here
        return quickSort(a, 0, n - 1, K - 1);
    }

    private int quickSort(int[] num, int begin, int end, int k) {

        int x = num[begin];
        int l = begin, r = end;
        while (l < r) {
            while(l<r && num[r] < x){
                r--;
            }
            if(l<r){
                num[l++] = num[r];
            }
            while(l<r && num[l] >= x){
                l++;
            }
            if(l<r){
                num[r--] = num[l];
            }
        }
        num[l] = x;

        if (l == k) {
            return num[l];
        } else if (l < k) {
            return quickSort(num, l + 1, end, k);
        } else {
            return quickSort(num, begin, l - 1, k);
        }
    }

    private void exchange(int[] num, int a, int b) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }
}
