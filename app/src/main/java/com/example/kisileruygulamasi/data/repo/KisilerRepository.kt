package com.example.kisileruygulamasi.data.repo

import android.util.Log
import com.example.kisileruygulamasi.data.datasource.KisilerDataSource
import com.example.kisileruygulamasi.data.entity.Kisiler

class KisilerRepository(var kds : KisilerDataSource) {
    suspend fun kisiKaydet(kisi_ad : String,  kisi_tel: String) = kds.kisiKaydet(kisi_ad,kisi_tel)
    suspend fun kisiGuncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) = kds.kisiGuncelle(kisi_id,kisi_ad,kisi_tel)
    suspend fun kisiSil(kisi_id : Int) = kds.kisiSil(kisi_id)
    suspend fun kisileriYukle() : List<Kisiler> =kds.kisileriYukle()
    suspend fun kisiAra(aramaKelimesi : String): List<Kisiler> = kds.kisiAra(aramaKelimesi)
}