package binarytree;

import java.util.ArrayList;
import java.util.List;

public class Tree{

    List<Integer> treeNumbers;
    private int cursor = 0;
    private int leftCursor = 0;
    private int rightCursor = 0;

    public Tree(List<Integer> treeNumbers) {
        this.treeNumbers = treeNumbers;
    }

    void add(int value) {
        if (treeNumbers.size() == 0) {
            treeNumbers.add(value);
            cursor++;
        } else if (value < treeNumbers.get(0) && value < treeNumbers.get(leftCursor)) {
            treeNumbers.add(leftCursor + 1, value);
            cursor++;
            leftCursor++;
        } else if (value < treeNumbers.get(0) && value > treeNumbers.get(leftCursor)) {
            treeNumbers.add(leftCursor + 1, value);
            cursor++;
            //leftCursor++;
        } else if (value < treeNumbers.get(0)) {
            treeNumbers.add(leftCursor + 1, value);
            cursor++;
            leftCursor++;
        } else if (value < treeNumbers.get(rightCursor) && value > treeNumbers.get(0)) {
            treeNumbers.add(cursor - 1, value);
            cursor++;
        } else if (value > treeNumbers.get(0) && value < rightCursor) {
            treeNumbers.add(cursor - 1, value);
            cursor++;
            rightCursor++;
        } else {
            treeNumbers.add(cursor, value);
            cursor++;
            rightCursor++;
        }
    }

    // 5, 3, 7, 2, 4, 6, 8
    List<Integer> read() {
        List<Integer> methodList = new ArrayList<>();


        return methodList;


//        for (int i = 0; i < treeNumbers.size(); i++) {
//            if (i == 0) {
//                methodList.add(treeNumbers.get(i));
//            } else if (treeNumbers.get(i) < treeNumbers.get(i - 1)) {  // liczba jest mniejsza od poprzedniej
//                methodList.add(treeNumbers.get(i));
//                for (int k = i ; k < treeNumbers.size(); k++) {  // cos tu przypisac do k moze innego
//                    if (treeNumbers.get(k) < treeNumbers.get(i)) { // liczba jest mniejsza od i
//                        methodList.add(treeNumbers.get(k));
//                    }
//                }
//                // kolejna petla?
//            } else methodList.add(treeNumbers.get(i));
//        }
//        return methodList;
    }


    @Override
    public String toString() {
        return "Tree{" +
                "treeNumbers=" + treeNumbers +
                '}';
    }
}


