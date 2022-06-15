package id.ac.unpas.todoapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "todo_list")
data class TodoItem(
    @PrimaryKey
    var id: String,

    val name: String,

    @ColumnInfo(name = "is_done")
    @SerializedName("is_done")
    val isDone: Boolean = false
)
