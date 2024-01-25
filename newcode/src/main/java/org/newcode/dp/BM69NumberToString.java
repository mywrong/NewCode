package org.newcode.dp;

/**
 * @link: <a href="https://www.nowcoder.com/practice/046a55e6cd274cffb88fc32dba695668?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
 * <p>
 * 现在给一串数字，返回有多少种可能的译码结果
 * 字符串长度满足  0<n<90
 *
 * 思路：
 * 若 d[i] 为 nums.sub(0,i+1) 可能的编译结果，分情况讨论：
 * 1. nums[i] 为 0，且可以和 nums[i-1] 组合，则 d[i] = d[i-2]
 * 2. nums[i] 为 0, 且不能和 nums[i-1] 组合，则 return 0
 * 3. nums[i] 不为 0，且可以和 nums[i-1] 组合，则 d[i] = d[i-1] + d[i-2]
 * 4. nums[i] 不为 0，且不能和 nums[i-1] 组合，则 d[i] = d[i-1]
 */
public class BM69NumberToString {
    public int solve(String nums) {
        // write code here
        if (nums.length() < 2) {
            return charToInt(nums.charAt(0)) == 0 ? 0 : 1;
        }
        if (charToInt(nums.charAt(0)) < 1) {
            return 0;
        }
        int a = 1;
        int b = 1;
        int res = 0;
        for (int i = 1; i < nums.length(); i++) {
            int prev = charToInt(nums.charAt(i - 1));
            int cur = charToInt(nums.charAt(i));

            if (cur == 0 && (prev == 1 || prev == 2)) {
                res = a;
            } else if ((prev == 1 && cur < 10) || (prev == 2 && cur < 7)) {
                res = a + b;
            } else if (cur > 0) {
                res = b;
            } else {
                return 0;
            }
            a = b;
            b = res;
        }
        return res;
    }

    private int charToInt(char c) {
        return Integer.parseInt(String.valueOf(c));
    }

    public static void main(String[] args) {
        BM69NumberToString s = new BM69NumberToString();
        System.out.println(s.solve("31717126241541717"));
        System.out.println(s.solve("10"));
        System.out.println(s.solve("72910721221427251718216239162221131917242"));
        System.out.println(s.solve("100"));
    }
}
