package com.juanorozco.practica5.model

import androidx.room.*


@Dao
interface UsuarioDAO {

    @Insert
    fun crearUsuario(usuario: Usuario)

    @Query("  SELECT * FROM tabla_usuario WHERE correo LIKE :correo")
    fun buscarUsuario(correo: String) : Usuario

    @Update
    fun actualizarUsuario(usuario: Usuario)

    @Delete
    fun borrarUsuario(usuario: Usuario)


}