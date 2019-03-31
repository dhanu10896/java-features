package problems.onbinarytree;

import edu.princeton.cs.algs4.In;

import java.util.Deque;
import java.util.LinkedList;

public class TreeTraversal {
    static void preOrder(BinaryTreeNode<Integer> root) {
        if (root != null) {
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    static void nonRecursivePreOrder(BinaryTreeNode<Integer> root) {
        Deque<BinaryTreeNode<Integer>> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                System.out.print(root.data + " ");
                stack.addFirst(root);
                root = root.left;
            }
            root = stack.removeFirst();
            root = root.right;
        }
    }

    static void inOrder(BinaryTreeNode<Integer> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    static void nonRecursivepostOrder(BinaryTreeNode<Integer> root) {
        Deque<BinaryTreeNode<Integer>> stack = new LinkedList<>();
        Deque<BinaryTreeNode<Integer>> result = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
                root = stack.removeFirst();
                result.addFirst(root);
                if (root.left != null) stack.addFirst(root.left);
                if (root.right != null) stack.addFirst(root.right);
        }
        while (!result.isEmpty()) {
            System.out.print(result.removeFirst().data+" ");
        }
    }

    static void nonRecursiveinOrder(BinaryTreeNode<Integer> root) {
        Deque<BinaryTreeNode<Integer>> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
            root = stack.removeFirst();
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    static void postOrder(BinaryTreeNode<Integer> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }

    static void levelOrder(BinaryTreeNode<Integer> root) {
        Deque<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
          BinaryTreeNode<Integer> currentNode = queue.removeLast();
            System.out.print(currentNode.data + " ");
            if (currentNode.left != null)
            queue.addFirst(currentNode.left);

            if (currentNode.right != null)
            queue.addFirst(currentNode.right);
        }
    }

    public static void main(String[] args) {
        System.out.print("pre  -> ");preOrder(BinaryTreeUtils.getSampleTree(2));
        System.out.print("\npre  -> ");nonRecursivePreOrder(BinaryTreeUtils.getSampleTree(4));
        System.out.print("\nin   -> ");inOrder(BinaryTreeUtils.getSampleTree(4));
        System.out.print("\nin   -> ");nonRecursiveinOrder(BinaryTreeUtils.getSampleTree(4));
        System.out.print("\npost -> ");postOrder(BinaryTreeUtils.getSampleTree(4));
        System.out.print("\npost -> ");nonRecursivepostOrder(BinaryTreeUtils.getSampleTree(4));
        System.out.print("\nlevelOrder -> ");levelOrder(BinaryTreeUtils.getSampleTree(4));
    }
}
