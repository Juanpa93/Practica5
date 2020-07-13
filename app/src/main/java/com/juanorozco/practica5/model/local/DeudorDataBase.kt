package com.juanorozco.practica5.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juanorozco.practica5.model.local.Deudor
import com.juanorozco.practica5.model.local.DeudorDAO


@Database(entities = arrayOf(Deudor::class), version =1)
abstract class DeudorDataBase :RoomDatabase() {

    abstract fun DeudorDAO() : DeudorDAO

}
