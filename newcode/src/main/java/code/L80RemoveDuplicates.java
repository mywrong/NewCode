package code;

import java.util.Arrays;

/**
 * @link: <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 *
 * @description: 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 思路： 双指针
 * slow 指向新数组的最后一位
 * fast 遍历原数组，用cnt记录连续相同的元素个数，
 *      当 nums[fast] == nums[fast-1] 时，cnt++,否则 cnt = 1
 *      当cnt<=2时，nums[slow++] = nums[fast]
 * 最后返回 slow
 *
 */
public class L80RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int cnt = 1;
        int slow = 0, fast = 0;
        for (; fast < nums.length; fast++) {
            if (fast > 0 && nums[fast] == nums[fast - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt <= 2) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        L80RemoveDuplicates l80RemoveDuplicates = new L80RemoveDuplicates();
        int[] nums = new int[]{1,1,1,2,2,4,4,4,4,5,6};
        System.out.println(l80RemoveDuplicates.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
