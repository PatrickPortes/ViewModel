package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var etContador: EditText
    lateinit var btDados: Button
    lateinit var btMostrar: Button

    lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initClick()

        //exibirLifeCycle(valor = "onCreate")
    }

    private fun initData(){
        //Implementando ViewModel
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        etContador = editTextContador
        btDados = buttonDados
        btMostrar = buttonMostrar

        mViewModel.mContador.observe(this, Observer { valor ->
            etContador.setText(valor)
        })
    }

    private fun initClick(){

        btDados.setOnClickListener{
            mViewModel.Contador()
        }

        btMostrar.setOnClickListener{
            Toast.makeText(applicationContext, "Valor Contador: ${mViewModel.mContador.value}", Toast.LENGTH_SHORT).show()
        }
    }

    //Testando LifeCycle:

    /*
    override fun onStart() {
        super.onStart()
        exibirLifeCycle(valor = "onStart")
    }

    override fun onResume() {
        super.onResume()
        exibirLifeCycle(valor = "onResume")
    }

    override fun onPause() {
        super.onPause()
        exibirLifeCycle(valor = "onPause")
    }

    override fun onStop() {
        super.onStop()
        exibirLifeCycle(valor = "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        exibirLifeCycle(valor = "onDestroy")
    }

    private fun exibirLifeCycle( tag: String = "Ciclo de Vida", valor: String ){
        Log.d(tag, valor)
    }

    private fun finalizarApp(){
        finish()
    }
     */
}
