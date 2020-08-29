typealias LocationListener = (latitude: Double, longitude: Double) -> Unit

interface LocationProvider {

    fun registerListener(listener: LocationListener): Boolean

    fun unregisterListener(listener: LocationListener): Boolean

    fun notifyListeners(latitude: Double, longitude: Double)

}

class GpsLocationProvider : LocationProvider {

    private val listeners: MutableList<LocationListener> = mutableListOf()

    override fun registerListener(listener: LocationListener): Boolean {
        return listeners.add(listener)
    }

    override fun unregisterListener(listener: LocationListener): Boolean {
        return listeners.remove(listener)
    }

    override fun notifyListeners(latitude: Double, longitude: Double) {
        listeners.forEach { listener: LocationListener ->
            listener(latitude, longitude)
        }
    }

}