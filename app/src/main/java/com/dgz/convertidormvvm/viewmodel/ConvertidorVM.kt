package com.dgz.convertidormvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dgz.convertidormvvm.model.Convertidor

//VIEW MODEL
/**
 * @author Diego Zurita Villarreal
 * View model
 */
class ConvertidorVM : ViewModel()
{
    //Referencia al modelo
    private val modelo = Convertidor()

    //Comunicación con la vista
    val gradosF = MutableLiveData<Double>()

    //Interface de la vista
    fun convertir(gradosC: Double){
        gradosF.value = modelo.convertirCaF(gradosC)
    }
}