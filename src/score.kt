import Exceptions.TooFewRollsException
import Exceptions.TooManyRollsException

fun score(): Int {
    var score = 0
    val frames = mutableListOf<Frame>()

    // Add first nine frames
    for (i in 1..9) {
        val first = Rolls.getNextRoll()
        if (first == 10) {
            frames.add(Frame(i, 10, type = "strike"))
        } else {
            val second = Rolls.getNextRoll()
            var type = ""
            val pins = first + second
            if (pins == 10) {
                type = "spare"
            }
            frames.add(Frame(i, first, second, type = type))
        }
    }

    // Add tenth frame
    val first = Rolls.getNextRoll()
    val second = Rolls.getNextRoll()
    var third = 0
    if (first + second >= 10) {
        third = Rolls.getNextRoll()
    }
    frames.add(Frame(10, first, second, third, type = "tenth"))

    for (frame in frames) {
        var bonus = 0
        if (frame.type == "strike") {
            bonus = calcBonus(frame.id, 2, frames)
        } else if (frame.type == "spare") {
            bonus = calcBonus(frame.id, 1, frames)
        }
        score += frame.pins() + bonus
    }
    if (Rolls.rolls.size > 0) {
        Rolls.rolls.clear()
        throw TooManyRollsException("Hey Kingpin! You rolled too many balls!")
    } else {
        Rolls.rolls.clear()
    }
    return score
}
