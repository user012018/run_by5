abstract class Sportsman {

    abstract fun warmUp()

    abstract fun mainWork()

    abstract fun coolDown()

    fun doWorkout() {
        warmUp()
        mainWork()
        coolDown()
    }

}


class Bodybuilder : Sportsman() {

    override fun warmUp() {
        println("Суставная разминка.")
    }

    override fun mainWork() {
        println("Жим штанги.")
    }

    override fun coolDown() {
        println("Растяжка грудных мышц.")
    }

}

class Cyclist : Sportsman() {

    override fun warmUp() {
        println("Проверка велосипеда.")
    }

    override fun mainWork() {
        println("Езда по горной местности.")
    }

    override fun coolDown() {
        println("Смазка велосипеда.")
    }

}

class Runner : Sportsman() {

    override fun warmUp() {
        println("Беговая разминка.")
    }

    override fun mainWork() {
        println("Интервальный бег 4 раза по 500 метров.")
    }

    override fun coolDown() {
        println("Растяжка ног.")
    }

}
