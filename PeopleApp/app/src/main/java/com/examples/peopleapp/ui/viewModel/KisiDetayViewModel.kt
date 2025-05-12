package com.examples.peopleapp.ui.viewModel

import android.util.Log
import android.view.inputmethod.CorrectionInfo
import androidx.lifecycle.ViewModel
import com.examples.peopleapp.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiDetayViewModel: ViewModel(){
    var kisilerRepository = KisilerRepository()


    fun update(kisi_id:Int,kisi_ad: String,kisi_tel: String) {
        CoroutineScope(Dispatchers.Main).launch{
            kisilerRepository.record(kisi_ad,kisi_tel)
        }
    }
}