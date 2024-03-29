package org.newcode.string;

/**
 * @description:
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址
 *
 * IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
 *
 * IPv6 地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 *
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 *
 * 说明: 你可以认为给定的字符串里没有空格或者其他特殊字符。
 *
 * 思路：
 * IPV4 注意 '.' 的个数是否等于 3，段数为 4, 每段数字小于 256，没有以 0 开头的数（除了0本身）
 * IPV6 注意 ':' 的个数是否等于 7，段数为 8，每段中不包含 > f 或 > F 的字母，每段长度为4（除了0本身）。
 */
public class BM85IPAdress {
    public String solve(String IP) {
        // write code here
        if (isIPV4(IP)) {
            return "IPv4";
        }
        if (isIPV6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPV4(String IP) {
        int cnt = 0;
        for (int i = 0; i < IP.length(); i++) {
            if (IP.charAt(i) == '.') {
                cnt++;
            }
        }
        if (cnt != 3) {
            return false;
        }
        String[] splits = IP.split("\\.");
        if (splits.length != 4) {
            return false;
        }
        for (String s : splits) {
            if (s.startsWith("0") && s.length() > 1) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c < '0' || c > '9') {
                    return false;
                }
            }
            int dig = Integer.parseInt(s);
            if (dig > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean isIPV6(String IP) {
        int cnt = 0;
        for (int i = 0; i < IP.length(); i++) {
            if (IP.charAt(i) == ':') {
                cnt++;
            }
        }
        if (cnt != 7) {
            return false;
        }
        String[] splits = IP.split(":");
        if (splits.length != 8) {
            return false;
        }
        for (String s : splits) {
            if (s.length() != 4 && !"0".equals(s)) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ((c > 'f' && c <= 'z') || (c > 'F' && c < 'Z')) {
                    return false;
                }
            }
        }
        return true;
    }
}
