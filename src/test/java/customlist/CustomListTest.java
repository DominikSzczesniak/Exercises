package customlist;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CustomListTest {

    private final CustomList tut = new CustomList();

    @Test
    void empty_list_should_have_0_size() {
        // expect
        assertThat(tut.size()).isEqualTo(0);
    }

    @Test
    void should_return_nothing() {
        // expect
        assertThat(tut.removeFIFO()).isEmpty();
    }

    @Test
    void should_add_elements() {
        // when
        tut.add(1);
        tut.add(10);
        tut.add(2);

        // then
        assertThat(tut.size()).isEqualTo(3);
    }

    @Test
    void should_add_duplicated_element() {
        // when
        tut.add(1);
        tut.add(10);
        tut.add(2);
        tut.add(10);

        // then
        assertThat(tut.size()).isEqualTo(4);
    }

    @Test
    void should_add_all_elements_from_array() {
        // given
        Integer[] numbers = {1, 2, 3, 4, 5};

        // when
        tut.addAll(numbers);

        // then
        assertThat(tut.size()).isEqualTo(5);
    }

    @Test
    void should_add_all_elements_from_list() {
        // given
        List<Integer> list = List.of(4, 5, 7, 8, 9, 12);

        // when
        tut.addAll(list);

        // then
        assertThat(tut.size()).isEqualTo(6);
    }

    @Test
    void should_add_all_int_elements() {
        // when
        tut.addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // then
        assertThat(tut.size()).isEqualTo(10);
    }

    @Test
    void should_read_all_added_elements_in_order_FIFO() {
        // given
        tut.add(7);
        tut.add(3);
        tut.add(10);

        // when
        int[] elements = tut.getAllInOrderFIFO();

        // then
        assertThat(elements).containsExactly(7, 3, 10);
    }

    @Test
    void should_read_all_added_elements_in_order_LIFO() {
        // when
        tut.add(7);
        tut.add(3);
        tut.add(10);
        tut.add(2);

        // when
        int[] elements = tut.getAllInOrderLIFO();

        // then
        assertThat(elements).containsExactly(2, 10, 3, 7);
    }

    @Test
    void should_remove_added_elements_in_order_FIFO() {
        // when
        tut.add(1);
        tut.add(10);
        tut.add(2);

        // expect
        assertThat(tut.removeFIFO()).get().isEqualTo(1);
        assertThat(tut.size()).isEqualTo(2);

        assertThat(tut.removeFIFO()).get().isEqualTo(10);
        assertThat(tut.size()).isEqualTo(1);

        assertThat(tut.removeFIFO()).get().isEqualTo(2);
        assertThat(tut.size()).isEqualTo(0);

        assertThat(tut.removeFIFO()).isEmpty();
    }

    @Test
    void should_remove_added_elements_in_order_LIFO() {
        // when
        tut.add(4);
        tut.add(5);
        tut.add(10);
        tut.add(10);
        tut.add(1);

        // expect
        assertThat(tut.removeLIFO()).get().isEqualTo(1);
        assertThat(tut.size()).isEqualTo(4);

        assertThat(tut.removeLIFO()).get().isEqualTo(10);
        assertThat(tut.size()).isEqualTo(3);

        assertThat(tut.removeLIFO()).get().isEqualTo(10);
        assertThat(tut.size()).isEqualTo(2);

        assertThat(tut.removeLIFO()).get().isEqualTo(5);
        assertThat(tut.size()).isEqualTo(1);

        assertThat(tut.removeLIFO()).get().isEqualTo(4);
        assertThat(tut.size()).isEqualTo(0);

        assertThat(tut.removeLIFO()).isEmpty();
    }

    @Test
    void should_return_lowest_value_to_highest() {
        // given
        tut.add(11);
        tut.add(10);
        tut.add(2);
        tut.add(5);
        tut.add(1);

        // when
        int[] elements = tut.sortLowestElementToHighest();

        // then
        assertThat(elements).containsExactly(1, 2, 5, 10, 11);
    }

    @Test
    void should_return_highest_value_to_lowest() {
        // when
        tut.add(11);
        tut.add(10);
        tut.add(2);
        tut.add(5);
        tut.add(1);

        int[] elements = tut.sortHighestElementToLowest();

        // then
        assertThat(elements).containsExactly(11, 10, 5, 2, 1);
    }

    @Test
    void should_return_values_higher_than_five() {
        // when
        tut.add(11);
        tut.add(10);
        tut.add(2);
        tut.add(7);
        tut.add(1);

        int[] elements = tut.filterBy((element) -> element > 5);

        // then
        assertThat(elements).containsExactly(11, 10, 7);
    }
}