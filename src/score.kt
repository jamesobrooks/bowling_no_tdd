import Exceptions.TooManyRollsException

fun score(): Int {
    val frames = mutableListOf<Frame>()
    for (i in 1..9) {
        frames.add(FrameFactory.createFrame(false, i))
    }
    frames.add(FrameFactory.createFrame(true, 10))

    if (Rolls.rolls.size > 0) {
        Rolls.rolls.clear()
        throw TooManyRollsException("Hey Kingpin! You rolled too many balls!")
    }

    var score = 0
    for (frame in frames) {
        var bonus = 0
        if (frame.type == "strike") {
            bonus = calcBonus(frame.id, 2, frames)
        } else if (frame.type == "spare") {
            bonus = calcBonus(frame.id, 1, frames)
        }
        score += frame.pins() + bonus
    }

    Rolls.rolls.clear()
    return score
}
