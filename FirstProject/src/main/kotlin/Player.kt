
class Player(val name:String, var lives: Int = 3, var level:Int = 1, var score:Int = 0){

    var weapon: Weapon = Weapon("fist",1)
    val inventory = ArrayList<Loot>()

    fun show(){
        println("""
            name: $name
            lives: $lives
            level: $level
            score: $score
            $weapon
            
        """.trimIndent())
    }

    fun showInventory() {
        println("$name's Inventory")
        for(item in inventory){
            println(item)
        }
        println("=============================")
    }
}