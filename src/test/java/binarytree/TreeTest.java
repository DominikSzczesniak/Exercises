package binarytree;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class TreeTest {

    private final Tree tut = new Tree();

    @Test
    void should_add_nodes() {
        // when
        tut.add(8);
        tut.add(6);
        tut.add(9);
        tut.add(5);
        tut.add(3);
        tut.add(4);
        tut.add(2);
        tut.add(1);
        tut.add(-7);

        // then
        assertThat(tut.read()).hasSize(9);
    }

    @Test
    void should_not_add_duplicated_nodes() {
        // when
        tut.add(5);
        tut.add(3);
        tut.add(7);
        tut.add(2);
        tut.add(4);
        tut.add(6);
        tut.add(8);
        tut.add(5);

        // then
        assertThat(tut.read()).hasSize(7);
        assertThat(tut.read()).containsExactly(5, 3, 2, 4, 7, 6, 8);
    }

    @Test
    void should_read_all_elements_in_binary_tree_order_one() {
        // when
        tut.add(5);
        tut.add(3);
        tut.add(7);
        tut.add(2);
        tut.add(4);
        tut.add(6);
        tut.add(8);

        // then
        List<Integer> elements = tut.read();

        assertThat(elements).containsExactly(5, 3, 2, 4, 7, 6, 8);
    }

    @Test
    void should_read_all_elements_in_binary_tree_order_two() {
        // given
        tut.add(8);
        tut.add(6);
        tut.add(9);
        tut.add(5);
        tut.add(3);
        tut.add(4);
        tut.add(2);
        tut.add(1);
        tut.add(7);

        // when
        List<Integer> elements = tut.read();

        // then
        assertThat(elements).containsExactly(8, 6, 5, 3, 2, 1, 4, 7, 9);
    }

    @Test
    void should_read_all_elements_in_binary_tree_order_two_three() {
        // given
        tut.add(10);
        tut.add(7);
        tut.add(6);
        tut.add(8);
        tut.add(3);
        tut.add(9);

        // when
        List<Integer> elements = tut.read();

        // then
        assertThat(elements).containsExactly(10, 7, 6, 3, 8, 9);
    }

    @Test
    void should_read_all_elements_in_binary_tree_order_four() {
        // given
        tut.add(5);
        tut.add(3);
        tut.add(7);
        tut.add(2);
        tut.add(4);
        tut.add(6);
        tut.add(8);

        // when
        List<Integer> numbers = tut.read();

        // then
        assertThat(numbers).containsExactly(5, 3, 2, 4, 7, 6, 8);
    }
}