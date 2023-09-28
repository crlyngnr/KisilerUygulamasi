package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentKisiDetayBinding
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasi.ui.viewmodel.KisiDetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiDetayFragment : Fragment() {
    private lateinit var binding: FragmentKisiDetayBinding
    private lateinit var viewModel: KisiDetayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay, container, false)
        binding.kisiDetayFragment = this
        binding.kisiDetayToolbarBaslik = "Kişi Detay"
        val bundle : KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi
        binding.kisiNesnesi = gelenKisi
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KisiDetayViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun btnGuncelle(kisi_id: Int,kisi_ad : String,  kisi_tel: String){
        Log.e("Kişi Güncelle", "$kisi_id - $kisi_ad - $kisi_tel")
    }
}