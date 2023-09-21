package com.example.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.CardTasarimBinding
import com.example.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContex : Context, var kisilerListesi: List<Kisiler>)
    : RecyclerView.Adapter<KisilerAdapter.CardViewHolder>() {

    inner class CardViewHolder(var tasarim : CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContex),parent,false)
        return CardViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val kisi = kisilerListesi.get(position)
        val t = holder.tasarim
        t.textViewKisiAd.text = kisi.kisi_ad
        t.textViewKisiTelefon.text = kisi.kisi_tel

        t.cardViewKisi.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewSil.setOnClickListener{
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi ?",Snackbar.LENGTH_SHORT).setAction("EVET"){
                kisiSil(kisi.kisi_id)
            }.show()
        }
    }
    override fun getItemCount(): Int {
        return kisilerListesi.size
    }
    fun kisiSil(kisi_id : Int){
        Log.e("Kişi sil:",kisi_id.toString())
    }
}