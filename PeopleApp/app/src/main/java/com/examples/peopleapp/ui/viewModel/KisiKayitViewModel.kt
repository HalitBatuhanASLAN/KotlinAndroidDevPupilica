package com.examples.peopleapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.examples.peopleapp.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiKayitViewModel : ViewModel(){
    var kisilerRepository = KisilerRepository()

    fun record(name : String,tel_number: String){
        //.Main görsele yakınalrda;IO ise veritabanına yakın işlemlerde
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepository.record(name,tel_number)
        }//bu kod ile artık asenkron olarak çalışmaya olanak sağladık

    }

}