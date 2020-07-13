package com.juanorozco.practica5.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juanorozco.practica5.model.local.Usuario
import com.juanorozco.practica5.model.local.UsuarioDAO


@Database(entities = arrayOf(Usuario::class), version =1)
abstract class UsuarioDataBase :RoomDatabase() {

    abstract fun UsuarioDAO() : UsuarioDAO

}