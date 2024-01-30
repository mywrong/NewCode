package org.newcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @link: <a href="https://www.nowcoder.com/practice/ce73540d47374dbe85b3125f57727e1e?tpId=295&tqId=653&ru=%2Fpractice%2F6d29638c85bb4ffd80c020fe244baf11&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 现在有一个只包含数字的字符串，将该字符串转化成IP地址的形式，返回所有可能的情况。
 * 例如：
 * 给出的字符串为"25525522135",
 * 返回["255.255.22.135", "255.255.221.35"]. (顺序没有关系)
 * 字符串长度 0<= n <=12
 * 时空复杂度 O(n!)
 * 注意：ip地址是由四段数字组成的数字序列，格式如 "x.x.x.x"，其中 x 的范围应当是 [0,255]。
 *
 * 思路：
 * 枚举法
 * 三个点可能出现的位置是有限的，第一个点的位置 i 在 [1,3],第二个点的位置 j 在[i+1,i+3], 第三个点的位置 k 在 [j+1,j+3]
 * 三层循环枚举出三个点可能的位置，并判断每段数字是否合法
 */
public class BM74RestoreIpAddresses {


    public ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        int n = s.length();
        ArrayList<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        for (int i = 1; i < 4 && i < n; i++) {
            String a = s.substring(0, i);
            if (!isVaild(a)) {
                continue;
            }
            path.add(a);
            for (int j = i + 1; j < i + 4 && j < n; j++) {
                String b = s.substring(i, j);
                if (!isVaild(b)) {
                    continue;
                }
                path.add(b);
                for (int k = j + 1; k < j + 4 && k < n; k++) {
                    String c = s.substring(j, k);
                    String d = s.substring(k, n);
                    if (!isVaild(c) || !isVaild(d)) {
                        continue;
                    }
                    path.add(c);
                    path.add(d);
                    String tmpRes = String.join(".", path);
                    res.add(tmpRes);
                    path.remove(path.size() - 1);
                    path.remove(path.size() - 1);
                }
                path.remove(path.size() - 1);
            }
            path.remove(path.size() - 1);
        }
        return res;

    }

    private boolean isVaild(String s) {
        if (s == null || s.length() == 0 || s.length() > 3) {
            return false;
        }
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }

}
