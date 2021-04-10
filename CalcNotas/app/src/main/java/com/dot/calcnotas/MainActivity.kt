package com.dot.calcnotas

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.dot.calcnotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalcular.setOnClickListener {
            val num1 = binding.nota1
            val num2 = binding.nota2
            val num3 = binding.nota3
            val num4 = binding.nota4
            val faltas = binding.faltas
            val resultado = binding.txtResult

            val nota1 = Integer.parseInt(num1.text.toString())
            val nota2 = Integer.parseInt(num2.text.toString())
            val nota3 = Integer.parseInt(num3.text.toString())
            val nota4 = Integer.parseInt(num4.text.toString())
            val numfaltas = Integer.parseInt(faltas.text.toString())

            val media = (nota1 + nota2 + nota3 + nota4) / 4
            if (media >= 6 && numfaltas <= 20){
                resultado.setText("Aluno Foi aprovado \n Méida final $media")
                resultado.setTextColor(getColor(R.color.green))
            } else if(numfaltas > 20){
                resultado.setText("Aluno Foi Reprovado por Faltas \n Média Final $media")
                resultado.setTextColor(getColor(R.color.red))
            }else if(media < 6){
                resultado.setText("Aluno Foi Reprovado por Nota \n Média Final $media")
                resultado.setTextColor(getColor(R.color.red))
            }
        }
    }
}