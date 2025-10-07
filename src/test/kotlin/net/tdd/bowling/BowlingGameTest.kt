package net.tdd.bowling

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test



class BowlingGameTest {

    lateinit var game: Game

    @BeforeEach
    fun setUp() {
        game = Game()
    }

    @Test
    //gutter game: 0
    fun `gutter game`() {
        rollMany(20, 0)
        assertThat(game.score()).isEqualTo(0)

    }
    @Test
    fun `all ones`(){
        rollMany(20, 1)
        assertThat(game.score()).isEqualTo(20)

    }
    /* 두번의 기회에 10개의 모든 핀을 쓰러트린 경우
    * 3번쨰 쓰러트린 만큼의 보너스 점수를 받을수 있다
    */
    @Test
    fun `one spare`(){
        rollSpare()
        game.roll(3)

        rollMany(17, 0)

        assertThat(game.score()).isEqualTo(10 + 3 + 3)
    }
    /*스트라이크 한 frame에 다음 두번 던진 점수를 보너스 점수로 추가 한다*/
    @Test
    fun `one strike`(){
        rollStrike()
        game.roll(3)
        game.roll(4)
        rollMany(16, 0)

        assertThat(game.score()).isEqualTo(10+3+4+3+4)

    }
    @Test
    fun `perfect game`(){
        rollMany(12, 10)
        assertThat(game.score()).isEqualTo(300)
    }

    private fun rollStrike() {
        game.roll(10)
    }

    private fun rollSpare() {
        game.roll(5)
        game.roll(5)
    }

    private fun rollMany(n: Int, pins: Int) {
        repeat(n) {
            game.roll(pins)
        }
    }

}