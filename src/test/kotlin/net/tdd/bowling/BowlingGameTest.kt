package net.tdd.bowling

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class BowlingGameTest {
    /**
     * bowling 게임은 20번의 기회가 있음
     * gutter 게임은 20번의 기회가 있을때 모든 점수가 0으로 남아야 함
     * roll은 몇개의 핀이 쓰러졌는지 기록함
     */

    // lateinit 나중에 초기화 하겠다는 의미
    lateinit var game: Game
    @BeforeEach
    fun setUp() {
        // lateinit를 초기화
        game = Game()
    }
    @Test
    fun `gutter game`() {
        rollMany(20,0)
        assertThat(game.score()).isEqualTo(0)
    }
    @Test
    fun `all one`() {
        rollMany(20,1)
        assertThat(game.score()).isEqualTo(20)
    }
    /**
     * spare는 두번의 기회에 10개의 모든 핀을 스러트리면
     * 다음 기회에 쓰러트린 핀의 개수를 보너스 점수로 받음
     * ex) spare 이후 4점을 스러트리면 4 + 4(보너스) */
    @Test
    fun `one spare`() {
        rollSpare() // spare
        game.roll(3)
        rollMany(17,0)

        assertThat(game.score()).isEqualTo(16)
    }

    @Test
    fun `one strike`() {
        rollStrike()
        game.roll(3)
        game.roll(4)
        rollMany(16,0)

        assertThat(game.score()).isEqualTo(24)
    }
    @Test
    fun `perfect game`() {
        rollMany(20, 10)

        Assertions.assertThat(game.score()).isEqualTo(300)
    }

    private fun rollStrike() {
        game.roll(10)
    }

    private fun rollSpare() {
        game.roll(5)
        game.roll(5)
    }

    private fun rollMany(n : Int, pins: Int) {
        repeat(n) {
            game.roll(pins)
        }
    }

}