package com.juanorozco.practica5.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.juanorozco.practica5.R
import com.juanorozco.practica5.model.local.Deudor
import com.juanorozco.practica5.model.remote.DeudorRemote
import kotlinx.android.synthetic.main.fragment_create.*
import java.sql.Types.NULL

class CreateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_create, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mostrarMensajeBienvenida()

        bt_guardar.setOnClickListener {
            val nombre = et_nombre.text.toString()
            val telefono = et_telefono.text.toString()
            val cantidad = et_cantidad.text.toString().toLong()

            guardarEnFirebase(nombre, telefono, cantidad)
            cleanEditText()

            /*val deudor = Deudor(
               NULL,
               nombre,
               telefono,
               cantidad
           )*/
            //val deudorDAO = SesionROOM.database.DeudorDAO()
            //deudorDAO.crearDeudor(deudor)


        }
    }

    private fun guardarEnFirebase(nombre : String, telefono : String, cantidad : Long) {
        val database : FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef : DatabaseReference = database.getReference("deudores")
        val id = myRef.push().key
        val deudor = DeudorRemote (
        id,
        nombre,
        telefono,
        cantidad
        )
        myRef.child(id!!).setValue(deudor)
    }

    private fun mostrarMensajeBienvenida() {
        val mAuth : FirebaseAuth = FirebaseAuth.getInstance()
        val user : FirebaseUser? = mAuth.currentUser
        val correo = user?.email

        Toast.makeText(requireContext(), "Bienvenido $correo", Toast.LENGTH_SHORT).show()
    }

    private fun cleanEditText() {
        et_nombre.setText("")
        et_telefono.setText("")
        et_cantidad.setText("")
    }
}
