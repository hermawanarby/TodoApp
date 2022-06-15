package id.ac.unpas.todoapp.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import id.ac.unpas.todoapp.entity.TodoItem

@Composable
fun TodoListItem(item: TodoItem)
{
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column {
            Row(modifier = Modifier.padding(4.dp)) {
                Text(text = item.name, modifier = Modifier.weight(0.6f))
                var status = "Not Done"
                if (item.isDone)
                {
                    status = "Done"
                }
                
                Text(text = status, modifier = Modifier.weight(0.4f))
            }
            Divider(color = Color.Gray, thickness = 1.dp)
        }

    }}