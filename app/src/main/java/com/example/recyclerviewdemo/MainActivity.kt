package com.example.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf<Todo>(
            Todo("Eat", false),
            Todo("Sleep", false)
        )

        val adapter = TodoAdapter(todoList)
        val rvTodos = findViewById<RecyclerView>(R.id.rvTodos)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val title = findViewById<EditText>(R.id.editTextText).text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }

    }
}