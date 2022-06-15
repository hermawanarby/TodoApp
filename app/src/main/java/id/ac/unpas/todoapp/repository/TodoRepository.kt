package id.ac.unpas.todoapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.benasher44.uuid.uuid4
import id.ac.unpas.todoapp.network.TodoService
import id.ac.unpas.todoapp.entity.TodoItem
import id.ac.unpas.todoapp.persistence.TodoDao

class TodoRepository (private val todoDao: TodoDao, private val todoService: TodoService) {
    val readAllData : LiveData<List<TodoItem>> = todoDao.getAll()

    suspend fun sync()
    {
        try {
            val response = todoService.all()
            val items = response.data
            todoDao.insert(items)
        } catch (e: Exception)
        {
            Log.e("TodoRepository", e.message.toString())
        }
    }

    suspend fun addTodo(todoItem: TodoItem) {
        todoItem.id = uuid4().toString()
        todoDao.insert(todoItem)
        var isDone = 0
        if (todoItem.isDone) isDone = 1
        todoService.insert(todoItem.id, todoItem.name, isDone)
    }
}