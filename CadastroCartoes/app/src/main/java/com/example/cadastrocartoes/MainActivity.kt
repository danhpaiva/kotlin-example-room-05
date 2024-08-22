package com.example.cadastrocartoes

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cadastrocartoes.model.CartaoModel
import com.example.cadastrocartoes.repository.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val cartaoDatabase = AppDatabase.getDataBase(this).cartaoDAO()

        val retornoInsert = cartaoDatabase.insertCartao(CartaoModel().apply {
            this.numero_cartao = "123456789"
            this.titular = "Daniel Paiva"
            this.cvv = "777"
            this.data_vencimento = "31/12/2031"
        })

        val retornoSelectMultiplo = cartaoDatabase.getAll()

        for(item in retornoSelectMultiplo){
            Log.d("Retorno Múltiplo", "id_cartao: ${item.id_cartao}, titular: ${item.titular}, cvv: ${item.cvv}, data: ${item.data_vencimento}")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}