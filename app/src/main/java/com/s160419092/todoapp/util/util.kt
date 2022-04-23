package com.s160419092.todoapp.util

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.s160419092.todoapp.Model.TodoDatabase

val DB_NAME = "newtododb"

fun buildDb(context: Context):TodoDatabase{
    val db = Room.databaseBuilder(context, TodoDatabase::class.java, DB_NAME)
                    .addMigrations(MIGRATION_1_3).build()
    return db
}

val MIGRATION_1_3 =object : Migration(1,3){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE todo ADD COLUMN priority INTEGER DEFAULT 3 not null"
        )

        database.execSQL(
            "ALTER TABLE todo ADD COLUMN isDone INTEGER DEFAULT 0 not null"
        )
    }
}
