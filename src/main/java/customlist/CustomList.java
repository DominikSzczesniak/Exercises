package customlist;

import java.util.*;
import java.util.List;
import java.util.function.Predicate;

public class CustomList {

    private Element firstElement = null;
    private int size = 0;

    public Optional<Integer> removeFIFO() {
        if (sizeIsZero()) {
            return Optional.empty();
        }

        Element elementToRemove = firstElement;
        firstElement = firstElement.nextElement;
        size--;
        return Optional.of(elementToRemove.getValue());
    }

    public int[] getAllInOrderFIFO() {
        int[] elements = new int[size];
        Element nextElement = firstElement;

        for (int i = 0; i < size; i++) {
            elements[i] = nextElement.value;
            nextElement = nextElement.nextElement;
        }
        return elements;
    }

    public Optional<Integer> removeLIFO() {
        Element lastElement = firstElement;
        int sizeAfterRemove = size - 1;

        if (sizeIsZero()) {
            return Optional.empty();
        }

        lastElement = getElementToRemoveLIFO(lastElement, sizeAfterRemove);
        Element elementToRemove = lastElement;
        size--;
        return Optional.of(elementToRemove.getValue());
    }

    private Element getElementToRemoveLIFO(Element lastElement, int sizeAfterRemove) {
        while ((lastElement.hasNext() && sizeAfterRemove > 0)) {
            lastElement = lastElement.nextElement;
            sizeAfterRemove--;
        }
        return lastElement;
    }

    public int[] getAllInOrderLIFO() {
        int[] elements = new int[size];
        Element nextElement = firstElement;

        for (int i = size - 1; i >= 0; i--) {
            elements[i] = nextElement.value;
            nextElement = nextElement.nextElement;
        }

        return elements;
    }

    public int[] sortLowestElementToHighest() {
        int[] elements = getAllInOrderFIFO();

        return Arrays.stream(elements).
                sorted().
                toArray();
    }

    public int[] sortHighestElementToLowest() {
        int[] elements = getAllInOrderFIFO();

        return Arrays.stream(elements).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] filterBy(Predicate<Integer> condition) {
        int[] elements = new int[size];
        Element nextElement = firstElement;
        int numberOfElementsAfterFilter = 0;

        for (int i = 0; i < size; i++) {
            if (elementMeetsCondition(condition, nextElement)) {
                elements[numberOfElementsAfterFilter] = nextElement.value;
                numberOfElementsAfterFilter++;
            }
            nextElement = nextElement.nextElement;
        }

        int[] filteredElements = new int[numberOfElementsAfterFilter];
        System.arraycopy(elements, 0, filteredElements, 0, numberOfElementsAfterFilter);

        return filteredElements;
    }

    public void add(int number) {
        if (firstElement == null) {
            firstElement = new Element(number);
        } else {
            getLastElement().setNextElement(new Element(number));
        }
        size++;
    }

    public void addAll(Integer[] elements) {
        for (int i = 0; i < elements.length; i++) {
            add(elements[i]);
        }
    }

    public void addAll(List<Integer> elements) {
        for (int i = 0; i < elements.size(); i++) {
            add(elements.get(i));
        }
    }

    public void addAll(int... elements) {
        for (int element : elements) {
            add(element);
        }
    }

    public int size() {
        return size;
    }

    private static boolean elementMeetsCondition(Predicate<Integer> condition, Element nextElement) {
        return condition.test(nextElement.value);
    }

    private Element getLastElement() {
        Element lastElement = firstElement;

        while (lastElement.hasNext()) {
            lastElement = lastElement.nextElement;
        }

        return lastElement;
    }

    private boolean sizeIsZero(){
        return size == 0;
    }

    private static class Element {
        int value;
        Element nextElement;

        public Element(int value) {
            this.value = value;
        }

        public void setNextElement(Element nextElement) {
            this.nextElement = nextElement;
        }

        public int getValue() {
            return value;
        }

        public boolean hasNext() {
            return nextElement != null;
        }
    }

}

