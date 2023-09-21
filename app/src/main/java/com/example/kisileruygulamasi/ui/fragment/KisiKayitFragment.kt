package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentKisiKayitBinding

class KisiKayitFragment : Fragment() {
        private lateinit var binding: FragmentKisiKayitBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKisiKayitBinding.inflate(inflater,container,false)

        binding.toolbarKisiKayit.title = "Kişi Kayıt"
        binding.btnKaydet.setOnClickListener {
            val kisi_ad = binding.editTextKisiAd.text.toString()
            val kisi_tel = binding.editTextKisiTel.text.toString()
            kisiKaydet(kisi_ad,kisi_tel)
        }


        return binding.root
    }
    fun kisiKaydet(kisi_ad : String,  kisi_tel: String){
        Log.e("Kişi Kaydet", "$kisi_ad - $kisi_tel")
    }
}