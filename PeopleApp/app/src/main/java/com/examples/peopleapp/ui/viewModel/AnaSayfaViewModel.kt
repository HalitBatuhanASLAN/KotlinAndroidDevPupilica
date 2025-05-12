package com.examples.peopleapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.examples.peopleapp.data.entity.Kisiler
import com.examples.peopleapp.data.repo.KisilerRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnaSayfaViewModel @Inject constructor(var kisilerRepository: KisilerRepository) : ViewModel(){
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()
    }
    fun sil(kisi_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepository.sil(kisi_id)
            kisileriYukle()
        }
    }

    fun kisileriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kisilerRepository.kisileriYukle()
            //trigger --- tetiekleme
        }
    }


    fun ara(aramamKelimesi: String){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kisilerRepository.ara(aramamKelimesi)
            //trigger --- tetiekleme
        }
    }

    //liveData ile bir değişken değiştiğinde bunu uı göndeririz
}