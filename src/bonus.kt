fun calcBonus(frame:Int, rolls:Int, frames:MutableList<Frame>):Int {
    var bonus = 0
    // note here that frame is an ordinal number so in index # (frame - 1)
    if (rolls == 2) {
        bonus += frames[frame].first
        if (frames[frame].type == "strike") {
            bonus += frames[frame+1].first
        } else {
            bonus += frames[frame].second
        }
    } else {
        bonus += frames[frame].first
    }
    return bonus
}