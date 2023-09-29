package com.example.kisileruygulamasi.room

import androidx.room.*
import com.example.kisileruygulamasi.data.entity.Kisiler

@Dao
interface KisilerDao {
    @Query("SELECT * FROM kisiler")
    suspend fun kisileriYukle() : List<Kisiler>

    @Insert
    suspend fun kisiKaydet(kisi:Kisiler)

    @Update
    suspend fun kisiGuncelle(kisi: Kisiler)

    @Delete
    suspend fun kisiSil(kisi:Kisiler)

    @Query("SELECT * FROM kisiler WHERE kisi_ad LIKE '%' || :aramaKelimesi || '%'")
    suspend fun kisiAra(aramaKelimesi: String) : List<Kisiler>
}