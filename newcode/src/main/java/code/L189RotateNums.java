package code;

import java.util.Arrays;

/**
 * @link: <a href="https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 *
 * @description: 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 思路：
 * 右移k个相当于把最右边 k 个元素放到最左边，等价于：
 * 1. 把数组全部翻转
 * 2. 翻转第 0 到 k-1 个元素
 * 3. 翻转第 k 到 nums.length-1 个元素
 */

public class L189RotateNums {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    private void rotate(int[] nums, int beg, int end) {
        while (beg < end) {
            swap(nums, beg++, end--);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        L189RotateNums l189RotateNums = new L189RotateNums();
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] nums = new int[]{-1};
        l189RotateNums.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
