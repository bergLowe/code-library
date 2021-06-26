import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
            return false;
        }

        stack.addLast(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!(stack.isEmpty()) && stack.peekLast() == '(') {
                    stack.pollLast();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (!(stack.isEmpty()) && stack.peekLast() == '{') {
                    stack.pollLast();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (!(stack.isEmpty()) && stack.peekLast() == '[') {
                    stack.pollLast();
                } else {
                    return false;
                }
            } else {
                stack.addLast(s.charAt(i));
            }
        }

        return stack.size() == 0;
    }
}import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
            return false;
        }

        stack.addLast(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!(stack.isEmpty()) && stack.peekLast() == '(') {
                    stack.pollLast();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (!(stack.isEmpty()) && stack.peekLast() == '{') {
                    stack.pollLast();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (!(stack.isEmpty()) && stack.peekLast() == '[') {
                    stack.pollLast();
                } else {
                    return false;
                }
            } else {
                stack.addLast(s.charAt(i));
            }
        }

        return stack.size() == 0;
    }
}