package com.xsb.study.sword;

/**
 * @author shibao.xing
 * @since 2018-04-21 16:21
 */
public class Question39 {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(3);

        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(100);
        left.left = leftChild;

        root.left = left;
        root.right = right;

        Question39 question39 = new Question39();
        int depth = question39.depth(root);
        System.out.println(depth);
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

    private int depth(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int rigth = depth(root.right);

        return (left > rigth) ? left + 1 : rigth + 1;
    }

}
