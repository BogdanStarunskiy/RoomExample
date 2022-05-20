package com.example.notesapproomexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapproomexample.database.dao.NoteDao
import com.example.notesapproomexample.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object {
        @Synchronized
        fun getInstance(context: Context): NoteDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(context, NoteDatabase::class.java, "db").build()
                database as NoteDatabase
            } else {
                database as NoteDatabase
            }
        }

        private var database: NoteDatabase? = null
    }


}