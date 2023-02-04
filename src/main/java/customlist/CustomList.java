package customlist;

import java.util.*;
import java.util.function.Predicate;

public class CustomList {

    private Element firstElement = null;
    private int size = 0;

    public void add(final int number) {
        final Element newElement = new Element(number);
        getLastElement().ifPresentOrElse(
                lastElement -> lastElement.setNextElement(newElement),
                () -> firstElement = newElement);
        size++;
    }

    private Optional<Element> getLastElement() {
        if (firstElement == null) {
            return Optional.empty();
        }
        Element lastElement = firstElement;

        while (lastElement.hasNext()) {
            lastElement = lastElement.nextElement;
        }

        return Optional.of(lastElement);
    }

    public void addAll(final Integer[] elements) {
        for (Integer element : elements) {
            add(element);
        }
    }

    public void addAll(final List<Integer> elements) {
        for (Integer element : elements) {
            add(element);
        }
    }

    public void addAll(final int... elements) {
        for (int element : elements) {
            add(element);
        }
    }

    public int[] getAllInOrderFIFO() {
        final int[] elements = new int[size];
        Element element = firstElement;

        for (int i = 0; i < size; i++) {
            elements[i] = element.value;
            element = element.nextElement;
        }
        return elements;
    }

    public Optional<Integer> removeFIFO() {
        if (size == 0) {
            return Optional.empty();
        }

        Element elementToRemove = firstElement;
        firstElement = firstElement.nextElement;
        size--;
        return Optional.of(elementToRemove.getValue());
    }

    public int[] getAllInOrderLIFO() {
        final int[] elements = new int[size];
        Element nextElement = firstElement;

        for (int i = size - 1; i >= 0; i--) {
            elements[i] = nextElement.value;
            nextElement = nextElement.nextElement;
        }
        return elements;
    }

    public Optional<Integer> removeLIFO() {
        if (size() == 0) {
            return Optional.empty();
        }
        if (size() == 1) {
            int value = firstElement.value;
            firstElement = null;
            size--;
            return Optional.of(value);
        }
        Element preLastElement = findPreLastElement();
        Element lastElement = preLastElement.nextElement;
        preLastElement.setNextElement(null);
        size--;
        return Optional.of(lastElement.value);
    }

    private Element findPreLastElement() {
        Element preLastElement = firstElement;
        Element lastElement = firstElement.nextElement;
        while (lastElement.hasNext()) {
            preLastElement = lastElement;
            lastElement = lastElement.nextElement;
        }
        return preLastElement;
    }

    public int[] sortLowestElementToHighest() {
        final int[] elements = getAllInOrderFIFO();

        return Arrays.stream(elements).
                sorted().
                toArray();
    }

    public int[] sortHighestElementToLowest() {
        final int[] elements = getAllInOrderFIFO();

        return Arrays.stream(elements).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] filterBy(final Predicate<Integer> criteria) {
        final int[] elements = new int[size];
        Element nextElement = firstElement;
        int numberOfElementsAfterFilter = 0;

        for (int i = 0; i < size; i++) {
            if (elementMeetsCondition(criteria, nextElement)) {
                elements[numberOfElementsAfterFilter] = nextElement.value;
                numberOfElementsAfterFilter++;
            }
            nextElement = nextElement.nextElement;
        }

        int[] filteredElements = new int[numberOfElementsAfterFilter];
        System.arraycopy(elements, 0, filteredElements, 0, numberOfElementsAfterFilter);

        return filteredElements;
    }

    public int size() {
        return size;
    }

    private static boolean elementMeetsCondition(Predicate<Integer> condition, Element nextElement) {
        return condition.test(nextElement.value);
    }

    private static class Element {
        int value;
        Element nextElement;

        public Element(final int value) {
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