package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.R.id.kisiKayitGecis
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
        binding.toolbarAnasayfa.title = "Kişiler"
        binding.recyclerViewKisiler.layoutManager = LinearLayoutManager(requireContext()) // Alt Alta gösterim
        //binding.recyclerViewKisiler.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL) // Aynı satırda 2 adet gösteriliyor
        //binding.recyclerViewKisiler.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL) // Horizontal şekilde tek satır halinde
        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Doğan","555555555")
        val k2 = Kisiler(2,"Doğan","666666666")
        val k3 = Kisiler(3,"Doğan","777777777")

        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        val kisilerAdapter  = KisilerAdapter(requireContext(),kisilerListesi)
        binding.recyclerViewKisiler.adapter = kisilerAdapter


        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(kisiKayitGecis)
        }
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    kisiAra(newText)
                }
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    kisiAra(query)
                }
                return true
            }
        } )

        return binding.root
    }
    fun kisiAra(aramaKelimesi : String){
        Log.e("Kişi Ara",aramaKelimesi)
    }
}