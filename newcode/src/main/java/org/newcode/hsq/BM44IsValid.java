package org.newcode.hsq;

import java.util.Stack;

/**
 * @program: https://www.nowcoder.com/practice/37548e94a270412c8b9fb85643c8ccc2?tpId=295&tqId=23268&ru=%2Fpractice%2Ff23604257af94d939848729b1a5cda08&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany
 * @description: 有效括号序列
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法
 *
 * 思路： 用栈来匹配
 */
public class BM44IsValid {
    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else if(c == ')' && (stack.isEmpty() || stack.pop() != '(')){
                return false;
            }else if(c == ']' && (stack.isEmpty() || stack.pop() != '[')){
                return false;
            }else if(c == '}' && (stack.isEmpty() || stack.pop() != '{')){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
