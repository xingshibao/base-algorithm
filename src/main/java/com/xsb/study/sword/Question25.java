package com.xsb.study.sword;

import java.util.Stack;

/**
 * @author shibao.xing
 * @since 2018-04-21 16:42
 */
public class Question25 {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(3);

        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(2);
        left.left = leftChild;

        root.left = left;
        root.right = right;

        Question25 question25 = new Question25();
        question25.findPath(root, 5);
    }

    private static class BinaryTreeNode<T> {
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
        T value;

        private BinaryTreeNode(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "BinaryTreeNode{" +
                    "value=" + value +
                    '}';
        }
    }

    private void findPath(BinaryTreeNode<Integer> root, int target) {
        if (root == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int currentSum = 0;
        findPath(root, stack, currentSum, target);
    }

    private void findPath(BinaryTreeNode<Integer> root, Stack<Integer> stack, int currentSum, int target) {
        currentSum += root.value;
        stack.push(root.value);

        if (root.left == null && root.right == null) {
            if (target == currentSum) {
                System.out.println(stack);
            }
        }

        if (root.left != null) {
            findPath(root.left, stack, currentSum, target);
        }
        if (root.right != null) {
            findPath(root.right, stack, currentSum, target);
        }

        stack.pop();
    }
}
