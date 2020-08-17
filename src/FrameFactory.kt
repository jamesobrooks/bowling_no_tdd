object FrameFactory {
    fun createFrame(isTenth: Boolean, id: Int): Frame {
        if (!isTenth) {
            val first = Rolls.getNextRoll()
            if (first == 10) {
                return Frame(id, 10, type = "strike")
            } else {
                val second = Rolls.getNextRoll()
                var type = ""
                val pins = first + second
                if (pins == 10) {
                    type = "spare"
                }
                return Frame(id, first, second, type = type)
            }
        } else {
            val first = Rolls.getNextRoll()
            val second = Rolls.getNextRoll()
            var third = 0
            if (first + second >= 10) {
                third = Rolls.getNextRoll()
            }
            return Frame(10, first, second, third, type = "tenth")
        }
    }
}
