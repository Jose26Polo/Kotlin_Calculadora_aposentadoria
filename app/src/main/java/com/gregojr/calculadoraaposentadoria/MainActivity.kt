package com.gregojr.calculadoraaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //definindo o arquivo de layout
        setContentView(R.layout.activity_main)

        //chamando spinner
        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)

        //chamando a caixa de idade
        val txt_idade = findViewById<EditText>(R.id.txt_idade)

        // chamando botao
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)

        // chamar resultado
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        //definindo valores do spinner
        spn_sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listOf("masculino", "feminino"))

        //acao ao clicar no botao
        btn_calcular.setOnClickListener {
            val sexo = spn_sexo.selectedItem as String
            val idade = txt_idade.text.toString().toInt()
            var resultado = 0

            if (sexo == "masculino") {
                resultado = 65 - idade
            } else {
                resultado = 60 - idade
            }


        txt_resultado.text = "Faltam $resultado anos para você se aposentar."
        txt_idade.text.clear()
        }
    }

}