package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kDao : KisilerDao) {

    suspend fun kisileriYukle() : List<Kisiler> =
        withContext(Dispatchers.IO){
            return@withContext kDao.kisileriYukle()
        }
    suspend fun kisiKaydet(kisi_ad : String,  kisi_tel: String){
        val yeniKisi = Kisiler(0,kisi_ad,kisi_tel)
        kDao.kisiKaydet(yeniKisi)
    }
    suspend fun kisiGuncelle(kisi_id: Int,kisi_ad: String,kisi_tel: String){
        val guncelKisi = Kisiler(kisi_id,kisi_ad,kisi_tel)
        kDao.kisiGuncelle(guncelKisi)
    }
    suspend fun kisiSil(kisi_id : Int){
        val silinenKisi = Kisiler(kisi_id,"","")
        kDao.kisiSil(silinenKisi)
    }
    suspend fun kisiAra(aramaKelimesi : String): List<Kisiler> =
        withContext(Dispatchers.IO){
            return@withContext kDao.kisiAra(aramaKelimesi)
        }
}