package com.example.cadastrocartoes.repository.dao

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
    fun updateUser(cartao: CartaoModel): Int

    @Delete
    fun deleteUser(cartao: CartaoModel): Int

    @Query("SELECT * FROM Cartao WHERE id_cartao = :id")
    fun get(id: Int): CartaoModel

    @Query("SELECT * FROM Cartao")
    fun getAll(): List<CartaoModel>

}