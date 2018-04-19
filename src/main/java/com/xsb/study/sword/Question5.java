package com.xsb.study.sword;

import java.util.Stack;

/**
 * @author shibao.xing
 * @since 2018-04-14 12:30
 */
public class Question5 {

    public static void main(String[] args) {
        ListNode<Integer> tail = new ListNode<>(3, null);
        ListNode<Integer> mid = new ListNode<>(2, tail);
        ListNode<Integer> head = new ListNode<>(1, mid);

        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
//            System.out.println(yhead.getValue());
            head = head.next;
        }

        while (!stack.empty()) {
            System.out.println(stack.pop().getValue());
        }
    }

    private static class ListNode<T> {

        private T value;

        private ListNode<T> next;

        private ListNode(T value, ListNode<T> next) {
            this.value = value;
            this.next = next;
        }

        private T getValue() {
            return value;
        }
    }
}
