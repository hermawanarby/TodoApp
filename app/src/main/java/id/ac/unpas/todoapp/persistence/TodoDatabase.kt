package id.ac.unpas.todoapp.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.todoapp.entity.TodoItem

@Database(entities = [TodoItem::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao
}