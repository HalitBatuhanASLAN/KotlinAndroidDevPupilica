package com.examples.homework7.ui.viewModel

import androidx.lifecycle.ViewModel
import com.examples.homework7.data.repo.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailPageViewModel @Inject constructor(var toDosRepository: ToDosRepository): ViewModel() {

    fun update(toDo_id : Int,toDo_name: String){
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepository.update(toDo_id,toDo_name)
        }
    }
}