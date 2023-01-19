package binarytree;

import java.util.ArrayList;
import java.util.List;

public class TreeApp {

    public static void main(String[] args) {
        Tree tree = new Tree(new ArrayList<>());
        tree.add(5);
        tree.add(7);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);

        List<Integer> elements = tree.read();
        System.out.println(elements);
    }
}
