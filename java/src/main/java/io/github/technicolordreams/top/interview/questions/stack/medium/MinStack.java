package io.github.technicolordreams.top.interview.questions.stack.medium;

import java.util.Map;
import java.util.Stack;

/**
 * <h1><a href="https://leetcode.com/problems/min-stack/description/">155. Min Stack</a></h1>
 * <h2>Medium</h2>
 * <h3>2025-02-05</h3>
 * <h4>4:35</h4>
 */
public class MinStack {

    private final Stack<Map.Entry<Integer, Integer>> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if (this.stack.empty()) {
            this.stack.push(Map.entry(val, val));
            return;
        }

        int min = Math.min(val, this.stack.peek().getValue());
        Map.Entry<Integer, Integer> entry = Map.entry(val, min);
        this.stack.push(entry);
    }

    public void pop() {
        this.stack.pop();
    }

    public int top() {
        return this.stack.peek().getKey();
    }

    public int getMin() {
        return this.stack.peek().getValue();
    }
}
