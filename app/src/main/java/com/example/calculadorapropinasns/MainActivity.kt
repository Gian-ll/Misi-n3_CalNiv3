package com.example.calculadorapropinasns

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: MoodViewModel by viewModels()

    private lateinit var etMonto: EditText
    private lateinit var tvPropina: TextView
    private lateinit var tvTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etMonto = findViewById(R.id.etMonto)
        tvPropina = findViewById(R.id.tvPropina)
        tvTotal = findViewById(R.id.tvTotal)

        val btnSBueno = findViewById<Button>(R.id.btnSBueno)
        val btnSRegular = findViewById<Button>(R.id.btnSRegular)
        val btnSMalo = findViewById<Button>(R.id.btnSMalo)

        btnSBueno.setOnClickListener { calcularpr("BUENO") }
        btnSRegular.setOnClickListener { calcularpr("REGULAR") }
        btnSMalo.setOnClickListener { calcularpr("MALO") }


        viewModel.propina.observe(this) { prop ->
            tvPropina.text = "Propina: $%.2f".format(prop)
        }
        viewModel.total.observe(this) { total ->
            tvTotal.text = "Total: $%.2f".format(total)
        }
    }

    private fun calcularpr(tipo: String) {
        val monto = etMonto.text.toString().toDoubleOrNull() ?: 0.0
        viewModel.calcularpr(monto, tipo)
    }
}