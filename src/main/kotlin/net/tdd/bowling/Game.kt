package net.tdd.bowling

class Game{
    var score = 0
    fun roll(pins: Int) {
        score += pins
    }

    /**
     * tdd의 룰은 실패하는 test를 먼저 만든다
     * 실해한 후에 정상적으로 동작하는 코드를 만든다
     * 이후 성공만하는 로직을 만들어도 됩니다.
     */
    fun score(): Int {
        return  score
    }

}
