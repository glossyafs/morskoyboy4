fun printBothFields(player: Player, enemy: Player) {
    println("=== Поле игрока ${player.name} ===" + "          " + "=== Поле игрока ${enemy.name} ===")
    print("  ")
    for (c in 0..9) print("$c ")
    print("     ")
    print("  ")
    for (c in 0..9) print("$c ")
    println()
    for (r in 0..9) {
        print("$r ")
        for (c in 0..9) print("${player.field()[r][c].toChar()} ")
        print("     ")
        print("$r ")
        for (c in 0..9) print("${enemy.field()[r][c].toChar()} ")
        println()
    }
}

fun main() {
    System.setOut(java.io.PrintStream(System.out, true, "UTF-8"))

    for (type in ShipType.values()) {
        println("${type.name}: ${type.size} клетки")
    }
    println()

    val currentState = GameState.PLAYER_TURN
    println(currentState.describe())
    println()

    println(ShipType.BATTLESHIP.isBig())
    println(ShipType.BOAT.isBig())
    println()

    val player = Player("Вы")
    val enemy = Player("Компьютер")

    player.placeShip(3, 2)
    player.placeShip(3, 3)
    player.placeShip(3, 4)
    player.placeShip(3, 5)

    enemy.placeShip(5, 7)
    enemy.placeShip(6, 7)
    enemy.placeShip(7, 7)

    printBothFields(player, enemy)
}