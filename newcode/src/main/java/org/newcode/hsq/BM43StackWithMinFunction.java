package org.newcode.hsq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @program: <a href="https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min 函数，输入操作时保证 pop、top 和 min 函数操作时，栈中一定有元素。
 * 此栈包含的方法有：
 * push(value):将value压入栈中
 * pop():弹出栈顶元素
 * top():获取栈顶元素
 * min():获取栈中最小元素
 *
 * 思路：在入栈时，将当前元素与栈顶元素的最小值一起入栈，这样栈顶元素就是当前栈中的最小值
 */
public class BM43StackWithMinFunction {

    private final Stack<List<Integer>> stack = new Stack<>();

    public void push(int node) {
        int min = stack.isEmpty() ? node : Math.min(stack.peek().get(1), node);
        stack.push(new ArrayList<>(Arrays.asList(node, min)));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().get(0);
    }

    public int min() {
        return stack.peek().get(1);
    }
}
