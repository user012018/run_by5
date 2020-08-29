interface Strategy {

    fun buildRoute(startPoint: Double, endPoint: Double)

}

class Navigator(
        private var currentStrategy: Strategy
) {

    fun buildRoute(startPoint: Double, endPoint: Double) {
        currentStrategy.buildRoute(startPoint, endPoint)
    }

    fun setStrategy(strategy: Strategy) {
        currentStrategy = strategy
    }

}

object HikingStrategy : Strategy {

    override fun buildRoute(startPoint: Double, endPoint: Double) {
        println("Построен пешеходный маршрут от точки $startPoint до точки $endPoint")
    }

}

object CarStrategy : Strategy {

    override fun buildRoute(startPoint: Double, endPoint: Double) {
        println("Построен маршрут на автомобиле от точки $startPoint до точки $endPoint")
    }

}

object PublicTransportStrategy : Strategy {

    override fun buildRoute(startPoint: Double, endPoint: Double) {
        println("Построен маршрут на общественном транспорте от точки $startPoint до точки $endPoint")
    }

}