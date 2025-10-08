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
        var i = 0

        for(frame in 0 until 10) {
            if(rolls[i] + rolls[i+1] == 10){
                score += 10 + rolls[i+2]
                i += 2
            }else{
                score += rolls[i] + rolls[i+1]
                i += 2
            }
        }

        return  score
    }

}
