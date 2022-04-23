package com.s160419092.todoapp.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.s160419092.todoapp.Model.Todo
import com.s160419092.todoapp.R
import kotlinx.android.synthetic.main.todo_item_layout.view.*

class TodoListAdapter(val todoList:ArrayList<Todo>, val adapterOnClick: (Todo)-> Unit) :RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>(){

    class TodoViewHolder(var view:View): RecyclerView.ViewHolder(view)

    fun updateTodoList(newTodoList:List<Todo>){
        todoList.clear()
        todoList.addAll(newTodoList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.todo_item_layout, parent, false)

        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.view.checkBox.setText(todoList[position].title.toString())

        holder.view.checkBox.setOnCheckedChangeListener{
            compoundButton, isChecked->
                if (isChecked == true){
                    adapterOnClick(todoList[position])
                    todoList[position].is_done = 1
                }
        }

        holder.view.imgEdit.setOnClickListener{
            val action = TodoListFragmentDirections.actionEditTodoFragment(todoList[position].uuid)

            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }


}