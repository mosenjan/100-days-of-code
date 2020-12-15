fun main(args: Array<String>) {

    val mohsen:Player = Player("mohsen",level = 4,lives = 8)
    val masood:Player = Player("masood",score = 1000,level = 2,lives = 5)

    val axe = Weapon("Axe",12)
    val sword = Weapon("Sword" , 15)
    val spear = Weapon("Spear" , 20)

    masood.weapon = sword
    mohsen.weapon = masood.weapon

    mohsen.show()
    masood.show()

    val redPotion = Loot("Red Potion",LootType.POTION, 7.50)
    mohsen.inventory.add(redPotion)
}