package com.examples.homework7.ui.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.examples.homework7.data.entity.ToDos
import com.examples.homework7.data.repo.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(var toDosRepository: ToDosRepository) : ViewModel(){
    var toDosList = MutableLiveData<List<ToDos>>()

    init {
        upload()
    }

    fun delete(toDos_id : Int){
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepository.delete(toDos_id)
            upload()
        }
    }

    fun upload(){
        CoroutineScope(Dispatchers.Main).launch {
            toDosList.value = toDosRepository.upload()
        }
    }

    fun search(searchingWord: String){
        CoroutineScope(Dispatchers.Main).launch {
            toDosList.value = toDosRepository.search(searchingWord)
        }
    }
}