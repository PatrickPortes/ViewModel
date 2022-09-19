package com.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var mContador = MutableLiveData<String>().apply { value = contador.toString() }

    private var contador: Int = 0

    private fun setContador(){
        mContador.value = contador.toString()
    }

    private fun validaContador(){
        contador++
        if(contador > 10){
            contador = 0
        }
        setContador()
    }

    fun Contador(){
        validaContador()
    }

}