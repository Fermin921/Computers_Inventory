package com.example.computers_inventory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class Alert_Delete : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.alert_delete, container, false)

        val btnEliminar = view.findViewById<Button>(R.id.btnEliminar)
        val btnCancelar = view.findViewById<Button>(R.id.btnCancelar)

        btnEliminar.setOnClickListener {
            onDeleteClick()
        }

        btnCancelar.setOnClickListener {
            onCancelClick()
        }

        return view
    }

    private fun onCancelClick() {
                (activity as? Details_Computer)?.restoreFragmentContainer()
    }

    private fun onDeleteClick() {
        (activity as? Details_Computer)?.restoreFragmentContainer()
    }
}
