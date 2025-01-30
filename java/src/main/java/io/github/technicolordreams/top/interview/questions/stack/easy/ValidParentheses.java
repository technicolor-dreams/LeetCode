package io.github.technicolordreams.top.interview.questions.stack.easy;

import java.util.Map;
import java.util.Stack;

/**
 * <h1><a href="https://leetcode.com/problems/valid-parentheses/description/">20. Valid Parentheses</a></h1>
 */
public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
//        System.out.println(validParentheses.solution("()"));
//        System.out.println(validParentheses.solution("(){}[]"));
//        System.out.println(validParentheses.solution("(]"));
//        System.out.println(validParentheses.solution("([)]"));
        System.out.println(validParentheses.solution("({[)"));
    }

    public boolean solution(String s) {
        Map<Character, Character> validParentheses = Map.of('(', ')', '{', '}', '[', ']');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(c);
                continue;
            }

            if (validParentheses.containsKey(stack.peek())) {
                if (c == validParentheses.get(stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                return false;
            }
        }

        return stack.empty();
    }
}
