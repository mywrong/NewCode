package code;


/**
 * @link: <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/submissions/510137079/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @description: 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * <p>
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 你所设计的解决方案必须只使用常量级的额外空间。
 *
 * 思路：
 * 双指针，i 从前往后，j从后往前遍历。
 * 1. 如果 numbers[i] + numbers[j] == target,则返回；
 * 2. 如果 numbers[i] + numbers[j] < target，说明要增大数值，i 向后移动;
 * 3. 如果 numbers[i] + numbers[j] > target，说明要减小数值，j 向前移动;
 */
public class L167TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0, j = n - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1, -1};
    }
}
