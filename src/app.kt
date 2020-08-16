import Exceptions.TooFewRollsException
import Exceptions.TooManyRollsException

fun main() {
    for (i in 1..12) {
        roll(10)
    }
    try {
        println("Score should be 300: " + score())
    } catch (e: TooFewRollsException) {
        println(e.message)
    } catch (e: TooManyRollsException) {
        println(e.message)
    }

    for (i in 1..20) {
        roll(1)
    }
    try {
        println("Score should be 20: " + score())
    } catch (e: TooFewRollsException) {
        println(e.message)
    } catch (e: TooManyRollsException) {
        println(e.message)
    }

    roll168()
    try {
        println("Score should be 168: " + score())
    } catch (e: TooFewRollsException) {
        println(e.message)
    } catch (e: TooManyRollsException) {
        println(e.message)
    }

    for (i in 1..13) {
        roll(10)
    }
    print("Score should be invalid: ")
    try {
        score()
    } catch (e: TooFewRollsException) {
        println(e.message)
    } catch (e: TooManyRollsException) {
        println(e.message)
    }

    for (i in 1..22) {
        roll(1)
    }
    print("Score should be invalid: ")
    try {
        score()
    } catch (e: TooFewRollsException) {
        println(e.message)
    } catch (e: TooManyRollsException) {
        println(e.message)
    }

    for (i in 1..11) {
        roll(10)
    }
    print("Score should be invalid: ")
    try {
        score()
    } catch (e: TooFewRollsException) {
        println(e.message)
    } catch (e: TooManyRollsException) {
        println(e.message)
    }

    for (i in 1..8) {
        roll(10)
    }
    print("Score should be invalid: ")
    try {
        score()
    } catch (e: TooFewRollsException) {
        println(e.message)
    } catch (e: TooManyRollsException) {
        println(e.message)
    }

    for (i in 1..9) {
        roll(10)
    }
    print("Score should be invalid: ")
    try {
        score()
    } catch (e: TooFewRollsException) {
        println(e.message)
    } catch (e: TooManyRollsException) {
        println(e.message)
    }
}
