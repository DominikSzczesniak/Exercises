package binarytree;

import java.util.ArrayList;
import java.util.List;

public class TreeApp {

    public static void main(String[] args) {
        Tree tree = new Tree(new ArrayList<>());
        tree.add(5);
        tree.add(7);
        tree.add(9);
        tree.add(6);
        tree.add(8);
        tree.add(1);
        tree.add(2);

        Tree secondTree = new Tree(new ArrayList<>());
        secondTree.add(5);
        secondTree.add(4);
        secondTree.add(7);
        secondTree.add(2);
        secondTree.add(3);
        secondTree.add(6);
        secondTree.add(8);

        Tree thirdTree = new Tree(new ArrayList<>());
        thirdTree.add(5);
        thirdTree.add(2);
        thirdTree.add(4);
        thirdTree.add(3);
        thirdTree.add(9);
        thirdTree.add(1);
        thirdTree.add(8);

        List<Integer> elements = tree.read();
        System.out.println(tree);
        System.out.println(secondTree);
        System.out.println(thirdTree);
    }
}
