package com.dgz.convertidormvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.dgz.convertidormvvm.databinding.ActivityMainBinding
import com.dgz.convertidormvvm.viewmodel.ConvertidorVM

//VISTA
/**
 * @author Diego Zurita Villarreal
 *
 * Vista de la app
 */


class MainActivity : AppCompatActivity()
{
    //Referencias a los componentes gráficos
    private lateinit var binding: ActivityMainBinding

    //Referencia al ViewModel
    private val convertidorVM : ConvertidorVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        registrarObservadores()
        registrarEventos()
    }

    private fun registrarEventos() {
        //Registrar click del botón
        binding.btnConvertir.setOnClickListener {
            val gradosC = binding.etCelsius.text.toString().toDouble()
            convertidorVM.convertir(gradosC)
            //NO ESPERA RESPUESTA  ...AQUÍ...
        }
    }

    private fun registrarObservadores(){
        //Suscribir a los cambios de gradosF.value...
        convertidorVM.gradosF.observe(this){nuevoValor ->
             binding.gradosF.setText("%.2f".format(nuevoValor))
        }
    }
}