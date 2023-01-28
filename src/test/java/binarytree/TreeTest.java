package binarytree;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class TreeTest {

    private final Tree tut = new Tree();

    @Test
    void should_add_numbers() {
        tut.add(8);
        tut.add(6);
        tut.add(9);
        tut.add(5);
        tut.add(3);
        tut.add(4);
        tut.add(2);
        tut.add(1);
        tut.add(7);

        assertThat(tut.size).isEqualTo(9);
    }

//    @Test
//    void should_read_all_elements_in_binary_tree_order() { //zamkniety w nieskonczonej petli
//        tut.add(5);
//        tut.add(3);
//        tut.add(7);
//        tut.add(2);
//        tut.add(4);
//        tut.add(6);
//        tut.add(8);
//
//        tut.read();
//
//        assertThat(tut.read()).containsExactly(5, 3, 2, 4, 7, 6, 8);
//    }

    @Test
    void should_read_all_elements_in_binary_tree_order_two() {
        tut.add(5);
        tut.add(3);
        tut.add(7);
        tut.add(2);
        tut.add(4);
        tut.add(6);
        tut.add(8);

        List<Integer> elements = tut.readTwo();

        assertThat(elements).containsExactly(5, 3, 2, 4, 7, 6, 8);
    }

    @Test
    void should_read_all_elements_in_binary_tree_order_two_second() {
        tut.add(8);
        tut.add(6);
        tut.add(9);
        tut.add(5);
        tut.add(3);
        tut.add(4);
        tut.add(2);
        tut.add(1);
        tut.add(7);

        List<Integer> elements = tut.readTwo();

        assertThat(elements).containsExactly(8, 6, 5, 3, 2, 1, 4, 7, 9);
    }



}