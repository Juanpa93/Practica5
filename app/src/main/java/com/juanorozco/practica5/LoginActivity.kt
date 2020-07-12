package com.juanorozco.practica5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.juanorozco.practica5.model.Usuario
import com.juanorozco.practica5.model.UsuarioDAO
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_login)
        var contrasenaUsuario = ""
        bt_registrarse.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        bt_iniciarSesion.setOnClickListener {
            val correo = et_correoLogin.text.toString()
            val contrasena = et_passwordLogin.text.toString()
            val usuarioDAO : UsuarioDAO = SesionROOM.database2.UsuarioDAO()
            val usuario = usuarioDAO.buscarUsuario(correo)

            if (usuario != null) {
                contrasenaUsuario = usuario.contrasena
                if (contrasenaUsuario == contrasena){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else
                    Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
            }
        else
                Toast.makeText(this, "Correo no existe", Toast.LENGTH_SHORT).show()

            }

    }
}