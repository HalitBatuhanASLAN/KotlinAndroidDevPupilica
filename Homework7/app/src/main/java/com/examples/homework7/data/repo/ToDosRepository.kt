package com.examples.homework7.data.repo

import com.examples.homework7.data.dataSource.ToDosDataSource
import com.examples.homework7.data.entity.ToDos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosRepository(var toDosDataSource: ToDosDataSource ) {

    suspend fun add(toDo_name: String){
        toDosDataSource.add(toDo_name)
    }

    suspend fun update(toDo_id: Int,toDo_name: String) = toDosDataSource.update(toDo_id,toDo_name)

    suspend fun delete(toDo_id: Int) = toDosDataSource.delete(toDo_id)

    suspend fun upload() : List<ToDos> = toDosDataSource.upload()

    suspend fun search(searchingWord: String) : List<ToDos> = toDosDataSource.search(searchingWord)

}