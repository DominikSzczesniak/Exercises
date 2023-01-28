package binarytree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    MyNumber startNumber = null;
    int size = 0;
    // 5, 3, 7, 2, 4, 6, 8
    // 5, 3, 2, 4, 7, 6, 8

    public void add(int value) {
        MyNumber newNumber = new MyNumber(value);

        if (startNumber == null) {
            startNumber = newNumber;
            size++;
        } else {
            MyNumber numberInAction = startNumber;
            MyNumber parent;

            while (numberInAction != null) {
                parent = numberInAction;
                if (value < numberInAction.value) {
                    numberInAction = numberInAction.leftNumber;
                    if (numberInAction == null) {
                        parent.leftNumber = newNumber;
                        size++;
                    }
                } else {
                    numberInAction = numberInAction.rightNumber;
                    if (numberInAction == null) {
                        parent.rightNumber = newNumber;
                        size++;
                    }
                }
            }
        }
    }

    public List<Integer> read() {
        List<Integer> methodList = new ArrayList<>();
        MyNumber numberInAction = startNumber;
        MyNumber parent = numberInAction;
        methodList.add(numberInAction.value);


        while (parent.hasNextLeft() && numberInAction.value <= startNumber.value) {         // TO JEST LEWA STRONA DRZEWA
            if (numberInAction.hasNextLeft() && numberInAction.hasNextRight())
                parent = numberInAction;
            if (numberInAction.hasNextLeft()) {
                numberInAction = numberInAction.leftNumber;
                methodList.add(numberInAction.value);
                if (!numberInAction.hasNextLeft() && parent.rightNumber.value < startNumber.value){
                    methodList.add(parent.rightNumber.value);
                }
            } else if (numberInAction.hasNextRight()) {
                numberInAction = numberInAction.rightNumber;
                methodList.add(numberInAction.value);
            }
        }
        return methodList;
    }

    public List<Integer> readTwo() {
        List<Integer> methodList = new ArrayList<>();
        MyNumber numberInAction = startNumber;
        MyNumber parent = numberInAction;
        methodList.add(numberInAction.value);

        while (parent.hasNextLeft() || parent.hasNextRight()) {
            parent = numberInAction;

            if (numberInAction.hasNextLeft()) {
                numberInAction = numberInAction.leftNumber;
                methodList.add(numberInAction.value);
                if (!numberInAction.hasNextLeft()) {
                    methodList.add(parent.rightNumber.value);
                }
            } else if (numberInAction.hasNextRight()) {
                numberInAction = numberInAction.rightNumber;
                methodList.add(numberInAction.value);
            }
        }

        numberInAction = startNumber;
        parent = numberInAction;

        while (parent.hasNextRight()) {
            parent = numberInAction;

            if (numberInAction.value > startNumber.value && numberInAction.hasNextLeft()) {
                methodList.add(numberInAction.leftNumber.value);
            }
            if (numberInAction.hasNextRight()) {
                numberInAction = numberInAction.rightNumber;
                methodList.add(numberInAction.value);
            }
        }
        return methodList;
    }
}


