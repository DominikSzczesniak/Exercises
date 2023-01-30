package binarytree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    List<Integer> recursionList = new ArrayList<>();
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
        methodList.add(numberInAction.value);
        MyNumber parent = findLastParentWithRightNumber();

        while (numberInAction.hasNextLeft()) {                    // LEWA STRONA DRZEWA
            numberInAction = numberInAction.leftNumber;
            methodList.add(numberInAction.value);
        }
        while (parent != startNumber) {
            if (numberInAction.hasNextRight()) {
                methodList.add(numberInAction.rightNumber.value);
            } else if (parent.hasNextRight()) {
                methodList.add(parent.rightNumber.value);
                parent.rightNumber = null;
                parent = findLastParentWithRightNumber();             // LEWA STRONA DRZEWA
            }
        }

        numberInAction = startNumber;

        while (numberInAction.hasNextRight()) {                  // PRAWA STRONA DRZEWA
            numberInAction = numberInAction.rightNumber;
            methodList.add(numberInAction.value);
            if (numberInAction.hasNextLeft()) {
                methodList.add(numberInAction.leftNumber.value); // PRAWA STRONA DRZEWA
            }
        }

        return methodList;
    }

    public List<Integer> readTwo() {
        List<Integer> methodList = new ArrayList<>();
        MyNumber numberInAction = startNumber;
        methodList.add(numberInAction.value);
        MyNumber parent = findLastParentWithRightNumber();

        while (numberInAction.hasNextLeft()) {
            numberInAction = numberInAction.leftNumber;
            methodList.add(numberInAction.value);
        }

        numberInAction = parent.rightNumber;
        while (parent.hasNextRight() && numberInAction != null) {
            methodList.add(numberInAction.value);
            if (numberInAction.hasNextLeft()) {
                numberInAction = numberInAction.leftNumber;
                methodList.add(numberInAction.value);
            }
            numberInAction = numberInAction.rightNumber;
            if (numberInAction == null) {
                parent.rightNumber = null;
                if (findLastParentWithRightNumber() != null) {
                    parent = findLastParentWithRightNumber();
                    numberInAction = parent.rightNumber;
                }
            }
        }


        return methodList;
    }

    public List<Integer> readThree() {
        List<Integer> methodList = new ArrayList<>();
        MyNumber numberInAction = startNumber;
        methodList.add(numberInAction.value);
        size--;
        numberInAction = numberInAction.leftNumber;

        while (size != 0) {
            if (numberInAction.value < startNumber.value) {
                methodList.add(numberInAction.value);
                size--;
                if (numberInAction.hasNextLeft()) {
                    numberInAction = numberInAction.leftNumber;
                }
            } else {
                methodList.add(numberInAction.value);
                size--;
                if (numberInAction.hasNextRight()) {
                    numberInAction = numberInAction.rightNumber;
                }
            }
        }

        return methodList;
    }

    public List<Integer> readFour() {
        List<Integer> methodList = new ArrayList<>();
        MyNumber numberInAction = startNumber;
        MyNumber numberInActiontwo = startNumber;
        methodList.add(numberInAction.value);
        size--;

        while (size != 0) {
            if (numberInAction.hasNextLeft()) {
                numberInAction = numberInAction.leftNumber;
                methodList.add(numberInAction.value);
                size--;
            }
            if (numberInActiontwo.hasNextLeft()) {
                numberInActiontwo = numberInActiontwo.leftNumber;
                if (numberInActiontwo.hasNextRight()) {
                    numberInActiontwo = numberInActiontwo.rightNumber;
                    methodList.add(numberInActiontwo.value);
                    size--;
                }
            }

        }


        return methodList;
    }


    private void addByRecursion(MyNumber number) {
        if (number == null) {
            return;
        }
        recursionList.add(number.value);
        addByRecursion(number.leftNumber);
        addByRecursion(number.rightNumber);
    }

    public List<Integer> readRecursion() {
        addByRecursion(startNumber);
        return recursionList;
    }

    public MyNumber findLastParentWithRightNumber() {
        MyNumber lastParent = null;
        MyNumber preLastNumberL = startNumber;
        MyNumber lastNumberL = startNumber.leftNumber;
        while (preLastNumberL.hasNextLeft()) {
            if (preLastNumberL.hasNextRight()) {
                lastParent = preLastNumberL;
            }
            preLastNumberL = lastNumberL;
            lastNumberL = lastNumberL.leftNumber;
        }
        return lastParent;
    }

}


