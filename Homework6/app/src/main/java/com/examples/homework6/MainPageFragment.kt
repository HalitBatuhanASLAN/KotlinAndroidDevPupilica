package com.examples.homework6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.examples.homework6.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainPageBinding.inflate(inflater,container,false)

        val carsList = mutableListOf<Cars>()

        val c1 = Cars(
            id = 1,
            price = 750000,
            announcementDate = "2025-05-01",
            brand = "Toyota",
            model = "Corolla",
            year = "2023",
            gearType = "Automatic",
            picture = "toyota_corolla2023",
            city = "İstanbul",
            exchange = "No",
            kilometers = "123.456",
            pitureList = arrayListOf(
                Photos("toyota_corolla2023"),
                Photos("corolla_2022_1"),
                Photos("corolla_2022_2"),
                Photos("corolla_2022_3"))
        )
        carsList.add(c1)

        val c2 = Cars(
            id = 2,
            price = 1250000,
            announcementDate = "2025-05-03",
            brand = "BMW",
            model = "3 Series",
            year = "2022",
            gearType = "Automatic",
            picture = "bmw3_2022",
            city = "Ankara",
            exchange = "No",
            kilometers = "123.456",
            pitureList = arrayListOf(
                Photos("bmw3_2022")
            )
        )
        carsList.add(c2)

        val c3 = Cars(
            id = 3,
            price = 950000,
            announcementDate = "2025-05-05",
            brand = "Honda",
            model = "Civic",
            year = "2024",
            gearType = "Manual",
            picture = "honda_civic",
            city = "İzmir",
            exchange = "Yes",
            kilometers = "123.456",
            pitureList = arrayListOf(
                Photos("honda_civic")
            )
        )
        carsList.add(c3)

        val c4 = Cars(
            id = 4,
            price = 2500000,
            announcementDate = "2025-05-02",
            brand = "Mercedes",
            model = "E-Class",
            year = "2023",
            gearType = "Automatic",
            picture = "mercedes_e2023",
            city = "Bursa",
            exchange = "Yes",
            kilometers = "123.456",
            pitureList = arrayListOf(Photos("toyota_corolla2023"), Photos("bmw3_2022"))
        )
        carsList.add(c4)

        val c5 = Cars(
            id = 5,
            price = 650000,
            announcementDate = "2025-05-07",
            brand = "Ford",
            model = "Focus",
            year = "2021",
            gearType = "Manual",
            picture = "ford_focus2019",
            city = "Antalya",
            exchange = "No",
            kilometers = "123.456",
            pitureList = arrayListOf(Photos("toyota_corolla2023"), Photos("bmw3_2022"))
        )
        carsList.add(c5)

        val c6 = Cars(
            id = 6,
            price = 1850000,
            announcementDate = "2025-05-08",
            brand = "Volkswagen",
            model = "Passat",
            year = "2023",
            gearType = "Automatic",
            picture = "passat_2023",
            city = "Adana",
            exchange = "Yes",
            kilometers = "123.456",
            pitureList = arrayListOf(Photos("toyota_corolla2023"), Photos("bmw3_2022"))
        )
        carsList.add(c6)

        val c7 = Cars(
            id = 7,
            price = 550000,
            announcementDate = "2025-05-06",
            brand = "Renault",
            model = "Clio",
            year = "2022",
            gearType = "Manual",
            picture = "clio_2022",
            city = "Eskişehir",
            exchange = "No",
            kilometers = "123.456",
            pitureList = arrayListOf(Photos("toyota_corolla2023"), Photos("bmw3_2022"))
        )
        carsList.add(c7)

        val c8 = Cars(
            id = 8,
            price = 3200000,
            announcementDate = "2025-05-09",
            brand = "Audi",
            model = "A6",
            year = "2024",
            gearType = "Automatic",
            picture = "a6_2024",
            city = "Trabzon",
            exchange = "No",
            kilometers = "12000",
            pitureList = arrayListOf(Photos("toyota_corolla2023"), Photos("bmw3_2022"))
        )
        carsList.add(c8)

        val c9 = Cars(
            id = 9,
            price = 1100000,
            announcementDate = "2025-05-04",
            brand = "Hyundai",
            model = "Tucson",
            year = "2023",
            gearType = "Automatic",
            picture = "tucson_2023",
            city = "Kayseri",
            exchange = "No",
            kilometers = "123.456",
            pitureList = arrayListOf(Photos("toyota_corolla2023"), Photos("bmw3_2022"))
        )
        carsList.add(c9)

        val c10 = Cars(
            id = 10,
            price = 900000,
            announcementDate = "2025-05-10",
            brand = "Kia",
            model = "Sportage",
            year = "2022",
            gearType = "Manual",
            picture = "sportage_2022",
            city = "Konya",
            exchange = "No",
            kilometers = "123.456",
            pitureList = arrayListOf(Photos("toyota_corolla2023"), Photos("bmw3_2022"))
        )
        carsList.add(c10)

        val carAdapter = CarAdapter(requireContext(),carsList)
        binding.carsRV.adapter = carAdapter
        binding.carsRV.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        return binding.root
    }
}