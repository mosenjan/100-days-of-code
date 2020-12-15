
class Player(val name:String, var lives: Int = 3, var level:Int = 1, var score:Int = 0){

    var weapon: Weapon = Weapon("fist",1)
    val inventory = ArrayList<Loot>()

    fun show(){
        println("""
            name: $name
            lives: $lives
            level: $level
            score: $score
            weapon Name: ${weapon.name}
            weapon Damage: ${weapon.damageInflicted}
            
        """.trimIndent())
    }

    fun showInventory() {
        println("$name's Inventory")
    }
}