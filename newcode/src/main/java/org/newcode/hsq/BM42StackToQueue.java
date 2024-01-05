package org.newcode.hsq;

import java.util.Stack;

/**
 * @program: <a href="https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=295&tqId=23281&ru=%2Fpractice%2Fc9480213597e45f4807880c763ddd5f0&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany">...</a>
 * @description: 用两个栈实现队列
 * 用两个栈来实现一个队列，使用n个元素来完成 n 次在队列尾部插入整数(push)和n次在队列头部删除整数(pop)的功能。
 * 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
 *
 * 思路：
 * stack1 用于入队列，stack2 用于出队列
 * 当 stack2 为空时，将stack1 中的元素全部出栈并入栈到 stack2 中，此时 stack2 的栈顶元素即为队列的队首元素
 */
public class BM42StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        return stack2.pop();
    }
}
