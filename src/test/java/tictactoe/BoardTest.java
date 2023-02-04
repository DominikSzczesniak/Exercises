package tictactoe;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    private Board tut = new Board();

    @Test
    void should_return_true_spot_is_taken() {
        // when
        tut.board[0][0] = "X";

        // expect
        assertThat(tut.spotIsTaken(0)).isEqualTo(true);
    }

    @Test
    void shouldnt_return_true_spot_is_taken() {
        // expect
        assertThat(tut.spotIsTaken(1)).isEqualTo(false);
    }

    @Test
    void should_end_game() {
        // when
        tut.board[0][0] = "X";
        tut.board[0][1] = "X";
        tut.board[0][2] = "X";

        // expect
        assertThat(tut.gameIsOver()).isEqualTo(true);
    }

    @Test
    void shouldnt_end_game() {
        // when
        tut.board[0][0] = "X";
        tut.board[0][1] = "◯";
        tut.board[0][2] = "X";

        // expect
        assertThat(tut.gameIsOver()).isEqualTo(false);
    }
}