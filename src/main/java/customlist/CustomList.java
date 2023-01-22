package customlist;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomList {

    private Element firstElement = null;
    int size = 0;

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

    private Element getLastElement() {
        Element lastElement = firstElement;
        while (lastElement.hasNext()) {
            lastElement = lastElement.getNextElement();
        }
        return lastElement;
    }

    public Optional<Integer> removeFIFO() {
        if (size() == 0) {
            return Optional.empty();
        }
        if (firstElement == null) {
            return Optional.empty();
        }
        Element elementToRemove = firstElement;
        firstElement = firstElement.nextElement;
        size--;
        return Optional.of(elementToRemove.getValue());
    }

    public Optional<Integer> removeLIFO() {  // TEGO NIE WIEM !!!!!!!!!!!!!
        if (size() == 0) {
            return Optional.empty();
        }
        if (firstElement == null) {
            return Optional.empty();
        }
        firstElement = getLastElement();
        Element elementToRemove = firstElement;
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

    public int[] getAllInOrderLIFO() {
        int[] elements = new int[size];
        Element nextElement = firstElement;
        for (int i = size - 1; i >= 0; i--) { // 3
            elements[i] = nextElement.value;
            nextElement = nextElement.nextElement;
        }
        return elements;
    }

    public int[] lowestElementToHighest() {
        int[] elements = new int[size];
        Element nextElement = firstElement;
        for (int i = 0; i < size; i++) {
            elements[i] = nextElement.value;
            nextElement = nextElement.nextElement;
        }
        return Arrays.stream(elements).
                sorted().
                toArray();
    }

    public int[] highestElementToLowest() {
        int[] elements = new int[size];
        Element nextElement = firstElement;
        for (int i = 0; i < size; i++) {
            elements[i] = nextElement.value;
            nextElement = nextElement.nextElement;
        }
        return Arrays.stream(elements).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] higherThanFive() {
        int[] elements = new int[size];
        Element nextElement = firstElement;
        for (int i = 0; i < size; i++) {
            elements[i] = nextElement.value;
            nextElement = nextElement.nextElement;
        }

        return Arrays.stream(elements)
                .filter(element -> element > 5)
                .toArray();
    }

    public int size() {
        return size;
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

        public Element getNextElement() {
            return nextElement;
        }

        public int getValue() {
            return value;
        }

        public boolean hasNext() {
            return nextElement != null;
        }
    }

}

