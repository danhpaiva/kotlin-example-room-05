package com.example.cadastrocartoes.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cadastrocartoes.model.CartaoModel

@Dao
interface CartaoDao {
    @Insert
    fun insertCartao(cartao: CartaoModel) : Long

    @Update
    fun updateCartao(cartao: CartaoModel): Int

    @Delete
    fun deleteCartao(cartao: CartaoModel): Int

    @Query("SELECT * FROM TB_CARTAO WHERE id_cartao = :id")
    fun get(id: Int): CartaoModel

    @Query("SELECT * FROM TB_CARTAO")
    fun getAll(): List<CartaoModel>
}