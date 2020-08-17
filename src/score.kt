import Exceptions.TooFewRollsException
import Exceptions.TooManyRollsException

fun score(): Int {
    var score = 0
    val frames = mutableListOf<Frame>()
    var shortGame = false

    // Add first nine frames
    for (i in 1..9) {
        var first = 0
        if (Rolls.rolls.size > 0) first = Rolls.rolls.removeAt(0) else shortGame = true
        if (first == 10) {
            frames.add(Frame(i, 10, type = "strike"))
        } else {
            var second = 0
            if (Rolls.rolls.size > 0) second = Rolls.rolls.removeAt(0) else shortGame = true
            var type = ""
            val pins = first + second
            if (pins == 10) {
                type = "spare"
            }
            frames.add(Frame(i, first, second, type = type))
        }
    }

    // Add tenth frame
    var first = 0
    if (Rolls.rolls.size > 0) first = Rolls.rolls.removeAt(0) else shortGame = true
    var second = 0
    if (Rolls.rolls.size > 0) second = Rolls.rolls.removeAt(0) else shortGame = true
    var third = 0
    if (first + second >= 10) {
        if (Rolls.rolls.size > 0) third = Rolls.rolls.removeAt(0) else shortGame = true
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
    } else if (shortGame) {
        Rolls.rolls.clear()
        throw TooFewRollsException("You didn't roll enough balls!")
    } else {
        Rolls.rolls.clear()
    }
    return score
}
