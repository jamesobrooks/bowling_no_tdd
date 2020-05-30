fun main() {
    for (i in 1..12) {
        roll(10)
    }
    print("Score should be 300: ")
    score()

    for (i in 1..20) {
        roll(1)
    }
    print("Score should be 20: ")
    score()

    roll168()
    print("Score should be 168: ")
    score()

    for (i in 1..13) {
        roll(10)
    }
    print("Score should be invalid: ")
    score()

    for (i in 1..22) {
        roll(1)
    }
    print("Score should be invalid: ")
    score()

    for (i in 1..11) {
        roll(10)
    }
    print("Score should be invalid: ")
    score()

    for (i in 1..8) {
        roll(10)
    }
    print("Score should be invalid: ")
    score()

    for (i in 1..9) {
        roll(10)
    }
    print("Score should be invalid: ")
    score()
}