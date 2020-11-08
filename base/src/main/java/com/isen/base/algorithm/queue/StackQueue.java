package com.isen.base.algorithm.queue;

import java.util.Stack;

/**
 * @author Isen
 * @date 2020/5/25 21:18
 * @since 1.0
 */
public class StackQueue {

    private Stack stack = new Stack();
    private Stack stack2 = new Stack();

    public void enqueue(Object object) {
        stack.push(object);
    }

    public Object dequeue() {
        if (!stack2.empty()) {
            return stack2.pop();
        }

        while(!stack.empty()) {
            stack2.push(stack.pop());
        }

        if (stack2.empty()) {
            throw new RuntimeException("none element");
        }

        return stack2.pop();

    }

}
