package binarytree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private Node root = null;

    public void add(final int value) {
        final Node nodeToAdd = new Node(value);

        if (root == null) {
            root = nodeToAdd;
            return;
        }
        if (value != root.getValue()) {
            Node placeToAdd = root;
            Node parent;

            while (placeToAdd != null) {
                parent = placeToAdd;
                if (value < placeToAdd.getValue()) {
                    placeToAdd = placeToAdd.getLeft();
                    if (placeToAdd == null) {
                        parent.setLeft(nodeToAdd);
                    }
                } else {
                    placeToAdd = placeToAdd.getRight();
                    if (placeToAdd == null) {
                        parent.setRight(nodeToAdd);
                    }
                }
            }
        }
    }


    public List<Integer> read() {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        readNode(root, result);
        return result;
    }

    private void readNode(final Node node, List<Integer> result) {
        result.add(node.getValue());
        if (node.hasNextLeft()) {
            readNode(node.getLeft(), result);
        }
        if (node.hasNextRight()) {
            readNode(node.getRight(), result);
        }
    }

}


