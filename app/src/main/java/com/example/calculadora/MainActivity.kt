package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.CalcButton.setOnClickListener{
            calculateOperation()
            //Toast
            val toast = Toast.makeText(this, "Sucesso no Calculo", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
    fun calculateOperation(){


        val N1 = binding.Valor1.text.toString().toInt()
        val N2 = binding.Valor2.text.toString().toInt()

        val selectedId = binding.tipOptions.checkedRadioButtonId

        val OperationTip = when (selectedId) {
            R.id.option_sum -> Calcular().somar(N1,N2)
            R.id.option_sub -> Calcular().subtrair(N1,N2)
            R.id.option_multi -> Calcular().multiplicar(N1,N2)
            else -> Calcular().dividir(N1,N2)
        }

        val result = DecimalFormat().format(OperationTip)
        binding.ResultadoView.text = result
    }
}

