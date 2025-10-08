package net.tdd.bowling

class Game{
    private val rolls = IntArray(21)
    var currentRoll = 0

    fun roll(pins: Int) {
        rolls[currentRoll++] = pins
    }

    /**
     * tdd의 룰은 실패하는 test를 먼저 만든다
     * 실해한 후에 정상적으로 동작하는 코드를 만든다
     * 이후 성공만하는 로직을 만들어도 됩니다.
     */
    fun score(): Int {
        var score = 0
        var frameIndex = 0

        for(frame in 0 until 10) {
            if(rolls[frameIndex] == 10){
                score += 10 + rolls[frameIndex + 1] + rolls[frameIndex + 2]
                frameIndex += 1
            }else if(isSpare(frameIndex)){
                score += 10 + rolls[frameIndex + 2]
                frameIndex += 2
            }else{
                score += rolls[frameIndex] + rolls[frameIndex + 1]
                frameIndex += 2
            }
        }

        return  score
    }

    private fun isSpare(frameIndex: Int): Boolean = rolls[frameIndex] + rolls[frameIndex + 1] == 10

}
