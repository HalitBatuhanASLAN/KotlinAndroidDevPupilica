package com.examples.homework7.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.examples.homework7.data.entity.ToDos


@Dao
interface ToDosDao {

    @Insert
    suspend fun add(toDo : ToDos)

    @Update
    suspend fun update(toDo : ToDos)

    @Delete
    suspend fun delete(toDo : ToDos)

    @Query("SELECT * FROM toDos")
    suspend fun upload(): List<ToDos>

    @Query("SELECT * FROM toDos WHERE toDo_id LIKE '%'|| :seachingWord ||'%'")
    suspend fun search(seachingWord : String): List<ToDos>
}