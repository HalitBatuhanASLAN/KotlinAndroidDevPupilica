package com.examples.navigationcomponenetusage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.examples.navigationcomponenetusage.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {
    //ViewGroup tasarım isimleri
    private lateinit var binding: FragmentMainPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)


        binding.buttonDetail.setOnClickListener {

            //direction eki gelir sonuna eğer veri gönderilecek sayfadaysak
            val passing = MainPageFragmentDirections.detailPass("How are you",100)

            //burada hangi sayfada olduğumuzu bir görsel seçsek yterli
            //Navigation.findNavController(binding.textViewMainPage)
            //ya da direkt it diyebiliriz
            //Navigation.findNavController(it).navigate(R.id.detailPass)
            Navigation.findNavController(it).navigate(passing)
        }
        return binding.root

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main_page, container, false)
    }


    //alt taraftaki metodlar uygulama çalışması sırasında logcat ile programın akışını(anlık olarak
    // hangi sayfada işlem yapılıoyor vs görebilmemizi sağlayan metodları bir kısmı)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //uygulama çalıştığınde birkez çalışır

        //Log.e ile logcat çıktı verir. .e kırmızı renk olduğu için dikkat çeker başka harflerde kullanılabilir
        // burada ilk kelime bizim arama yapacağımız key gibidir. Bu şekilde sadece bu sayfanın loglarını filtreleriz
        Log.e("LifeCycle","onCreate")
    }

    override fun onResume() {
        super.onResume()
        //sayfa her çalıştığında çalışır
        //bu sayfaya geri dönüldüğünde çalışır
        Log.e("LifeCycle","onResume")

    }

    override fun onPause() {
        super.onPause()
        //sayfa her görünmez olduğunda çalışır
        Log.e("LifeCycle","onPause")
    }

}