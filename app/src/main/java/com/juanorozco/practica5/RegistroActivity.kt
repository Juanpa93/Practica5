package com.juanorozco.practica5

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.juanorozco.practica5.model.Usuario
import kotlinx.android.synthetic.main.activity_registro.*
import java.sql.Types.NULL
import java.util.*

class RegistroActivity : AppCompatActivity() {
    private var fecha : String = ""
    private var cal = Calendar.getInstance()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_registro)
        val usuarioDAO = SesionROOM.database2.UsuarioDAO()

        bt_guardar_r.setOnClickListener {
            val nombre = et_nombre.text.toString()
            val correo = et_correo.text.toString()
            val telefono = et_telefono.text.toString()
            val contrasena = et_password.text.toString()
            val repcontrasena = et_reppassword.text.toString()
            val usuario = Usuario(NULL, nombre, correo, telefono, contrasena)




            if (nombre.isNotEmpty() && correo.isNotEmpty() && telefono.isNotEmpty() && contrasena.isNotEmpty()) {
                if (contrasena.length < 6) {
                    Toast.makeText(
                        this,
                        "La contraseña debe contener minimo 6 caracteres",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                if (contrasena == repcontrasena && contrasena.length >= 6) {
                    usuarioDAO.crearUsuario(usuario)
                    finish()
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    onBackPressed()
                    et_nombre.setText("")
                    et_correo.setText("")
                    et_telefono.setText("")
                    et_password.setText("")
                    et_reppassword.setText("")



                } else {
                    if (contrasena != repcontrasena) {
                        Toast.makeText(this, "Contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Datos incompletos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
