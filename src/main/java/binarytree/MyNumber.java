package binarytree;

public class MyNumber {

    int value;
    MyNumber leftNumber;
    MyNumber rightNumber;

    public MyNumber(int mainNumber) {
        this.value = mainNumber;
        this.leftNumber = null;
        this.rightNumber = null;
    }

    public boolean hasNextLeft() {
        return leftNumber != null;
    }

    public boolean hasNextRight() {
        return rightNumber != null;
    }
}
