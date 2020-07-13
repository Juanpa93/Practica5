package com.juanorozco.practica5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.juanorozco.practica5.model.local.UsuarioDAO
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_login)

        val mAuth : FirebaseAuth = FirebaseAuth.getInstance()

        var contrasenaUsuario = ""
        bt_registrarse.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        bt_iniciarSesion.setOnClickListener {
            val email = et_correoLogin.text.toString()
            val password = et_passwordLogin.text.toString()
            val usuarioDAO : UsuarioDAO = SesionROOM.database2.UsuarioDAO()
            val usuario = usuarioDAO.buscarUsuario(email)


            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Campos incompletos", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(
                        this
                    ) { task ->
                        if (task.isSuccessful) {
                            startActivity(Intent(this, MainActivity::class.java))
                        } else {
                            Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT)
                                .show()
                            Log.w("TAGGG","signInWithEmail:failure", task.getException())
                            Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT)
                                .show()

                        }
                        /*if (usuario != null) {
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

            */
                    }

            }
        }
    }
}