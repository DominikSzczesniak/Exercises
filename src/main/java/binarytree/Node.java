package binarytree;

import static java.util.Objects.requireNonNull;

public class Node {

    private final int value;
    private Node left;
    private Node right;


    public Node(int mainNumber) {
        this.value = mainNumber;
        this.left = null;
        this.right = null;
    }

    public boolean hasNextLeft() {
        return left != null;
    }

    public boolean hasNextRight() {
        return right != null;
    }

    public void setLeft(Node left) {
        this.left = requireNonNull(left);
    }

    public void setRight(Node right) {
        this.right = requireNonNull(right);
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
