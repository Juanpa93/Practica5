package com.juanorozco.practica5

import android.app.Application
import androidx.room.Room
import com.juanorozco.practica5.model.local.DeudorDataBase
import com.juanorozco.practica5.model.local.UsuarioDataBase

class SesionROOM : Application() {

    companion object{
        lateinit var database: DeudorDataBase
        lateinit var database2: UsuarioDataBase
    }
    override fun onCreate(){
        super.onCreate()
        database = Room.databaseBuilder(
             this,
            DeudorDataBase::class.java,
             "misdeudores_db").allowMainThreadQueries()
            .build()
        database2 = Room.databaseBuilder(
            this,
            UsuarioDataBase::class.java,
            "misusuarios_db").allowMainThreadQueries()
            .build()

    }
}