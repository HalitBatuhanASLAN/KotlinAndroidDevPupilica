package com.examples.homework7.data.dataSource

import com.examples.homework7.data.entity.ToDos
import com.examples.homework7.room.ToDosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDataSource(var toDosDao: ToDosDao) {

    suspend fun add(toDo_name: String){
        val newToDo = ToDos(0,toDo_name)
        toDosDao.add(newToDo)
    }

    suspend fun update(toDo_id: Int,toDo_name: String){
        val updatedToDo = ToDos(toDo_id,toDo_name)
        toDosDao.update(updatedToDo)
    }

    suspend fun delete(toDo_id: Int){
        val deletedToDo = ToDos(toDo_id,"")
        toDosDao.delete(deletedToDo)
    }

    suspend fun upload():List<ToDos> = withContext(Dispatchers.IO){
        return@withContext toDosDao.upload()
    }

    suspend fun search(searchingWord: String): List<ToDos> = withContext(Dispatchers.IO) {
        return@withContext toDosDao.search(searchingWord)
    }
}