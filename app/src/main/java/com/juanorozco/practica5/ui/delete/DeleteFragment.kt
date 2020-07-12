package com.juanorozco.practica5.ui.delete

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.juanorozco.practica5.R
import com.juanorozco.practica5.SesionROOM
import kotlinx.android.synthetic.main.fragment_delete.*
import java.sql.Types.NULL

class DeleteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_delete, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_eliminar.setOnClickListener {
            val nombre = et_nombre.text.toString()
            val deudorDAO = SesionROOM.database.DeudorDAO()
            val deudor = deudorDAO.buscarDeudor(nombre)
            if(deudor != null) {
                deudorDAO.borrarDeudor(deudor)
                et_nombre.setText("")
            }
            else
                Toast.makeText(context," Deudor no encontrado", Toast.LENGTH_SHORT).show()

        }
    }
}