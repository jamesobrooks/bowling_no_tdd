import Exceptions.TooFewRollsException

object Rolls {
    val rolls = mutableListOf<Int>()

    fun getNextRoll(): Int {
        if (rolls.size == 0) {
            rolls.clear()
            throw TooFewRollsException("You didn't roll enough balls!")
        }
        return rolls.removeAt(0)
    }
}
