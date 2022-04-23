package com.s160419092.todoapp.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @ColumnInfo(name="title")
    var title:String,
    @ColumnInfo(name="notes")
    var notes:String,
    @ColumnInfo(name="priority")
    var priority:Int,
    @ColumnInfo(name="is_done")
    var is_done:Int,//karena dalam sqlite, tidak terdapat tipe data boolean. Sehingga, dapat digantikan dengan tipe data int berupa 0 atau 1, yang mana berfungsi seperti boolean.
    ){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}

