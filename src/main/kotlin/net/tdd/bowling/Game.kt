package net.tdd.bowling

class Game{
    private val rolls = IntArray(21)
    var currentRoll = 0

    fun roll(pins: Int) {
        rolls[currentRoll++] = pins
    }

    fun score(): Int {
        var score = 0
        var frameIndex = 0

        for (frame in 0 until 10){
            if(isStrike(frameIndex)) { // strike
                score += 10 + strikeBonus(frameIndex)
                frameIndex += 1
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex)
                frameIndex += 2
            } else {
                score += sumOfBallsInFrame(frameIndex)
                frameIndex += 2
            }
        }

        return score;
    }

    private fun spareBonus(frameIndex: Int) = rolls[frameIndex + 2]

    private fun strikeBonus(frameIndex: Int)= rolls[frameIndex + 1] + rolls[frameIndex + 2]

    private fun isStrike(frameIndex: Int): Boolean = rolls[frameIndex] == 10

    private fun isSpare(frameIndex: Int): Boolean = sumOfBallsInFrame(frameIndex) == 10

    private fun sumOfBallsInFrame(frameIndex: Int): Int = rolls[frameIndex] + rolls[frameIndex + 1]
}
