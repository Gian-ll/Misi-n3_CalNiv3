package com.example.calculadorapropinasns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

class MoodViewModel: ViewModel() {
    private val _propina = MutableLiveData<Double>()
    val propina: LiveData<Double> get() = _propina

    private val _total = MutableLiveData<Double>()
    val total: LiveData<Double> get() = _total

    fun calcularpr(monto: Double, tipoServicio: String){
        val porcentaje = when (tipoServicio) {
            "BUENO" -> 0.15
            "REGULAR" -> 0.10
            "MALO" -> 0.05
            else -> 0.0
        }

        val Calpropina = monto * porcentaje
        val Ctotal = monto + Calpropina

        _propina.value = Calpropina
        _total.value = Ctotal
    }
}