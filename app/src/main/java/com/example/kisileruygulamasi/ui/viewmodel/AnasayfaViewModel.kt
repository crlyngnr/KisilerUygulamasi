package com.example.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var kRepo : KisilerRepository): ViewModel() {
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {  //AnasayfaViewModel oluşturulduğu anda çalış anlamına geliyor
        kisileriYukle()
    }

    fun kisiSil(kisi_id : Int){
        CoroutineScope(Dispatchers.Main).launch {
            kRepo.kisiSil(kisi_id)
            kisileriYukle()
        }
    }
    fun kisileriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
           kisilerListesi.value = kRepo.kisileriYukle()
        }
    }
fun kisiAra(aramaKelimesi : String) {
    CoroutineScope(Dispatchers.Main).launch {
        kisilerListesi.value = kRepo.kisiAra(aramaKelimesi)
    }
}
}