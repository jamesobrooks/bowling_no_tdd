class Frame(val id:Int, val first: Int, val second:Int = 0, val third:Int = 0, val type:String) {
    fun pins():Int {
        return first + second + third
    }
}