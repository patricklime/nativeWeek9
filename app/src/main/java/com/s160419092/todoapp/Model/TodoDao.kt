package com.s160419092.todoapp.Model

import androidx.room.*

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg todo:Todo)

    @Query("SELECT * FROM todo where is_done = 0 order by priority desc")
    suspend fun selectAllTodo(): List<Todo>

    @Query("SELECT * FROM todo WHERE uuid= :id")
    suspend fun selectTodo(id:Int): Todo

    @Query("UPDATE todo set title= :title, notes= :notes, priority= :priority WHERE uuid= :id")
    suspend fun update(title:String, notes:String, priority:Int ,id:Int)

    @Query("UPDATE todo set is_done= :isdone WHERE uuid= :id")
    suspend fun updateIsDone(isdone:Int ,id:Int)

    @Delete
    suspend fun deleteTodo(todo:Todo)
}

