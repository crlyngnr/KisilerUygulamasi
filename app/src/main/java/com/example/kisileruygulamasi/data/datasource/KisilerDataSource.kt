package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {
    suspend fun kisiKaydet(kisi_ad : String,  kisi_tel: String){
        Log.e("Kişi Kaydet", "$kisi_ad - $kisi_tel")
    }
    suspend fun kisiGuncelle(kisi_id: Int,kisi_ad: String,kisi_tel: String){
        Log.e("Kişi Güncelle", "$kisi_id - $kisi_ad - $kisi_tel")
    }
    suspend fun kisiSil(kisi_id : Int){
        Log.e("Kişi sil:",kisi_id.toString())
    }
    suspend fun kisileriYukle() : List<Kisiler> =
        withContext(Dispatchers.IO){
            val kisilerListesi = ArrayList<Kisiler>()
            val k1 = Kisiler(1,"Doğan","555555555")
            val k2 = Kisiler(2,"Doğan","666666666")
            val k3 = Kisiler(3,"Doğan","777777777")

            kisilerListesi.add(k1)
            kisilerListesi.add(k2)
            kisilerListesi.add(k3)
            return@withContext kisilerListesi
        }
    suspend fun kisiAra(aramaKelimesi : String): List<Kisiler> =
        withContext(Dispatchers.IO){
            val kisilerListesi = ArrayList<Kisiler>()
            val k1 = Kisiler(1,"Doğan","555555555")

            kisilerListesi.add(k1)
            return@withContext kisilerListesi
        }
}