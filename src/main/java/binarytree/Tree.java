package binarytree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    List<Integer> treeNumbers;

    public Tree(List<Integer> treeNumbers) {
        this.treeNumbers = treeNumbers;
    }

    void add(int value) {
        treeNumbers.add(value);
    }


    List<Integer> read() {
        List<Integer> methodList = new ArrayList<>();
        for (int i = 0; i < treeNumbers.size(); i++) {
            if (i == 0) {
                methodList.add(treeNumbers.get(i));
            } else if (treeNumbers.get(i) < treeNumbers.get(0)) {  // MNIEJSZE OD PIERWSZEJ
                methodList.add(treeNumbers.get(i));
            }
        }

        for (int k = 0; k < treeNumbers.size(); k++) {
            if (treeNumbers.get(k) > treeNumbers.get(0))
                methodList.add(treeNumbers.get(k));
        }
        return methodList;
    }


    @Override
    public String toString() {
        return "Tree{" +
                "treeNumbers=" + treeNumbers +
                '}';
    }
}
