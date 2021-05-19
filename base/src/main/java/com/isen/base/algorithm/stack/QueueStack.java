package com.isen.base.algorithm.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Isen
 * @date 2020/5/25 21:40
 * @since 1.0
 */
public class QueueStack {

    private Queue queue = new LinkedList();
    private Queue queue2 = new LinkedList();

    public void push(Object object) {
        if (!queue2.isEmpty()) {
            queue2.add(object);
            return;
        }

        queue.add(object);
    }

    public Object pop() {
        if (!queue.isEmpty()) {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue2.add(queue.poll());
            }

            return queue.poll();
        }

        if (!queue2.isEmpty()) {
            for (int i = 0; i < queue2.size() - 1; i++) {
                queue.add(queue2.poll());
            }

            return queue2.poll();
        }

        throw new RuntimeException("none element");
    }
}
