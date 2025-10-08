package net.tdd.bowling

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import kotlin.test.Test

class BowlingGameTest {
    /**
     * bowling 게임은 20번의 기회가 있음
     * gutter 게임은 20번의 기회가 있을때 모든 점수가 0으로 남아야 함
     * roll은 몇개의 핀이 쓰러졌는지 기록함
     */
    @Test
    fun `gutter game`() {
        val game = Game()

        repeat(20){
            game.roll(0)
        }
        assertThat(game.score()).isEqualTo(0)
    }

}