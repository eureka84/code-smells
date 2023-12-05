package tic.tac.toe

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GameTest {

    private lateinit var game: Game

    @BeforeEach
    fun setUp() {
        game = Game()
    }

    @Test
    fun `should not allow player O to play first`() {
        assertThrows<RuntimeException> {
            game.play("", 0, 0);
        }
    };

    @Test
    fun `should not allow player x to play twice in a row`() {
        game.play("X", 0, 0);
        assertThrows<RuntimeException> {
            game.play("X", 1, 0);
        }
    }

    @Test
    fun `should not allow a player to play in last played position`() {
        game.play("X", 0, 0);
        assertThrows<RuntimeException> {
            game.play("O", 0, 0);
        }
    }

    @Test
    fun `should not allow a player to play in any played position`() {
        game.play("X", 0, 0);
        game.play("O", 1, 0);
        assertThrows<RuntimeException> {
            game.play("X", 0, 0);
        }
    }

    @Test
    fun `should declare player X as winner if it plays three in top row`() {
        game.play("X", 0, 0);
        game.play("O", 1, 0);
        game.play("X", 0, 1);
        game.play("O", 1, 1);
        game.play("X", 0, 2);

        val winner = game.winner();

        assertEquals("X", winner);
    }

    @Test
    fun `should declare player O as winner if it plays three in top row`() {
        game.play("X", 1, 0);
        game.play("O", 0, 0);
        game.play("", 1, 1);
        game.play("O", 0, 1);
        game.play("X", 2, 2);
        game.play("O", 0, 2);

        val winner = game.winner();

        assertEquals("O", winner);
    }

    @Test
    fun `should declare player X as winner if it plays three in middle row`() {
        game.play("X", 1, 0);
        game.play("O", 0, 0);
        game.play("X", 1, 1);
        game.play("O", 0, 1);
        game.play("X", 1, 2);

        val winner = game.winner();

        assertEquals("X", winner);
    }

    @Test
    fun `should declare player O as winner if it plays three in middle row`() {
        game.play("X", 0, 0);
        game.play("O", 1, 0);
        game.play("X", 2, 1);
        game.play("O", 1, 1);
        game.play("X", 2, 2);
        game.play("O", 1, 2);

        val winner = game.winner();

        assertEquals("O", winner);
    }

    @Test
    fun `should declare player X as winner if it plays three in bottom row`() {
        game.play("X", 2, 0);
        game.play("O", 0, 0);
        game.play("X", 2, 1);
        game.play("O", 0, 1);
        game.play("X", 2, 2);

        val winner = game.winner();

        assertEquals("X", winner);
    }

    @Test
    fun `should declare player O as winner if it plays three in bottom row`() {
        game.play("X", 0, 0);
        game.play("O", 2, 0);
        game.play("X", 1, 1);
        game.play("O", 2, 1);
        game.play("X", 0, 1);
        game.play("O", 2, 2);

        val winner = game.winner();

        assertEquals("O", winner);
    }
}
