interface Figure

class Triangle : Figure {



}

class Circle : Figure {



}

class Rectangle : Figure {



}

fun draw(figure: Figure) {
    when (figure) {
        is Triangle -> {
            println("Рисуем треугольник.")
        }
        is Circle -> {
            println("Рисуем круг.")
        }
        is Rectangle -> {
            println("Рисуем прямоугольник.")
        }
    }
}
