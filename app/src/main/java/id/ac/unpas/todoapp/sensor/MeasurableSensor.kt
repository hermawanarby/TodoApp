package id.ac.unpas.todoapp.sensor

abstract class MeasurableSensor(protected val sensorType: Int) {

    protected var onSensorValuesChange: ((List<Float>) -> Unit)? = null

    abstract val doesSensorExist: Boolean

    abstract fun startListening()
    abstract fun stopListening()

    fun setOnSensorValueChangedListener(listener: (List<Float>) -> Unit) {
        onSensorValuesChange = listener
    }
}