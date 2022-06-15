package id.ac.unpas.todoapp.ui.main

import androidx.annotation.WorkerThread
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.ac.unpas.todoapp.entity.TodoItem
import id.ac.unpas.todoapp.repository.TodoRepository
import id.ac.unpas.todoapp.sensor.MeasurableSensor
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val todoRepository: TodoRepository,
                                        private val lightSensor: MeasurableSensor) : ViewModel() {
    val liveData = todoRepository.readAllData

    var isDark by mutableStateOf(false)

    init {
        lightSensor.startListening()
        lightSensor.setOnSensorValueChangedListener { values ->
            val lux = values[0]
            isDark = lux < 60f
        }
    }

    @WorkerThread
    suspend fun addTodo(name: String)
    {
        todoRepository.addTodo(TodoItem("", name, false))
    }

    suspend fun syncTodo()
    {
        todoRepository.sync()
    }
}