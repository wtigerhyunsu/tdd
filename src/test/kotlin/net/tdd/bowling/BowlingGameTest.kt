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

    private fun rollMany(n : Int, pins: Int) {
        repeat(n) {
            game.roll(pins)
        }
    }

}