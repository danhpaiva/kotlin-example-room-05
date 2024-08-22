package com.example.cadastrocartoes.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.cadastrocartoes.model.CartaoModel
import com.example.cadastrocartoes.repository.dao.CartaoDao

@Database(entities = [CartaoModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cartaoDAO(): CartaoDao

    companion object {
        private lateinit var INSTANCE: AppDatabase

        fun getDataBase(context: Context): AppDatabase {
            if (!::INSTANCE.isInitialized) {
                synchronized(AppDatabase::class) {
                    INSTANCE =
                        Room.databaseBuilder(context, AppDatabase::class.java, "cartaodb")
                            .addMigrations(
                                MIGRATION_1_2, MIGRATION_2_3
                            ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("")
            }
        }

        private val MIGRATION_2_3: Migration = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("")
            }
        }
    }
}
